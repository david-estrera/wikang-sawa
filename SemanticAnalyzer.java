import java.util.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Semantic analyzer: symbols, constants, structs, pointers (shallow), types.
 */
public class SemanticAnalyzer {

    public enum ValueType {
        NUMBER,
        DECIMAL,
        STRING,
        BOOLEAN,
        ARRAY,
        NULL,
        UNKNOWN,
        /** Result of &x */
        REF,
        /** Struct instance (bagong T() or variable holding struct) */
        STRUCT_INSTANCE
    }

    private static final class SemanticError {
        final int line;
        final int col;
        final String message;

        SemanticError(int line, int col, String message) {
            this.line = line;
            this.col = col;
            this.message = message;
        }
    }

    private static final class PrimaryTyping {
        final ValueType type;
        /** Struct type name if this value is a known struct instance */
        final String structName;

        PrimaryTyping(ValueType type, String structName) {
            this.type = type;
            this.structName = structName;
        }
    }

    private final Map<String, ValueType> symbols = new LinkedHashMap<>();
    private final Set<String> consts = new HashSet<>();
    /** variable or constant name -> struct type name */
    private final Map<String, String> varStructType = new LinkedHashMap<>();
    private final Map<String, Integer> functions = new LinkedHashMap<>();
    /** struct type name -> field -> type */
    private final Map<String, Map<String, ValueType>> structTypes = new LinkedHashMap<>();
    private final List<SemanticError> errors = new ArrayList<>();
    private final Map<String, ConstValue> constantValues = new LinkedHashMap<>();

    private int checkedVarDecl = 0;
    private int checkedAssign = 0;
    private int checkedPrint = 0;
    private int checkedConditionals = 0;
    private int checkedLoops = 0;
    private int checkedExpressions = 0;
    private int foldedConstants = 0;
    private int deadBranchesPruned = 0;
    private final List<String> foldEvents = new ArrayList<>();
    private final List<String> pruneEvents = new ArrayList<>();

    private static final class ConstValue {
        final ValueType type;
        final Object value;
        ConstValue(ValueType type, Object value) {
            this.type = type;
            this.value = value;
        }
    }

