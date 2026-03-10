import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class ParserDriver {
    public static void main(String[] args) {
        // Check command-line argument
        if (args.length == 0) {
            System.err.println("Error: No input file provided.");
            System.exit(1);
        }
        
        String filename = args[0];
        
        // Validate file extension
        if (!filename.endsWith(".sawa")) {
            System.err.println("Error: Input file must have a .sawa extension.");
            System.exit(1);
        }
        
        // Check if file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("Error: File '" + filename + "' not found.");
            System.exit(1);
        }
        
        try {
            // Create input stream from file
            CharStream input = CharStreams.fromFileName(filename);
            
            // Create lexer
            WikangSawaLexer lexer = new WikangSawaLexer(input);
            
            // Create token stream
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Create parser
            WikangSawaParser parser = new WikangSawaParser(tokens);
            
            // Remove default error listeners and add custom one
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                    System.err.println("Parse error at line " + line + ":" + (charPositionInLine + 1) + " - " + msg);
                }
            });
            
            // Parse the program
            ParseTree tree = parser.program();

            // Show parse tree (LISP-style) for demo
            System.out.println();
            System.out.println("Parse tree (LISP-style):");
            System.out.println(tree.toStringTree(parser));
            
            // Check for parse errors
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Parsing failed with " + parser.getNumberOfSyntaxErrors() + " error(s).");
                System.exit(1);
            }
            
            // Walk the parse tree with our custom visitor (demo output)
            System.out.println("========================================");
            System.out.println("  WIKANG SAWA PARSER - Construct Demo");
            System.out.println("========================================");
            System.out.println("  File: " + filename);
            System.out.println("  Status: Parsing successful!");
            System.out.println("----------------------------------------");
            System.out.println("  Recognized constructs and statements:");
            System.out.println("----------------------------------------");
            ConstructRecognizer recognizer = new ConstructRecognizer();
            recognizer.visitProgram((WikangSawaParser.ProgramContext) tree);
            recognizer.printSummary();

            // Semantic analysis demo (type checks + symbol table)
            SemanticAnalyzer sema = new SemanticAnalyzer();
            sema.analyze((WikangSawaParser.ProgramContext) tree);
            sema.printReport();
            System.out.println("========================================");
            System.out.println("  Demo complete.");
            System.out.println("========================================");
            System.out.println();
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }
}


