// Generated from WikangSawaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class WikangSawaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, GAMITIN=3, PUNSYON=4, BALIK=5, KUNG=6, HABANG=7, BARYABOL=8, 
		TAPOS=9, PARA=10, KAPAG=11, KUNDI=12, SA=13, AY=14, MAGPAKITA=15, MAGBASA=16, 
		TOTOO=17, MALI=18, WALA=19, AT=20, O=21, HINDI=22, EQUAL=23, NOT_EQUAL=24, 
		LT=25, GT=26, LE=27, GE=28, PLUS=29, MINUS=30, STAR=31, SLASH=32, PERCENT=33, 
		ASSIGN=34, LPAREN=35, RPAREN=36, LBRACKET=37, RBRACKET=38, LBRACE=39, 
		RBRACE=40, COMMA=41, SEMICOLON=42, COLON=43, DOT=44, NUMERO=45, DESIMAL=46, 
		SALITA=47, IDENTIFIER=48, COMMENT=49, WS=50, NEWLINE=51;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_blockStatement = 2, RULE_importStatement = 3, 
		RULE_functionDeclaration = 4, RULE_paramList = 5, RULE_variableDeclaration = 6, 
		RULE_assignmentStatement = 7, RULE_printStatement = 8, RULE_returnStatement = 9, 
		RULE_optionalNewlines = 10, RULE_conditionalStatement = 11, RULE_loopStatement = 12, 
		RULE_block = 13, RULE_expression = 14, RULE_andExpression = 15, RULE_notExpression = 16, 
		RULE_comparisonExpression = 17, RULE_relOp = 18, RULE_arithmeticExpression = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_postfix = 22, RULE_primary = 23, 
		RULE_argList = 24, RULE_arrayLiteral = 25, RULE_literal = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "blockStatement", "importStatement", "functionDeclaration", 
			"paramList", "variableDeclaration", "assignmentStatement", "printStatement", 
			"returnStatement", "optionalNewlines", "conditionalStatement", "loopStatement", 
			"block", "expression", "andExpression", "notExpression", "comparisonExpression", 
			"relOp", "arithmeticExpression", "term", "factor", "postfix", "primary", 
			"argList", "arrayLiteral", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'gamitin'", "'punsyon'", "'balik'", "'kung'", "'habang'", 
			"'baryabol'", "'tapos'", "'para'", "'kapag'", "'kundi'", "'sa'", "'ay'", 
			"'magpakita'", "'magbasa'", "'totoo'", "'mali'", "'wala'", "'at'", "'o'", 
			"'hindi'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"','", "';'", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "GAMITIN", "PUNSYON", "BALIK", "KUNG", "HABANG", 
			"BARYABOL", "TAPOS", "PARA", "KAPAG", "KUNDI", "SA", "AY", "MAGPAKITA", 
			"MAGBASA", "TOTOO", "MALI", "WALA", "AT", "O", "HINDI", "EQUAL", "NOT_EQUAL", 
			"LT", "GT", "LE", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", 
			"ASSIGN", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", 
			"COMMA", "SEMICOLON", "COLON", "DOT", "NUMERO", "DESIMAL", "SALITA", 
			"IDENTIFIER", "COMMENT", "WS", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "WikangSawaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WikangSawaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WikangSawaParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2533274790429176L) != 0)) {
				{
				{
				setState(54);
				statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
			case PUNSYON:
			case BALIK:
			case KUNG:
			case HABANG:
			case BARYABOL:
			case MAGPAKITA:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				blockStatement();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				importStatement();
				}
				break;
			case PUNSYON:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				functionDeclaration();
				}
				break;
			case BARYABOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				variableDeclaration();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				assignmentStatement();
				}
				break;
			case MAGPAKITA:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				printStatement();
				}
				break;
			case BALIK:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				returnStatement();
				}
				break;
			case KUNG:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				conditionalStatement();
				}
				break;
			case HABANG:
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				loopStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode GAMITIN() { return getToken(WikangSawaParser.GAMITIN, 0); }
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode MAGPAKITA() { return getToken(WikangSawaParser.MAGPAKITA, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(GAMITIN);
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==MAGPAKITA || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(78);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode PUNSYON() { return getToken(WikangSawaParser.PUNSYON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(WikangSawaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(WikangSawaParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TAPOS() { return getToken(WikangSawaParser.TAPOS, 0); }
		public OptionalNewlinesContext optionalNewlines() {
			return getRuleContext(OptionalNewlinesContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(PUNSYON);
			setState(81);
			match(IDENTIFIER);
			setState(82);
			match(LPAREN);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(83);
				paramList();
				}
			}

			setState(86);
			match(RPAREN);
			setState(87);
			match(COLON);
			setState(88);
			block();
			setState(89);
			match(TAPOS);
			setState(90);
			optionalNewlines();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(WikangSawaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(WikangSawaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WikangSawaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WikangSawaParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFIER);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				match(IDENTIFIER);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode BARYABOL() { return getToken(WikangSawaParser.BARYABOL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(WikangSawaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(BARYABOL);
			setState(101);
			match(IDENTIFIER);
			setState(102);
			match(ASSIGN);
			setState(103);
			expression();
			setState(104);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(WikangSawaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(IDENTIFIER);
			setState(107);
			match(ASSIGN);
			setState(108);
			expression();
			setState(109);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode MAGPAKITA() { return getToken(WikangSawaParser.MAGPAKITA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(MAGPAKITA);
			setState(112);
			expression();
			setState(113);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode BALIK() { return getToken(WikangSawaParser.BALIK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(BALIK);
			setState(116);
			expression();
			setState(117);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionalNewlinesContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(WikangSawaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(WikangSawaParser.NEWLINE, i);
		}
		public OptionalNewlinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalNewlines; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitOptionalNewlines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionalNewlinesContext optionalNewlines() throws RecognitionException {
		OptionalNewlinesContext _localctx = new OptionalNewlinesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_optionalNewlines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					match(NEWLINE);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ParserRuleContext {
		public TerminalNode KUNG() { return getToken(WikangSawaParser.KUNG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(WikangSawaParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(WikangSawaParser.COLON, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> TAPOS() { return getTokens(WikangSawaParser.TAPOS); }
		public TerminalNode TAPOS(int i) {
			return getToken(WikangSawaParser.TAPOS, i);
		}
		public List<OptionalNewlinesContext> optionalNewlines() {
			return getRuleContexts(OptionalNewlinesContext.class);
		}
		public OptionalNewlinesContext optionalNewlines(int i) {
			return getRuleContext(OptionalNewlinesContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(WikangSawaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(WikangSawaParser.NEWLINE, i);
		}
		public TerminalNode KUNDI() { return getToken(WikangSawaParser.KUNDI, 0); }
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conditionalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(KUNG);
			setState(126);
			expression();
			setState(127);
			match(COLON);
			setState(128);
			block();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(129);
				match(NEWLINE);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(TAPOS);
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(136);
				optionalNewlines();
				setState(137);
				match(KUNDI);
				setState(138);
				match(COLON);
				setState(139);
				block();
				setState(140);
				optionalNewlines();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TAPOS) {
					{
					setState(141);
					match(TAPOS);
					}
				}

				}
				break;
			}
			setState(146);
			optionalNewlines();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode HABANG() { return getToken(WikangSawaParser.HABANG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TAPOS() { return getToken(WikangSawaParser.TAPOS, 0); }
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(HABANG);
			setState(149);
			expression();
			setState(150);
			match(COLON);
			setState(151);
			block();
			setState(152);
			match(TAPOS);
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(153);
				match(NEWLINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(WikangSawaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(WikangSawaParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(WikangSawaParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(WikangSawaParser.DEDENT, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(NEWLINE);
			setState(157);
			match(INDENT);
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(158);
				blockStatement();
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 281474976743928L) != 0) );
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(163);
				match(NEWLINE);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> O() { return getTokens(WikangSawaParser.O); }
		public TerminalNode O(int i) {
			return getToken(WikangSawaParser.O, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			andExpression();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==O) {
				{
				{
				setState(172);
				match(O);
				setState(173);
				andExpression();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public List<NotExpressionContext> notExpression() {
			return getRuleContexts(NotExpressionContext.class);
		}
		public NotExpressionContext notExpression(int i) {
			return getRuleContext(NotExpressionContext.class,i);
		}
		public List<TerminalNode> AT() { return getTokens(WikangSawaParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(WikangSawaParser.AT, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			notExpression();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(180);
				match(AT);
				setState(181);
				notExpression();
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ParserRuleContext {
		public TerminalNode HINDI() { return getToken(WikangSawaParser.HINDI, 0); }
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_notExpression);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HINDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(HINDI);
				setState(188);
				notExpression();
				}
				break;
			case TOTOO:
			case MALI:
			case WALA:
			case MINUS:
			case LPAREN:
			case LBRACKET:
			case NUMERO:
			case DESIMAL:
			case SALITA:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				comparisonExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			arithmeticExpression();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) {
				{
				setState(193);
				relOp();
				setState(194);
				arithmeticExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelOpContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(WikangSawaParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(WikangSawaParser.NOT_EQUAL, 0); }
		public TerminalNode LT() { return getToken(WikangSawaParser.LT, 0); }
		public TerminalNode GT() { return getToken(WikangSawaParser.GT, 0); }
		public TerminalNode LE() { return getToken(WikangSawaParser.LE, 0); }
		public TerminalNode GE() { return getToken(WikangSawaParser.GE, 0); }
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(WikangSawaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(WikangSawaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(WikangSawaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(WikangSawaParser.MINUS, i);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			term();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(201);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(202);
				term();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(WikangSawaParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(WikangSawaParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(WikangSawaParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(WikangSawaParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(WikangSawaParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(WikangSawaParser.PERCENT, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			factor();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) {
				{
				{
				setState(209);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				factor();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(WikangSawaParser.MINUS, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(216);
				match(MINUS);
				}
			}

			setState(219);
			postfix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(WikangSawaParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(WikangSawaParser.LBRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(WikangSawaParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(WikangSawaParser.RBRACKET, i);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			primary();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(222);
				match(LBRACKET);
				setState(223);
				expression();
				setState(224);
				match(RBRACKET);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(WikangSawaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(WikangSawaParser.RPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary);
		int _la;
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOTOO:
			case MALI:
			case WALA:
			case NUMERO:
			case DESIMAL:
			case SALITA:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				literal();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				match(IDENTIFIER);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(233);
					match(LPAREN);
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 527938458877952L) != 0)) {
						{
						setState(234);
						argList();
						}
					}

					setState(237);
					match(RPAREN);
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(LPAREN);
				setState(241);
				expression();
				setState(242);
				match(RPAREN);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				arrayLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WikangSawaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WikangSawaParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			expression();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(248);
				match(COMMA);
				setState(249);
				expression();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(WikangSawaParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(WikangSawaParser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WikangSawaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WikangSawaParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(LBRACKET);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 527938458877952L) != 0)) {
				{
				setState(256);
				expression();
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(257);
					match(COMMA);
					setState(258);
					expression();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(266);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(WikangSawaParser.NUMERO, 0); }
		public TerminalNode DESIMAL() { return getToken(WikangSawaParser.DESIMAL, 0); }
		public TerminalNode SALITA() { return getToken(WikangSawaParser.SALITA, 0); }
		public TerminalNode TOTOO() { return getToken(WikangSawaParser.TOTOO, 0); }
		public TerminalNode MALI() { return getToken(WikangSawaParser.MALI, 0); }
		public TerminalNode WALA() { return getToken(WikangSawaParser.WALA, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 246290605539328L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u010f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0005\u0000"+
		"8\b\u0000\n\u0000\f\u0000;\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"K\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004U\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005`\b\u0005\n\u0005\f\u0005c\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0005\ny\b"+
		"\n\n\n\f\n|\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u0083\b\u000b\n\u000b\f\u000b\u0086\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u008f\b\u000b\u0003\u000b\u0091\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u009b\b"+
		"\f\u0001\r\u0001\r\u0001\r\u0004\r\u00a0\b\r\u000b\r\f\r\u00a1\u0001\r"+
		"\u0005\r\u00a5\b\r\n\r\f\r\u00a8\t\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00af\b\u000e\n\u000e\f\u000e\u00b2\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00b7\b\u000f\n\u000f"+
		"\f\u000f\u00ba\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00bf\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00c5\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00cc\b\u0013\n\u0013\f\u0013\u00cf\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u00d4\b\u0014\n\u0014\f\u0014\u00d7\t\u0014"+
		"\u0001\u0015\u0003\u0015\u00da\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00e3\b\u0016"+
		"\n\u0016\f\u0016\u00e6\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u00ec\b\u0017\u0001\u0017\u0003\u0017\u00ef\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u00f6\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00fb\b"+
		"\u0018\n\u0018\f\u0018\u00fe\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0104\b\u0019\n\u0019\f\u0019\u0107\t\u0019\u0003"+
		"\u0019\u0109\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0000\u0000\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0005\u0002\u0000"+
		"\u000f\u000f00\u0001\u0000\u0017\u001c\u0001\u0000\u001d\u001e\u0001\u0000"+
		"\u001f!\u0002\u0000\u0011\u0013-/\u0115\u00009\u0001\u0000\u0000\u0000"+
		"\u0002@\u0001\u0000\u0000\u0000\u0004J\u0001\u0000\u0000\u0000\u0006L"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\n\\\u0001\u0000\u0000"+
		"\u0000\fd\u0001\u0000\u0000\u0000\u000ej\u0001\u0000\u0000\u0000\u0010"+
		"o\u0001\u0000\u0000\u0000\u0012s\u0001\u0000\u0000\u0000\u0014z\u0001"+
		"\u0000\u0000\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u0094\u0001\u0000"+
		"\u0000\u0000\u001a\u009c\u0001\u0000\u0000\u0000\u001c\u00ab\u0001\u0000"+
		"\u0000\u0000\u001e\u00b3\u0001\u0000\u0000\u0000 \u00be\u0001\u0000\u0000"+
		"\u0000\"\u00c0\u0001\u0000\u0000\u0000$\u00c6\u0001\u0000\u0000\u0000"+
		"&\u00c8\u0001\u0000\u0000\u0000(\u00d0\u0001\u0000\u0000\u0000*\u00d9"+
		"\u0001\u0000\u0000\u0000,\u00dd\u0001\u0000\u0000\u0000.\u00f5\u0001\u0000"+
		"\u0000\u00000\u00f7\u0001\u0000\u0000\u00002\u00ff\u0001\u0000\u0000\u0000"+
		"4\u010c\u0001\u0000\u0000\u000068\u0003\u0002\u0001\u000076\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<=\u0005\u0000\u0000\u0001=\u0001\u0001\u0000\u0000\u0000>A\u0003\u0004"+
		"\u0002\u0000?A\u00053\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000A\u0003\u0001\u0000\u0000\u0000BK\u0003\u0006\u0003\u0000"+
		"CK\u0003\b\u0004\u0000DK\u0003\f\u0006\u0000EK\u0003\u000e\u0007\u0000"+
		"FK\u0003\u0010\b\u0000GK\u0003\u0012\t\u0000HK\u0003\u0016\u000b\u0000"+
		"IK\u0003\u0018\f\u0000JB\u0001\u0000\u0000\u0000JC\u0001\u0000\u0000\u0000"+
		"JD\u0001\u0000\u0000\u0000JE\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000"+
		"\u0000JG\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000"+
		"\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LM\u0005\u0003\u0000\u0000"+
		"MN\u0007\u0000\u0000\u0000NO\u00053\u0000\u0000O\u0007\u0001\u0000\u0000"+
		"\u0000PQ\u0005\u0004\u0000\u0000QR\u00050\u0000\u0000RT\u0005#\u0000\u0000"+
		"SU\u0003\n\u0005\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VW\u0005$\u0000\u0000WX\u0005+\u0000\u0000X"+
		"Y\u0003\u001a\r\u0000YZ\u0005\t\u0000\u0000Z[\u0003\u0014\n\u0000[\t\u0001"+
		"\u0000\u0000\u0000\\a\u00050\u0000\u0000]^\u0005)\u0000\u0000^`\u0005"+
		"0\u0000\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u000b\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000de\u0005\b\u0000\u0000ef\u00050\u0000"+
		"\u0000fg\u0005\"\u0000\u0000gh\u0003\u001c\u000e\u0000hi\u00053\u0000"+
		"\u0000i\r\u0001\u0000\u0000\u0000jk\u00050\u0000\u0000kl\u0005\"\u0000"+
		"\u0000lm\u0003\u001c\u000e\u0000mn\u00053\u0000\u0000n\u000f\u0001\u0000"+
		"\u0000\u0000op\u0005\u000f\u0000\u0000pq\u0003\u001c\u000e\u0000qr\u0005"+
		"3\u0000\u0000r\u0011\u0001\u0000\u0000\u0000st\u0005\u0005\u0000\u0000"+
		"tu\u0003\u001c\u000e\u0000uv\u00053\u0000\u0000v\u0013\u0001\u0000\u0000"+
		"\u0000wy\u00053\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0015\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0006\u0000\u0000"+
		"~\u007f\u0003\u001c\u000e\u0000\u007f\u0080\u0005+\u0000\u0000\u0080\u0084"+
		"\u0003\u001a\r\u0000\u0081\u0083\u00053\u0000\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0090\u0005"+
		"\t\u0000\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089\u008a\u0005\f\u0000"+
		"\u0000\u008a\u008b\u0005+\u0000\u0000\u008b\u008c\u0003\u001a\r\u0000"+
		"\u008c\u008e\u0003\u0014\n\u0000\u008d\u008f\u0005\t\u0000\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0091\u0001\u0000\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0003\u0014\n\u0000\u0093\u0017\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\u0007\u0000\u0000\u0095\u0096\u0003\u001c\u000e\u0000\u0096\u0097"+
		"\u0005+\u0000\u0000\u0097\u0098\u0003\u001a\r\u0000\u0098\u009a\u0005"+
		"\t\u0000\u0000\u0099\u009b\u00053\u0000\u0000\u009a\u0099\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0019\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u00053\u0000\u0000\u009d\u009f\u0005\u0001\u0000"+
		"\u0000\u009e\u00a0\u0003\u0004\u0002\u0000\u009f\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a5\u00053\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0002\u0000\u0000"+
		"\u00aa\u001b\u0001\u0000\u0000\u0000\u00ab\u00b0\u0003\u001e\u000f\u0000"+
		"\u00ac\u00ad\u0005\u0015\u0000\u0000\u00ad\u00af\u0003\u001e\u000f\u0000"+
		"\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u001d\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b8\u0003 \u0010\u0000\u00b4\u00b5\u0005\u0014\u0000\u0000\u00b5"+
		"\u00b7\u0003 \u0010\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b9\u001f\u0001\u0000\u0000\u0000\u00ba\u00b8"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00bf"+
		"\u0003 \u0010\u0000\u00bd\u00bf\u0003\"\u0011\u0000\u00be\u00bb\u0001"+
		"\u0000\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf!\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c4\u0003&\u0013\u0000\u00c1\u00c2\u0003$\u0012\u0000"+
		"\u00c2\u00c3\u0003&\u0013\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"#\u0001\u0000\u0000\u0000\u00c6\u00c7\u0007\u0001\u0000\u0000\u00c7%\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cd\u0003(\u0014\u0000\u00c9\u00ca\u0007\u0002"+
		"\u0000\u0000\u00ca\u00cc\u0003(\u0014\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\'\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d5\u0003*\u0015\u0000\u00d1"+
		"\u00d2\u0007\u0003\u0000\u0000\u00d2\u00d4\u0003*\u0015\u0000\u00d3\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6)\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00da\u0005"+
		"\u001e\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0003"+
		",\u0016\u0000\u00dc+\u0001\u0000\u0000\u0000\u00dd\u00e4\u0003.\u0017"+
		"\u0000\u00de\u00df\u0005%\u0000\u0000\u00df\u00e0\u0003\u001c\u000e\u0000"+
		"\u00e0\u00e1\u0005&\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2"+
		"\u00de\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"-\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00f6"+
		"\u00034\u001a\u0000\u00e8\u00ee\u00050\u0000\u0000\u00e9\u00eb\u0005#"+
		"\u0000\u0000\u00ea\u00ec\u00030\u0018\u0000\u00eb\u00ea\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ef\u0005$\u0000\u0000\u00ee\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0005#\u0000\u0000\u00f1\u00f2\u0003\u001c\u000e\u0000\u00f2"+
		"\u00f3\u0005$\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f6"+
		"\u00032\u0019\u0000\u00f5\u00e7\u0001\u0000\u0000\u0000\u00f5\u00e8\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f0\u0001\u0000\u0000\u0000\u00f5\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f6/\u0001\u0000\u0000\u0000\u00f7\u00fc\u0003\u001c"+
		"\u000e\u0000\u00f8\u00f9\u0005)\u0000\u0000\u00f9\u00fb\u0003\u001c\u000e"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd1\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00ff\u0108\u0005%\u0000\u0000\u0100\u0105\u0003\u001c\u000e\u0000\u0101"+
		"\u0102\u0005)\u0000\u0000\u0102\u0104\u0003\u001c\u000e\u0000\u0103\u0101"+
		"\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0109"+
		"\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0100"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0005&\u0000\u0000\u010b3\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0007\u0004\u0000\u0000\u010d5\u0001\u0000\u0000"+
		"\u0000\u001a9@JTaz\u0084\u008e\u0090\u009a\u00a1\u00a6\u00b0\u00b8\u00be"+
		"\u00c4\u00cd\u00d5\u00d9\u00e4\u00eb\u00ee\u00f5\u00fc\u0105\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}