    public void analyze(WikangSawaParser.ProgramContext program) {
        analyzeProgram(program);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrorMessages() {
        List<String> out = new ArrayList<>();
        for (SemanticError e : errors) {
            out.add("line " + e.line + ":" + (e.col + 1) + " - " + e.message);
        }
        return out;
    }

    /** Structured errors for IDE / APIs. */
    public List<WikangSawaPipeline.Diagnostic> getDiagnostics() {
        List<WikangSawaPipeline.Diagnostic> out = new ArrayList<>();
        for (SemanticError e : errors) {
            out.add(new WikangSawaPipeline.Diagnostic(e.line, e.col + 1, e.message, "error"));
        }
        return out;
    }

    public void printReport() {
        System.out.println("----------------------------------------");
        System.out.println("  Semantic analysis (demo):");
        System.out.println("----------------------------------------");
        System.out.println("  Checks performed:");
        System.out.println("    Variable declarations checked: " + checkedVarDecl);
        System.out.println("    Assignments checked:           " + checkedAssign);
        System.out.println("    Print statements checked:      " + checkedPrint);
        System.out.println("    Conditionals checked:          " + checkedConditionals);
        System.out.println("    Loops checked:                 " + checkedLoops);
        System.out.println("    Expressions type-checked:      " + checkedExpressions);
        System.out.println("    Constant folds (semantic):     " + foldedConstants);
        System.out.println("    Dead branches pruned (kung):   " + deadBranchesPruned);
        if (!foldEvents.isEmpty() || !pruneEvents.isEmpty()) {
            System.out.println("  Optimization log:");
            for (String s : foldEvents) {
                System.out.println("    [Fold]  " + s);
            }
            for (String s : pruneEvents) {
                System.out.println("    [Prune] " + s);
            }
        }

        if (errors.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("  Result: Semantic checks passed (no errors).");
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("  Result: Semantic errors found: " + errors.size());
        for (int i = 0; i < errors.size(); i++) {
            SemanticError e = errors.get(i);
            System.out.println("    [" + (i + 1) + "] line " + e.line + ":" + (e.col + 1) + " - " + e.message);
        }
    }

    private void analyzeProgram(WikangSawaParser.ProgramContext ctx) {
        for (WikangSawaParser.StatementContext st : ctx.statement()) {
            if (st.blockStatement() != null && st.blockStatement().structureDeclaration() != null) {
                registerStructure(st.blockStatement().structureDeclaration());
            }
        }
        for (WikangSawaParser.StatementContext st : ctx.statement()) {
            if (st.blockStatement() != null) {
                analyzeBlockStatement(st.blockStatement());
            }
        }
    }

    private void registerStructure(WikangSawaParser.StructureDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        if (structTypes.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Struct '" + name + "' is already declared.");
            return;
        }
        Map<String, ValueType> fields = new LinkedHashMap<>();
        for (WikangSawaParser.StructFieldContext sf : ctx.structBlock().structField()) {
            String fn = sf.IDENTIFIER().getText();
            if (fields.containsKey(fn)) {
                error(sf.IDENTIFIER().getSymbol(), "Duplicate field '" + fn + "' in struct '" + name + "'.");
                continue;
            }
            fields.put(fn, typeOfExpression(sf.expression()));
        }
        structTypes.put(name, fields);
    }

    private void analyzeBlock(WikangSawaParser.BlockContext ctx) {
        for (WikangSawaParser.BlockStatementContext bs : ctx.blockStatement()) {
            analyzeBlockStatement(bs);
        }
    }

    private void analyzeBlockStatement(WikangSawaParser.BlockStatementContext ctx) {
        if (ctx.importStatement() != null) {
            return;
        }
        if (ctx.structureDeclaration() != null) {
            return;
        }
        if (ctx.functionDeclaration() != null) {
            analyzeFunctionDeclaration(ctx.functionDeclaration());
            return;
        }
        if (ctx.variableDeclaration() != null) {
            analyzeVariableDeclaration(ctx.variableDeclaration());
            return;
        }
        if (ctx.constantDeclaration() != null) {
            analyzeConstantDeclaration(ctx.constantDeclaration());
            return;
        }
        if (ctx.assignmentStatement() != null) {
            analyzeAssignment(ctx.assignmentStatement());
            return;
        }
        if (ctx.printStatement() != null) {
            analyzePrint(ctx.printStatement());
            return;
        }
        if (ctx.inputStatement() != null) {
            analyzeInputStatement(ctx.inputStatement());
            return;
        }
        if (ctx.returnStatement() != null) {
            typeOfExpression(ctx.returnStatement().expression());
            return;
        }
        if (ctx.conditionalStatement() != null) {
            analyzeConditional(ctx.conditionalStatement());
            return;
        }
        if (ctx.loopStatement() != null) {
            analyzeLoop(ctx.loopStatement());
            return;
        }
        if (ctx.countLoopStatement() != null) {
            analyzeCountLoop(ctx.countLoopStatement());
            return;
        }
        if (ctx.repeatUntilStatement() != null) {
            analyzeRepeatUntil(ctx.repeatUntilStatement());
            return;
        }
        if (ctx.eventLineLoopStatement() != null) {
            analyzeEventLineLoop(ctx.eventLineLoopStatement());
            return;
        }
    }

    private void analyzeFunctionDeclaration(WikangSawaParser.FunctionDeclarationContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        int arity = 0;
        if (ctx.paramList() != null) arity = ctx.paramList().IDENTIFIER().size();
        if (functions.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Function '" + name + "' is already declared.");
            return;
        }
        functions.put(name, arity);

        Map<String, ValueType> savedSym = new LinkedHashMap<>(symbols);
        Set<String> savedConst = new HashSet<>(consts);
        Map<String, String> savedVS = new LinkedHashMap<>(varStructType);

        if (ctx.paramList() != null) {
            for (var id : ctx.paramList().IDENTIFIER()) {
                symbols.put(id.getText(), ValueType.UNKNOWN);
            }
        }
        analyzeBlock(ctx.block());

        symbols.clear();
        symbols.putAll(savedSym);
        consts.clear();
        consts.addAll(savedConst);
        varStructType.clear();
        varStructType.putAll(savedVS);
    }

    private void analyzeVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx) {
        checkedVarDecl++;
        String name = ctx.IDENTIFIER().getText();
        if (symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is already declared.");
        }
        ValueType rhs = typeOfExpression(ctx.expression());
        symbols.put(name, rhs);
        constantValues.remove(name);
        String sn = extractBagongStructName(ctx.expression());
        if (sn != null) varStructType.put(name, sn);
    }

    private void analyzeConstantDeclaration(WikangSawaParser.ConstantDeclarationContext ctx) {
        checkedVarDecl++;
        String name = ctx.IDENTIFIER().getText();
        if (symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Constant '" + name + "' conflicts with an existing declaration.");
            return;
        }
        ValueType rhs = typeOfExpression(ctx.expression());
        symbols.put(name, rhs);
        consts.add(name);
        ConstValue cv = evaluateConstExpression(ctx.expression());
        if (cv != null) {
            constantValues.put(name, cv);
            foldedConstants++;
            foldEvents.add("line " + ctx.getStart().getLine() + ": konstant " + name + " = "
                + ctx.expression().getText() + " -> " + constValueToText(cv));
        }
        String sn = extractBagongStructName(ctx.expression());
        if (sn != null) varStructType.put(name, sn);
    }

    private void analyzeAssignment(WikangSawaParser.AssignmentStatementContext ctx) {
        checkedAssign++;
        ValueType rhs = typeOfExpression(ctx.expression());

        if (ctx.STAR() != null) {
            String ptrName = ctx.IDENTIFIER().getText();
            if (!symbols.containsKey(ptrName)) {
                error(ctx.IDENTIFIER().getSymbol(), "Variable '" + ptrName + "' is not declared (cannot assign through pointer).");
                return;
            }
            ValueType pt = symbols.get(ptrName);
            if (pt != ValueType.REF && pt != ValueType.UNKNOWN) {
                error(ctx.IDENTIFIER().getSymbol(), "Pointer assignment requires a pointer variable, got " + pt + ".");
            }
            return;
        }

        String name = ctx.IDENTIFIER().getText();
        if (!symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot assign).");
            return;
        }
        if (consts.contains(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Cannot assign to constant '" + name + "'.");
            return;
        }
        symbols.put(name, rhs);
        constantValues.remove(name);
        String sn = extractBagongStructName(ctx.expression());
        if (sn != null) varStructType.put(name, sn);
        else varStructType.remove(name);
    }

    private void analyzePrint(WikangSawaParser.PrintStatementContext ctx) {
        checkedPrint++;
        typeOfExpression(ctx.expression());
    }

    private void analyzeInputStatement(WikangSawaParser.InputStatementContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        if (!symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (magbasa requires prior baryabol).");
            return;
        }
        if (consts.contains(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Cannot read into constant '" + name + "'.");
        }
    }

    private void analyzeConditional(WikangSawaParser.ConditionalStatementContext ctx) {
        checkedConditionals++;
        ValueType cond = typeOfExpression(ctx.expression());
        requireBoolean(ctx.expression().getStart(), cond, "Condition in 'kung' must be boolean (totoo/mali or boolean expression).");
        ConstValue c = evaluateConstExpression(ctx.expression());
        if (c != null && c.type == ValueType.BOOLEAN) {
            boolean b = (boolean) c.value;
            deadBranchesPruned++;
            pruneEvents.add("line " + ctx.getStart().getLine() + ": kung " + ctx.expression().getText()
                + " is constant " + (b ? "totoo" : "mali")
                + " (pruned " + (b ? "kundi" : "then") + " branch)");
            if (b) {
                if (ctx.block().size() > 0) analyzeBlock(ctx.block(0));
            } else {
                if (ctx.block().size() > 1) analyzeBlock(ctx.block(1));
            }
            return;
        }
        if (ctx.block().size() > 0) analyzeBlock(ctx.block(0));
        if (ctx.block().size() > 1) analyzeBlock(ctx.block(1));
    }

    private void analyzeLoop(WikangSawaParser.LoopStatementContext ctx) {
        checkedLoops++;
        ValueType cond = typeOfExpression(ctx.expression());
        requireBoolean(ctx.expression().getStart(), cond, "Condition in 'habang' must be boolean (totoo/mali or boolean expression).");
        analyzeBlock(ctx.block());
    }

    private void analyzeCountLoop(WikangSawaParser.CountLoopStatementContext ctx) {
        checkedLoops++;
        String var = ctx.IDENTIFIER().getText();
        if (!symbols.containsKey(var)) {
            error(ctx.IDENTIFIER().getSymbol(), "Loop variable '" + var + "' must be declared before 'para'.");
        }
        if (consts.contains(var)) {
            error(ctx.IDENTIFIER().getSymbol(), "Cannot use constant '" + var + "' as 'para' loop variable.");
        }
        ValueType a = typeOfExpression(ctx.expression(0));
        ValueType b = typeOfExpression(ctx.expression(1));
        if (!isNumeric(a) || !isNumeric(b)) {
            error(ctx.getStart(), "'para' bounds must be numeric, got " + a + " .. " + b + ".");
        }
        analyzeBlock(ctx.block());
    }

    private void analyzeRepeatUntil(WikangSawaParser.RepeatUntilStatementContext ctx) {
        checkedLoops++;
        analyzeBlock(ctx.block());
        ValueType cond = typeOfExpression(ctx.expression());
        requireBoolean(ctx.expression().getStart(), cond, "Condition in 'hanggang' must be boolean.");
    }

    private void analyzeEventLineLoop(WikangSawaParser.EventLineLoopStatementContext ctx) {
        checkedLoops++;
        analyzeBlock(ctx.block());
    }

    private ValueType typeOfExpression(WikangSawaParser.ExpressionContext ctx) {
        checkedExpressions++;
        ValueType t = typeOfAndExpression(ctx.andExpression(0));
        for (int i = 1; i < ctx.andExpression().size(); i++) {
            ValueType r = typeOfAndExpression(ctx.andExpression(i));
            requireBoolean(ctx.getStart(), t, "Left side of 'o' must be boolean.");
            requireBoolean(ctx.getStart(), r, "Right side of 'o' must be boolean.");
            t = ValueType.BOOLEAN;
        }
        return t;
    }

    private ValueType typeOfAndExpression(WikangSawaParser.AndExpressionContext ctx) {
        checkedExpressions++;
        ValueType t = typeOfNotExpression(ctx.notExpression(0));
        for (int i = 1; i < ctx.notExpression().size(); i++) {
            ValueType r = typeOfNotExpression(ctx.notExpression(i));
            requireBoolean(ctx.getStart(), t, "Left side of 'at' must be boolean.");
            requireBoolean(ctx.getStart(), r, "Right side of 'at' must be boolean.");
            t = ValueType.BOOLEAN;
        }
        return t;
    }

    private ValueType typeOfNotExpression(WikangSawaParser.NotExpressionContext ctx) {
        checkedExpressions++;
        if (ctx.HINDI() != null) {
            ValueType inner = typeOfNotExpression(ctx.notExpression());
            requireBoolean(ctx.getStart(), inner, "Operand of 'hindi' must be boolean.");
            return ValueType.BOOLEAN;
        }
        return typeOfComparisonExpression(ctx.comparisonExpression());
    }

    private ValueType typeOfComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx) {
        checkedExpressions++;
        ValueType left = typeOfArithmeticExpression(ctx.arithmeticExpression(0));
        if (ctx.relOp() == null) return left;

        ValueType right = typeOfArithmeticExpression(ctx.arithmeticExpression(1));
        String op = ctx.relOp().getText();

        if ("==".equals(op) || "!=".equals(op)) return ValueType.BOOLEAN;

        if (isNumeric(left) && isNumeric(right)) return ValueType.BOOLEAN;
        if (left == ValueType.STRING && right == ValueType.STRING) return ValueType.BOOLEAN;

        error(ctx.getStart(), "Operator '" + op + "' cannot compare types " + left + " and " + right + ".");
        return ValueType.BOOLEAN;
    }

    private ValueType typeOfArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx) {
        checkedExpressions++;
        ValueType t = typeOfTerm(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            ValueType r = typeOfTerm(ctx.term(i));
            if (!isNumeric(t) || !isNumeric(r)) {
                error(ctx.getStart(), "Arithmetic operator requires numeric operands, got " + t + " and " + r + ".");
            }
            t = promoteNumeric(t, r);
        }
        return t;
    }

