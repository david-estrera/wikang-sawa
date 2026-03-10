import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.util.Arrays;

/**
 * Simple GUI viewer for Wikang Sawa parse trees using ANTLR's TreeViewer.
 */
public class ParseTreeGui {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: java ParseTreeGui <file.sawa>");
            System.exit(1);
        }

        String filename = args[0];
        if (!filename.endsWith(".sawa")) {
            System.err.println("Error: Input file must have a .sawa extension.");
            System.exit(1);
        }

        CharStream input = CharStreams.fromFileName(filename);
        WikangSawaLexer lexer = new WikangSawaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WikangSawaParser parser = new WikangSawaParser(tokens);

        // Start rule for the grammar
        ParseTree tree = parser.program();

        // Create a Swing frame to host the tree
        JFrame frame = new JFrame("Wikang Sawa Parse Tree - " + filename);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(1.2); // zoom level

        frame.add(new JScrollPane(viewer));
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

