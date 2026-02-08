import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class ScannerDriver {
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
            
            // Scan tokens
            Token token = lexer.nextToken();
            while (token.getType() != Token.EOF) {
                String tokenName = getTokenName(token.getType(), lexer);
                String lexeme = escapeLexeme(token.getText());
                
                System.out.println("Type: " + tokenName + ", Value: '" + lexeme + "', Line: " + 
                                 token.getLine() + ", Column: " + (token.getCharPositionInLine() + 1));
                
                token = lexer.nextToken();
            }
            
            // Print EOF token
            String tokenName = getTokenName(token.getType(), lexer);
            String lexeme = escapeLexeme(token.getText());
            System.out.println("Type: " + tokenName + ", Value: '" + lexeme + "', Line: " + 
                             token.getLine() + ", Column: " + (token.getCharPositionInLine() + 1));
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }
    
    private static String getTokenName(int tokenType, Lexer lexer) {
        if (tokenType == Token.EOF) {
            return "EOF";
        }
        String[] tokenNames = lexer.getTokenNames();
        if (tokenType >= 0 && tokenType < tokenNames.length) {
            return tokenNames[tokenType];
        }
        return "UNKNOWN";
    }
    
    private static String escapeLexeme(String lexeme) {
        if (lexeme == null) {
            return "";
        }
        // Escape special characters for display
        return lexeme
            .replace("\\", "\\\\")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t")
            .replace("'", "\\'");
    }
}