    private ValueType typeOfTerm(WikangSawaParser.TermContext ctx) {
        checkedExpressions++;
        ValueType t = typeOfFactor(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            ValueType r = typeOfFactor(ctx.factor(i));
            if (!isNumeric(t) || !isNumeric(r)) {
                error(ctx.getStart(), "Term operator requires numeric operands, got " + t + " and " + r + ".");
            }
            t = promoteNumeric(t, r);
        }
        return t;
    }

    private ValueType typeOfFactor(WikangSawaParser.FactorContext ctx) {
        checkedExpressions++;
        if (ctx.STAR() != null) {
            ValueType inner = typeOfPostfix(ctx.postfix());
            if (inner != ValueType.REF && inner != ValueType.UNKNOWN) {
                error(ctx.getStart(), "Unary '*' expects a pointer operand, got " + inner + ".");
            }
            return ValueType.UNKNOWN;
        }
        ValueType base = typeOfPostfix(ctx.postfix());
        if (ctx.MINUS() != null) {
            if (!isNumeric(base)) {
                error(ctx.getStart(), "Unary '-' requires a numeric operand, got " + base + ".");
            }
            return base;
        }
        return base;
    }

    private ValueType typeOfPostfix(WikangSawaParser.PostfixContext ctx) {
        checkedExpressions++;
        PrimaryTyping pt = typeOfPrimaryDetailed(ctx.primary());
        ValueType base = pt.type;
        String structName = pt.structName;

        List<ParseTree> ch = ctx.children;
        for (int i = 0; i < ch.size(); i++) {
            ParseTree c = ch.get(i);
            if (c instanceof WikangSawaParser.PrimaryContext) {
                continue;
            }
            if (!(c instanceof TerminalNode tn)) {
                continue;
            }
            int tt = tn.getSymbol().getType();
            if (tt == WikangSawaParser.DOT) {
                TerminalNode idNode = (TerminalNode) ch.get(i + 1);
                String field = idNode.getText();
                i++;
                if (structName != null) {
                    Map<String, ValueType> fmap = structTypes.get(structName);
                    if (fmap == null || !fmap.containsKey(field)) {
                        error(idNode.getSymbol(), "Struct '" + structName + "' has no field '" + field + "'.");
                        base = ValueType.UNKNOWN;
                    } else {
                        base = fmap.get(field);
                    }
                    structName = null;
                } else if (base == ValueType.STRUCT_INSTANCE || base == ValueType.UNKNOWN) {
                    base = ValueType.UNKNOWN;
                } else {
                    error(idNode.getSymbol(), "Field access requires a struct, got " + base + ".");
                    base = ValueType.UNKNOWN;
                }
            } else if (tt == WikangSawaParser.LBRACKET) {
                WikangSawaParser.ExpressionContext ex = (WikangSawaParser.ExpressionContext) ch.get(i + 1);
                ValueType it = typeOfExpression(ex);
                if (!isNumeric(it)) {
                    error(ex.getStart(), "Array index must be numeric, got " + it + ".");
                }
                base = ValueType.UNKNOWN;
                structName = null;
                i += 2;
            }
        }
        return base;
    }

