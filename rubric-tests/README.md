# Wikang Sawa Rubric Tests

Each `.sawa` file here is a small test aligned to one rubric item.

Legend:
- **PASS**: should parse + pass semantic checks + run in interpreter
- **PARSE-FAIL**: grammar feature not implemented (parser should error)
- **SEMANTIC-FAIL**: syntax parses, but semantic analyzer should reject
- **INTERPRETER-FAIL**: syntax + semantics pass, but runtime should error/stop

Run any file using:

```bash
javac -cp ".;antlr-4.13.1-complete.jar" *.java
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver rubric-tests/<file>.sawa
```

