import java.util.*;
import org.antlr.v4.runtime.Token;

/**
 * Minimal semantic analyzer for demo:
 * - Symbol table (declared variables)
 * - Type inference for expressions
 * - Type checks for boolean/arithmetic/comparison operators
 * - Reports semantic errors with source locations when possible
 *
 * Note: This project’s generated parser contexts currently do not include
 * visitor-dispatch (`accept`) overrides (ANTLR generated without -visitor),
 * so this analyzer intentionally uses direct recursive analysis instead of
 * relying on ParseTreeVisitor dispatch.
 */
public class SemanticAnalyzer {

    public enum ValueType {
        NUMBER,
        DECIMAL,
        STRING,
        BOOLEAN,
        NULL,
        UNKNOWN
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

    private final Map<String, ValueType> symbols = new LinkedHashMap<>();
    private final List<SemanticError> errors = new ArrayList<>();

    // For demo stats
    private int checkedVarDecl = 0;
    private int checkedAssign = 0;
    private int checkedPrint = 0;
    private int checkedConditionals = 0;
    private int checkedLoops = 0;
    private int checkedExpressions = 0;

    public void analyze(WikangSawaParser.ProgramContext program) {
        analyzeProgram(program);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
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
            if (st.blockStatement() != null) {
                analyzeBlockStatement(st.blockStatement());
            }
        }
    }

    private void analyzeBlock(WikangSawaParser.BlockContext ctx) {
        for (WikangSawaParser.BlockStatementContext bs : ctx.blockStatement()) {
            analyzeBlockStatement(bs);
        }
    }

    private void analyzeBlockStatement(WikangSawaParser.BlockStatementContext ctx) {
        if (ctx.importStatement() != null) {
            // No semantic checks for imports in this demo.
            return;
        }
        if (ctx.variableDeclaration() != null) {
            analyzeVariableDeclaration(ctx.variableDeclaration());
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
        if (ctx.conditionalStatement() != null) {
            analyzeConditional(ctx.conditionalStatement());
            return;
        }
        if (ctx.loopStatement() != null) {
            analyzeLoop(ctx.loopStatement());
            return;
        }
    }

    private void analyzeVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx) {
        checkedVarDecl++;
        String name = ctx.IDENTIFIER().getText();
        if (symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is already declared.");
        }

        ValueType rhs = typeOfExpression(ctx.expression());
        symbols.put(name, rhs);
    }

    private void analyzeAssignment(WikangSawaParser.AssignmentStatementContext ctx) {
        checkedAssign++;
        String name = ctx.IDENTIFIER().getText();
        if (!symbols.containsKey(name)) {
            error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot assign).");
        }
        ValueType rhs = typeOfExpression(ctx.expression());
        // For demo: allow changing type, but warn via UNKNOWN handling is unnecessary.
        symbols.put(name, rhs);
    }

    private void analyzePrint(WikangSawaParser.PrintStatementContext ctx) {
        checkedPrint++;
        typeOfExpression(ctx.expression());
    }

    private void analyzeConditional(WikangSawaParser.ConditionalStatementContext ctx) {
        checkedConditionals++;
        ValueType cond = typeOfExpression(ctx.expression());
        requireBoolean(ctx.expression().getStart(), cond, "Condition in 'kung' must be boolean (totoo/mali or boolean expression).");
        if (ctx.block().size() > 0) analyzeBlock(ctx.block(0));
        if (ctx.block().size() > 1) analyzeBlock(ctx.block(1));
    }

    private void analyzeLoop(WikangSawaParser.LoopStatementContext ctx) {
        checkedLoops++;
        ValueType cond = typeOfExpression(ctx.expression());
        requireBoolean(ctx.expression().getStart(), cond, "Condition in 'habang' must be boolean (totoo/mali or boolean expression).");
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

        // == and != allow any types (including boolean/null/unknown) in this demo.
        if ("==".equals(op) || "!=".equals(op)) return ValueType.BOOLEAN;

        // Other comparisons require numeric with numeric or string with string.
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
            // Only numeric arithmetic for demo.
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

        ValueType base;
        if (ctx.literal() != null) {
            base = typeOfLiteral(ctx.literal());
        } else if (ctx.IDENTIFIER() != null) {
            String name = ctx.IDENTIFIER().getText();
            ValueType t = symbols.get(name);
            if (t == null) {
                error(ctx.IDENTIFIER().getSymbol(), "Variable '" + name + "' is not declared (cannot use in expression).");
                t = ValueType.UNKNOWN;
            }
            base = t;
        } else {
            // ( expression )
            base = typeOfExpression(ctx.expression());
        }

        if (ctx.MINUS() != null) {
            if (!isNumeric(base)) {
                error(ctx.getStart(), "Unary '-' requires a numeric operand, got " + base + ".");
            }
            return base;
        }
        return base;
    }

    private ValueType typeOfLiteral(WikangSawaParser.LiteralContext ctx) {
        checkedExpressions++;
        if (ctx.NUMERO() != null) return ValueType.NUMBER;
        if (ctx.DESIMAL() != null) return ValueType.DECIMAL;
        if (ctx.SALITA() != null) return ValueType.STRING;
        if (ctx.TOTOO() != null) return ValueType.BOOLEAN;
        if (ctx.MALI() != null) return ValueType.BOOLEAN;
        if (ctx.WALA() != null) return ValueType.NULL;
        return ValueType.UNKNOWN;
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

