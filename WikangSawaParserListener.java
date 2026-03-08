// Generated from WikangSawaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WikangSawaParser}.
 */
public interface WikangSawaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WikangSawaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WikangSawaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(WikangSawaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(WikangSawaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(WikangSawaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(WikangSawaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(WikangSawaParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(WikangSawaParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(WikangSawaParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(WikangSawaParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(WikangSawaParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(WikangSawaParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#optionalNewlines}.
	 * @param ctx the parse tree
	 */
	void enterOptionalNewlines(WikangSawaParser.OptionalNewlinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#optionalNewlines}.
	 * @param ctx the parse tree
	 */
	void exitOptionalNewlines(WikangSawaParser.OptionalNewlinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(WikangSawaParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(WikangSawaParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(WikangSawaParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(WikangSawaParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(WikangSawaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(WikangSawaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(WikangSawaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(WikangSawaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(WikangSawaParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(WikangSawaParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(WikangSawaParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(WikangSawaParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(WikangSawaParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(WikangSawaParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(WikangSawaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(WikangSawaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(WikangSawaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(WikangSawaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link WikangSawaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(WikangSawaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link WikangSawaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(WikangSawaParser.LiteralContext ctx);
}