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
		KONSTANT=9, TAPOS=10, PARA=11, GAWIN=12, HANGGANG=13, KAPAG=14, KUNDI=15, 
		SA=16, AY=17, MAGPAKITA=18, MAGBASA=19, HABANG_MAGBASA=20, ISTRAKTURA=21, 
		BAGONG=22, TOTOO=23, MALI=24, WALA=25, AT=26, O=27, HINDI=28, EQUAL=29, 
		NOT_EQUAL=30, LT=31, GT=32, LE=33, GE=34, PLUS=35, MINUS=36, STAR=37, 
		SLASH=38, PERCENT=39, ASSIGN=40, AMPERSAND=41, LPAREN=42, RPAREN=43, LBRACKET=44, 
		RBRACKET=45, LBRACE=46, RBRACE=47, COMMA=48, SEMICOLON=49, COLON=50, DOT=51, 
		NUMERO=52, DESIMAL=53, SALITA=54, IDENTIFIER=55, COMMENT=56, WS=57, NEWLINE=58;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GAMITIN", "PUNSYON", "BALIK", "KUNG", "HABANG", "BARYABOL", "KONSTANT", 
			"TAPOS", "PARA", "GAWIN", "HANGGANG", "KAPAG", "KUNDI", "SA", "AY", "MAGPAKITA", 
			"MAGBASA", "HABANG_MAGBASA", "ISTRAKTURA", "BAGONG", "TOTOO", "MALI", 
			"WALA", "AT", "O", "HINDI", "EQUAL", "NOT_EQUAL", "LT", "GT", "LE", "GE", 
			"PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "ASSIGN", "AMPERSAND", "LPAREN", 
			"RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", 
			"COLON", "DOT", "NUMERO", "DESIMAL", "SALITA", "IDENTIFIER", "COMMENT", 
			"WS", "NEWLINE"
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
		case 55:
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
		"\u0004\u0000:\u0199\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001"+
		",\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u0001"+
		"1\u00041\u0153\b1\u000b1\f1\u0154\u00012\u00042\u0158\b2\u000b2\f2\u0159"+
		"\u00012\u00012\u00052\u015e\b2\n2\f2\u0161\t2\u00012\u00012\u00042\u0165"+
		"\b2\u000b2\f2\u0166\u00032\u0169\b2\u00013\u00013\u00013\u00013\u0005"+
		"3\u016f\b3\n3\f3\u0172\t3\u00013\u00013\u00014\u00014\u00054\u0178\b4"+
		"\n4\f4\u017b\t4\u00015\u00015\u00055\u017f\b5\n5\f5\u0182\t5\u00015\u0001"+
		"5\u00016\u00046\u0187\b6\u000b6\f6\u0188\u00016\u00016\u00017\u00037\u018e"+
		"\b7\u00017\u00017\u00017\u00057\u0193\b7\n7\f7\u0196\t7\u00017\u00017"+
		"\u0000\u00008\u0001\u0003\u0003\u0004\u0005\u0005\u0007\u0006\t\u0007"+
		"\u000b\b\r\t\u000f\n\u0011\u000b\u0013\f\u0015\r\u0017\u000e\u0019\u000f"+
		"\u001b\u0010\u001d\u0011\u001f\u0012!\u0013#\u0014%\u0015\'\u0016)\u0017"+
		"+\u0018-\u0019/\u001a1\u001b3\u001c5\u001d7\u001e9\u001f; =!?\"A#C$E%"+
		"G&I\'K(M)O*Q+S,U-W.Y/[0]1_2a3c4e5g6i7k8m9o:\u0001\u0000\u0007\u0001\u0000"+
		"09\u0007\u0000\"\"\\\\bbffnnrrtt\u0004\u0000\n\n\r\r\"\"\\\\\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0002\u0000\n\n\r\r\u0002\u0000\t\t  \u01a4"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"+
		"\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000"+
		"\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000"+
		"\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y"+
		"\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000"+
		"\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000"+
		"\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g"+
		"\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000"+
		"\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000"+
		"\u0001q\u0001\u0000\u0000\u0000\u0003y\u0001\u0000\u0000\u0000\u0005\u0081"+
		"\u0001\u0000\u0000\u0000\u0007\u0087\u0001\u0000\u0000\u0000\t\u008c\u0001"+
		"\u0000\u0000\u0000\u000b\u0093\u0001\u0000\u0000\u0000\r\u009c\u0001\u0000"+
		"\u0000\u0000\u000f\u00a5\u0001\u0000\u0000\u0000\u0011\u00ab\u0001\u0000"+
		"\u0000\u0000\u0013\u00b0\u0001\u0000\u0000\u0000\u0015\u00b6\u0001\u0000"+
		"\u0000\u0000\u0017\u00bf\u0001\u0000\u0000\u0000\u0019\u00c5\u0001\u0000"+
		"\u0000\u0000\u001b\u00cb\u0001\u0000\u0000\u0000\u001d\u00ce\u0001\u0000"+
		"\u0000\u0000\u001f\u00d1\u0001\u0000\u0000\u0000!\u00db\u0001\u0000\u0000"+
		"\u0000#\u00e3\u0001\u0000\u0000\u0000%\u00f2\u0001\u0000\u0000\u0000\'"+
		"\u00fd\u0001\u0000\u0000\u0000)\u0104\u0001\u0000\u0000\u0000+\u010a\u0001"+
		"\u0000\u0000\u0000-\u010f\u0001\u0000\u0000\u0000/\u0114\u0001\u0000\u0000"+
		"\u00001\u0117\u0001\u0000\u0000\u00003\u0119\u0001\u0000\u0000\u00005"+
		"\u011f\u0001\u0000\u0000\u00007\u0122\u0001\u0000\u0000\u00009\u0125\u0001"+
		"\u0000\u0000\u0000;\u0127\u0001\u0000\u0000\u0000=\u0129\u0001\u0000\u0000"+
		"\u0000?\u012c\u0001\u0000\u0000\u0000A\u012f\u0001\u0000\u0000\u0000C"+
		"\u0131\u0001\u0000\u0000\u0000E\u0133\u0001\u0000\u0000\u0000G\u0135\u0001"+
		"\u0000\u0000\u0000I\u0137\u0001\u0000\u0000\u0000K\u0139\u0001\u0000\u0000"+
		"\u0000M\u013b\u0001\u0000\u0000\u0000O\u013d\u0001\u0000\u0000\u0000Q"+
		"\u013f\u0001\u0000\u0000\u0000S\u0141\u0001\u0000\u0000\u0000U\u0143\u0001"+
		"\u0000\u0000\u0000W\u0145\u0001\u0000\u0000\u0000Y\u0147\u0001\u0000\u0000"+
		"\u0000[\u0149\u0001\u0000\u0000\u0000]\u014b\u0001\u0000\u0000\u0000_"+
		"\u014d\u0001\u0000\u0000\u0000a\u014f\u0001\u0000\u0000\u0000c\u0152\u0001"+
		"\u0000\u0000\u0000e\u0168\u0001\u0000\u0000\u0000g\u016a\u0001\u0000\u0000"+
		"\u0000i\u0175\u0001\u0000\u0000\u0000k\u017c\u0001\u0000\u0000\u0000m"+
		"\u0186\u0001\u0000\u0000\u0000o\u018d\u0001\u0000\u0000\u0000qr\u0005"+
		"g\u0000\u0000rs\u0005a\u0000\u0000st\u0005m\u0000\u0000tu\u0005i\u0000"+
		"\u0000uv\u0005t\u0000\u0000vw\u0005i\u0000\u0000wx\u0005n\u0000\u0000"+
		"x\u0002\u0001\u0000\u0000\u0000yz\u0005p\u0000\u0000z{\u0005u\u0000\u0000"+
		"{|\u0005n\u0000\u0000|}\u0005s\u0000\u0000}~\u0005y\u0000\u0000~\u007f"+
		"\u0005o\u0000\u0000\u007f\u0080\u0005n\u0000\u0000\u0080\u0004\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005b\u0000\u0000\u0082\u0083\u0005a\u0000\u0000"+
		"\u0083\u0084\u0005l\u0000\u0000\u0084\u0085\u0005i\u0000\u0000\u0085\u0086"+
		"\u0005k\u0000\u0000\u0086\u0006\u0001\u0000\u0000\u0000\u0087\u0088\u0005"+
		"k\u0000\u0000\u0088\u0089\u0005u\u0000\u0000\u0089\u008a\u0005n\u0000"+
		"\u0000\u008a\u008b\u0005g\u0000\u0000\u008b\b\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005h\u0000\u0000\u008d\u008e\u0005a\u0000\u0000\u008e\u008f"+
		"\u0005b\u0000\u0000\u008f\u0090\u0005a\u0000\u0000\u0090\u0091\u0005n"+
		"\u0000\u0000\u0091\u0092\u0005g\u0000\u0000\u0092\n\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005b\u0000\u0000\u0094\u0095\u0005a\u0000\u0000\u0095"+
		"\u0096\u0005r\u0000\u0000\u0096\u0097\u0005y\u0000\u0000\u0097\u0098\u0005"+
		"a\u0000\u0000\u0098\u0099\u0005b\u0000\u0000\u0099\u009a\u0005o\u0000"+
		"\u0000\u009a\u009b\u0005l\u0000\u0000\u009b\f\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005k\u0000\u0000\u009d\u009e\u0005o\u0000\u0000\u009e\u009f"+
		"\u0005n\u0000\u0000\u009f\u00a0\u0005s\u0000\u0000\u00a0\u00a1\u0005t"+
		"\u0000\u0000\u00a1\u00a2\u0005a\u0000\u0000\u00a2\u00a3\u0005n\u0000\u0000"+
		"\u00a3\u00a4\u0005t\u0000\u0000\u00a4\u000e\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005t\u0000\u0000\u00a6\u00a7\u0005a\u0000\u0000\u00a7\u00a8\u0005"+
		"p\u0000\u0000\u00a8\u00a9\u0005o\u0000\u0000\u00a9\u00aa\u0005s\u0000"+
		"\u0000\u00aa\u0010\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005p\u0000\u0000"+
		"\u00ac\u00ad\u0005a\u0000\u0000\u00ad\u00ae\u0005r\u0000\u0000\u00ae\u00af"+
		"\u0005a\u0000\u0000\u00af\u0012\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"g\u0000\u0000\u00b1\u00b2\u0005a\u0000\u0000\u00b2\u00b3\u0005w\u0000"+
		"\u0000\u00b3\u00b4\u0005i\u0000\u0000\u00b4\u00b5\u0005n\u0000\u0000\u00b5"+
		"\u0014\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005h\u0000\u0000\u00b7\u00b8"+
		"\u0005a\u0000\u0000\u00b8\u00b9\u0005n\u0000\u0000\u00b9\u00ba\u0005g"+
		"\u0000\u0000\u00ba\u00bb\u0005g\u0000\u0000\u00bb\u00bc\u0005a\u0000\u0000"+
		"\u00bc\u00bd\u0005n\u0000\u0000\u00bd\u00be\u0005g\u0000\u0000\u00be\u0016"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005k\u0000\u0000\u00c0\u00c1\u0005"+
		"a\u0000\u0000\u00c1\u00c2\u0005p\u0000\u0000\u00c2\u00c3\u0005a\u0000"+
		"\u0000\u00c3\u00c4\u0005g\u0000\u0000\u00c4\u0018\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0005k\u0000\u0000\u00c6\u00c7\u0005u\u0000\u0000\u00c7\u00c8"+
		"\u0005n\u0000\u0000\u00c8\u00c9\u0005d\u0000\u0000\u00c9\u00ca\u0005i"+
		"\u0000\u0000\u00ca\u001a\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005s\u0000"+
		"\u0000\u00cc\u00cd\u0005a\u0000\u0000\u00cd\u001c\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0005a\u0000\u0000\u00cf\u00d0\u0005y\u0000\u0000\u00d0\u001e"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005m\u0000\u0000\u00d2\u00d3\u0005"+
		"a\u0000\u0000\u00d3\u00d4\u0005g\u0000\u0000\u00d4\u00d5\u0005p\u0000"+
		"\u0000\u00d5\u00d6\u0005a\u0000\u0000\u00d6\u00d7\u0005k\u0000\u0000\u00d7"+
		"\u00d8\u0005i\u0000\u0000\u00d8\u00d9\u0005t\u0000\u0000\u00d9\u00da\u0005"+
		"a\u0000\u0000\u00da \u0001\u0000\u0000\u0000\u00db\u00dc\u0005m\u0000"+
		"\u0000\u00dc\u00dd\u0005a\u0000\u0000\u00dd\u00de\u0005g\u0000\u0000\u00de"+
		"\u00df\u0005b\u0000\u0000\u00df\u00e0\u0005a\u0000\u0000\u00e0\u00e1\u0005"+
		"s\u0000\u0000\u00e1\u00e2\u0005a\u0000\u0000\u00e2\"\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005h\u0000\u0000\u00e4\u00e5\u0005a\u0000\u0000\u00e5"+
		"\u00e6\u0005b\u0000\u0000\u00e6\u00e7\u0005a\u0000\u0000\u00e7\u00e8\u0005"+
		"n\u0000\u0000\u00e8\u00e9\u0005g\u0000\u0000\u00e9\u00ea\u0005_\u0000"+
		"\u0000\u00ea\u00eb\u0005m\u0000\u0000\u00eb\u00ec\u0005a\u0000\u0000\u00ec"+
		"\u00ed\u0005g\u0000\u0000\u00ed\u00ee\u0005b\u0000\u0000\u00ee\u00ef\u0005"+
		"a\u0000\u0000\u00ef\u00f0\u0005s\u0000\u0000\u00f0\u00f1\u0005a\u0000"+
		"\u0000\u00f1$\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005i\u0000\u0000\u00f3"+
		"\u00f4\u0005s\u0000\u0000\u00f4\u00f5\u0005t\u0000\u0000\u00f5\u00f6\u0005"+
		"r\u0000\u0000\u00f6\u00f7\u0005a\u0000\u0000\u00f7\u00f8\u0005k\u0000"+
		"\u0000\u00f8\u00f9\u0005t\u0000\u0000\u00f9\u00fa\u0005u\u0000\u0000\u00fa"+
		"\u00fb\u0005r\u0000\u0000\u00fb\u00fc\u0005a\u0000\u0000\u00fc&\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005b\u0000\u0000\u00fe\u00ff\u0005a\u0000"+
		"\u0000\u00ff\u0100\u0005g\u0000\u0000\u0100\u0101\u0005o\u0000\u0000\u0101"+
		"\u0102\u0005n\u0000\u0000\u0102\u0103\u0005g\u0000\u0000\u0103(\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0005t\u0000\u0000\u0105\u0106\u0005o\u0000"+
		"\u0000\u0106\u0107\u0005t\u0000\u0000\u0107\u0108\u0005o\u0000\u0000\u0108"+
		"\u0109\u0005o\u0000\u0000\u0109*\u0001\u0000\u0000\u0000\u010a\u010b\u0005"+
		"m\u0000\u0000\u010b\u010c\u0005a\u0000\u0000\u010c\u010d\u0005l\u0000"+
		"\u0000\u010d\u010e\u0005i\u0000\u0000\u010e,\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0005w\u0000\u0000\u0110\u0111\u0005a\u0000\u0000\u0111\u0112\u0005"+
		"l\u0000\u0000\u0112\u0113\u0005a\u0000\u0000\u0113.\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0005a\u0000\u0000\u0115\u0116\u0005t\u0000\u0000\u0116"+
		"0\u0001\u0000\u0000\u0000\u0117\u0118\u0005o\u0000\u0000\u01182\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0005h\u0000\u0000\u011a\u011b\u0005i\u0000"+
		"\u0000\u011b\u011c\u0005n\u0000\u0000\u011c\u011d\u0005d\u0000\u0000\u011d"+
		"\u011e\u0005i\u0000\u0000\u011e4\u0001\u0000\u0000\u0000\u011f\u0120\u0005"+
		"=\u0000\u0000\u0120\u0121\u0005=\u0000\u0000\u01216\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0005!\u0000\u0000\u0123\u0124\u0005=\u0000\u0000\u0124"+
		"8\u0001\u0000\u0000\u0000\u0125\u0126\u0005<\u0000\u0000\u0126:\u0001"+
		"\u0000\u0000\u0000\u0127\u0128\u0005>\u0000\u0000\u0128<\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0005<\u0000\u0000\u012a\u012b\u0005=\u0000\u0000\u012b"+
		">\u0001\u0000\u0000\u0000\u012c\u012d\u0005>\u0000\u0000\u012d\u012e\u0005"+
		"=\u0000\u0000\u012e@\u0001\u0000\u0000\u0000\u012f\u0130\u0005+\u0000"+
		"\u0000\u0130B\u0001\u0000\u0000\u0000\u0131\u0132\u0005-\u0000\u0000\u0132"+
		"D\u0001\u0000\u0000\u0000\u0133\u0134\u0005*\u0000\u0000\u0134F\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0005/\u0000\u0000\u0136H\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005%\u0000\u0000\u0138J\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0005=\u0000\u0000\u013aL\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"&\u0000\u0000\u013cN\u0001\u0000\u0000\u0000\u013d\u013e\u0005(\u0000"+
		"\u0000\u013eP\u0001\u0000\u0000\u0000\u013f\u0140\u0005)\u0000\u0000\u0140"+
		"R\u0001\u0000\u0000\u0000\u0141\u0142\u0005[\u0000\u0000\u0142T\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005]\u0000\u0000\u0144V\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0005{\u0000\u0000\u0146X\u0001\u0000\u0000\u0000\u0147"+
		"\u0148\u0005}\u0000\u0000\u0148Z\u0001\u0000\u0000\u0000\u0149\u014a\u0005"+
		",\u0000\u0000\u014a\\\u0001\u0000\u0000\u0000\u014b\u014c\u0005;\u0000"+
		"\u0000\u014c^\u0001\u0000\u0000\u0000\u014d\u014e\u0005:\u0000\u0000\u014e"+
		"`\u0001\u0000\u0000\u0000\u014f\u0150\u0005.\u0000\u0000\u0150b\u0001"+
		"\u0000\u0000\u0000\u0151\u0153\u0007\u0000\u0000\u0000\u0152\u0151\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0152\u0001"+
		"\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155d\u0001\u0000"+
		"\u0000\u0000\u0156\u0158\u0007\u0000\u0000\u0000\u0157\u0156\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015f\u0005.\u0000\u0000\u015c\u015e\u0007\u0000\u0000"+
		"\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000"+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u0160\u0169\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000"+
		"\u0000\u0162\u0164\u0005.\u0000\u0000\u0163\u0165\u0007\u0000\u0000\u0000"+
		"\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000"+
		"\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000"+
		"\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0157\u0001\u0000\u0000\u0000"+
		"\u0168\u0162\u0001\u0000\u0000\u0000\u0169f\u0001\u0000\u0000\u0000\u016a"+
		"\u0170\u0005\"\u0000\u0000\u016b\u016c\u0005\\\u0000\u0000\u016c\u016f"+
		"\u0007\u0001\u0000\u0000\u016d\u016f\b\u0002\u0000\u0000\u016e\u016b\u0001"+
		"\u0000\u0000\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f\u0172\u0001"+
		"\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170\u0171\u0001"+
		"\u0000\u0000\u0000\u0171\u0173\u0001\u0000\u0000\u0000\u0172\u0170\u0001"+
		"\u0000\u0000\u0000\u0173\u0174\u0005\"\u0000\u0000\u0174h\u0001\u0000"+
		"\u0000\u0000\u0175\u0179\u0007\u0003\u0000\u0000\u0176\u0178\u0007\u0004"+
		"\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000"+
		"\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000"+
		"\u0000\u0000\u017aj\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000"+
		"\u0000\u017c\u0180\u0005#\u0000\u0000\u017d\u017f\b\u0005\u0000\u0000"+
		"\u017e\u017d\u0001\u0000\u0000\u0000\u017f\u0182\u0001\u0000\u0000\u0000"+
		"\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000"+
		"\u0181\u0183\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000"+
		"\u0183\u0184\u00065\u0000\u0000\u0184l\u0001\u0000\u0000\u0000\u0185\u0187"+
		"\u0007\u0006\u0000\u0000\u0186\u0185\u0001\u0000\u0000\u0000\u0187\u0188"+
		"\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0189"+
		"\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b"+
		"\u00066\u0000\u0000\u018bn\u0001\u0000\u0000\u0000\u018c\u018e\u0005\r"+
		"\u0000\u0000\u018d\u018c\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000"+
		"\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u0190\u0005\n\u0000"+
		"\u0000\u0190\u0194\u0001\u0000\u0000\u0000\u0191\u0193\u0007\u0006\u0000"+
		"\u0000\u0192\u0191\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000"+
		"\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000"+
		"\u0000\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000"+
		"\u0000\u0197\u0198\u00067\u0001\u0000\u0198p\u0001\u0000\u0000\u0000\r"+
		"\u0000\u0154\u0159\u015f\u0166\u0168\u016e\u0170\u0179\u0180\u0188\u018d"+
		"\u0194\u0002\u0006\u0000\u0000\u00017\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}