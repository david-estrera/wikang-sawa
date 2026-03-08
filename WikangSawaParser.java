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
		INDENT=1, DEDENT=2, GAMITIN=3, KUNG=4, HABANG=5, BARYABOL=6, TAPOS=7, 
		PARA=8, KAPAG=9, KUNDI=10, SA=11, AY=12, MAGPAKITA=13, MAGBASA=14, TOTOO=15, 
		MALI=16, WALA=17, AT=18, O=19, HINDI=20, EQUAL=21, NOT_EQUAL=22, LT=23, 
		GT=24, LE=25, GE=26, PLUS=27, MINUS=28, STAR=29, SLASH=30, PERCENT=31, 
		ASSIGN=32, LPAREN=33, RPAREN=34, LBRACKET=35, RBRACKET=36, LBRACE=37, 
		RBRACE=38, COMMA=39, SEMICOLON=40, COLON=41, DOT=42, NUMERO=43, DESIMAL=44, 
		SALITA=45, IDENTIFIER=46, COMMENT=47, WS=48, NEWLINE=49;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_blockStatement = 2, RULE_importStatement = 3, 
		RULE_variableDeclaration = 4, RULE_assignmentStatement = 5, RULE_printStatement = 6, 
		RULE_optionalNewlines = 7, RULE_conditionalStatement = 8, RULE_loopStatement = 9, 
		RULE_block = 10, RULE_expression = 11, RULE_andExpression = 12, RULE_notExpression = 13, 
		RULE_comparisonExpression = 14, RULE_relOp = 15, RULE_arithmeticExpression = 16, 
		RULE_term = 17, RULE_factor = 18, RULE_literal = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "blockStatement", "importStatement", "variableDeclaration", 
			"assignmentStatement", "printStatement", "optionalNewlines", "conditionalStatement", 
			"loopStatement", "block", "expression", "andExpression", "notExpression", 
			"comparisonExpression", "relOp", "arithmeticExpression", "term", "factor", 
			"literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'gamitin'", "'kung'", "'habang'", "'baryabol'", "'tapos'", 
			"'para'", "'kapag'", "'kundi'", "'sa'", "'ay'", "'magpakita'", "'magbasa'", 
			"'totoo'", "'mali'", "'wala'", "'at'", "'o'", "'hindi'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "','", "';'", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "GAMITIN", "KUNG", "HABANG", "BARYABOL", "TAPOS", 
			"PARA", "KAPAG", "KUNDI", "SA", "AY", "MAGPAKITA", "MAGBASA", "TOTOO", 
			"MALI", "WALA", "AT", "O", "HINDI", "EQUAL", "NOT_EQUAL", "LT", "GT", 
			"LE", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", 
			"COLON", "DOT", "NUMERO", "DESIMAL", "SALITA", "IDENTIFIER", "COMMENT", 
			"WS", "NEWLINE"
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 633318697607288L) != 0)) {
				{
				{
				setState(40);
				statement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
			case KUNG:
			case HABANG:
			case BARYABOL:
			case MAGPAKITA:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				blockStatement();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
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
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GAMITIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				importStatement();
				}
				break;
			case BARYABOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				variableDeclaration();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				assignmentStatement();
				}
				break;
			case MAGPAKITA:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				printStatement();
				}
				break;
			case KUNG:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				conditionalStatement();
				}
				break;
			case HABANG:
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(GAMITIN);
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==MAGPAKITA || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(62);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(BARYABOL);
			setState(65);
			match(IDENTIFIER);
			setState(66);
			match(ASSIGN);
			setState(67);
			expression();
			setState(68);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitAssignmentStatement(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(IDENTIFIER);
			setState(71);
			match(ASSIGN);
			setState(72);
			expression();
			setState(73);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(MAGPAKITA);
			setState(76);
			expression();
			setState(77);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterOptionalNewlines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitOptionalNewlines(this);
		}
	}

	public final OptionalNewlinesContext optionalNewlines() throws RecognitionException {
		OptionalNewlinesContext _localctx = new OptionalNewlinesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_optionalNewlines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					match(NEWLINE);
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitConditionalStatement(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_conditionalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(KUNG);
			setState(86);
			expression();
			setState(87);
			match(COLON);
			setState(88);
			block();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(89);
				match(NEWLINE);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			match(TAPOS);
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(96);
				optionalNewlines();
				setState(97);
				match(KUNDI);
				setState(98);
				match(COLON);
				setState(99);
				block();
				setState(100);
				optionalNewlines();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TAPOS) {
					{
					setState(101);
					match(TAPOS);
					}
				}

				}
				break;
			}
			setState(106);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitLoopStatement(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(HABANG);
			setState(109);
			expression();
			setState(110);
			match(COLON);
			setState(111);
			block();
			setState(112);
			match(TAPOS);
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(113);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(NEWLINE);
			setState(117);
			match(INDENT);
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				blockStatement();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744185976L) != 0) );
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(123);
				match(NEWLINE);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			andExpression();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==O) {
				{
				{
				setState(132);
				match(O);
				setState(133);
				andExpression();
				}
				}
				setState(138);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			notExpression();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(140);
				match(AT);
				setState(141);
				notExpression();
				}
				}
				setState(146);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitNotExpression(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_notExpression);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HINDI:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(HINDI);
				setState(148);
				notExpression();
				}
				break;
			case TOTOO:
			case MALI:
			case WALA:
			case MINUS:
			case LPAREN:
			case NUMERO:
			case DESIMAL:
			case SALITA:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitComparisonExpression(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			arithmeticExpression();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) {
				{
				setState(153);
				relOp();
				setState(154);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitRelOp(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitArithmeticExpression(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			term();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(161);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				term();
				}
				}
				setState(167);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			factor();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3758096384L) != 0)) {
				{
				{
				setState(169);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3758096384L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				factor();
				}
				}
				setState(175);
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(WikangSawaParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(WikangSawaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(WikangSawaParser.RPAREN, 0); }
		public TerminalNode MINUS() { return getToken(WikangSawaParser.MINUS, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(176);
				match(MINUS);
				}
			}

			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOTOO:
			case MALI:
			case WALA:
			case NUMERO:
			case DESIMAL:
			case SALITA:
				{
				setState(179);
				literal();
				}
				break;
			case IDENTIFIER:
				{
				setState(180);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				{
				setState(181);
				match(LPAREN);
				setState(182);
				expression();
				setState(183);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WikangSawaParserListener ) ((WikangSawaParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61572651384832L) != 0)) ) {
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
		"\u0004\u00011\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001"+
		"3\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0005\u0007"+
		"Q\b\u0007\n\u0007\f\u0007T\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b[\b\b\n\b\f\b^\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bg\b\b\u0003\bi\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\ts\b\t\u0001\n\u0001\n\u0001\n\u0004"+
		"\nx\b\n\u000b\n\f\ny\u0001\n\u0005\n}\b\n\n\n\f\n\u0080\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0087\b\u000b\n\u000b"+
		"\f\u000b\u008a\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u008f\b\f\n\f\f"+
		"\f\u0092\t\f\u0001\r\u0001\r\u0001\r\u0003\r\u0097\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u009d\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00a4\b\u0010\n"+
		"\u0010\f\u0010\u00a7\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u00ac\b\u0011\n\u0011\f\u0011\u00af\t\u0011\u0001\u0012\u0003\u0012"+
		"\u00b2\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00ba\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0005\u0002\u0000\r\r..\u0001"+
		"\u0000\u0015\u001a\u0001\u0000\u001b\u001c\u0001\u0000\u001d\u001f\u0002"+
		"\u0000\u000f\u0011+-\u00c0\u0000+\u0001\u0000\u0000\u0000\u00022\u0001"+
		"\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000"+
		"\u0000\b@\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000\u0000\fK\u0001"+
		"\u0000\u0000\u0000\u000eR\u0001\u0000\u0000\u0000\u0010U\u0001\u0000\u0000"+
		"\u0000\u0012l\u0001\u0000\u0000\u0000\u0014t\u0001\u0000\u0000\u0000\u0016"+
		"\u0083\u0001\u0000\u0000\u0000\u0018\u008b\u0001\u0000\u0000\u0000\u001a"+
		"\u0096\u0001\u0000\u0000\u0000\u001c\u0098\u0001\u0000\u0000\u0000\u001e"+
		"\u009e\u0001\u0000\u0000\u0000 \u00a0\u0001\u0000\u0000\u0000\"\u00a8"+
		"\u0001\u0000\u0000\u0000$\u00b1\u0001\u0000\u0000\u0000&\u00bb\u0001\u0000"+
		"\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000"+
		"\u0001/\u0001\u0001\u0000\u0000\u000003\u0003\u0004\u0002\u000013\u0005"+
		"1\u0000\u000020\u0001\u0000\u0000\u000021\u0001\u0000\u0000\u00003\u0003"+
		"\u0001\u0000\u0000\u00004;\u0003\u0006\u0003\u00005;\u0003\b\u0004\u0000"+
		"6;\u0003\n\u0005\u00007;\u0003\f\u0006\u00008;\u0003\u0010\b\u00009;\u0003"+
		"\u0012\t\u0000:4\u0001\u0000\u0000\u0000:5\u0001\u0000\u0000\u0000:6\u0001"+
		"\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":9\u0001\u0000\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0005\u0003"+
		"\u0000\u0000=>\u0007\u0000\u0000\u0000>?\u00051\u0000\u0000?\u0007\u0001"+
		"\u0000\u0000\u0000@A\u0005\u0006\u0000\u0000AB\u0005.\u0000\u0000BC\u0005"+
		" \u0000\u0000CD\u0003\u0016\u000b\u0000DE\u00051\u0000\u0000E\t\u0001"+
		"\u0000\u0000\u0000FG\u0005.\u0000\u0000GH\u0005 \u0000\u0000HI\u0003\u0016"+
		"\u000b\u0000IJ\u00051\u0000\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0005"+
		"\r\u0000\u0000LM\u0003\u0016\u000b\u0000MN\u00051\u0000\u0000N\r\u0001"+
		"\u0000\u0000\u0000OQ\u00051\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"S\u000f\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005\u0004"+
		"\u0000\u0000VW\u0003\u0016\u000b\u0000WX\u0005)\u0000\u0000X\\\u0003\u0014"+
		"\n\u0000Y[\u00051\u0000\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_h\u0005\u0007\u0000\u0000"+
		"`a\u0003\u000e\u0007\u0000ab\u0005\n\u0000\u0000bc\u0005)\u0000\u0000"+
		"cd\u0003\u0014\n\u0000df\u0003\u000e\u0007\u0000eg\u0005\u0007\u0000\u0000"+
		"fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000"+
		"\u0000h`\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000jk\u0003\u000e\u0007\u0000k\u0011\u0001\u0000\u0000\u0000"+
		"lm\u0005\u0005\u0000\u0000mn\u0003\u0016\u000b\u0000no\u0005)\u0000\u0000"+
		"op\u0003\u0014\n\u0000pr\u0005\u0007\u0000\u0000qs\u00051\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0013\u0001\u0000"+
		"\u0000\u0000tu\u00051\u0000\u0000uw\u0005\u0001\u0000\u0000vx\u0003\u0004"+
		"\u0002\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z~\u0001\u0000\u0000\u0000"+
		"{}\u00051\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005\u0002\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0088"+
		"\u0003\u0018\f\u0000\u0084\u0085\u0005\u0013\u0000\u0000\u0085\u0087\u0003"+
		"\u0018\f\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008b\u0090\u0003\u001a\r\u0000\u008c\u008d\u0005\u0012\u0000"+
		"\u0000\u008d\u008f\u0003\u001a\r\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0019\u0001\u0000\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0014\u0000\u0000"+
		"\u0094\u0097\u0003\u001a\r\u0000\u0095\u0097\u0003\u001c\u000e\u0000\u0096"+
		"\u0093\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u001b\u0001\u0000\u0000\u0000\u0098\u009c\u0003 \u0010\u0000\u0099\u009a"+
		"\u0003\u001e\u000f\u0000\u009a\u009b\u0003 \u0010\u0000\u009b\u009d\u0001"+
		"\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c\u009d\u0001"+
		"\u0000\u0000\u0000\u009d\u001d\u0001\u0000\u0000\u0000\u009e\u009f\u0007"+
		"\u0001\u0000\u0000\u009f\u001f\u0001\u0000\u0000\u0000\u00a0\u00a5\u0003"+
		"\"\u0011\u0000\u00a1\u00a2\u0007\u0002\u0000\u0000\u00a2\u00a4\u0003\""+
		"\u0011\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6!\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ad\u0003$\u0012\u0000\u00a9\u00aa\u0007\u0003\u0000\u0000"+
		"\u00aa\u00ac\u0003$\u0012\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac"+
		"\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ae#\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005\u001c\u0000\u0000\u00b1\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b3\u00ba\u0003&\u0013\u0000\u00b4\u00ba\u0005"+
		".\u0000\u0000\u00b5\u00b6\u0005!\u0000\u0000\u00b6\u00b7\u0003\u0016\u000b"+
		"\u0000\u00b7\u00b8\u0005\"\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b5\u0001\u0000\u0000\u0000\u00ba%\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0007\u0004\u0000\u0000\u00bc\'\u0001\u0000\u0000\u0000\u0012+"+
		"2:R\\fhry~\u0088\u0090\u0096\u009c\u00a5\u00ad\u00b1\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}