import org.antlr.v4.runtime.Token;

public class InterpreterException extends RuntimeException {
    public InterpreterException(String message) {
        super(message);
    }

    public InterpreterException(Token where, String message) {
        super(format(where, message));
    }

    private static String format(Token where, String message) {
        if (where == null) return "Runtime error: " + message;
        int line = where.getLine();
        int col = where.getCharPositionInLine() + 1;
        return "Runtime error at line " + line + ":" + col + " - " + message;
    }
}

