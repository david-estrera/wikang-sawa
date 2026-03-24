import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Automated rubric: all *_PASS.sawa must exit 0; negative demos 21–26 must fail with expected messages.
 */
public class RubricRunner {

    private record NegativeCase(String filename, int expectedExit, String[] mustContainSubstrings) {}

    private static final List<NegativeCase> NEGATIVE = List.of(
        new NegativeCase("21_semantic_fail_undeclared_variable.sawa", 2, new String[] {"not declared"}),
        new NegativeCase("22_interpreter_fail_array_oob.sawa", 3, new String[] {"bounds"}),
        new NegativeCase("23_semantic_fail_nonboolean_condition.sawa", 2, new String[] {"boolean"}),
        new NegativeCase("24_semantic_fail_type_mismatch_arithmetic.sawa", 2, new String[] {"numeric"}),
        new NegativeCase("25_semantic_fail_wrong_function_arity.sawa", 2, new String[] {"argument"}),
        new NegativeCase("26_interpreter_fail_indexing_nonarray.sawa", 3, new String[] {"array"})
    );

    public static void main(String[] args) throws IOException {
        Path root = Path.of("rubric-tests");
        if (!Files.isDirectory(root)) {
            System.err.println("Missing rubric-tests/ directory.");
            System.exit(2);
        }

        List<Path> passFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root, "*_PASS.sawa")) {
            for (Path p : stream) {
                passFiles.add(p);
            }
        }
        passFiles.sort(Comparator.comparing(Path::getFileName));

        int failures = 0;
        System.out.println("=== Positive rubric (*_PASS.sawa) ===");
        for (Path p : passFiles) {
            String stdin = stdinForPassFile(p.getFileName().toString());
            WikangSawaPipeline.RunOutcome o = WikangSawaPipeline.runFileQuiet(p, stdin);
            if (o.exitCode != 0) {
                System.err.println("FAIL " + p.getFileName() + " exit=" + o.exitCode);
                System.err.println(o.stderr);
                failures++;
            } else {
                System.out.println("OK   " + p.getFileName());
            }
        }

        System.out.println();
        System.out.println("=== Negative rubric (expected failure) ===");
        for (NegativeCase nc : NEGATIVE) {
            Path p = root.resolve(nc.filename);
            if (!Files.exists(p)) {
                System.err.println("MISSING " + nc.filename);
                failures++;
                continue;
            }
            WikangSawaPipeline.RunOutcome o = WikangSawaPipeline.runFileQuiet(p, "");
            String combined = o.stdout + "\n" + o.stderr;
            boolean okExit = o.exitCode == nc.expectedExit;
            boolean okMsg = true;
            for (String sub : nc.mustContainSubstrings) {
                if (!combined.toLowerCase().contains(sub.toLowerCase())) {
                    okMsg = false;
                    break;
                }
            }
            if (!okExit || !okMsg) {
                System.err.println("FAIL " + nc.filename + " exit=" + o.exitCode + " (want " + nc.expectedExit + ")");
                System.err.println(combined);
                failures++;
            } else {
                System.out.println("OK   " + nc.filename + " (exit " + o.exitCode + ")");
            }
        }

        System.out.println();
        if (failures > 0) {
            System.err.println("RubricRunner: " + failures + " failure(s).");
            System.exit(1);
        }
        System.out.println("RubricRunner: all checks passed.");
    }

    private static String stdinForPassFile(String name) {
        if (name.contains("12_input")) {
            return "42\n";
        }
        if (name.contains("08_event")) {
            return "a\nb\nc\n";
        }
        return "";
    }
}
