import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;

public class ConstructRecognizer extends WikangSawaParserBaseVisitor<Void> {
    private int indentLevel = 0;
    private int counter = 0;

    private int countImport = 0, countVarDecl = 0, countConst = 0, countAssign = 0, countPrint = 0;
    private int countInput = 0, countConditional = 0, countLoop = 0, countPara = 0, countGawin = 0;
    private int countEvent = 0, countStruct = 0, countFunc = 0;

    @Override
    public Void visitProgram(WikangSawaParser.ProgramContext ctx) {
        int n = ctx.statement().size();
        for (int i = 0; i < n; i++) {
            WikangSawaParser.StatementContext st = ctx.statement(i);
            WikangSawaParser.BlockStatementContext bs = st.blockStatement();
            if (bs != null) {
                dispatchBlockStatement(bs);
            }
        }
        return null;
    }

    private void dispatchBlockStatement(WikangSawaParser.BlockStatementContext bs) {
        if (bs.importStatement() != null) visitImportStatement(bs.importStatement());
        else if (bs.structureDeclaration() != null) visitStructureDeclaration(bs.structureDeclaration());
        else if (bs.functionDeclaration() != null) visitFunctionDeclaration(bs.functionDeclaration());
        else if (bs.variableDeclaration() != null) visitVariableDeclaration(bs.variableDeclaration());
        else if (bs.constantDeclaration() != null) visitConstantDeclaration(bs.constantDeclaration());
        else if (bs.assignmentStatement() != null) visitAssignmentStatement(bs.assignmentStatement());
        else if (bs.printStatement() != null) visitPrintStatement(bs.printStatement());
        else if (bs.inputStatement() != null) visitInputStatement(bs.inputStatement());
        else if (bs.returnStatement() != null) visitReturnStatement(bs.returnStatement());
        else if (bs.conditionalStatement() != null) visitConditionalStatement(bs.conditionalStatement());
        else if (bs.loopStatement() != null) visitLoopStatement(bs.loopStatement());
        else if (bs.countLoopStatement() != null) visitCountLoopStatement(bs.countLoopStatement());
        else if (bs.repeatUntilStatement() != null) visitRepeatUntilStatement(bs.repeatUntilStatement());
        else if (bs.eventLineLoopStatement() != null) visitEventLineLoopStatement(bs.eventLineLoopStatement());
    }

    @Override
    public Void visitBlockStatement(WikangSawaParser.BlockStatementContext ctx) {
        return visitChildren(ctx);
    }

    private void printConstruct(String label, String detail) {
        counter++;
        System.out.println("  [" + counter + "] " + label + ": " + detail);
    }

    @Override
    public Void visitImportStatement(WikangSawaParser.ImportStatementContext ctx) {
        String identifier = ctx.IDENTIFIER() != null ? ctx.IDENTIFIER().getText() : ctx.MAGPAKITA().getText();
        printConstruct("IMPORT STATEMENT", "gamitin " + identifier);
        countImport++;
        return null;
    }

