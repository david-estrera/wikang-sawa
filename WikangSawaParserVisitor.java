// Generated from WikangSawaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WikangSawaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WikangSawaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WikangSawaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(WikangSawaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(WikangSawaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(WikangSawaParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(WikangSawaParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(WikangSawaParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(WikangSawaParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(WikangSawaParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(WikangSawaParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(WikangSawaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#optionalNewlines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalNewlines(WikangSawaParser.OptionalNewlinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(WikangSawaParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(WikangSawaParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(WikangSawaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(WikangSawaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(WikangSawaParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(WikangSawaParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(WikangSawaParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#relOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(WikangSawaParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(WikangSawaParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(WikangSawaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(WikangSawaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(WikangSawaParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(WikangSawaParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(WikangSawaParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(WikangSawaParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link WikangSawaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(WikangSawaParser.LiteralContext ctx);
}