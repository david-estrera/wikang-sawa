import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.Token;

public class Interpreter {
    private final Map<String, FunctionDef> functions = new LinkedHashMap<>();
    private final Deque<Map<String, RuntimeValue>> envStack = new ArrayDeque<>();
    private final int maxLoopIterations;

    public Interpreter() {
        this(1_000_000);
    }

    public Interpreter(int maxLoopIterations) {
        this.maxLoopIterations = maxLoopIterations;
        this.envStack.push(new LinkedHashMap<>()); // global frame
    }

    public void execute(WikangSawaParser.ProgramContext program) {
        // First pass: collect function declarations (so recursion works regardless of order)
        for (WikangSawaParser.StatementContext st : program.statement()) {
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

    private void executeBlock(WikangSawaParser.BlockContext block) {
        for (WikangSawaParser.BlockStatementContext bs : block.blockStatement()) {
            executeBlockStatement(bs);
        }
    }

    private void executeBlockStatement(WikangSawaParser.BlockStatementContext bs) {
        if (bs.importStatement() != null) {
            // No-op for now (no module system implemented)
            return;
        }
        if (bs.functionDeclaration() != null) {
            // Already registered in the first pass. No-op at runtime.
            return;
        }
        if (bs.variableDeclaration() != null) {
            execVarDecl(bs.variableDeclaration());
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
        }
    }

    private void execVarDecl(WikangSawaParser.VariableDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        RuntimeValue value = evalExpression(ctx.expression());
        // Keep interpreter strict and simple: treat redeclare as runtime error.
        if (currentEnv().containsKey(name)) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is already declared.");
        }
        currentEnv().put(name, value);
    }

    private void execAssign(WikangSawaParser.AssignmentStatementContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        if (!lookupEnv(name).exists) {
            throw new InterpreterException(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot assign).");
        }
        RuntimeValue value = evalExpression(ctx.expression());
        // Assign into nearest scope where declared.
        lookupEnv(name).frame.put(name, value);
    }

    private void execPrint(WikangSawaParser.PrintStatementContext ctx) {
        RuntimeValue v = evalExpression(ctx.expression());
        System.out.println(v.toString());
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

    // ===== Expression evaluation (mirrors WikangSawaParser.g4 precedence) =====

    private RuntimeValue evalExpression(WikangSawaParser.ExpressionContext ctx) {
        // OR: andExpression (O andExpression)*
        RuntimeValue left = evalAndExpression(ctx.andExpression(0));
        for (int i = 1; i < ctx.andExpression().size(); i++) {
            boolean l = requireBoolean(ctx.getStart(), left, "Left side of 'o' must be boolean.");
            if (l) return RuntimeValue.bool(true); // short-circuit
            RuntimeValue right = evalAndExpression(ctx.andExpression(i));
            boolean r = requireBoolean(ctx.getStart(), right, "Right side of 'o' must be boolean.");
            left = RuntimeValue.bool(r);
        }
        return left;
    }

    private RuntimeValue evalAndExpression(WikangSawaParser.AndExpressionContext ctx) {
        // AND: notExpression (AT notExpression)*
        RuntimeValue left = evalNotExpression(ctx.notExpression(0));
        for (int i = 1; i < ctx.notExpression().size(); i++) {
            boolean l = requireBoolean(ctx.getStart(), left, "Left side of 'at' must be boolean.");
            if (!l) return RuntimeValue.bool(false); // short-circuit
            RuntimeValue right = evalNotExpression(ctx.notExpression(i));
            boolean r = requireBoolean(ctx.getStart(), right, "Right side of 'at' must be boolean.");
            left = RuntimeValue.bool(r);
        }
        return left;
    }

    private RuntimeValue evalNotExpression(WikangSawaParser.NotExpressionContext ctx) {
        // NOT: HINDI notExpression | comparisonExpression
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

        switch (op) {
            case "==":
                return RuntimeValue.bool(equalsValue(left, right));
            case "!=":
                return RuntimeValue.bool(!equalsValue(left, right));
            case "<":
            case ">":
            case "<=":
            case ">=":
                return RuntimeValue.bool(compare(ctx.getStart(), op, left, right));
            default:
                throw new InterpreterException(ctx.getStart(), "Unknown comparison operator '" + op + "'.");
        }
    }

    private RuntimeValue evalArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx) {
        RuntimeValue acc = evalTerm(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            RuntimeValue rhs = evalTerm(ctx.term(i));
            // Operator token is interleaved: term ((PLUS|MINUS) term)*
            String op = ctx.getChild(2 * i - 1).getText();
            acc = arithmetic(ctx.getStart(), op, acc, rhs);
        }
        return acc;
    }

    private RuntimeValue evalTerm(WikangSawaParser.TermContext ctx) {
        RuntimeValue acc = evalFactor(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            RuntimeValue rhs = evalFactor(ctx.factor(i));
            String op = ctx.getChild(2 * i - 1).getText(); // *, /, %
            acc = arithmetic(ctx.getStart(), op, acc, rhs);
        }
        return acc;
    }

    private RuntimeValue evalFactor(WikangSawaParser.FactorContext ctx) {
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

    private RuntimeValue evalPostfix(WikangSawaParser.PostfixContext ctx) {
        RuntimeValue base = evalPrimary(ctx.primary());
        // Apply indexing: primary ('[' expression ']')*
        for (int i = 0; i < ctx.expression().size(); i++) {
            RuntimeValue idxV = evalExpression(ctx.expression(i));
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
        }
        return base;
    }

    private RuntimeValue evalPrimary(WikangSawaParser.PrimaryContext ctx) {
        if (ctx.literal() != null) return evalLiteral(ctx.literal());
        if (ctx.arrayLiteral() != null) return evalArrayLiteral(ctx.arrayLiteral());
        if (ctx.expression() != null) return evalExpression(ctx.expression()); // parenthesized

        // IDENTIFIER ( '(' argList? ')' )?
        if (ctx.IDENTIFIER() != null) {
            String name = ctx.IDENTIFIER().getText();
            if (ctx.LPAREN() != null) {
                // function call
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

    private RuntimeValue evalArrayLiteral(WikangSawaParser.ArrayLiteralContext ctx) {
        List<RuntimeValue> values = new ArrayList<>();
        for (WikangSawaParser.ExpressionContext e : ctx.expression()) {
            values.add(evalExpression(e));
        }
        return RuntimeValue.array(values);
    }

    private RuntimeValue evalLiteral(WikangSawaParser.LiteralContext ctx) {
        if (ctx.NUMERO() != null) {
            long v = Long.parseLong(ctx.NUMERO().getText());
            return RuntimeValue.number(v);
        }
        if (ctx.DESIMAL() != null) {
            double v = Double.parseDouble(ctx.DESIMAL().getText());
            return RuntimeValue.decimal(v);
        }
        if (ctx.SALITA() != null) {
            return RuntimeValue.string(unescapeString(ctx.SALITA().getText()));
        }
        if (ctx.TOTOO() != null) return RuntimeValue.bool(true);
        if (ctx.MALI() != null) return RuntimeValue.bool(false);
        if (ctx.WALA() != null) return RuntimeValue.nullValue();
        throw new InterpreterException(ctx.getStart(), "Unknown literal.");
    }

    // ===== Helpers =====

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
        // numeric vs numeric
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

        // string vs string
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
        // Allow numeric equality across NUMBER/DECIMAL by value.
        if (a.isNumeric() && b.isNumeric()) {
            return a.asDouble() == b.asDouble();
        }
        // Otherwise, require same type/value.
        return a.equals(b);
    }

    private String unescapeString(String quoted) {
        // Token text includes quotes per lexer rule SALITA.
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

    // ===== Functions / recursion =====

    private static final class FunctionDef {
        final List<String> params;
        final WikangSawaParser.BlockContext body;

        FunctionDef(List<String> params, WikangSawaParser.BlockContext body) {
            this.params = params;
            this.body = body;
        }
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

        Map<String, RuntimeValue> frame = new LinkedHashMap<>();
        for (int i = 0; i < def.params.size(); i++) {
            frame.put(def.params.get(i), args.get(i));
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

    private Map<String, RuntimeValue> currentEnv() {
        return envStack.peek();
    }

    private static final class Lookup {
        final boolean exists;
        final Map<String, RuntimeValue> frame;
        Lookup(boolean exists, Map<String, RuntimeValue> frame) {
            this.exists = exists;
            this.frame = frame;
        }
    }

    private Lookup lookupEnv(String name) {
        for (Map<String, RuntimeValue> frame : envStack) {
            if (frame.containsKey(name)) return new Lookup(true, frame);
        }
        return new Lookup(false, null);
    }

    private RuntimeValue lookupValue(String name) {
        for (Map<String, RuntimeValue> frame : envStack) {
            if (frame.containsKey(name)) return frame.get(name);
        }
        return null;
    }
}

