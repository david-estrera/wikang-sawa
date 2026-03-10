# Wikang Sawa ANTLR Lexer & Parser - Setup & Execution Guide

This guide explains how to set up and use the Wikang Sawa ANTLR Lexer Grammar, Parser Grammar, and Java Drivers.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- ANTLR v4.13.1 (or latest version)

## Step 1: Download ANTLR

1. Download the ANTLR complete JAR file:
   - **Direct download**: [antlr-4.13.1-complete.jar](https://www.antlr.org/download/antlr-4.13.1-complete.jar)
   - Or visit [https://www.antlr.org/download.html](https://www.antlr.org/download.html) for the latest version

2. Save the JAR file in your project directory (same directory as `WikangSawaLexer.g4`)

## Step 2: Generate Java Files from Grammars

Run the following commands to generate the Java lexer and parser files from the ANTLR grammars:

```bash
# Generate lexer files
java -jar antlr-4.13.1-complete.jar WikangSawaLexer.g4

# Generate parser files (must run after lexer generation)
java -jar antlr-4.13.1-complete.jar WikangSawaParser.g4
```

This will generate the following Java files:
- **Lexer files:**
  - `WikangSawaLexer.java`
  - `WikangSawaLexer.tokens`
  - `WikangSawaLexer.interp` (if using ANTLR 4.13.1+)
- **Parser files:**
  - `WikangSawaParser.java`
  - `WikangSawaParserBaseVisitor.java`
  - `WikangSawaParserBaseListener.java`
  - `WikangSawaParser.tokens`

## Step 3: Compile Java Files

Compile all Java files including the generated lexer and the driver:

### On Unix/Linux/Mac:
```bash
javac -cp ".:antlr-4.13.1-complete.jar" *.java
```

### On Windows:
```bash
javac -cp ".;antlr-4.13.1-complete.jar" *.java
```

**Note**: Windows uses semicolon (`;`) instead of colon (`:`) for the classpath separator.

## Step 4: Run the Scanner Driver

Execute the scanner driver with a `.sawa` input file:

### On Unix/Linux/Mac:
```bash
java -cp ".:antlr-4.13.1-complete.jar" ScannerDriver sample.sawa
```

### On Windows:
```bash
java -cp ".;antlr-4.13.1-complete.jar" ScannerDriver sample.sawa
```

## Step 5: Run the Parser Driver

Execute the parser driver to recognize and demonstrate language constructs:

### On Unix/Linux/Mac:
```bash
java -cp ".:antlr-4.13.1-complete.jar" ParserDriver sample.sawa
```

### On Windows:
```bash
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver sample.sawa
```

### Parser Output Example (demo format)

The parser prints a clear list of recognized constructs, a construct summary, and a **semantic-analysis report** (suitable for demos):

```
========================================
  WIKANG SAWA PARSER - Construct Demo
========================================
  File: demo.sawa
  Status: Parsing successful!
----------------------------------------
  Recognized constructs and statements:
----------------------------------------
  [1] IMPORT STATEMENT: gamitin magpakita
  [2] VARIABLE DECLARATION: x = 10  (baryabol)
  ...
  [7] CONDITIONAL STATEMENT (kung): condition: x>y
      --> Then block:
  [8] PRINT STATEMENT: magpakita "x mas malaki"
      --> Else block (kundi):
  [9] PRINT STATEMENT: magpakita "y mas malaki o pantay"
  [11] LOOP STATEMENT (habang): condition: counter<3
      --> Loop body:
  [12] PRINT STATEMENT: magpakita counter
  [13] ASSIGNMENT STATEMENT: counter = counter+1
----------------------------------------
  Summary (constructs recognized):
----------------------------------------
    Import statements:     1
    Variable declarations: 4
    Assignment statements: 1
    Print statements:      6
    Conditional (kung):    1
    Loop (habang):         1
    Total statements:      14
----------------------------------------
  Semantic analysis (demo):
----------------------------------------
  Result: Semantic checks passed (no errors).
========================================
  Demo complete.
========================================
```

### Run the full construct demo

To show all construct types in one run, use the included `demo.sawa` file:

```bash
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver demo.sawa
```

(Use `:` instead of `;` on Unix/Linux/Mac.)

### Run the semantic-analysis demos (recommended for presentation)

These two files are designed for a simple “pass vs fail” semantic demo:

- `demo_ok_semantics.sawa`: should parse **and** pass semantic checks
- `demo_semantic_errors.sawa`: should parse, then show **semantic errors** (undeclared variable, non-boolean condition, non-numeric arithmetic)

```bash
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver demo_ok_semantics.sawa
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver demo_semantic_errors.sawa
```

## Recognized Language Constructs

The parser demonstrates recognition of the following Wikang Sawa constructs:

### 1. Import Statements
- **Syntax**: `gamitin identifier`
- **Example**: `gamitin magpakita`

### 2. Variable Declarations
- **Syntax**: `baryabol identifier = expression`
- **Example**: `baryabol x = 10`, `baryabol y = 5.5`

### 3. Assignment Statements
- **Syntax**: `identifier = expression`
- **Example**: `counter = counter + 1`

### 4. Print Statements
- **Syntax**: `magpakita expression`
- **Example**: `magpakita "Hello"`, `magpakita x`

### 5. Conditional Statements
- **Syntax**: `kung expression: block (tapos | (kundi: block tapos))`
- **Example**: 
  ```sawa
  kung age >= 18:
      magpakita "Adulto"
  tapos
  kundi:
      magpakita "Bata"
  tapos
  ```

### 6. Loop Statements
- **Syntax**: `habang expression: block tapos`
- **Example**:
  ```sawa
  habang counter <= 5:
      magpakita counter
      counter = counter + 1
  tapos
  ```

### 7. Expression Types
The parser recognizes expressions with proper operator precedence:

- **Arithmetic**: `+`, `-`, `*`, `/`, `%`
- **Relational**: `==`, `!=`, `<`, `>`, `<=`, `>=`
- **Logical**: `at` (AND), `o` (OR), `hindi` (NOT)

**Operator Precedence** (highest to lowest):
1. Unary operators (`-`, `hindi`)
2. Multiplicative (`*`, `/`, `%`)
3. Additive (`+`, `-`)
4. Relational (`==`, `!=`, `<`, `>`, `<=`, `>=`)
5. Logical NOT (`hindi`)
6. Logical AND (`at`)
7. Logical OR (`o`)

### 8. Block Structure
- Uses Python-style indentation with `INDENT` and `DEDENT` tokens
- Blocks are defined by indentation after `:` in conditionals and loops

## Example Usage

1. Create a sample file `test.sawa`:
```sawa
gamitin magpakita
baryabol x = 10
kung x > 5:
    magpakita "Malaki"
```

2. Run the scanner:
```bash
java -cp ".:antlr-4.13.1-complete.jar" ScannerDriver test.sawa
```

3. Expected output format:
```
Type: GAMITIN, Value: 'gamitin', Line: 1, Column: 1
Type: IDENTIFIER, Value: 'magpakita', Line: 1, Column: 9
Type: NEWLINE, Value: '\n', Line: 1, Column: 17
Type: BARYABOL, Value: 'baryabol', Line: 2, Column: 1
...
Type: EOF, Value: '', Line: 4, Column: 1
```

## File Extension Validation

The scanner driver strictly validates that input files have the `.sawa` extension. If you provide a file with a different extension, you will see:

```
Error: Input file must have a .sawa extension.
```

## Troubleshooting

### ClassNotFoundException
- Ensure the ANTLR JAR file is in the classpath
- Check that you're using the correct path separator (`:` for Unix, `;` for Windows)

### Cannot find symbol errors during compilation
- Make sure you've generated the Java files from the grammar first (Step 2)
- Ensure all generated files are in the same directory

### File not found errors
- Verify the input file path is correct
- Ensure the file has the `.sawa` extension

## Project Structure

```
wikang-sawa/
├── WikangSawaLexer.g4          # ANTLR lexer grammar
├── WikangSawaParser.g4          # ANTLR parser grammar
├── ScannerDriver.java           # Java scanner driver
├── ParserDriver.java            # Java parser driver
├── ConstructRecognizer.java     # Custom visitor for construct recognition
├── README.md                     # This file
├── antlr-4.13.1-complete.jar    # ANTLR runtime (download separately)
└── sample*.sawa                  # Sample input files
```

## Additional Notes

- The lexer implements Python-style indentation using INDENT and DEDENT tokens
- Comments starting with `#` are skipped
- String literals support escape sequences (`\"`, `\\`, `\n`, `\t`, etc.)
- Keywords are case-sensitive and must match exactly (e.g., `gamitin`, `kung`, `habang`)
- `SemanticAnalyzer.java` implements a minimal semantic pass for demo:
  - variables must be declared before use
  - `kung` / `habang` conditions must be boolean
  - arithmetic operators require numeric operands

