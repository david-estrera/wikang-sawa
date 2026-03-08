import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;

public class ConstructRecognizer extends WikangSawaParserBaseVisitor<Void> {
    private int indentLevel = 0;
    private int counter = 0;

    // Counts for demo summary
    private int countImport = 0, countVarDecl = 0, countAssign = 0, countPrint = 0;
    private int countConditional = 0, countLoop = 0;

    @Override
    public Void visitProgram(WikangSawaParser.ProgramContext ctx) {
        int n = ctx.statement().size();
        for (int i = 0; i < n; i++) {
            WikangSawaParser.StatementContext st = ctx.statement(i);
            WikangSawaParser.BlockStatementContext bs = st.blockStatement();
            if (bs != null) {
                if (bs.importStatement() != null) visitImportStatement(bs.importStatement());
                else if (bs.variableDeclaration() != null) visitVariableDeclaration(bs.variableDeclaration());
                else if (bs.assignmentStatement() != null) visitAssignmentStatement(bs.assignmentStatement());
                else if (bs.printStatement() != null) visitPrintStatement(bs.printStatement());
                else if (bs.conditionalStatement() != null) visitConditionalStatement(bs.conditionalStatement());
                else if (bs.loopStatement() != null) visitLoopStatement(bs.loopStatement());
            }
        }
        return null;
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
    public Void visitVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        String expr = ctx.expression().getText();
        printConstruct("VARIABLE DECLARATION", varName + " = " + expr + "  (baryabol)");
        countVarDecl++;
        visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitAssignmentStatement(WikangSawaParser.AssignmentStatementContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        String expr = ctx.expression().getText();
        printConstruct("ASSIGNMENT STATEMENT", varName + " = " + expr);
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
    public Void visitBlock(WikangSawaParser.BlockContext ctx) {
        for (int i = 0; i < ctx.blockStatement().size(); i++) {
            WikangSawaParser.BlockStatementContext bs = ctx.blockStatement(i);
            if (bs.importStatement() != null) visitImportStatement(bs.importStatement());
            else if (bs.variableDeclaration() != null) visitVariableDeclaration(bs.variableDeclaration());
            else if (bs.assignmentStatement() != null) visitAssignmentStatement(bs.assignmentStatement());
            else if (bs.printStatement() != null) visitPrintStatement(bs.printStatement());
            else if (bs.conditionalStatement() != null) visitConditionalStatement(bs.conditionalStatement());
            else if (bs.loopStatement() != null) visitLoopStatement(bs.loopStatement());
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
        if (ctx.literal() != null) {
            System.out.println(indent() + "        (literal: " + ctx.literal().getText() + ")");
        } else if (ctx.IDENTIFIER() != null) {
            System.out.println(indent() + "        (identifier: " + ctx.IDENTIFIER().getText() + ")");
        }
        return visitChildren(ctx);
    }

    private String indent() {
        return "  ".repeat(indentLevel);
    }

    /** Print a summary of recognized constructs (for demo). */
    public void printSummary() {
        System.out.println("----------------------------------------");
        System.out.println("  Summary (constructs recognized):");
        System.out.println("----------------------------------------");
        if (countImport > 0)  System.out.println("    Import statements:     " + countImport);
        if (countVarDecl > 0) System.out.println("    Variable declarations: " + countVarDecl);
        if (countAssign > 0)  System.out.println("    Assignment statements: " + countAssign);
        if (countPrint > 0)   System.out.println("    Print statements:      " + countPrint);
        if (countConditional > 0) System.out.println("    Conditional (kung):    " + countConditional);
        if (countLoop > 0)    System.out.println("    Loop (habang):         " + countLoop);
        System.out.println("    -----------------------");
        System.out.println("    Total statements:      " + counter);
    }
}


