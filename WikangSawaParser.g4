parser grammar WikangSawaParser;

options {
    tokenVocab = WikangSawaLexer;
}

// Top-level program structure
program: statement* EOF;

// Statements (NEWLINE only at top level; inside blocks use blockStatement)
statement: blockStatement | NEWLINE;
blockStatement: importStatement
              | variableDeclaration
              | assignmentStatement
              | printStatement
              | conditionalStatement
              | loopStatement
              ;

// Import statement: gamitin identifier (e.g. gamitin magpakita; magpakita is a keyword)
importStatement: GAMITIN (IDENTIFIER | MAGPAKITA) NEWLINE;

// Variable declaration: baryabol identifier = expression
variableDeclaration: BARYABOL IDENTIFIER ASSIGN expression NEWLINE;

// Assignment statement: identifier = expression
assignmentStatement: IDENTIFIER ASSIGN expression NEWLINE;

// Print statement: magpakita expression
printStatement: MAGPAKITA expression NEWLINE;

// Conditional statement: kung expression: block tapos [kundi: block tapos?]
// Single path NEWLINE* TAPOS so newlines before tapos are always consumed
optionalNewlines: NEWLINE*;
conditionalStatement: KUNG expression COLON block NEWLINE* TAPOS (optionalNewlines KUNDI COLON block optionalNewlines TAPOS?)? optionalNewlines;

// Loop statement: habang expression: block tapos
loopStatement: HABANG expression COLON block TAPOS NEWLINE?;

// Block structure using INDENT/DEDENT (Python-style)
// blockStatement+ (no NEWLINE) so NEWLINE* before DEDENT consumes newlines; next token after block is DEDENT then tapos/kundi
block: NEWLINE INDENT blockStatement+ NEWLINE* DEDENT;

// Expression hierarchy with proper operator precedence
// Lowest precedence: Logical OR
expression: andExpression (O andExpression)*;

// Logical AND
andExpression: notExpression (AT notExpression)*;

// Logical NOT or comparison
notExpression: HINDI notExpression
             | comparisonExpression
             ;

// Comparison expressions
comparisonExpression: arithmeticExpression (relOp arithmeticExpression)?;

// Relational operators
relOp: EQUAL | NOT_EQUAL | LT | GT | LE | GE;

// Arithmetic expressions (addition/subtraction)
arithmeticExpression: term ((PLUS | MINUS) term)*;

// Terms (multiplication/division/modulo)
term: factor ((STAR | SLASH | PERCENT) factor)*;

// Factors: unary minus, parentheses, literals, identifiers
factor: (MINUS)? (literal | IDENTIFIER | LPAREN expression RPAREN);

// Literals
literal: NUMERO
       | DESIMAL
       | SALITA
       | TOTOO
       | MALI
       | WALA
       ;


