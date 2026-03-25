import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.*;

/**
 * Shared path: lex → parse → semantic → (optional) interpret.
 */
public final class WikangSawaPipeline {

    public static final class Diagnostic {
        public final int line;
        public final int col;
        public final String message;
        public final String severity;

        public Diagnostic(int line, int col, String message, String severity) {
            this.line = line;
            this.col = col;
            this.message = message;
            this.severity = severity;
        }
    }

    public static final class ParseResult {
        public final boolean ok;
        public final WikangSawaParser.ProgramContext program;
        public final List<Diagnostic> parseErrors;
        public final String lispTree;

        ParseResult(boolean ok, WikangSawaParser.ProgramContext program, List<Diagnostic> parseErrors, String lispTree) {
            this.ok = ok;
            this.program = program;
            this.parseErrors = parseErrors;
            this.lispTree = lispTree;
        }
    }

    public static ParseResult parse(String source) {
        List<Diagnostic> errs = new ArrayList<>();
        try {
            CharStream input = CharStreams.fromString(source);
            WikangSawaLexer lexer = new WikangSawaLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    errs.add(new Diagnostic(line, charPositionInLine + 1, msg, "error"));
                }
            });
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            WikangSawaParser parser = new WikangSawaParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    errs.add(new Diagnostic(line, charPositionInLine + 1, msg, "error"));
                }
            });
            WikangSawaParser.ProgramContext tree = parser.program();
            String lisp = tree.toStringTree(parser);
            boolean ok = parser.getNumberOfSyntaxErrors() == 0 && errs.isEmpty();
            return new ParseResult(ok, tree, errs, lisp);
        } catch (Exception ex) {
            errs.add(new Diagnostic(0, 1, ex.getMessage(), "error"));
            return new ParseResult(false, null, errs, "");
        }
    }

    public static List<Diagnostic> semanticDiagnostics(WikangSawaParser.ProgramContext program) {
        SemanticAnalyzer sema = new SemanticAnalyzer();
        sema.analyze(program);
        if (!sema.hasErrors()) return List.of();
        return sema.getDiagnostics();
    }

    public static String runInterpret(WikangSawaParser.ProgramContext program, InputStream stdin, PrintStream stdout)
            throws InterpreterException {
        Interpreter ip = new Interpreter(stdin, stdout);
        ip.execute(program);
        return ip.getCseStatsJson();
    }

    /** 0 = success, 1 = parse, 2 = semantic, 3 = runtime */
    public static final class RunOutcome {
        public final int exitCode;
        public final String stdout;
        public final String stderr;
        public final String optimStats;
        public final String gcStats;

        public RunOutcome(int exitCode, String stdout, String stderr) {
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
            this.optimStats = "{}";
            this.gcStats = "{}";
        }

        public RunOutcome(int exitCode, String stdout, String stderr, String optimStats) {
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
            this.optimStats = optimStats == null ? "{}" : optimStats;
            this.gcStats = "{}";
        }

        public RunOutcome(int exitCode, String stdout, String stderr, String optimStats, String gcStats) {
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
            this.optimStats = optimStats == null ? "{}" : optimStats;
            this.gcStats = gcStats == null ? "{}" : gcStats;
        }
    }

    public static RunOutcome runSourceQuiet(String source, String stdinText) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ByteArrayOutputStream berr = new ByteArrayOutputStream();
        PrintStream po = new PrintStream(bout, true, StandardCharsets.UTF_8);
        PrintStream pe = new PrintStream(berr, true, StandardCharsets.UTF_8);

        ParseResult pr = parse(source);
        if (!pr.ok || pr.program == null) {
            for (Diagnostic d : pr.parseErrors) {
                pe.println("Parse error at line " + d.line + ":" + d.col + " - " + d.message);
            }
            if (pr.parseErrors.isEmpty()) {
                pe.println("Parse failed.");
            }
            return new RunOutcome(1, bout.toString(StandardCharsets.UTF_8), berr.toString(StandardCharsets.UTF_8));
        }

        SemanticAnalyzer sema = new SemanticAnalyzer();
        sema.analyze(pr.program);
        if (sema.hasErrors()) {
            for (WikangSawaPipeline.Diagnostic d : sema.getDiagnostics()) {
                pe.println("Semantic error at line " + d.line + ":" + d.col + " - " + d.message);
            }
            return new RunOutcome(2, bout.toString(StandardCharsets.UTF_8), berr.toString(StandardCharsets.UTF_8));
        }

        try {
            InputStream in = new ByteArrayInputStream(
                stdinText == null ? new byte[0] : stdinText.getBytes(StandardCharsets.UTF_8));
            Interpreter ip = new Interpreter(in, po);
            ip.execute(pr.program);
            String optimStats = ip.getCseStatsJson();
            String gcStats = ip.getGcStatsJson();
            return new RunOutcome(0, bout.toString(StandardCharsets.UTF_8), berr.toString(StandardCharsets.UTF_8), optimStats, gcStats);
        } catch (InterpreterException ex) {
            pe.println(ex.getMessage());
            return new RunOutcome(3, bout.toString(StandardCharsets.UTF_8), berr.toString(StandardCharsets.UTF_8));
        }
    }

    public static RunOutcome runFileQuiet(Path path, String stdinText) throws IOException {
        return runSourceQuiet(Files.readString(path, StandardCharsets.UTF_8), stdinText);
    }

    public static String runInterpret(Interpreter interpreter, WikangSawaParser.ProgramContext program)
            throws InterpreterException {
        interpreter.execute(program);
        return "";
    }

    public static ParseResult parseFile(Path path) throws IOException {
        String src = Files.readString(path, StandardCharsets.UTF_8);
        return parse(src);
    }

    /** Token spans for syntax coloring: char start (inclusive), end (exclusive), css class */
    public static List<TokenSpan> highlightTokens(String source) {
        List<TokenSpan> spans = new ArrayList<>();
        CharStream input = CharStreams.fromString(source);
        WikangSawaLexer lexer = new WikangSawaLexer(input);
        lexer.removeErrorListeners();
        for (Token t = lexer.nextToken(); t.getType() != Token.EOF; t = lexer.nextToken()) {
            String name = lexer.getVocabulary().getSymbolicName(t.getType());
            if (name == null) name = lexer.getVocabulary().getDisplayName(t.getType());
            String css = tokenClass(name);
            spans.add(new TokenSpan(t.getStartIndex(), t.getStopIndex() + 1, css, t.getText()));
        }
        return spans;
    }

    private static final java.util.Set<String> KEYWORDS = java.util.Set.of(
        "GAMITIN", "PUNSYON", "BALIK", "KUNG", "HABANG", "BARYABOL", "KONSTANT", "TAPOS",
        "PARA", "GAWIN", "HANGGANG", "KAPAG", "KUNDI", "SA", "AY", "MAGPAKITA", "MAGBASA",
        "HABANG_MAGBASA", "ISTRAKTURA", "BAGONG", "TOTOO", "MALI", "WALA", "AT", "O", "HINDI"
    );

    private static final java.util.Set<String> OPS = java.util.Set.of(
        "EQUAL", "NOT_EQUAL", "LT", "GT", "LE", "GE", "PLUS", "MINUS", "STAR", "SLASH",
        "PERCENT", "ASSIGN", "AMPERSAND", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET",
        "COMMA", "COLON", "DOT"
    );

    private static String tokenClass(String symbolicName) {
        if (symbolicName == null) return "tok-other";
        if (KEYWORDS.contains(symbolicName)) return "tok-keyword";
        if (OPS.contains(symbolicName)) return "tok-op";
        return switch (symbolicName) {
            case "NUMERO", "DESIMAL" -> "tok-number";
            case "SALITA" -> "tok-string";
            case "IDENTIFIER" -> "tok-id";
            case "NEWLINE", "INDENT", "DEDENT" -> "tok-ws";
            default -> "tok-other";
        };
    }

    public static final class TokenSpan {
        public final int start;
        public final int end;
        public final String cssClass;
        public final String text;

        public TokenSpan(int start, int end, String cssClass, String text) {
            this.start = start;
            this.end = end;
            this.cssClass = cssClass;
            this.text = text;
        }
    }
}
