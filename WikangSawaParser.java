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
		KONSTANT=9, TAPOS=10, PARA=11, GAWIN=12, HANGGANG=13, KAPAG=14, KUNDI=15, 
		SA=16, AY=17, MAGPAKITA=18, MAGBASA=19, HABANG_MAGBASA=20, ISTRAKTURA=21, 
		BAGONG=22, TOTOO=23, MALI=24, WALA=25, AT=26, O=27, HINDI=28, EQUAL=29, 
		NOT_EQUAL=30, LT=31, GT=32, LE=33, GE=34, PLUS=35, MINUS=36, STAR=37, 
		SLASH=38, PERCENT=39, ASSIGN=40, AMPERSAND=41, LPAREN=42, RPAREN=43, LBRACKET=44, 
		RBRACKET=45, LBRACE=46, RBRACE=47, COMMA=48, SEMICOLON=49, COLON=50, DOT=51, 
		NUMERO=52, DESIMAL=53, SALITA=54, IDENTIFIER=55, COMMENT=56, WS=57, NEWLINE=58;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_blockStatement = 2, RULE_importStatement = 3, 
		RULE_functionDeclaration = 4, RULE_paramList = 5, RULE_variableDeclaration = 6, 
		RULE_constantDeclaration = 7, RULE_structureDeclaration = 8, RULE_structBlock = 9, 
		RULE_structField = 10, RULE_assignmentStatement = 11, RULE_inputStatement = 12, 
		RULE_printStatement = 13, RULE_returnStatement = 14, RULE_optionalNewlines = 15, 
		RULE_conditionalStatement = 16, RULE_loopStatement = 17, RULE_countLoopStatement = 18, 
		RULE_repeatUntilStatement = 19, RULE_eventLineLoopStatement = 20, RULE_block = 21, 
		RULE_expression = 22, RULE_andExpression = 23, RULE_notExpression = 24, 
		RULE_comparisonExpression = 25, RULE_relOp = 26, RULE_arithmeticExpression = 27, 
		RULE_term = 28, RULE_factor = 29, RULE_postfix = 30, RULE_primary = 31, 
		RULE_argList = 32, RULE_arrayLiteral = 33, RULE_literal = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "blockStatement", "importStatement", "functionDeclaration", 
			"paramList", "variableDeclaration", "constantDeclaration", "structureDeclaration", 
			"structBlock", "structField", "assignmentStatement", "inputStatement", 
			"printStatement", "returnStatement", "optionalNewlines", "conditionalStatement", 
			"loopStatement", "countLoopStatement", "repeatUntilStatement", "eventLineLoopStatement", 
			"block", "expression", "andExpression", "notExpression", "comparisonExpression", 
			"relOp", "arithmeticExpression", "term", "factor", "postfix", "primary", 
			"argList", "arrayLiteral", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'gamitin'", "'punsyon'", "'balik'", "'kung'", "'habang'", 
			"'baryabol'", "'konstant'", "'tapos'", "'para'", "'gawin'", "'hanggang'", 
			"'kapag'", "'kundi'", "'sa'", "'ay'", "'magpakita'", "'magbasa'", "'habang_magbasa'", 
			"'istraktura'", "'bagong'", "'totoo'", "'mali'", "'wala'", "'at'", "'o'", 
			"'hindi'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'='", "'&'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "','", "';'", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "GAMITIN", "PUNSYON", "BALIK", "KUNG", "HABANG", 
			"BARYABOL", "KONSTANT", "TAPOS", "PARA", "GAWIN", "HANGGANG", "KAPAG", 
			"KUNDI", "SA", "AY", "MAGPAKITA", "MAGBASA", "HABANG_MAGBASA", "ISTRAKTURA", 
			"BAGONG", "TOTOO", "MALI", "WALA", "AT", "O", "HINDI", "EQUAL", "NOT_EQUAL", 
			"LT", "GT", "LE", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", 
			"ASSIGN", "AMPERSAND", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", 
			"RBRACE", "COMMA", "SEMICOLON", "COLON", "DOT", "NUMERO", "DESIMAL", 
			"SALITA", "IDENTIFIER", "COMMENT", "WS", "NEWLINE"
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
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 324259310613568504L) != 0)) {
				{
				{
				setState(70);
				statement();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
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
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
			case PUNSYON:
			case BALIK:
			case KUNG:
			case HABANG:
			case BARYABOL:
			case KONSTANT:
			case PARA:
			case GAWIN:
			case MAGPAKITA:
			case MAGBASA:
			case HABANG_MAGBASA:
			case ISTRAKTURA:
			case STAR:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				blockStatement();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
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
		public StructureDeclarationContext structureDeclaration() {
			return getRuleContext(StructureDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
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
		public CountLoopStatementContext countLoopStatement() {
			return getRuleContext(CountLoopStatementContext.class,0);
		}
		public RepeatUntilStatementContext repeatUntilStatement() {
			return getRuleContext(RepeatUntilStatementContext.class,0);
		}
		public EventLineLoopStatementContext eventLineLoopStatement() {
			return getRuleContext(EventLineLoopStatementContext.class,0);
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
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				importStatement();
				}
				break;
			case PUNSYON:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				functionDeclaration();
				}
				break;
			case ISTRAKTURA:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				structureDeclaration();
				}
				break;
			case BARYABOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				variableDeclaration();
				}
				break;
			case KONSTANT:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				constantDeclaration();
				}
				break;
			case STAR:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				assignmentStatement();
				}
				break;
			case MAGPAKITA:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				printStatement();
				}
				break;
			case MAGBASA:
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				inputStatement();
				}
				break;
			case BALIK:
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				returnStatement();
				}
				break;
			case KUNG:
				enterOuterAlt(_localctx, 10);
				{
				setState(91);
				conditionalStatement();
				}
				break;
			case HABANG:
				enterOuterAlt(_localctx, 11);
				{
				setState(92);
				loopStatement();
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 12);
				{
				setState(93);
				countLoopStatement();
				}
				break;
			case GAWIN:
				enterOuterAlt(_localctx, 13);
				{
				setState(94);
				repeatUntilStatement();
				}
				break;
			case HABANG_MAGBASA:
				enterOuterAlt(_localctx, 14);
				{
				setState(95);
				eventLineLoopStatement();
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
			setState(98);
			match(GAMITIN);
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==MAGPAKITA || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(100);
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
			setState(102);
			match(PUNSYON);
			setState(103);
			match(IDENTIFIER);
			setState(104);
			match(LPAREN);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(105);
				paramList();
				}
			}

			setState(108);
			match(RPAREN);
			setState(109);
			match(COLON);
			setState(110);
			block();
			setState(111);
			match(TAPOS);
			setState(112);
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
			setState(114);
			match(IDENTIFIER);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(115);
				match(COMMA);
				setState(116);
				match(IDENTIFIER);
				}
				}
				setState(121);
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
			setState(122);
			match(BARYABOL);
			setState(123);
			match(IDENTIFIER);
			setState(124);
			match(ASSIGN);
			setState(125);
			expression();
			setState(126);
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
	public static class ConstantDeclarationContext extends ParserRuleContext {
		public TerminalNode KONSTANT() { return getToken(WikangSawaParser.KONSTANT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(WikangSawaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitConstantDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constantDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(KONSTANT);
			setState(129);
			match(IDENTIFIER);
			setState(130);
			match(ASSIGN);
			setState(131);
			expression();
			setState(132);
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
	public static class StructureDeclarationContext extends ParserRuleContext {
		public TerminalNode ISTRAKTURA() { return getToken(WikangSawaParser.ISTRAKTURA, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public StructBlockContext structBlock() {
			return getRuleContext(StructBlockContext.class,0);
		}
		public TerminalNode TAPOS() { return getToken(WikangSawaParser.TAPOS, 0); }
		public OptionalNewlinesContext optionalNewlines() {
			return getRuleContext(OptionalNewlinesContext.class,0);
		}
		public StructureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structureDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitStructureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureDeclarationContext structureDeclaration() throws RecognitionException {
		StructureDeclarationContext _localctx = new StructureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structureDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ISTRAKTURA);
			setState(135);
			match(IDENTIFIER);
			setState(136);
			match(COLON);
			setState(137);
			structBlock();
			setState(138);
			match(TAPOS);
			setState(139);
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
	public static class StructBlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(WikangSawaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(WikangSawaParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(WikangSawaParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(WikangSawaParser.DEDENT, 0); }
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public StructBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitStructBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBlockContext structBlock() throws RecognitionException {
		StructBlockContext _localctx = new StructBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(NEWLINE);
			setState(142);
			match(INDENT);
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				structField();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BARYABOL );
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(148);
				match(NEWLINE);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
	public static class StructFieldContext extends ParserRuleContext {
		public TerminalNode BARYABOL() { return getToken(WikangSawaParser.BARYABOL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(WikangSawaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitStructField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(BARYABOL);
			setState(157);
			match(IDENTIFIER);
			setState(158);
			match(ASSIGN);
			setState(159);
			expression();
			setState(160);
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
		public TerminalNode STAR() { return getToken(WikangSawaParser.STAR, 0); }
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
		enterRule(_localctx, 22, RULE_assignmentStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(162);
				match(STAR);
				}
			}

			setState(165);
			match(IDENTIFIER);
			setState(166);
			match(ASSIGN);
			setState(167);
			expression();
			setState(168);
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
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode MAGBASA() { return getToken(WikangSawaParser.MAGBASA, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(MAGBASA);
			setState(171);
			match(IDENTIFIER);
			setState(172);
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
		enterRule(_localctx, 26, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(MAGPAKITA);
			setState(175);
			expression();
			setState(176);
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
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(BALIK);
			setState(179);
			expression();
			setState(180);
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
		enterRule(_localctx, 30, RULE_optionalNewlines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(NEWLINE);
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 32, RULE_conditionalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(KUNG);
			setState(189);
			expression();
			setState(190);
			match(COLON);
			setState(191);
			block();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(192);
				match(NEWLINE);
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(TAPOS);
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(199);
				optionalNewlines();
				setState(200);
				match(KUNDI);
				setState(201);
				match(COLON);
				setState(202);
				block();
				setState(203);
				optionalNewlines();
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TAPOS) {
					{
					setState(204);
					match(TAPOS);
					}
				}

				}
				break;
			}
			setState(209);
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
		enterRule(_localctx, 34, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(HABANG);
			setState(212);
			expression();
			setState(213);
			match(COLON);
			setState(214);
			block();
			setState(215);
			match(TAPOS);
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(216);
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
	public static class CountLoopStatementContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(WikangSawaParser.PARA, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(WikangSawaParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode HANGGANG() { return getToken(WikangSawaParser.HANGGANG, 0); }
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TAPOS() { return getToken(WikangSawaParser.TAPOS, 0); }
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public CountLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countLoopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitCountLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountLoopStatementContext countLoopStatement() throws RecognitionException {
		CountLoopStatementContext _localctx = new CountLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_countLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(PARA);
			setState(220);
			match(IDENTIFIER);
			setState(221);
			match(ASSIGN);
			setState(222);
			expression();
			setState(223);
			match(HANGGANG);
			setState(224);
			expression();
			setState(225);
			match(COLON);
			setState(226);
			block();
			setState(227);
			match(TAPOS);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(228);
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
	public static class RepeatUntilStatementContext extends ParserRuleContext {
		public TerminalNode GAWIN() { return getToken(WikangSawaParser.GAWIN, 0); }
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode HANGGANG() { return getToken(WikangSawaParser.HANGGANG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public RepeatUntilStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatUntilStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitRepeatUntilStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatUntilStatementContext repeatUntilStatement() throws RecognitionException {
		RepeatUntilStatementContext _localctx = new RepeatUntilStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_repeatUntilStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(GAWIN);
			setState(232);
			match(COLON);
			setState(233);
			block();
			setState(234);
			match(HANGGANG);
			setState(235);
			expression();
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(236);
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
	public static class EventLineLoopStatementContext extends ParserRuleContext {
		public TerminalNode HABANG_MAGBASA() { return getToken(WikangSawaParser.HABANG_MAGBASA, 0); }
		public TerminalNode COLON() { return getToken(WikangSawaParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TAPOS() { return getToken(WikangSawaParser.TAPOS, 0); }
		public TerminalNode NEWLINE() { return getToken(WikangSawaParser.NEWLINE, 0); }
		public EventLineLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventLineLoopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WikangSawaParserVisitor ) return ((WikangSawaParserVisitor<? extends T>)visitor).visitEventLineLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventLineLoopStatementContext eventLineLoopStatement() throws RecognitionException {
		EventLineLoopStatementContext _localctx = new EventLineLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_eventLineLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(HABANG_MAGBASA);
			setState(240);
			match(COLON);
			setState(241);
			block();
			setState(242);
			match(TAPOS);
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(243);
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
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(NEWLINE);
			setState(247);
			match(INDENT);
			setState(255); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(248);
						match(NEWLINE);
						}
						}
						setState(253);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(254);
					blockStatement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(257); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(259);
				match(NEWLINE);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
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
		enterRule(_localctx, 44, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			andExpression();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==O) {
				{
				{
				setState(268);
				match(O);
				setState(269);
				andExpression();
				}
				}
				setState(274);
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
		enterRule(_localctx, 46, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			notExpression();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(276);
				match(AT);
				setState(277);
				notExpression();
				}
				}
				setState(282);
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
		enterRule(_localctx, 48, RULE_notExpression);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HINDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(HINDI);
				setState(284);
				notExpression();
				}
				break;
			case BAGONG:
			case TOTOO:
			case MALI:
			case WALA:
			case MINUS:
			case STAR:
			case AMPERSAND:
			case LPAREN:
			case LBRACKET:
			case NUMERO:
			case DESIMAL:
			case SALITA:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
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
		enterRule(_localctx, 50, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			arithmeticExpression();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) {
				{
				setState(289);
				relOp();
				setState(290);
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
		enterRule(_localctx, 52, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) ) {
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
		enterRule(_localctx, 54, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			term();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(297);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(298);
				term();
				}
				}
				setState(303);
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
		enterRule(_localctx, 56, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			factor();
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(305);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 962072674304L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(306);
					factor();
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		public TerminalNode STAR() { return getToken(WikangSawaParser.STAR, 0); }
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
		enterRule(_localctx, 58, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS || _la==STAR) {
				{
				setState(312);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==STAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(315);
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
		public List<TerminalNode> DOT() { return getTokens(WikangSawaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(WikangSawaParser.DOT, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(WikangSawaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(WikangSawaParser.IDENTIFIER, i);
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
		enterRule(_localctx, 60, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			primary();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(318);
				match(DOT);
				setState(319);
				match(IDENTIFIER);
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(325);
				match(LBRACKET);
				setState(326);
				expression();
				setState(327);
				match(RBRACKET);
				}
				}
				setState(333);
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
		public TerminalNode BAGONG() { return getToken(WikangSawaParser.BAGONG, 0); }
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(WikangSawaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(WikangSawaParser.RPAREN, 0); }
		public TerminalNode AMPERSAND() { return getToken(WikangSawaParser.AMPERSAND, 0); }
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
		enterRule(_localctx, 62, RULE_primary);
		int _la;
		try {
			setState(354);
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
				setState(334);
				literal();
				}
				break;
			case BAGONG:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(BAGONG);
				setState(336);
				match(IDENTIFIER);
				setState(337);
				match(LPAREN);
				setState(338);
				match(RPAREN);
				}
				break;
			case AMPERSAND:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				match(AMPERSAND);
				setState(340);
				match(IDENTIFIER);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(341);
				match(IDENTIFIER);
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(342);
					match(LPAREN);
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67578390156148736L) != 0)) {
						{
						setState(343);
						argList();
						}
					}

					setState(346);
					match(RPAREN);
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(349);
				match(LPAREN);
				setState(350);
				expression();
				setState(351);
				match(RPAREN);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
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
		enterRule(_localctx, 64, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			expression();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(357);
				match(COMMA);
				setState(358);
				expression();
				}
				}
				setState(363);
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
		enterRule(_localctx, 66, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(LBRACKET);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67578390156148736L) != 0)) {
				{
				setState(365);
				expression();
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(366);
					match(COMMA);
					setState(367);
					expression();
					}
					}
					setState(372);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(375);
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
		enterRule(_localctx, 68, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525197450313728L) != 0)) ) {
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
		"\u0004\u0001:\u017c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0005\u0000H\b\u0000\n\u0000\f\u0000K\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u0001Q\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002a\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004k\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005v\b\u0005\n\u0005"+
		"\f\u0005y\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0004\t\u0091\b\t\u000b\t\f\t\u0092\u0001\t"+
		"\u0005\t\u0096\b\t\n\t\f\t\u0099\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0003\u000b\u00a4\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0005\u000f\u00b8\b\u000f\n\u000f"+
		"\f\u000f\u00bb\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00c2\b\u0010\n\u0010\f\u0010\u00c5\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00ce\b\u0010\u0003\u0010\u00d0\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00da\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00e6\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ee\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00f5\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00fa\b\u0015\n\u0015"+
		"\f\u0015\u00fd\t\u0015\u0001\u0015\u0004\u0015\u0100\b\u0015\u000b\u0015"+
		"\f\u0015\u0101\u0001\u0015\u0005\u0015\u0105\b\u0015\n\u0015\f\u0015\u0108"+
		"\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u010f\b\u0016\n\u0016\f\u0016\u0112\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u0117\b\u0017\n\u0017\f\u0017\u011a\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u011f\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0125\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u012c\b\u001b\n"+
		"\u001b\f\u001b\u012f\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u0134\b\u001c\n\u001c\f\u001c\u0137\t\u001c\u0001\u001d\u0003\u001d"+
		"\u013a\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0005\u001e\u0141\b\u001e\n\u001e\f\u001e\u0144\t\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u014a\b\u001e\n\u001e\f\u001e"+
		"\u014d\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0159\b\u001f\u0001\u001f\u0003\u001f\u015c\b\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0163\b\u001f\u0001"+
		" \u0001 \u0001 \u0005 \u0168\b \n \f \u016b\t \u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u0171\b!\n!\f!\u0174\t!\u0003!\u0176\b!\u0001!\u0001!\u0001\""+
		"\u0001\"\u0001\"\u0000\u0000#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0006"+
		"\u0002\u0000\u0012\u001277\u0001\u0000\u001d\"\u0001\u0000#$\u0001\u0000"+
		"%\'\u0001\u0000$%\u0002\u0000\u0017\u001946\u018a\u0000I\u0001\u0000\u0000"+
		"\u0000\u0002P\u0001\u0000\u0000\u0000\u0004`\u0001\u0000\u0000\u0000\u0006"+
		"b\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000"+
		"\u0000\fz\u0001\u0000\u0000\u0000\u000e\u0080\u0001\u0000\u0000\u0000"+
		"\u0010\u0086\u0001\u0000\u0000\u0000\u0012\u008d\u0001\u0000\u0000\u0000"+
		"\u0014\u009c\u0001\u0000\u0000\u0000\u0016\u00a3\u0001\u0000\u0000\u0000"+
		"\u0018\u00aa\u0001\u0000\u0000\u0000\u001a\u00ae\u0001\u0000\u0000\u0000"+
		"\u001c\u00b2\u0001\u0000\u0000\u0000\u001e\u00b9\u0001\u0000\u0000\u0000"+
		" \u00bc\u0001\u0000\u0000\u0000\"\u00d3\u0001\u0000\u0000\u0000$\u00db"+
		"\u0001\u0000\u0000\u0000&\u00e7\u0001\u0000\u0000\u0000(\u00ef\u0001\u0000"+
		"\u0000\u0000*\u00f6\u0001\u0000\u0000\u0000,\u010b\u0001\u0000\u0000\u0000"+
		".\u0113\u0001\u0000\u0000\u00000\u011e\u0001\u0000\u0000\u00002\u0120"+
		"\u0001\u0000\u0000\u00004\u0126\u0001\u0000\u0000\u00006\u0128\u0001\u0000"+
		"\u0000\u00008\u0130\u0001\u0000\u0000\u0000:\u0139\u0001\u0000\u0000\u0000"+
		"<\u013d\u0001\u0000\u0000\u0000>\u0162\u0001\u0000\u0000\u0000@\u0164"+
		"\u0001\u0000\u0000\u0000B\u016c\u0001\u0000\u0000\u0000D\u0179\u0001\u0000"+
		"\u0000\u0000FH\u0003\u0002\u0001\u0000GF\u0001\u0000\u0000\u0000HK\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0005\u0000\u0000"+
		"\u0001M\u0001\u0001\u0000\u0000\u0000NQ\u0003\u0004\u0002\u0000OQ\u0005"+
		":\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000Q\u0003"+
		"\u0001\u0000\u0000\u0000Ra\u0003\u0006\u0003\u0000Sa\u0003\b\u0004\u0000"+
		"Ta\u0003\u0010\b\u0000Ua\u0003\f\u0006\u0000Va\u0003\u000e\u0007\u0000"+
		"Wa\u0003\u0016\u000b\u0000Xa\u0003\u001a\r\u0000Ya\u0003\u0018\f\u0000"+
		"Za\u0003\u001c\u000e\u0000[a\u0003 \u0010\u0000\\a\u0003\"\u0011\u0000"+
		"]a\u0003$\u0012\u0000^a\u0003&\u0013\u0000_a\u0003(\u0014\u0000`R\u0001"+
		"\u0000\u0000\u0000`S\u0001\u0000\u0000\u0000`T\u0001\u0000\u0000\u0000"+
		"`U\u0001\u0000\u0000\u0000`V\u0001\u0000\u0000\u0000`W\u0001\u0000\u0000"+
		"\u0000`X\u0001\u0000\u0000\u0000`Y\u0001\u0000\u0000\u0000`Z\u0001\u0000"+
		"\u0000\u0000`[\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000`]\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000"+
		"a\u0005\u0001\u0000\u0000\u0000bc\u0005\u0003\u0000\u0000cd\u0007\u0000"+
		"\u0000\u0000de\u0005:\u0000\u0000e\u0007\u0001\u0000\u0000\u0000fg\u0005"+
		"\u0004\u0000\u0000gh\u00057\u0000\u0000hj\u0005*\u0000\u0000ik\u0003\n"+
		"\u0005\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000lm\u0005+\u0000\u0000mn\u00052\u0000\u0000no\u0003*"+
		"\u0015\u0000op\u0005\n\u0000\u0000pq\u0003\u001e\u000f\u0000q\t\u0001"+
		"\u0000\u0000\u0000rw\u00057\u0000\u0000st\u00050\u0000\u0000tv\u00057"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u000b\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z{\u0005\b\u0000\u0000{|\u00057\u0000"+
		"\u0000|}\u0005(\u0000\u0000}~\u0003,\u0016\u0000~\u007f\u0005:\u0000\u0000"+
		"\u007f\r\u0001\u0000\u0000\u0000\u0080\u0081\u0005\t\u0000\u0000\u0081"+
		"\u0082\u00057\u0000\u0000\u0082\u0083\u0005(\u0000\u0000\u0083\u0084\u0003"+
		",\u0016\u0000\u0084\u0085\u0005:\u0000\u0000\u0085\u000f\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u0015\u0000\u0000\u0087\u0088\u00057\u0000\u0000"+
		"\u0088\u0089\u00052\u0000\u0000\u0089\u008a\u0003\u0012\t\u0000\u008a"+
		"\u008b\u0005\n\u0000\u0000\u008b\u008c\u0003\u001e\u000f\u0000\u008c\u0011"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005:\u0000\u0000\u008e\u0090\u0005"+
		"\u0001\u0000\u0000\u008f\u0091\u0003\u0014\n\u0000\u0090\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0097\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\u0005:\u0000\u0000\u0095\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0002\u0000"+
		"\u0000\u009b\u0013\u0001\u0000\u0000\u0000\u009c\u009d\u0005\b\u0000\u0000"+
		"\u009d\u009e\u00057\u0000\u0000\u009e\u009f\u0005(\u0000\u0000\u009f\u00a0"+
		"\u0003,\u0016\u0000\u00a0\u00a1\u0005:\u0000\u0000\u00a1\u0015\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a4\u0005%\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u00057\u0000\u0000\u00a6\u00a7\u0005(\u0000\u0000\u00a7"+
		"\u00a8\u0003,\u0016\u0000\u00a8\u00a9\u0005:\u0000\u0000\u00a9\u0017\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\u0013\u0000\u0000\u00ab\u00ac\u0005"+
		"7\u0000\u0000\u00ac\u00ad\u0005:\u0000\u0000\u00ad\u0019\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0005\u0012\u0000\u0000\u00af\u00b0\u0003,\u0016\u0000"+
		"\u00b0\u00b1\u0005:\u0000\u0000\u00b1\u001b\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005\u0005\u0000\u0000\u00b3\u00b4\u0003,\u0016\u0000\u00b4\u00b5"+
		"\u0005:\u0000\u0000\u00b5\u001d\u0001\u0000\u0000\u0000\u00b6\u00b8\u0005"+
		":\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005\u0006\u0000\u0000\u00bd\u00be\u0003,\u0016"+
		"\u0000\u00be\u00bf\u00052\u0000\u0000\u00bf\u00c3\u0003*\u0015\u0000\u00c0"+
		"\u00c2\u0005:\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c6\u00cf\u0005\n\u0000\u0000\u00c7\u00c8\u0003"+
		"\u001e\u000f\u0000\u00c8\u00c9\u0005\u000f\u0000\u0000\u00c9\u00ca\u0005"+
		"2\u0000\u0000\u00ca\u00cb\u0003*\u0015\u0000\u00cb\u00cd\u0003\u001e\u000f"+
		"\u0000\u00cc\u00ce\u0005\n\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000"+
		"\u00cf\u00c7\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0003\u001e\u000f\u0000"+
		"\u00d2!\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0007\u0000\u0000\u00d4"+
		"\u00d5\u0003,\u0016\u0000\u00d5\u00d6\u00052\u0000\u0000\u00d6\u00d7\u0003"+
		"*\u0015\u0000\u00d7\u00d9\u0005\n\u0000\u0000\u00d8\u00da\u0005:\u0000"+
		"\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000"+
		"\u0000\u00da#\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u000b\u0000\u0000"+
		"\u00dc\u00dd\u00057\u0000\u0000\u00dd\u00de\u0005(\u0000\u0000\u00de\u00df"+
		"\u0003,\u0016\u0000\u00df\u00e0\u0005\r\u0000\u0000\u00e0\u00e1\u0003"+
		",\u0016\u0000\u00e1\u00e2\u00052\u0000\u0000\u00e2\u00e3\u0003*\u0015"+
		"\u0000\u00e3\u00e5\u0005\n\u0000\u0000\u00e4\u00e6\u0005:\u0000\u0000"+
		"\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e6%\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\f\u0000\u0000\u00e8"+
		"\u00e9\u00052\u0000\u0000\u00e9\u00ea\u0003*\u0015\u0000\u00ea\u00eb\u0005"+
		"\r\u0000\u0000\u00eb\u00ed\u0003,\u0016\u0000\u00ec\u00ee\u0005:\u0000"+
		"\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\'\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u0014\u0000\u0000"+
		"\u00f0\u00f1\u00052\u0000\u0000\u00f1\u00f2\u0003*\u0015\u0000\u00f2\u00f4"+
		"\u0005\n\u0000\u0000\u00f3\u00f5\u0005:\u0000\u0000\u00f4\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5)\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0005:\u0000\u0000\u00f7\u00ff\u0005\u0001\u0000"+
		"\u0000\u00f8\u00fa\u0005:\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u0100\u0003\u0004\u0002\u0000"+
		"\u00ff\u00fb\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000"+
		"\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0106\u0001\u0000\u0000\u0000\u0103\u0105\u0005:\u0000\u0000\u0104"+
		"\u0103\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106"+
		"\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107"+
		"\u0109\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0005\u0002\u0000\u0000\u010a+\u0001\u0000\u0000\u0000\u010b\u0110"+
		"\u0003.\u0017\u0000\u010c\u010d\u0005\u001b\u0000\u0000\u010d\u010f\u0003"+
		".\u0017\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000"+
		"\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000"+
		"\u0000\u0000\u0111-\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000"+
		"\u0000\u0113\u0118\u00030\u0018\u0000\u0114\u0115\u0005\u001a\u0000\u0000"+
		"\u0115\u0117\u00030\u0018\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117"+
		"\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0001\u0000\u0000\u0000\u0119/\u0001\u0000\u0000\u0000\u011a\u0118"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u001c\u0000\u0000\u011c\u011f"+
		"\u00030\u0018\u0000\u011d\u011f\u00032\u0019\u0000\u011e\u011b\u0001\u0000"+
		"\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f1\u0001\u0000\u0000"+
		"\u0000\u0120\u0124\u00036\u001b\u0000\u0121\u0122\u00034\u001a\u0000\u0122"+
		"\u0123\u00036\u001b\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0121"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u01253\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0007\u0001\u0000\u0000\u01275\u0001\u0000"+
		"\u0000\u0000\u0128\u012d\u00038\u001c\u0000\u0129\u012a\u0007\u0002\u0000"+
		"\u0000\u012a\u012c\u00038\u001c\u0000\u012b\u0129\u0001\u0000\u0000\u0000"+
		"\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0001\u0000\u0000\u0000\u012e7\u0001\u0000\u0000\u0000\u012f"+
		"\u012d\u0001\u0000\u0000\u0000\u0130\u0135\u0003:\u001d\u0000\u0131\u0132"+
		"\u0007\u0003\u0000\u0000\u0132\u0134\u0003:\u001d\u0000\u0133\u0131\u0001"+
		"\u0000\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u01369\u0001\u0000"+
		"\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u013a\u0007\u0004"+
		"\u0000\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0003<\u001e"+
		"\u0000\u013c;\u0001\u0000\u0000\u0000\u013d\u0142\u0003>\u001f\u0000\u013e"+
		"\u013f\u00053\u0000\u0000\u013f\u0141\u00057\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u014b\u0001"+
		"\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146\u0005"+
		",\u0000\u0000\u0146\u0147\u0003,\u0016\u0000\u0147\u0148\u0005-\u0000"+
		"\u0000\u0148\u014a\u0001\u0000\u0000\u0000\u0149\u0145\u0001\u0000\u0000"+
		"\u0000\u014a\u014d\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c=\u0001\u0000\u0000\u0000"+
		"\u014d\u014b\u0001\u0000\u0000\u0000\u014e\u0163\u0003D\"\u0000\u014f"+
		"\u0150\u0005\u0016\u0000\u0000\u0150\u0151\u00057\u0000\u0000\u0151\u0152"+
		"\u0005*\u0000\u0000\u0152\u0163\u0005+\u0000\u0000\u0153\u0154\u0005)"+
		"\u0000\u0000\u0154\u0163\u00057\u0000\u0000\u0155\u015b\u00057\u0000\u0000"+
		"\u0156\u0158\u0005*\u0000\u0000\u0157\u0159\u0003@ \u0000\u0158\u0157"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0001\u0000\u0000\u0000\u015a\u015c\u0005+\u0000\u0000\u015b\u0156\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u0163\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0005*\u0000\u0000\u015e\u015f\u0003,\u0016"+
		"\u0000\u015f\u0160\u0005+\u0000\u0000\u0160\u0163\u0001\u0000\u0000\u0000"+
		"\u0161\u0163\u0003B!\u0000\u0162\u014e\u0001\u0000\u0000\u0000\u0162\u014f"+
		"\u0001\u0000\u0000\u0000\u0162\u0153\u0001\u0000\u0000\u0000\u0162\u0155"+
		"\u0001\u0000\u0000\u0000\u0162\u015d\u0001\u0000\u0000\u0000\u0162\u0161"+
		"\u0001\u0000\u0000\u0000\u0163?\u0001\u0000\u0000\u0000\u0164\u0169\u0003"+
		",\u0016\u0000\u0165\u0166\u00050\u0000\u0000\u0166\u0168\u0003,\u0016"+
		"\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000"+
		"\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000"+
		"\u0000\u016aA\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016c\u0175\u0005,\u0000\u0000\u016d\u0172\u0003,\u0016\u0000\u016e\u016f"+
		"\u00050\u0000\u0000\u016f\u0171\u0003,\u0016\u0000\u0170\u016e\u0001\u0000"+
		"\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000\u0172\u0170\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000"+
		"\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0175\u016d\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000"+
		"\u0000\u0000\u0177\u0178\u0005-\u0000\u0000\u0178C\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0007\u0005\u0000\u0000\u017aE\u0001\u0000\u0000\u0000\""+
		"IP`jw\u0092\u0097\u00a3\u00b9\u00c3\u00cd\u00cf\u00d9\u00e5\u00ed\u00f4"+
		"\u00fb\u0101\u0106\u0110\u0118\u011e\u0124\u012d\u0135\u0139\u0142\u014b"+
		"\u0158\u015b\u0162\u0169\u0172\u0175";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}