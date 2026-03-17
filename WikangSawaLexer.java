// Generated from WikangSawaLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class WikangSawaLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GAMITIN", "PUNSYON", "BALIK", "KUNG", "HABANG", "BARYABOL", "TAPOS", 
			"PARA", "KAPAG", "KUNDI", "SA", "AY", "MAGPAKITA", "MAGBASA", "TOTOO", 
			"MALI", "WALA", "AT", "O", "HINDI", "EQUAL", "NOT_EQUAL", "LT", "GT", 
			"LE", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "ASSIGN", "LPAREN", 
			"RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", 
			"COLON", "DOT", "NUMERO", "DESIMAL", "SALITA", "IDENTIFIER", "COMMENT", 
			"WS", "NEWLINE"
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


	    private java.util.Stack<Integer> indentStack = new java.util.Stack<>();
	    private java.util.Queue<Token> tokenQueue = new java.util.LinkedList<>();
	    private boolean initialized = false;
	    
	    @Override
	    public Token nextToken() {
	        if (!initialized) {
	            indentStack.push(0);
	            initialized = true;
	        }
	        
	        if (!tokenQueue.isEmpty()) {
	            return tokenQueue.poll();
	        }
	        
	        Token next = super.nextToken();
	        
	        if (next.getType() == EOF) {
	            // Handle EOF: emit DEDENTs for remaining indentation levels
	            while (indentStack.size() > 1) {
	                indentStack.pop();
	                CommonToken dedent = new CommonToken(_tokenFactorySourcePair, DEDENT, DEFAULT_TOKEN_CHANNEL, 
	                    next.getStartIndex(), next.getStopIndex());
	                dedent.setLine(next.getLine());
	                dedent.setCharPositionInLine(next.getCharPositionInLine());
	                tokenQueue.offer(dedent);
	            }
	            if (!tokenQueue.isEmpty()) {
	                return tokenQueue.poll();
	            }
	        }
	        
	        return next;
	    }
	    
	    private int calculateIndentation(String whitespace) {
	        int length = 0;
	        for (char c : whitespace.toCharArray()) {
	            if (c == ' ') {
	                length++;
	            } else if (c == '\t') {
	                length += 8; // Tab is typically 8 spaces
	            } else {
	                break;
	            }
	        }
	        return length;
	    }
	    
	    private Token createIndentDedentToken(int type, int line, int charPositionInLine, int startIndex, int stopIndex) {
	        CommonToken token = new CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL,
	            startIndex, stopIndex);
	        token.setLine(line);
	        token.setCharPositionInLine(charPositionInLine);
	        return token;
	    }


	public WikangSawaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WikangSawaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 48:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    String text = getText();
			    // Extract just the newline part for the token text
			    int newlineEnd = text.indexOf('\n') + 1;
			    String newlinePart = text.substring(0, newlineEnd);
			    String whitespacePart = text.substring(newlineEnd);
			    
			    // Set token text to just the newline
			    setText(newlinePart);
			    
			    // Calculate indentation from whitespace
			    int indent = calculateIndentation(whitespacePart);
			    int currentLevel = indentStack.peek();
			    
			    // Check if next token is EOF or another newline (empty line)
			    int nextChar = _input.LA(1);
			    if (nextChar == EOF || nextChar == '\r' || nextChar == '\n') {
			        // Empty line or EOF - don't change indentation, just emit NEWLINE
			        return;
			    }
			    
			    if (indent > currentLevel) {
			        // Increased indentation
			        indentStack.push(indent);
			        // Queue INDENT after NEWLINE
			        int line = getLine();
			        int col = getCharPositionInLine();
			        int start = _tokenStartCharIndex;
			        int stop = _input.index() - 1;
			        Token indentToken = createIndentDedentToken(INDENT, line, col, start, stop);
			        tokenQueue.offer(indentToken);
			    } else if (indent < currentLevel) {
			        // Decreased indentation
			        while (!indentStack.isEmpty() && indent < indentStack.peek()) {
			            indentStack.pop();
			            int line = getLine();
			            int col = getCharPositionInLine();
			            int start = _tokenStartCharIndex;
			            int stop = _input.index() - 1;
			            Token dedentToken = createIndentDedentToken(DEDENT, line, col, start, stop);
			            tokenQueue.offer(dedentToken);
			        }
			        if (indentStack.isEmpty() || indent != indentStack.peek()) {
			            // Indentation error - mismatched indentation
			            // Still emit the newline
			        }
			    }
			    // If equal, just emit NEWLINE (this token)

			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u00003\u0150\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0004*\u010a\b*\u000b*\f*\u010b\u0001+\u0004"+
		"+\u010f\b+\u000b+\f+\u0110\u0001+\u0001+\u0005+\u0115\b+\n+\f+\u0118\t"+
		"+\u0001+\u0001+\u0004+\u011c\b+\u000b+\f+\u011d\u0003+\u0120\b+\u0001"+
		",\u0001,\u0001,\u0001,\u0005,\u0126\b,\n,\f,\u0129\t,\u0001,\u0001,\u0001"+
		"-\u0001-\u0005-\u012f\b-\n-\f-\u0132\t-\u0001.\u0001.\u0005.\u0136\b."+
		"\n.\f.\u0139\t.\u0001.\u0001.\u0001/\u0004/\u013e\b/\u000b/\f/\u013f\u0001"+
		"/\u0001/\u00010\u00030\u0145\b0\u00010\u00010\u00010\u00050\u014a\b0\n"+
		"0\f0\u014d\t0\u00010\u00010\u0000\u00001\u0001\u0003\u0003\u0004\u0005"+
		"\u0005\u0007\u0006\t\u0007\u000b\b\r\t\u000f\n\u0011\u000b\u0013\f\u0015"+
		"\r\u0017\u000e\u0019\u000f\u001b\u0010\u001d\u0011\u001f\u0012!\u0013"+
		"#\u0014%\u0015\'\u0016)\u0017+\u0018-\u0019/\u001a1\u001b3\u001c5\u001d"+
		"7\u001e9\u001f; =!?\"A#C$E%G&I\'K(M)O*Q+S,U-W.Y/[0]1_2a3\u0001\u0000\u0007"+
		"\u0001\u000009\u0007\u0000\"\"\\\\bbffnnrrtt\u0004\u0000\n\n\r\r\"\"\\"+
		"\\\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\n\n\r\r\u0002\u0000"+
		"\t\t  \u015b\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001"+
		"\u0000\u0000\u0000\u0001c\u0001\u0000\u0000\u0000\u0003k\u0001\u0000\u0000"+
		"\u0000\u0005s\u0001\u0000\u0000\u0000\u0007y\u0001\u0000\u0000\u0000\t"+
		"~\u0001\u0000\u0000\u0000\u000b\u0085\u0001\u0000\u0000\u0000\r\u008e"+
		"\u0001\u0000\u0000\u0000\u000f\u0094\u0001\u0000\u0000\u0000\u0011\u0099"+
		"\u0001\u0000\u0000\u0000\u0013\u009f\u0001\u0000\u0000\u0000\u0015\u00a5"+
		"\u0001\u0000\u0000\u0000\u0017\u00a8\u0001\u0000\u0000\u0000\u0019\u00ab"+
		"\u0001\u0000\u0000\u0000\u001b\u00b5\u0001\u0000\u0000\u0000\u001d\u00bd"+
		"\u0001\u0000\u0000\u0000\u001f\u00c3\u0001\u0000\u0000\u0000!\u00c8\u0001"+
		"\u0000\u0000\u0000#\u00cd\u0001\u0000\u0000\u0000%\u00d0\u0001\u0000\u0000"+
		"\u0000\'\u00d2\u0001\u0000\u0000\u0000)\u00d8\u0001\u0000\u0000\u0000"+
		"+\u00db\u0001\u0000\u0000\u0000-\u00de\u0001\u0000\u0000\u0000/\u00e0"+
		"\u0001\u0000\u0000\u00001\u00e2\u0001\u0000\u0000\u00003\u00e5\u0001\u0000"+
		"\u0000\u00005\u00e8\u0001\u0000\u0000\u00007\u00ea\u0001\u0000\u0000\u0000"+
		"9\u00ec\u0001\u0000\u0000\u0000;\u00ee\u0001\u0000\u0000\u0000=\u00f0"+
		"\u0001\u0000\u0000\u0000?\u00f2\u0001\u0000\u0000\u0000A\u00f4\u0001\u0000"+
		"\u0000\u0000C\u00f6\u0001\u0000\u0000\u0000E\u00f8\u0001\u0000\u0000\u0000"+
		"G\u00fa\u0001\u0000\u0000\u0000I\u00fc\u0001\u0000\u0000\u0000K\u00fe"+
		"\u0001\u0000\u0000\u0000M\u0100\u0001\u0000\u0000\u0000O\u0102\u0001\u0000"+
		"\u0000\u0000Q\u0104\u0001\u0000\u0000\u0000S\u0106\u0001\u0000\u0000\u0000"+
		"U\u0109\u0001\u0000\u0000\u0000W\u011f\u0001\u0000\u0000\u0000Y\u0121"+
		"\u0001\u0000\u0000\u0000[\u012c\u0001\u0000\u0000\u0000]\u0133\u0001\u0000"+
		"\u0000\u0000_\u013d\u0001\u0000\u0000\u0000a\u0144\u0001\u0000\u0000\u0000"+
		"cd\u0005g\u0000\u0000de\u0005a\u0000\u0000ef\u0005m\u0000\u0000fg\u0005"+
		"i\u0000\u0000gh\u0005t\u0000\u0000hi\u0005i\u0000\u0000ij\u0005n\u0000"+
		"\u0000j\u0002\u0001\u0000\u0000\u0000kl\u0005p\u0000\u0000lm\u0005u\u0000"+
		"\u0000mn\u0005n\u0000\u0000no\u0005s\u0000\u0000op\u0005y\u0000\u0000"+
		"pq\u0005o\u0000\u0000qr\u0005n\u0000\u0000r\u0004\u0001\u0000\u0000\u0000"+
		"st\u0005b\u0000\u0000tu\u0005a\u0000\u0000uv\u0005l\u0000\u0000vw\u0005"+
		"i\u0000\u0000wx\u0005k\u0000\u0000x\u0006\u0001\u0000\u0000\u0000yz\u0005"+
		"k\u0000\u0000z{\u0005u\u0000\u0000{|\u0005n\u0000\u0000|}\u0005g\u0000"+
		"\u0000}\b\u0001\u0000\u0000\u0000~\u007f\u0005h\u0000\u0000\u007f\u0080"+
		"\u0005a\u0000\u0000\u0080\u0081\u0005b\u0000\u0000\u0081\u0082\u0005a"+
		"\u0000\u0000\u0082\u0083\u0005n\u0000\u0000\u0083\u0084\u0005g\u0000\u0000"+
		"\u0084\n\u0001\u0000\u0000\u0000\u0085\u0086\u0005b\u0000\u0000\u0086"+
		"\u0087\u0005a\u0000\u0000\u0087\u0088\u0005r\u0000\u0000\u0088\u0089\u0005"+
		"y\u0000\u0000\u0089\u008a\u0005a\u0000\u0000\u008a\u008b\u0005b\u0000"+
		"\u0000\u008b\u008c\u0005o\u0000\u0000\u008c\u008d\u0005l\u0000\u0000\u008d"+
		"\f\u0001\u0000\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f\u0090"+
		"\u0005a\u0000\u0000\u0090\u0091\u0005p\u0000\u0000\u0091\u0092\u0005o"+
		"\u0000\u0000\u0092\u0093\u0005s\u0000\u0000\u0093\u000e\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005p\u0000\u0000\u0095\u0096\u0005a\u0000\u0000\u0096"+
		"\u0097\u0005r\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098\u0010\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005k\u0000\u0000\u009a\u009b\u0005a\u0000"+
		"\u0000\u009b\u009c\u0005p\u0000\u0000\u009c\u009d\u0005a\u0000\u0000\u009d"+
		"\u009e\u0005g\u0000\u0000\u009e\u0012\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0005k\u0000\u0000\u00a0\u00a1\u0005u\u0000\u0000\u00a1\u00a2\u0005n"+
		"\u0000\u0000\u00a2\u00a3\u0005d\u0000\u0000\u00a3\u00a4\u0005i\u0000\u0000"+
		"\u00a4\u0014\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005s\u0000\u0000\u00a6"+
		"\u00a7\u0005a\u0000\u0000\u00a7\u0016\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005a\u0000\u0000\u00a9\u00aa\u0005y\u0000\u0000\u00aa\u0018\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0005m\u0000\u0000\u00ac\u00ad\u0005a\u0000\u0000"+
		"\u00ad\u00ae\u0005g\u0000\u0000\u00ae\u00af\u0005p\u0000\u0000\u00af\u00b0"+
		"\u0005a\u0000\u0000\u00b0\u00b1\u0005k\u0000\u0000\u00b1\u00b2\u0005i"+
		"\u0000\u0000\u00b2\u00b3\u0005t\u0000\u0000\u00b3\u00b4\u0005a\u0000\u0000"+
		"\u00b4\u001a\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005m\u0000\u0000\u00b6"+
		"\u00b7\u0005a\u0000\u0000\u00b7\u00b8\u0005g\u0000\u0000\u00b8\u00b9\u0005"+
		"b\u0000\u0000\u00b9\u00ba\u0005a\u0000\u0000\u00ba\u00bb\u0005s\u0000"+
		"\u0000\u00bb\u00bc\u0005a\u0000\u0000\u00bc\u001c\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005t\u0000\u0000\u00be\u00bf\u0005o\u0000\u0000\u00bf\u00c0"+
		"\u0005t\u0000\u0000\u00c0\u00c1\u0005o\u0000\u0000\u00c1\u00c2\u0005o"+
		"\u0000\u0000\u00c2\u001e\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005m\u0000"+
		"\u0000\u00c4\u00c5\u0005a\u0000\u0000\u00c5\u00c6\u0005l\u0000\u0000\u00c6"+
		"\u00c7\u0005i\u0000\u0000\u00c7 \u0001\u0000\u0000\u0000\u00c8\u00c9\u0005"+
		"w\u0000\u0000\u00c9\u00ca\u0005a\u0000\u0000\u00ca\u00cb\u0005l\u0000"+
		"\u0000\u00cb\u00cc\u0005a\u0000\u0000\u00cc\"\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0005a\u0000\u0000\u00ce\u00cf\u0005t\u0000\u0000\u00cf$"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005o\u0000\u0000\u00d1&\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0005h\u0000\u0000\u00d3\u00d4\u0005i\u0000\u0000"+
		"\u00d4\u00d5\u0005n\u0000\u0000\u00d5\u00d6\u0005d\u0000\u0000\u00d6\u00d7"+
		"\u0005i\u0000\u0000\u00d7(\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005="+
		"\u0000\u0000\u00d9\u00da\u0005=\u0000\u0000\u00da*\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005!\u0000\u0000\u00dc\u00dd\u0005=\u0000\u0000\u00dd,"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0005<\u0000\u0000\u00df.\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0005>\u0000\u0000\u00e10\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0005<\u0000\u0000\u00e3\u00e4\u0005=\u0000\u0000\u00e42"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005>\u0000\u0000\u00e6\u00e7\u0005"+
		"=\u0000\u0000\u00e74\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005+\u0000"+
		"\u0000\u00e96\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005-\u0000\u0000\u00eb"+
		"8\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005*\u0000\u0000\u00ed:\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0005/\u0000\u0000\u00ef<\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0005%\u0000\u0000\u00f1>\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0005=\u0000\u0000\u00f3@\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005"+
		"(\u0000\u0000\u00f5B\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005)\u0000"+
		"\u0000\u00f7D\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005[\u0000\u0000\u00f9"+
		"F\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005]\u0000\u0000\u00fbH\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005{\u0000\u0000\u00fdJ\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0005}\u0000\u0000\u00ffL\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0005,\u0000\u0000\u0101N\u0001\u0000\u0000\u0000\u0102\u0103\u0005"+
		";\u0000\u0000\u0103P\u0001\u0000\u0000\u0000\u0104\u0105\u0005:\u0000"+
		"\u0000\u0105R\u0001\u0000\u0000\u0000\u0106\u0107\u0005.\u0000\u0000\u0107"+
		"T\u0001\u0000\u0000\u0000\u0108\u010a\u0007\u0000\u0000\u0000\u0109\u0108"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010cV\u0001"+
		"\u0000\u0000\u0000\u010d\u010f\u0007\u0000\u0000\u0000\u010e\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u0116\u0005.\u0000\u0000\u0113\u0115\u0007\u0000"+
		"\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000"+
		"\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117\u0120\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0119\u011b\u0005.\u0000\u0000\u011a\u011c\u0007\u0000\u0000"+
		"\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000"+
		"\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u010e\u0001\u0000\u0000"+
		"\u0000\u011f\u0119\u0001\u0000\u0000\u0000\u0120X\u0001\u0000\u0000\u0000"+
		"\u0121\u0127\u0005\"\u0000\u0000\u0122\u0123\u0005\\\u0000\u0000\u0123"+
		"\u0126\u0007\u0001\u0000\u0000\u0124\u0126\b\u0002\u0000\u0000\u0125\u0122"+
		"\u0001\u0000\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0129"+
		"\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128"+
		"\u0001\u0000\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0127"+
		"\u0001\u0000\u0000\u0000\u012a\u012b\u0005\"\u0000\u0000\u012bZ\u0001"+
		"\u0000\u0000\u0000\u012c\u0130\u0007\u0003\u0000\u0000\u012d\u012f\u0007"+
		"\u0004\u0000\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012f\u0132\u0001"+
		"\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001"+
		"\u0000\u0000\u0000\u0131\\\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000"+
		"\u0000\u0000\u0133\u0137\u0005#\u0000\u0000\u0134\u0136\b\u0005\u0000"+
		"\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0139\u0001\u0000\u0000"+
		"\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138\u013a\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0006.\u0000\u0000\u013b^\u0001\u0000\u0000\u0000\u013c"+
		"\u013e\u0007\u0006\u0000\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f"+
		"\u0140\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0006/\u0000\u0000\u0142`\u0001\u0000\u0000\u0000\u0143\u0145\u0005"+
		"\r\u0000\u0000\u0144\u0143\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0147\u0005\n\u0000"+
		"\u0000\u0147\u014b\u0001\u0000\u0000\u0000\u0148\u014a\u0007\u0006\u0000"+
		"\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000\u0000"+
		"\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014e\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\u00060\u0001\u0000\u014fb\u0001\u0000\u0000\u0000\r"+
		"\u0000\u010b\u0110\u0116\u011d\u011f\u0125\u0127\u0130\u0137\u013f\u0144"+
		"\u014b\u0002\u0006\u0000\u0000\u00010\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}