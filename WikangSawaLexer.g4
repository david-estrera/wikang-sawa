lexer grammar WikangSawaLexer;

tokens {
    INDENT,
    DEDENT
}

@lexer::members {
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
}

// Keywords (must come before IDENTIFIER)
GAMITIN : 'gamitin';
KUNG : 'kung';
HABANG : 'habang';
BARYABOL : 'baryabol';
TAPOS : 'tapos';
PARA : 'para';
KAPAG : 'kapag';
KUNDI : 'kundi';
SA : 'sa';
AY : 'ay';
MAGPAKITA : 'magpakita';
MAGBASA : 'magbasa';
TOTOO : 'totoo';
MALI : 'mali';
WALA : 'wala';

// Logical Operators
AT : 'at';
O : 'o';
HINDI : 'hindi';

// Relational Operators
EQUAL : '==';
NOT_EQUAL : '!=';
LT : '<';
GT : '>';
LE : '<=';
GE : '>=';

// Arithmetic Operators
PLUS : '+';
MINUS : '-';
STAR : '*';
SLASH : '/';
PERCENT : '%';

// Assignment
ASSIGN : '=';

// Punctuation
LPAREN : '(';
RPAREN : ')';
LBRACKET : '[';
RBRACKET : ']';
LBRACE : '{';
RBRACE : '}';
COMMA : ',';
SEMICOLON : ';';
COLON : ':';
DOT : '.';

// Literals
NUMERO : [0-9]+;
DESIMAL : [0-9]+ '.' [0-9]* | '.' [0-9]+;

SALITA : '"' ( '\\' [btnfr"\\] | ~[\\"\r\n] )* '"';

// Identifiers
IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]*;

// Comments
COMMENT : '#' ~[\r\n]* -> skip;

// Whitespace (skip, but track for indentation)
WS : [ \t]+ -> skip;

// Newline with indentation handling
// Match newline and following whitespace, then process indentation
NEWLINE : ('\r'? '\n') [ \t]* {
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
};

// INDENT and DEDENT are virtual tokens defined in tokens{} block above
// They are created programmatically in the NEWLINE action and EOF handling

