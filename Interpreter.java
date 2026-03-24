import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Interpreter {
    private final Map<String, FunctionDef> functions = new LinkedHashMap<>();
    private final Map<String, StructureDef> structs = new LinkedHashMap<>();
    private final Deque<EnvFrame> envStack = new ArrayDeque<>();
    private final int maxLoopIterations;

    private Scanner inputScanner;
    private PrintStream out;

    private volatile boolean stepping = false;
    /** Worker waits here until UI releases (one step). */
    private final Semaphore stepIn = new Semaphore(0);
    /** UI waits here until one statement has finished. */
    private Semaphore stepDone;
    private volatile int lastStepLine = 0;
    private int nextAddress = 0x1000;

    public static final class MemoryCell {
        public final String variableName;
        public final String memoryAddress;
        public final String value;

        MemoryCell(String variableName, String memoryAddress, String value) {
            this.variableName = variableName;
            this.memoryAddress = memoryAddress;
            this.value = value;
        }
    }

    public Interpreter() {
        this(1_000_000, System.in, System.out);
    }

    public Interpreter(int maxLoopIterations) {
        this(maxLoopIterations, System.in, System.out);
    }

    public Interpreter(InputStream in, PrintStream out) {
        this(1_000_000, in, out);
    }

    public Interpreter(int maxLoopIterations, InputStream in, PrintStream out) {
        this.maxLoopIterations = maxLoopIterations;
        this.inputScanner = new Scanner(in);
        this.out = out;
        this.envStack.push(new EnvFrame());
    }

    public void setInputOutput(InputStream in, PrintStream out) {
        this.inputScanner = new Scanner(in);
        this.out = out;
    }

    public void setStepping(boolean stepping) {
        this.stepping = stepping;
    }

    public boolean isStepping() {
        return stepping;
    }

    /** Optional: when set, released after each statement completes (for IDE sync). */
    public void setStepDoneSemaphore(Semaphore stepDone) {
        this.stepDone = stepDone;
    }

    /** Call from another thread to run one statement when stepping. */
    public void stepContinue() {
        stepIn.release();
    }

    public int getLastStepLine() {
        return lastStepLine;
    }

    public void execute(WikangSawaParser.ProgramContext program) {
        for (WikangSawaParser.StatementContext st : program.statement()) {
            if (st.blockStatement() != null && st.blockStatement().structureDeclaration() != null) {
                registerStructure(st.blockStatement().structureDeclaration());
            }
            if (st.blockStatement() != null && st.blockStatement().functionDeclaration() != null) {
                registerFunction(st.blockStatement().functionDeclaration());
            }
        }

        for (WikangSawaParser.StatementContext st : program.statement()) {
            if (st.blockStatement() != null) {
                executeBlockStatement(st.blockStatement());
            }
        }
    }

    private void registerStructure(WikangSawaParser.StructureDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        List<String> fieldOrder = new ArrayList<>();
        Map<String, WikangSawaParser.ExpressionContext> inits = new LinkedHashMap<>();
        for (WikangSawaParser.StructFieldContext sf : ctx.structBlock().structField()) {
            String fn = sf.IDENTIFIER().getText();
            fieldOrder.add(fn);
            inits.put(fn, sf.expression());
        }
        structs.put(name, new StructureDef(fieldOrder, inits));
    }

    private void executeBlock(WikangSawaParser.BlockContext block) {
        for (WikangSawaParser.BlockStatementContext bs : block.blockStatement()) {
            executeBlockStatement(bs);
        }
    }

    private void beforeStatement(WikangSawaParser.BlockStatementContext bs) {
        if (!stepping) return;
        Token t = bs.getStart();
        lastStepLine = t != null ? t.getLine() : 0;
        try {
            stepIn.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void afterStatementStep() {
        if (stepping && stepDone != null) {
            stepDone.release();
        }
    }

    private void executeBlockStatement(WikangSawaParser.BlockStatementContext bs) {
        beforeStatement(bs);
        try {
            if (bs.importStatement() != null) {
                return;
            }
            if (bs.functionDeclaration() != null) {
                return;
            }
            if (bs.structureDeclaration() != null) {
                return;
            }
            if (bs.variableDeclaration() != null) {
                execVarDecl(bs.variableDeclaration());
                return;
            }
            if (bs.constantDeclaration() != null) {
                execConstantDecl(bs.constantDeclaration());
                return;
            }
            if (bs.assignmentStatement() != null) {
                execAssign(bs.assignmentStatement());
                return;
            }
            if (bs.printStatement() != null) {
                execPrint(bs.printStatement());
                return;
            }
            if (bs.inputStatement() != null) {
                execInput(bs.inputStatement());
                return;
            }
            if (bs.returnStatement() != null) {
                RuntimeValue v = evalExpression(bs.returnStatement().expression());
                throw new ReturnSignal(v);
            }
            if (bs.conditionalStatement() != null) {
                execIf(bs.conditionalStatement());
                return;
            }
            if (bs.loopStatement() != null) {
                execWhile(bs.loopStatement());
                return;
            }
            if (bs.countLoopStatement() != null) {
                execCountLoop(bs.countLoopStatement());
                return;
            }
            if (bs.repeatUntilStatement() != null) {
                execRepeatUntil(bs.repeatUntilStatement());
                return;
            }
            if (bs.eventLineLoopStatement() != null) {
                execEventLineLoop(bs.eventLineLoopStatement());
                return;
            }
            throw new InterpreterException(bs.getStart(), "Unsupported statement type.");
        } finally {
            afterStatementStep();
        }
    }

    private void execConstantDecl(WikangSawaParser.ConstantDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        EnvFrame frame = currentFrame();
        if (frame.vars.containsKey(name)) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Constant '" + name + "' conflicts with an existing variable.");
        }
        RuntimeValue value = evalExpression(ctx.expression());
        frame.vars.put(name, value);
        frame.addresses.put(name, allocateAddress());
        frame.consts.add(name);
    }

    private void execVarDecl(WikangSawaParser.VariableDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        EnvFrame frame = currentFrame();
        if (frame.vars.containsKey(name)) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is already declared in this scope.");
        }
        frame.vars.put(name, evalExpression(ctx.expression()));
        frame.addresses.put(name, allocateAddress());
    }

    private void execAssign(WikangSawaParser.AssignmentStatementContext ctx) {
        RuntimeValue value = evalExpression(ctx.expression());
        if (ctx.STAR() != null) {
            String ptrName = ctx.IDENTIFIER().getText();
            RuntimeValue ptr = lookupValue(ptrName);
            if (ptr == null) {
                throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + ptrName + "' is not declared.");
            }
            if (ptr.type != RuntimeValue.Type.REFERENCE) {
                throw new InterpreterException(ctx.getStart(), "Dereference assignment requires a pointer, got " + ptr.type + ".");
            }
            assignToVariableName(ctx.getStart(), ptr.refTargetName(), value);
            return;
        }
        String name = ctx.IDENTIFIER().getText();
        assignToVariableName(ctx.IDENTIFIER().getSymbol(), name, value);
    }

    private void assignToVariableName(Token where, String name, RuntimeValue value) {
        Lookup L = lookupEnv(name);
        if (!L.exists) {
            throw new InterpreterException(where, "Variable '" + name + "' is not declared (cannot assign).");
        }
        if (L.frame.consts.contains(name)) {
            throw new InterpreterException(where, "Cannot assign to constant '" + name + "'.");
        }
        L.frame.vars.put(name, value);
    }

    private void execPrint(WikangSawaParser.PrintStatementContext ctx) {
        RuntimeValue v = evalExpression(ctx.expression());
        out.println(v.toString());
    }

    private void execInput(WikangSawaParser.InputStatementContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        Lookup L = lookupEnv(name);
        if (!L.exists) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (magbasa requires prior baryabol).");
        }
        if (L.frame.consts.contains(name)) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Cannot read into constant '" + name + "'.");
        }
        if (!inputScanner.hasNextLine()) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "No input available for magbasa.");
        }
        String line = inputScanner.nextLine();
        L.frame.vars.put(name, parseInputLine(line));
    }

    private static RuntimeValue parseInputLine(String line) {
        if (line == null) return RuntimeValue.string("");
        String t = line.trim();
        if (t.isEmpty()) return RuntimeValue.string("");
        try {
            return RuntimeValue.number(Long.parseLong(t));
        } catch (NumberFormatException ignored) {
        }
        try {
            return RuntimeValue.decimal(Double.parseDouble(t));
        } catch (NumberFormatException ignored) {
        }
        return RuntimeValue.string(t);
    }

    private void execIf(WikangSawaParser.ConditionalStatementContext ctx) {
        RuntimeValue cond = evalExpression(ctx.expression());
        boolean b = requireBoolean(ctx.expression().getStart(), cond, "Condition in 'kung' must be boolean.");
        if (b) {
            executeBlock(ctx.block(0));
        } else if (ctx.block().size() > 1) {
            executeBlock(ctx.block(1));
        }
    }

    private void execWhile(WikangSawaParser.LoopStatementContext ctx) {
        int i = 0;
        while (true) {
            RuntimeValue cond = evalExpression(ctx.expression());
            boolean b = requireBoolean(ctx.expression().getStart(), cond, "Condition in 'habang' must be boolean.");
            if (!b) break;
            executeBlock(ctx.block());
            i++;
            if (i > maxLoopIterations) {
                throw new InterpreterException(ctx.getStart(),
                    "Loop exceeded max iterations (" + maxLoopIterations + "). Possible infinite loop.");
            }
        }
    }

    private void execCountLoop(WikangSawaParser.CountLoopStatementContext ctx) {
        String var = ctx.IDENTIFIER().getText();
        Lookup L = lookupEnv(var);
        if (!L.exists) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Loop variable '" + var + "' must be declared before 'para'.");
        }
        if (L.frame.consts.contains(var)) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Cannot use constant '" + var + "' as loop variable.");
        }
        RuntimeValue startV = evalExpression(ctx.expression(0));
        RuntimeValue endV = evalExpression(ctx.expression(1));
        if (!startV.isNumeric() || !endV.isNumeric()) {
            throw new InterpreterException(ctx.getStart(), "'para' bounds must be numeric.");
        }
        long start = (long) Math.floor(startV.asDouble());
        long end = (long) Math.floor(endV.asDouble());
        int guard = 0;
        for (long k = start; k <= end; k++) {
            assignToVariableName(ctx.getStart(), var, RuntimeValue.number(k));
            executeBlock(ctx.block());
            guard++;
            if (guard > maxLoopIterations) {
                throw new InterpreterException(ctx.getStart(),
                    "Loop exceeded max iterations (" + maxLoopIterations + "). Possible infinite loop.");
            }
        }
    }

    private void execRepeatUntil(WikangSawaParser.RepeatUntilStatementContext ctx) {
        int i = 0;
        while (true) {
            executeBlock(ctx.block());
            RuntimeValue cond = evalExpression(ctx.expression());
            boolean b = requireBoolean(ctx.expression().getStart(), cond, "Condition in 'hanggang' must be boolean.");
            if (b) break;
            i++;
            if (i > maxLoopIterations) {
                throw new InterpreterException(ctx.getStart(),
                    "Loop exceeded max iterations (" + maxLoopIterations + "). Possible infinite loop.");
            }
        }
    }

    private void execEventLineLoop(WikangSawaParser.EventLineLoopStatementContext ctx) {
        int i = 0;
        while (inputScanner.hasNextLine()) {
            inputScanner.nextLine(); // consume line (event); body runs once per line
            executeBlock(ctx.block());
            i++;
            if (i > maxLoopIterations) {
                throw new InterpreterException(ctx.getStart(),
                    "Event loop exceeded max iterations (" + maxLoopIterations + ").");
            }
        }
    }

    // ===== Expression evaluation =====

    private RuntimeValue evalExpression(WikangSawaParser.ExpressionContext ctx) {
        RuntimeValue left = evalAndExpression(ctx.andExpression(0));
        for (int i = 1; i < ctx.andExpression().size(); i++) {
            boolean l = requireBoolean(ctx.getStart(), left, "Left side of 'o' must be boolean.");
            if (l) return RuntimeValue.bool(true);
            RuntimeValue right = evalAndExpression(ctx.andExpression(i));
            boolean r = requireBoolean(ctx.getStart(), right, "Right side of 'o' must be boolean.");
            left = RuntimeValue.bool(r);
        }
        return left;
    }

    private RuntimeValue evalAndExpression(WikangSawaParser.AndExpressionContext ctx) {
        RuntimeValue left = evalNotExpression(ctx.notExpression(0));
        for (int i = 1; i < ctx.notExpression().size(); i++) {
            boolean l = requireBoolean(ctx.getStart(), left, "Left side of 'at' must be boolean.");
            if (!l) return RuntimeValue.bool(false);
            RuntimeValue right = evalNotExpression(ctx.notExpression(i));
            boolean r = requireBoolean(ctx.getStart(), right, "Right side of 'at' must be boolean.");
            left = RuntimeValue.bool(r);
        }
        return left;
    }

    private RuntimeValue evalNotExpression(WikangSawaParser.NotExpressionContext ctx) {
        if (ctx.HINDI() != null) {
            RuntimeValue inner = evalNotExpression(ctx.notExpression());
            boolean b = requireBoolean(ctx.getStart(), inner, "Operand of 'hindi' must be boolean.");
            return RuntimeValue.bool(!b);
        }
        return evalComparisonExpression(ctx.comparisonExpression());
    }

    private RuntimeValue evalComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx) {
        RuntimeValue left = evalArithmeticExpression(ctx.arithmeticExpression(0));
        if (ctx.relOp() == null) return left;

        RuntimeValue right = evalArithmeticExpression(ctx.arithmeticExpression(1));
        String op = ctx.relOp().getText();

        return switch (op) {
            case "==" -> RuntimeValue.bool(equalsValue(left, right));
            case "!=" -> RuntimeValue.bool(!equalsValue(left, right));
            case "<", ">", "<=", ">=" -> RuntimeValue.bool(compare(ctx.getStart(), op, left, right));
            default -> throw new InterpreterException(ctx.getStart(), "Unknown comparison operator '" + op + "'.");
        };
    }

    private RuntimeValue evalArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx) {
        RuntimeValue acc = evalTerm(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            RuntimeValue rhs = evalTerm(ctx.term(i));
            String op = ctx.getChild(2 * i - 1).getText();
            acc = arithmetic(ctx.getStart(), op, acc, rhs);
        }
        return acc;
    }

    private RuntimeValue evalTerm(WikangSawaParser.TermContext ctx) {
        RuntimeValue acc = evalFactor(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            RuntimeValue rhs = evalFactor(ctx.factor(i));
            String op = ctx.getChild(2 * i - 1).getText();
            acc = arithmetic(ctx.getStart(), op, acc, rhs);
        }
        return acc;
    }

    private RuntimeValue evalFactor(WikangSawaParser.FactorContext ctx) {
        if (ctx.STAR() != null) {
            RuntimeValue inner = evalPostfix(ctx.postfix());
            return dereference(ctx.getStart(), inner);
        }
        RuntimeValue base = evalPostfix(ctx.postfix());
        if (ctx.MINUS() != null) {
            if (!base.isNumeric()) {
                throw new InterpreterException(ctx.getStart(), "Unary '-' requires a numeric operand, got " + base.type + ".");
            }
            if (base.type == RuntimeValue.Type.DECIMAL) return RuntimeValue.decimal(-base.asDouble());
            return RuntimeValue.number(-base.asLong());
        }
        return base;
    }

    private RuntimeValue dereference(Token where, RuntimeValue v) {
        if (v.type == RuntimeValue.Type.REFERENCE) {
            RuntimeValue got = lookupValue(v.refTargetName());
            if (got == null) {
                throw new InterpreterException(where, "Dereference of undeclared variable '" + v.refTargetName() + "'.");
            }
            return got;
        }
        throw new InterpreterException(where, "Unary '*' requires a pointer value, got " + v.type + ".");
    }

    private RuntimeValue evalPostfix(WikangSawaParser.PostfixContext ctx) {
        RuntimeValue base = evalPrimary(ctx.primary());
        List<ParseTree> ch = ctx.children;
        int i = 0;
        while (i < ch.size() && !(ch.get(i) instanceof WikangSawaParser.PrimaryContext)) {
            i++;
        }
        if (i < ch.size()) i++;

        while (i < ch.size()) {
            ParseTree c = ch.get(i);
            if (!(c instanceof TerminalNode tn)) {
                throw new InterpreterException(ctx.getStart(), "Unexpected parse tree in postfix.");
            }
            int tt = tn.getSymbol().getType();
            if (tt == WikangSawaParser.DOT) {
                i++;
                TerminalNode idNode = (TerminalNode) ch.get(i++);
                base = readField(ctx.getStart(), base, idNode.getText());
            } else if (tt == WikangSawaParser.LBRACKET) {
                i++;
                WikangSawaParser.ExpressionContext ex = (WikangSawaParser.ExpressionContext) ch.get(i++);
                i++;
                RuntimeValue idxV = evalExpression(ex);
                if (!idxV.isNumeric()) {
                    throw new InterpreterException(ctx.getStart(), "Array index must be numeric.");
                }
                int idx = (int) idxV.asDouble();
                if (base.type != RuntimeValue.Type.ARRAY) {
                    throw new InterpreterException(ctx.getStart(), "Indexing requires an array, got " + base.type + ".");
                }
                List<RuntimeValue> arr = base.asArray();
                if (idx < 0 || idx >= arr.size()) {
                    throw new InterpreterException(ctx.getStart(), "Array index out of bounds: " + idx + ".");
                }
                base = arr.get(idx);
            } else {
                throw new InterpreterException(ctx.getStart(), "Unexpected token in postfix.");
            }
        }
        return base;
    }

    private RuntimeValue readField(Token where, RuntimeValue base, String field) {
        if (base.type != RuntimeValue.Type.STRUCT) {
            throw new InterpreterException(where, "Field access requires a struct, got " + base.type + ".");
        }
        Map<String, RuntimeValue> m = base.asStructFields();
        if (!m.containsKey(field)) {
            throw new InterpreterException(where, "Unknown struct field '" + field + "'.");
        }
        return m.get(field);
    }

    private RuntimeValue evalPrimary(WikangSawaParser.PrimaryContext ctx) {
        if (ctx.literal() != null) return evalLiteral(ctx.literal());
        if (ctx.arrayLiteral() != null) return evalArrayLiteral(ctx.arrayLiteral());
        if (ctx.expression() != null) return evalExpression(ctx.expression());

        if (ctx.BAGONG() != null) {
            String tname = ctx.IDENTIFIER().getText();
            return constructStruct(ctx.getStart(), tname);
        }
        if (ctx.AMPERSAND() != null) {
            String name = ctx.IDENTIFIER().getText();
            if (!lookupEnv(name).exists) {
                throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot take address).");
            }
            return RuntimeValue.reference(name);
        }

        if (ctx.IDENTIFIER() != null) {
            String name = ctx.IDENTIFIER().getText();
            if (ctx.LPAREN() != null) {
                List<RuntimeValue> args = new ArrayList<>();
                if (ctx.argList() != null) {
                    for (WikangSawaParser.ExpressionContext e : ctx.argList().expression()) {
                        args.add(evalExpression(e));
                    }
                }
                return callFunction(ctx.getStart(), name, args);
            }
            RuntimeValue v = lookupValue(name);
            if (v == null) throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared.");
            return v;
        }

        throw new InterpreterException(ctx.getStart(), "Unknown primary expression.");
    }

    private RuntimeValue constructStruct(Token where, String typeName) {
        StructureDef def = structs.get(typeName);
        if (def == null) {
            throw new InterpreterException(where, "Struct type '" + typeName + "' is not declared.");
        }
        Map<String, RuntimeValue> fields = new LinkedHashMap<>();
        for (String fn : def.fieldOrder) {
            WikangSawaParser.ExpressionContext ex = def.inits.get(fn);
            fields.put(fn, evalExpression(ex));
        }
        return RuntimeValue.structInstance(fields);
    }

    private RuntimeValue evalArrayLiteral(WikangSawaParser.ArrayLiteralContext ctx) {
        List<RuntimeValue> values = new ArrayList<>();
        for (WikangSawaParser.ExpressionContext e : ctx.expression()) {
            values.add(evalExpression(e));
        }
        return RuntimeValue.array(values);
    }

    private RuntimeValue evalLiteral(WikangSawaParser.LiteralContext ctx) {
        if (ctx.NUMERO() != null) {
            return RuntimeValue.number(Long.parseLong(ctx.NUMERO().getText()));
        }
        if (ctx.DESIMAL() != null) {
            return RuntimeValue.decimal(Double.parseDouble(ctx.DESIMAL().getText()));
        }
        if (ctx.SALITA() != null) {
            return RuntimeValue.string(unescapeString(ctx.SALITA().getText()));
        }
        if (ctx.TOTOO() != null) return RuntimeValue.bool(true);
        if (ctx.MALI() != null) return RuntimeValue.bool(false);
        if (ctx.WALA() != null) return RuntimeValue.nullValue();
        throw new InterpreterException(ctx.getStart(), "Unknown literal.");
    }

    private boolean requireBoolean(Token where, RuntimeValue v, String message) {
        if (v.type != RuntimeValue.Type.BOOLEAN) {
            throw new InterpreterException(where, message + " Got " + v.type + ".");
        }
        return v.asBoolean();
    }

    private RuntimeValue arithmetic(Token where, String op, RuntimeValue a, RuntimeValue b) {
        if (!a.isNumeric() || !b.isNumeric()) {
            throw new InterpreterException(where,
                "Operator '" + op + "' requires numeric operands, got " + a.type + " and " + b.type + ".");
        }

        boolean promote = (a.type == RuntimeValue.Type.DECIMAL) || (b.type == RuntimeValue.Type.DECIMAL);
        if (promote) {
            double x = a.asDouble();
            double y = b.asDouble();
            return switch (op) {
                case "+" -> RuntimeValue.decimal(x + y);
                case "-" -> RuntimeValue.decimal(x - y);
                case "*" -> RuntimeValue.decimal(x * y);
                case "/" -> RuntimeValue.decimal(x / y);
                case "%" -> RuntimeValue.decimal(x % y);
                default -> throw new InterpreterException(where, "Unknown arithmetic operator '" + op + "'.");
            };
        } else {
            long x = a.asLong();
            long y = b.asLong();
            return switch (op) {
                case "+" -> RuntimeValue.number(x + y);
                case "-" -> RuntimeValue.number(x - y);
                case "*" -> RuntimeValue.number(x * y);
                case "/" -> RuntimeValue.number(x / y);
                case "%" -> RuntimeValue.number(x % y);
                default -> throw new InterpreterException(where, "Unknown arithmetic operator '" + op + "'.");
            };
        }
    }

    private boolean compare(Token where, String op, RuntimeValue a, RuntimeValue b) {
        if (a.isNumeric() && b.isNumeric()) {
            double x = a.asDouble();
            double y = b.asDouble();
            return switch (op) {
                case "<" -> x < y;
                case ">" -> x > y;
                case "<=" -> x <= y;
                case ">=" -> x >= y;
                default -> throw new InterpreterException(where, "Unknown comparison operator '" + op + "'.");
            };
        }

        if (a.type == RuntimeValue.Type.STRING && b.type == RuntimeValue.Type.STRING) {
            int c = a.asString().compareTo(b.asString());
            return switch (op) {
                case "<" -> c < 0;
                case ">" -> c > 0;
                case "<=" -> c <= 0;
                case ">=" -> c >= 0;
                default -> throw new InterpreterException(where, "Unknown comparison operator '" + op + "'.");
            };
        }

        throw new InterpreterException(where, "Operator '" + op + "' cannot compare " + a.type + " and " + b.type + ".");
    }

    private boolean equalsValue(RuntimeValue a, RuntimeValue b) {
        if (a.isNumeric() && b.isNumeric()) {
            return a.asDouble() == b.asDouble();
        }
        return a.equals(b);
    }

    private String unescapeString(String quoted) {
        if (quoted == null || quoted.length() < 2) return "";
        String s = quoted.substring(1, quoted.length() - 1);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < s.length()) {
                char n = s.charAt(i + 1);
                switch (n) {
                    case 'b': out.append('\b'); break;
                    case 't': out.append('\t'); break;
                    case 'n': out.append('\n'); break;
                    case 'f': out.append('\f'); break;
                    case 'r': out.append('\r'); break;
                    case '"': out.append('"'); break;
                    case '\\': out.append('\\'); break;
                    default: out.append(n); break;
                }
                i++;
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    private static final class FunctionDef {
        final List<String> params;
        final WikangSawaParser.BlockContext body;

        FunctionDef(List<String> params, WikangSawaParser.BlockContext body) {
            this.params = params;
            this.body = body;
        }
    }

    private static final class StructureDef {
        final List<String> fieldOrder;
        final Map<String, WikangSawaParser.ExpressionContext> inits;

        StructureDef(List<String> fieldOrder, Map<String, WikangSawaParser.ExpressionContext> inits) {
            this.fieldOrder = fieldOrder;
            this.inits = inits;
        }
    }

    private static final class EnvFrame {
        final Map<String, RuntimeValue> vars = new LinkedHashMap<>();
        final java.util.Set<String> consts = new java.util.HashSet<>();
        final Map<String, Integer> addresses = new LinkedHashMap<>();
    }

    private static final class ReturnSignal extends RuntimeException {
        final RuntimeValue value;
        ReturnSignal(RuntimeValue value) { this.value = value; }
    }

    private void registerFunction(WikangSawaParser.FunctionDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (var id : ctx.paramList().IDENTIFIER()) {
                params.add(id.getText());
            }
        }
        functions.put(name, new FunctionDef(params, ctx.block()));
    }

    private RuntimeValue callFunction(Token where, String name, List<RuntimeValue> args) {
        FunctionDef def = functions.get(name);
        if (def == null) {
            throw new InterpreterException(where, "Function '" + name + "' is not declared.");
        }
        if (args.size() != def.params.size()) {
            throw new InterpreterException(where, "Function '" + name + "' expects " + def.params.size() + " argument(s), got " + args.size() + ".");
        }

        EnvFrame frame = new EnvFrame();
        for (int i = 0; i < def.params.size(); i++) {
            String param = def.params.get(i);
            frame.vars.put(param, args.get(i));
            frame.addresses.put(param, allocateAddress());
        }
        envStack.push(frame);
        try {
            executeBlock(def.body);
            return RuntimeValue.nullValue();
        } catch (ReturnSignal rs) {
            return rs.value;
        } finally {
            envStack.pop();
        }
    }

    private EnvFrame currentFrame() {
        return envStack.peek();
    }

    private static final class Lookup {
        final boolean exists;
        final EnvFrame frame;
        Lookup(boolean exists, EnvFrame frame) {
            this.exists = exists;
            this.frame = frame;
        }
    }

    private Lookup lookupEnv(String name) {
        for (EnvFrame frame : envStack) {
            if (frame.vars.containsKey(name)) return new Lookup(true, frame);
        }
        return new Lookup(false, null);
    }

    private RuntimeValue lookupValue(String name) {
        for (EnvFrame frame : envStack) {
            if (frame.vars.containsKey(name)) return frame.vars.get(name);
        }
        return null;
    }

    public List<MemoryCell> snapshotMemoryMap() {
        List<MemoryCell> out = new ArrayList<>();
        List<EnvFrame> frames = new ArrayList<>(envStack);
        for (int i = frames.size() - 1; i >= 0; i--) {
            EnvFrame frame = frames.get(i);
            for (Map.Entry<String, RuntimeValue> e : frame.vars.entrySet()) {
                String name = e.getKey();
                Integer addr = frame.addresses.get(name);
                String addrText = formatAddress(addr == null ? 0 : addr);
                String valueText = renderMemoryValue(e.getValue());
                out.add(new MemoryCell(name, addrText, valueText));
            }
        }
        return out;
    }

    private String renderMemoryValue(RuntimeValue v) {
        if (v.type == RuntimeValue.Type.REFERENCE) {
            Integer target = lookupAddress(v.refTargetName());
            if (target != null) {
                return formatAddress(target) + " (points to " + v.refTargetName() + ")";
            }
        }
        return v.toString();
    }

    private Integer lookupAddress(String name) {
        for (EnvFrame frame : envStack) {
            if (frame.addresses.containsKey(name)) return frame.addresses.get(name);
        }
        return null;
    }

    private int allocateAddress() {
        int addr = nextAddress;
        nextAddress += 4;
        return addr;
    }

    private String formatAddress(int addr) {
        return String.format("0x%04X", addr);
    }
}