    @Override
    public Void visitStructureDeclaration(WikangSawaParser.StructureDeclarationContext ctx) {
        printConstruct("STRUCTURE (istraktura)", ctx.IDENTIFIER().getText());
        countStruct++;
        indentLevel++;
        for (WikangSawaParser.StructFieldContext sf : ctx.structBlock().structField()) {
            printConstruct("  STRUCT FIELD", sf.IDENTIFIER().getText() + " = " + sf.expression().getText());
            visit(sf.expression());
        }
        indentLevel--;
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(WikangSawaParser.FunctionDeclarationContext ctx) {
        printConstruct("FUNCTION (punsyon)", ctx.IDENTIFIER().getText() + "()");
        countFunc++;
        indentLevel++;
        System.out.println(indent() + "    --> Body:");
        visitBlock(ctx.block());
        indentLevel--;
        return null;
    }

    @Override
    public Void visitVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        String expr = ctx.expression().getText();
        printConstruct("VARIABLE DECLARATION", varName + " = " + expr + "  (baryabol)");
        countVarDecl++;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitConstantDeclaration(WikangSawaParser.ConstantDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        printConstruct("CONSTANT (konstant)", varName + " = " + ctx.expression().getText());
        countConst++;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitAssignmentStatement(WikangSawaParser.AssignmentStatementContext ctx) {
        String lhs = (ctx.STAR() != null ? "*" : "") + ctx.IDENTIFIER().getText();
        String expr = ctx.expression().getText();
        printConstruct("ASSIGNMENT STATEMENT", lhs + " = " + expr);
        countAssign++;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitPrintStatement(WikangSawaParser.PrintStatementContext ctx) {
        String expr = ctx.expression().getText();
        printConstruct("PRINT STATEMENT", "magpakita " + expr);
        countPrint++;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitInputStatement(WikangSawaParser.InputStatementContext ctx) {
        printConstruct("INPUT (magbasa)", ctx.IDENTIFIER().getText());
        countInput++;
        return null;
    }

    @Override
    public Void visitReturnStatement(WikangSawaParser.ReturnStatementContext ctx) {
        printConstruct("RETURN (balik)", ctx.expression().getText());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitConditionalStatement(WikangSawaParser.ConditionalStatementContext ctx) {
        String condition = ctx.expression().getText();
        printConstruct("CONDITIONAL STATEMENT (kung)", "condition: " + condition);
        countConditional++;
        visit(ctx.expression());
        indentLevel++;
        if (ctx.block().size() > 0) {
            System.out.println(indent() + "    --> Then block:");
            visitBlock(ctx.block(0));
        }
        if (ctx.block().size() > 1) {
            System.out.println(indent() + "    --> Else block (kundi):");
            visitBlock(ctx.block(1));
        }
        indentLevel--;
        return null;
    }

    @Override
    public Void visitLoopStatement(WikangSawaParser.LoopStatementContext ctx) {
        String condition = ctx.expression().getText();
        printConstruct("LOOP STATEMENT (habang)", "condition: " + condition);
        countLoop++;
        visit(ctx.expression());
        indentLevel++;
        System.out.println(indent() + "    --> Loop body:");
        visitBlock(ctx.block());
        indentLevel--;
        return null;
    }

    @Override
    public Void visitCountLoopStatement(WikangSawaParser.CountLoopStatementContext ctx) {
        printConstruct("COUNT LOOP (para)", ctx.IDENTIFIER().getText() + " = "
            + ctx.expression(0).getText() + " hanggang " + ctx.expression(1).getText());
        countPara++;
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        indentLevel++;
        visitBlock(ctx.block());
        indentLevel--;
        return null;
    }

    @Override
    public Void visitRepeatUntilStatement(WikangSawaParser.RepeatUntilStatementContext ctx) {
        printConstruct("REPEAT-UNTIL (gawin ... hanggang)", "until: " + ctx.expression().getText());
        countGawin++;
        indentLevel++;
        visitBlock(ctx.block());
        indentLevel--;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitEventLineLoopStatement(WikangSawaParser.EventLineLoopStatementContext ctx) {
        printConstruct("EVENT LOOP (habang_magbasa)", "one body per stdin line until EOF");
        countEvent++;
        indentLevel++;
        visitBlock(ctx.block());
        indentLevel--;
        return null;
    }

    @Override
    public Void visitBlock(WikangSawaParser.BlockContext ctx) {
        for (int i = 0; i < ctx.blockStatement().size(); i++) {
            dispatchBlockStatement(ctx.blockStatement(i));
        }
        return null;
    }

    @Override
    public Void visitExpression(WikangSawaParser.ExpressionContext ctx) {
        if (ctx.O() != null && ctx.O().size() > 0) {
            System.out.println(indent() + "        (expression: logical OR)");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitAndExpression(WikangSawaParser.AndExpressionContext ctx) {
        if (ctx.AT() != null && ctx.AT().size() > 0) {
            System.out.println(indent() + "        (expression: logical AND)");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitNotExpression(WikangSawaParser.NotExpressionContext ctx) {
        if (ctx.HINDI() != null) {
            System.out.println(indent() + "        (expression: logical NOT)");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx) {
        if (ctx.relOp() != null) {
            String op = ctx.relOp().getText();
            System.out.println(indent() + "        (expression: comparison " + op + ")");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx) {
        if (ctx.PLUS() != null || ctx.MINUS() != null) {
            String op = ctx.PLUS() != null ? "+" : "-";
            System.out.println(indent() + "        (expression: arithmetic " + op + ")");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitTerm(WikangSawaParser.TermContext ctx) {
        if (ctx.STAR() != null || ctx.SLASH() != null || ctx.PERCENT() != null) {
            String op = ctx.STAR() != null ? "*" : (ctx.SLASH() != null ? "/" : "%");
            System.out.println(indent() + "        (expression: term " + op + ")");
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitFactor(WikangSawaParser.FactorContext ctx) {
        WikangSawaParser.PostfixContext post = ctx.postfix();
        if (post != null && post.primary() != null) {
            WikangSawaParser.PrimaryContext p = post.primary();
            if (ctx.STAR() != null) {
                System.out.println(indent() + "        (unary dereference *)");
            }
            if (p.literal() != null) {
                System.out.println(indent() + "        (literal: " + p.literal().getText() + ")");
            } else if (p.arrayLiteral() != null) {
                System.out.println(indent() + "        (array literal)");
            } else if (p.BAGONG() != null) {
                System.out.println(indent() + "        (struct ctor: bagong " + p.IDENTIFIER().getText() + "())");
            } else if (p.AMPERSAND() != null) {
                System.out.println(indent() + "        (address-of: &" + p.IDENTIFIER().getText() + ")");
            } else if (p.IDENTIFIER() != null) {
                if (p.LPAREN() != null) {
                    System.out.println(indent() + "        (function call: " + p.IDENTIFIER().getText() + "())");
                } else {
                    System.out.println(indent() + "        (identifier: " + p.IDENTIFIER().getText() + ")");
                }
            }
            if (post.DOT() != null && post.DOT().size() > 0) {
                System.out.println(indent() + "        (field access: " + post.DOT().size() + " dot(s))");
            }
            if (post.expression() != null && post.expression().size() > 0) {
                System.out.println(indent() + "        (indexing: " + post.expression().size() + " index(es))");
            }
        }
        return visitChildren(ctx);
    }

    private String indent() {
        return "  ".repeat(indentLevel);
    }

    public void printSummary() {
        System.out.println("----------------------------------------");
        System.out.println("  Summary (constructs recognized):");
        System.out.println("----------------------------------------");
        if (countImport > 0) System.out.println("    Import statements:       " + countImport);
        if (countStruct > 0) System.out.println("    Structures (istraktura): " + countStruct);
        if (countFunc > 0) System.out.println("    Functions (punsyon):     " + countFunc);
        if (countVarDecl > 0) System.out.println("    Variable declarations:   " + countVarDecl);
        if (countConst > 0) System.out.println("    Constants (konstant):    " + countConst);
        if (countAssign > 0) System.out.println("    Assignment statements:   " + countAssign);
        if (countPrint > 0) System.out.println("    Print statements:        " + countPrint);
        if (countInput > 0) System.out.println("    Input (magbasa):         " + countInput);
        if (countConditional > 0) System.out.println("    Conditional (kung):      " + countConditional);
        if (countLoop > 0) System.out.println("    Loop (habang):           " + countLoop);
        if (countPara > 0) System.out.println("    Count loop (para):       " + countPara);
        if (countGawin > 0) System.out.println("    Repeat-until (gawin):    " + countGawin);
        if (countEvent > 0) System.out.println("    Event loop (habang_magbasa): " + countEvent);
        System.out.println("    -----------------------");
        System.out.println("    Total statements:        " + counter);
    }
}
