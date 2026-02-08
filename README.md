# Wikang Sawa ANTLR Lexer - Setup & Execution Guide

This guide explains how to set up and use the Wikang Sawa ANTLR Lexer Grammar and Java Scanner Driver.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- ANTLR v4.13.1 (or latest version)

## Step 1: Download ANTLR

1. Download the ANTLR complete JAR file:
   - **Direct download**: [antlr-4.13.1-complete.jar](https://www.antlr.org/download/antlr-4.13.1-complete.jar)
   - Or visit [https://www.antlr.org/download.html](https://www.antlr.org/download.html) for the latest version

2. Save the JAR file in your project directory (same directory as `WikangSawaLexer.g4`)

## Step 2: Generate Java Files from Grammar

Run the following command to generate the Java lexer files from the ANTLR grammar:

```bash
java -jar antlr-4.13.1-complete.jar WikangSawaLexer.g4
```

This will generate the following Java files:
- `WikangSawaLexer.java`
- `WikangSawaLexer.tokens`
- `WikangSawaLexer.interp` (if using ANTLR 4.13.1+)

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
├── ScannerDriver.java          # Java scanner driver
├── README.md                   # This file
├── antlr-4.13.1-complete.jar  # ANTLR runtime (download separately)
└── sample.sawa                 # Sample input file (create as needed)
```

## Additional Notes

- The lexer implements Python-style indentation using INDENT and DEDENT tokens
- Comments starting with `#` are skipped
- String literals support escape sequences (`\"`, `\\`, `\n`, `\t`, etc.)
- Keywords are case-sensitive and must match exactly (e.g., `gamitin`, `kung`, `habang`)