    private ValueType typeOfPrimary(WikangSawaParser.PrimaryContext ctx) {
        return typeOfPrimaryDetailed(ctx).type;
    }

    private PrimaryTyping typeOfPrimaryDetailed(WikangSawaParser.PrimaryContext ctx) {
        checkedExpressions++;
        if (ctx.literal() != null) {
            return new PrimaryTyping(typeOfLiteral(ctx.literal()), null);
        }
        if (ctx.arrayLiteral() != null) {
            for (var e : ctx.arrayLiteral().expression()) typeOfExpression(e);
            return new PrimaryTyping(ValueType.ARRAY, null);
        }
        if (ctx.expression() != null) {
            ValueType t = typeOfExpression(ctx.expression());
            return new PrimaryTyping(t, null);
        }
        if (ctx.BAGONG() != null) {
            String tname = ctx.IDENTIFIER().getText();
            if (!structTypes.containsKey(tname)) {
                error(ctx.IDENTIFIER().getSymbol(), "Struct type '" + tname + "' is not declared.");
                return new PrimaryTyping(ValueType.STRUCT_INSTANCE, tname);
            }
            return new PrimaryTyping(ValueType.STRUCT_INSTANCE, tname);
        }
        if (ctx.AMPERSAND() != null) {
            String name = ctx.IDENTIFIER().getText();
            if (!symbols.containsKey(name)) {
                error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot take address).");
            }
            return new PrimaryTyping(ValueType.REF, null);
        }
        if (ctx.IDENTIFIER() != null) {
            String name = ctx.IDENTIFIER().getText();
            if (ctx.LPAREN() != null) {
                int arity = 0;
                if (ctx.argList() != null) arity = ctx.argList().expression().size();
                Integer expected = functions.get(name);
                if (expected == null) {
                    error(ctx.IDENTIFIER().getSymbol(), "Function '" + name + "' is not declared.");
                } else if (expected != arity) {
                    error(ctx.IDENTIFIER().getSymbol(), "Function '" + name + "' expects " + expected + " argument(s), got " + arity + ".");
                }
                if (ctx.argList() != null) {
                    for (var e : ctx.argList().expression()) typeOfExpression(e);
                }
                return new PrimaryTyping(ValueType.UNKNOWN, null);
            }
            ValueType t = symbols.get(name);
            if (t == null) {
                error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot use in expression).");
                return new PrimaryTyping(ValueType.UNKNOWN, null);
            }
            String sn = varStructType.get(name);
            if (sn != null) {
                return new PrimaryTyping(ValueType.STRUCT_INSTANCE, sn);
            }
            return new PrimaryTyping(t, null);
        }
        return new PrimaryTyping(ValueType.UNKNOWN, null);
    }

    private ValueType typeOfLiteral(WikangSawaParser.LiteralContext ctx) {
        if (ctx.NUMERO() != null) return ValueType.NUMBER;
        if (ctx.DESIMAL() != null) return ValueType.DECIMAL;
        if (ctx.SALITA() != null) return ValueType.STRING;
        if (ctx.TOTOO() != null) return ValueType.BOOLEAN;
        if (ctx.MALI() != null) return ValueType.BOOLEAN;
        if (ctx.WALA() != null) return ValueType.NULL;
        return ValueType.UNKNOWN;
    }

    private ConstValue evaluateConstExpression(WikangSawaParser.ExpressionContext ctx) {
        if (ctx == null) return null;
        if (ctx.andExpression().isEmpty()) return null;
        ConstValue left = evalConstAnd(ctx.andExpression(0));
        if (left == null) return null;
        for (int i = 1; i < ctx.andExpression().size(); i++) {
            ConstValue right = evalConstAnd(ctx.andExpression(i));
            if (right == null) return null;
            if (left.type != ValueType.BOOLEAN || right.type != ValueType.BOOLEAN) return null;
            left = new ConstValue(ValueType.BOOLEAN, ((boolean) left.value) || ((boolean) right.value));
        }
        return left;
    }

    private ConstValue evalConstAnd(WikangSawaParser.AndExpressionContext ctx) {
        ConstValue left = evalConstNot(ctx.notExpression(0));
        if (left == null) return null;
        for (int i = 1; i < ctx.notExpression().size(); i++) {
            ConstValue right = evalConstNot(ctx.notExpression(i));
            if (right == null) return null;
            if (left.type != ValueType.BOOLEAN || right.type != ValueType.BOOLEAN) return null;
            left = new ConstValue(ValueType.BOOLEAN, ((boolean) left.value) && ((boolean) right.value));
        }
        return left;
    }

    private ConstValue evalConstNot(WikangSawaParser.NotExpressionContext ctx) {
        if (ctx.HINDI() != null) {
            ConstValue inner = evalConstNot(ctx.notExpression());
            if (inner == null || inner.type != ValueType.BOOLEAN) return null;
            return new ConstValue(ValueType.BOOLEAN, !((boolean) inner.value));
        }
        return evalConstComparison(ctx.comparisonExpression());
    }

    private ConstValue evalConstComparison(WikangSawaParser.ComparisonExpressionContext ctx) {
        ConstValue left = evalConstArithmetic(ctx.arithmeticExpression(0));
        if (left == null) return null;
        if (ctx.relOp() == null) return left;
        ConstValue right = evalConstArithmetic(ctx.arithmeticExpression(1));
        if (right == null) return null;
        String op = ctx.relOp().getText();
        if ("==".equals(op) || "!=".equals(op)) {
            boolean eq;
            if (isNumericConst(left) && isNumericConst(right)) {
                eq = asDouble(left) == asDouble(right);
            } else {
                eq = Objects.equals(left.value, right.value) && left.type == right.type;
            }
            return new ConstValue(ValueType.BOOLEAN, "==".equals(op) ? eq : !eq);
        }
        if (isNumericConst(left) && isNumericConst(right)) {
            double a = asDouble(left);
            double b = asDouble(right);
            return switch (op) {
                case "<" -> new ConstValue(ValueType.BOOLEAN, a < b);
                case ">" -> new ConstValue(ValueType.BOOLEAN, a > b);
                case "<=" -> new ConstValue(ValueType.BOOLEAN, a <= b);
                case ">=" -> new ConstValue(ValueType.BOOLEAN, a >= b);
                default -> null;
            };
        }
        return null;
    }

    private ConstValue evalConstArithmetic(WikangSawaParser.ArithmeticExpressionContext ctx) {
        ConstValue acc = evalConstTerm(ctx.term(0));
        if (acc == null) return null;
        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            ConstValue rhs = evalConstTerm(ctx.term(i));
            if (rhs == null || !isNumericConst(acc) || !isNumericConst(rhs)) return null;
            double a = asDouble(acc);
            double b = asDouble(rhs);
            boolean dec = isDecimalConst(acc) || isDecimalConst(rhs);
            double v = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                default -> Double.NaN;
            };
            if (Double.isNaN(v)) return null;
            acc = dec ? new ConstValue(ValueType.DECIMAL, v) : new ConstValue(ValueType.NUMBER, (long) v);
        }
        return acc;
    }

    private ConstValue evalConstTerm(WikangSawaParser.TermContext ctx) {
        ConstValue acc = evalConstFactor(ctx.factor(0));
        if (acc == null) return null;
        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            ConstValue rhs = evalConstFactor(ctx.factor(i));
            if (rhs == null || !isNumericConst(acc) || !isNumericConst(rhs)) return null;
            double a = asDouble(acc);
            double b = asDouble(rhs);
            boolean dec = isDecimalConst(acc) || isDecimalConst(rhs);
            double v = switch (op) {
                case "*" -> a * b;
                case "/" -> a / b;
                case "%" -> a % b;
                default -> Double.NaN;
            };
            if (Double.isNaN(v)) return null;
            acc = dec ? new ConstValue(ValueType.DECIMAL, v) : new ConstValue(ValueType.NUMBER, (long) v);
        }
        return acc;
    }

    private ConstValue evalConstFactor(WikangSawaParser.FactorContext ctx) {
        if (ctx.STAR() != null) return null;
        ConstValue base = evalConstPostfix(ctx.postfix());
        if (base == null) return null;
        if (ctx.MINUS() != null) {
            if (!isNumericConst(base)) return null;
            if (isDecimalConst(base)) return new ConstValue(ValueType.DECIMAL, -asDouble(base));
            return new ConstValue(ValueType.NUMBER, -((long) base.value));
        }
        return base;
    }

    private ConstValue evalConstPostfix(WikangSawaParser.PostfixContext ctx) {
        // Keep folding conservative: only plain primaries (no [] or . access)
        if (ctx.children != null) {
            for (ParseTree ch : ctx.children) {
                if (ch instanceof TerminalNode tn) {
                    int tt = tn.getSymbol().getType();
                    if (tt == WikangSawaParser.DOT || tt == WikangSawaParser.LBRACKET) return null;
                }
            }
        }
        return evalConstPrimary(ctx.primary());
    }

    private ConstValue evalConstPrimary(WikangSawaParser.PrimaryContext ctx) {
        if (ctx.literal() != null) {
            if (ctx.literal().NUMERO() != null) return new ConstValue(ValueType.NUMBER, Long.parseLong(ctx.literal().NUMERO().getText()));
            if (ctx.literal().DESIMAL() != null) return new ConstValue(ValueType.DECIMAL, Double.parseDouble(ctx.literal().DESIMAL().getText()));
            if (ctx.literal().TOTOO() != null) return new ConstValue(ValueType.BOOLEAN, true);
            if (ctx.literal().MALI() != null) return new ConstValue(ValueType.BOOLEAN, false);
            if (ctx.literal().SALITA() != null) return new ConstValue(ValueType.STRING, ctx.literal().SALITA().getText());
            if (ctx.literal().WALA() != null) return new ConstValue(ValueType.NULL, null);
            return null;
        }
        if (ctx.expression() != null) return evaluateConstExpression(ctx.expression());
        if (ctx.IDENTIFIER() != null && ctx.LPAREN() == null) {
            return constantValues.get(ctx.IDENTIFIER().getText());
        }
        return null;
    }

    private boolean isNumericConst(ConstValue v) {
        return v.type == ValueType.NUMBER || v.type == ValueType.DECIMAL;
    }

    private boolean isDecimalConst(ConstValue v) {
        return v.type == ValueType.DECIMAL;
    }

    private double asDouble(ConstValue v) {
        if (v.type == ValueType.DECIMAL) return (double) v.value;
        return (double) ((long) v.value);
    }

    private String constValueToText(ConstValue v) {
        if (v == null) return "<?>"; 
        return switch (v.type) {
            case NUMBER -> Long.toString((long) v.value);
            case DECIMAL -> Double.toString((double) v.value);
            case BOOLEAN -> ((boolean) v.value) ? "totoo" : "mali";
            case STRING -> "\"" + v.value + "\"";
            case NULL -> "wala";
            default -> String.valueOf(v.value);
        };
    }

    /** If expression is exactly `bagong Type()`, return Type; else null. */
    private String extractBagongStructName(WikangSawaParser.ExpressionContext ctx) {
        try {
            WikangSawaParser.PrimaryContext p = ctx.andExpression(0).notExpression(0).comparisonExpression()
                .arithmeticExpression(0).term(0).factor(0).postfix().primary();
            if (p.BAGONG() != null) return p.IDENTIFIER().getText();
        } catch (Exception ignored) {
        }
        return null;
    }

    private void requireBoolean(Token where, ValueType actual, String message) {
        if (actual != ValueType.BOOLEAN && actual != ValueType.UNKNOWN) {
            error(where, message + " Got " + actual + ".");
        }
    }

    private boolean isNumeric(ValueType t) {
        return t == ValueType.NUMBER || t == ValueType.DECIMAL || t == ValueType.UNKNOWN;
    }

    private ValueType promoteNumeric(ValueType a, ValueType b) {
        if (a == ValueType.DECIMAL || b == ValueType.DECIMAL) return ValueType.DECIMAL;
        if (a == ValueType.UNKNOWN || b == ValueType.UNKNOWN) return ValueType.UNKNOWN;
        return ValueType.NUMBER;
    }

    private void error(Token where, String message) {
        int line = where != null ? where.getLine() : 0;
        int col = where != null ? where.getCharPositionInLine() : 0;
        errors.add(new SemanticError(line, col, message));
    }
}
