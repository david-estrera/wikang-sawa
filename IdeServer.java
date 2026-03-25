import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Local IDE backend: static files under ide/web, JSON APIs for highlight, diagnostics, parse tree, run, step.
 */
public class IdeServer {

    private static final Path WEB_ROOT = Path.of("ide", "web");
    private static final Path WORKSPACE_ROOT = Path.of("").toAbsolutePath().normalize();
    private static final Map<String, StepSession> STEPS = new ConcurrentHashMap<>();

    private static final class StepSession {
        Interpreter interpreter;
        Thread thread;
        Semaphore stepDone;
        ByteArrayOutputStream outBuf;
        volatile String runtimeError;
    }

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8787;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", IdeServer::handle);
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Wikang Sawa IDE server http://localhost:" + port + "/");
        System.out.println("Serving static files from " + WEB_ROOT.toAbsolutePath());
    }

    private static void handle(HttpExchange ex) throws IOException {
        try {
            String method = ex.getRequestMethod();
            if ("OPTIONS".equalsIgnoreCase(method)) {
                cors(ex);
                ex.sendResponseHeaders(204, -1);
                ex.close();
                return;
            }
            String path = ex.getRequestURI().getPath();
            if (path.startsWith("/api/")) {
                handleApi(ex, method, path);
                return;
            }
            serveStatic(ex, path);
        } catch (Exception e) {
            e.printStackTrace();
            error(ex, 500, e.getMessage());
        }
    }

    private static void cors(HttpExchange ex) {
        ex.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        ex.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        ex.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
    }

    private static void handleApi(HttpExchange ex, String method, String path) throws IOException {
        cors(ex);
        if (!"POST".equalsIgnoreCase(method)) {
            error(ex, 405, "POST only");
            return;
        }
        String body = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);

        switch (path) {
            case "/api/highlight" -> apiHighlight(ex, body);
            case "/api/diagnostics" -> apiDiagnostics(ex, body);
            case "/api/parse-tree" -> apiParseTree(ex, body);
            case "/api/run" -> apiRun(ex, body);
            case "/api/symbols" -> apiSymbols(ex, body);
            case "/api/files/list" -> apiFilesList(ex, body);
            case "/api/file/read" -> apiFileRead(ex, body);
            case "/api/file/write" -> apiFileWrite(ex, body);
            case "/api/step/init" -> apiStepInit(ex, body);
            case "/api/step/next" -> apiStepNext(ex, body);
            default -> error(ex, 404, "Unknown API");
        }
    }

    private static void apiFilesList(HttpExchange ex, String body) throws IOException {
        String dir = extractJsonString(body, "dir");
        if (dir == null) dir = "";
        Path resolvedDir = resolveWorkspaceDir(dir);
        if (resolvedDir == null || !Files.isDirectory(resolvedDir)) {
            okJson(ex, "{\"ok\":true,\"items\":[]}");
            return;
        }

        StringBuilder arr = new StringBuilder("[");
        boolean first = true;
        try (var ds = Files.newDirectoryStream(resolvedDir)) {
            var items = new java.util.ArrayList<Path>();
            for (Path p : ds) items.add(p);
            items.sort((a, b) -> a.getFileName().toString().compareToIgnoreCase(b.getFileName().toString()));
            for (Path p : items) {
                String name = p.getFileName().toString();
                String rel = WORKSPACE_ROOT.relativize(p).toString().replace('\\', '/');
                if (Files.isDirectory(p)) {
                    if (!first) arr.append(',');
                    first = false;
                    arr.append("{\"type\":\"dir\",\"name\":\"").append(escJson(name)).append("\",\"path\":\"")
                        .append(escJson(rel)).append("\"}");
                } else if (name.endsWith(".sawa")) {
                    if (!first) arr.append(',');
                    first = false;
                    arr.append("{\"type\":\"file\",\"name\":\"").append(escJson(name)).append("\",\"path\":\"")
                        .append(escJson(rel)).append("\"}");
                }
            }
        }
        arr.append("]");
        okJson(ex, "{\"ok\":true,\"items\":" + arr + "}");
    }

    private static void apiFileRead(HttpExchange ex, String body) throws IOException {
        String path = extractJsonString(body, "path");
        if (path == null || path.isBlank()) {
            error(ex, 400, "path required");
            return;
        }
        Path resolved = resolveWorkspaceFile(path);
        if (resolved == null || !Files.isRegularFile(resolved)) {
            error(ex, 404, "file not found");
            return;
        }
        String text = Files.readString(resolved, StandardCharsets.UTF_8);
        okJson(ex, "{\"ok\":true,\"text\":\"" + escJson(text) + "\"}");
    }

    private static void apiFileWrite(HttpExchange ex, String body) throws IOException {
        String path = extractJsonString(body, "path");
        String content = extractJsonString(body, "content");
        if (path == null || path.isBlank()) {
            error(ex, 400, "path required");
            return;
        }
        if (content == null) content = "";
        if (!path.replace('\\', '/').endsWith(".sawa")) {
            error(ex, 400, "only .sawa files can be written");
            return;
        }
        Path resolved = resolveWorkspaceFile(path);
        if (resolved == null) {
            error(ex, 403, "invalid path");
            return;
        }
        Path parent = resolved.getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(resolved, content, StandardCharsets.UTF_8);
        okJson(ex, "{\"ok\":true}");
    }

    private static Path resolveWorkspaceDir(String dir) {
        String p = dir == null ? "" : dir.trim();
        p = p.replace('\\', '/');
        if (p.startsWith("/")) p = p.substring(1);
        Path resolved = WORKSPACE_ROOT.resolve(p).normalize();
        if (!resolved.startsWith(WORKSPACE_ROOT)) return null;
        return resolved;
    }

    private static Path resolveWorkspaceFile(String path) {
        if (path == null) return null;
        String p = path.trim().replace('\\', '/');
        if (p.startsWith("/")) p = p.substring(1);
        Path resolved = WORKSPACE_ROOT.resolve(p).normalize();
        if (!resolved.startsWith(WORKSPACE_ROOT)) return null;
        return resolved;
    }

    private static void apiHighlight(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;
        var spans = WikangSawaPipeline.highlightTokens(src);
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < spans.size(); i++) {
            var s = spans.get(i);
            if (i > 0) json.append(',');
            json.append("{\"start\":").append(s.start).append(",\"end\":").append(s.end)
                .append(",\"class\":\"").append(escJson(s.cssClass)).append("\"}");
        }
        json.append("]");
        okJson(ex, "{\"tokens\":" + json + "}");
    }

    private static void apiDiagnostics(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;
        var pr = WikangSawaPipeline.parse(src);
        StringBuilder arr = new StringBuilder("[");
        int k = 0;
        for (var d : pr.parseErrors) {
            if (k++ > 0) arr.append(',');
            arr.append(diagJson(d));
        }
        if (pr.ok && pr.program != null) {
            var sema = new SemanticAnalyzer();
            sema.analyze(pr.program);
            for (var d : sema.getDiagnostics()) {
                if (k++ > 0) arr.append(',');
                arr.append(diagJson(d));
            }
        }
        arr.append("]");
        okJson(ex, "{\"diagnostics\":" + arr + "}");
    }

    private static void apiSymbols(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;

        var pr = WikangSawaPipeline.parse(src);
        if (!pr.ok || pr.program == null) {
            // Return empty table; Editor diagnostics will show parse errors anyway.
            okJson(ex, "{\"ok\":false,\"symbols\":[]}");
            return;
        }

        SemanticAnalyzer sema = new SemanticAnalyzer();
        sema.analyze(pr.program);
        if (sema.hasErrors()) {
            okJson(ex, "{\"ok\":false,\"symbols\":[]}");
            return;
        }

        var rows = sema.getSymbolsTable();
        StringBuilder arr = new StringBuilder("[");
        for (int i = 0; i < rows.size(); i++) {
            if (i > 0) arr.append(',');
            var r = rows.get(i);
            arr.append("{\"name\":\"").append(escJson(r.name)).append('"')
                .append(",\"kind\":\"").append(escJson(r.kind)).append('"')
                .append(",\"type\":\"").append(escJson(r.type)).append('"')
                .append(",\"knownValue\":\"").append(escJson(r.knownValue)).append('"')
                .append('}');
        }
        arr.append("]");
        okJson(ex, "{\"ok\":true,\"symbols\":" + arr + "}");
    }

    private static String diagJson(WikangSawaPipeline.Diagnostic d) {
        return "{\"line\":" + d.line + ",\"col\":" + d.col
            + ",\"severity\":\"" + escJson(d.severity) + "\",\"message\":\""
            + escJson(d.message) + "\"}";
    }

    private static void apiParseTree(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;
        var pr = WikangSawaPipeline.parse(src);
        if (!pr.ok || pr.program == null) {
            okJson(ex, "{\"ok\":false,\"tree\":\"\",\"errors\":true}");
            return;
        }
        okJson(ex, "{\"ok\":true,\"tree\":\"" + escJson(pr.lispTree) + "\"}");
    }

    private static void apiRun(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;
        String stdin = extractJsonString(body, "stdin");
        if (stdin == null) stdin = "";
        var o = WikangSawaPipeline.runSourceQuiet(src, stdin);
        okJson(ex, "{\"exitCode\":" + o.exitCode
            + ",\"stdout\":\"" + escJson(o.stdout)
            + "\",\"stderr\":\"" + escJson(o.stderr) + "\""
            + ",\"optimStats\":" + o.optimStats
            + ",\"gc\":" + o.gcStats + "}");
    }

    private static void apiStepInit(HttpExchange ex, String body) throws IOException {
        String src = extractJsonString(body, "source");
        if (src == null) src = body;
        String stdin = extractJsonString(body, "stdin");
        if (stdin == null) stdin = "";
        var pr = WikangSawaPipeline.parse(src);
        if (!pr.ok || pr.program == null) {
            okJson(ex, "{\"ok\":false,\"error\":\"parse failed\"}");
            return;
        }
        SemanticAnalyzer sema = new SemanticAnalyzer();
        sema.analyze(pr.program);
        if (sema.hasErrors()) {
            okJson(ex, "{\"ok\":false,\"error\":\"semantic errors\"}");
            return;
        }

        String id = UUID.randomUUID().toString();
        Semaphore stepDone = new Semaphore(0);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream po = new PrintStream(bout, true, StandardCharsets.UTF_8);
        InputStream in = new ByteArrayInputStream(stdin.getBytes(StandardCharsets.UTF_8));

        Interpreter ip = new Interpreter(in, po);
        ip.setStepping(true);
        ip.setStepDoneSemaphore(stepDone);

        StepSession s = new StepSession();
        s.interpreter = ip;
        s.stepDone = stepDone;
        s.outBuf = bout;
        s.thread = new Thread(() -> {
            try {
                ip.execute(pr.program);
            } catch (InterpreterException e) {
                s.runtimeError = e.getMessage();
            } catch (Throwable t) {
                s.runtimeError = t.getMessage();
            }
        });
        s.thread.start();
        STEPS.put(id, s);
        okJson(ex, "{\"ok\":true,\"sessionId\":\"" + id + "\"}");
    }

    private static void apiStepNext(HttpExchange ex, String body) throws IOException {
        String id = extractJsonString(body, "sessionId");
        if (id == null) {
            error(ex, 400, "sessionId required");
            return;
        }
        StepSession s = STEPS.get(id);
        if (s == null) {
            okJson(ex, "{\"done\":true,\"error\":\"no session\"}");
            return;
        }
        if (!s.thread.isAlive()) {
            STEPS.remove(id);
            String err = s.runtimeError != null ? s.runtimeError : "";
            okJson(ex, "{\"done\":true,\"line\":0,\"stdout\":\""
                + escJson(drain(s)) + "\",\"error\":\"" + escJson(err) + "\",\"memory\":" + memoryJson(s.interpreter)
                + ",\"optimStats\":" + s.interpreter.getCseStatsJson()
                + ",\"gc\":" + s.interpreter.getGcStatsJson() + "}");
            return;
        }
        s.interpreter.stepContinue();
        try {
            boolean got = s.stepDone.tryAcquire(30, TimeUnit.SECONDS);
            if (!got) {
                okJson(ex, "{\"done\":false,\"line\":" + s.interpreter.getLastStepLine()
                    + ",\"stdout\":\"" + escJson(drain(s)) + "\",\"error\":\"timeout\",\"memory\":" + memoryJson(s.interpreter)
                    + ",\"optimStats\":" + s.interpreter.getCseStatsJson()
                    + ",\"gc\":" + s.interpreter.getGcStatsJson() + "}");
                return;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int line = s.interpreter.getLastStepLine();
        String out = drain(s);
        String err = s.runtimeError != null ? s.runtimeError : "";
        boolean done = !s.thread.isAlive();
        if (done) STEPS.remove(id);
        okJson(ex, "{\"done\":" + done + ",\"line\":" + line + ",\"stdout\":\""
            + escJson(out) + "\",\"error\":\"" + escJson(err) + "\",\"memory\":" + memoryJson(s.interpreter)
            + ",\"optimStats\":" + s.interpreter.getCseStatsJson()
            + ",\"gc\":" + s.interpreter.getGcStatsJson() + "}");
    }

    private static String drain(StepSession s) {
        String p = s.outBuf.toString(StandardCharsets.UTF_8);
        s.outBuf.reset();
        return p;
    }

    private static String memoryJson(Interpreter interpreter) {
        StringBuilder sb = new StringBuilder("[");
        var cells = interpreter.snapshotMemoryMap();
        for (int i = 0; i < cells.size(); i++) {
            var c = cells.get(i);
            if (i > 0) sb.append(',');
            sb.append("{\"name\":\"").append(escJson(c.variableName))
                .append("\",\"address\":\"").append(escJson(c.memoryAddress))
                .append("\",\"value\":\"").append(escJson(c.value)).append("\"}");
        }
        sb.append("]");
        return sb.toString();
    }

    private static void serveStatic(HttpExchange ex, String path) throws IOException {
        cors(ex);
        if ("/".equals(path)) path = "/index.html";
        Path file = WEB_ROOT.resolve(path.substring(1)).normalize();
        if (!file.startsWith(WEB_ROOT.normalize()) || !Files.isRegularFile(file)) {
            error(ex, 404, "Not found");
            return;
        }
        byte[] data = Files.readAllBytes(file);
        String ct = guessContentType(path);
        ex.getResponseHeaders().set("Content-Type", ct);
        ex.sendResponseHeaders(200, data.length);
        try (OutputStream os = ex.getResponseBody()) {
            os.write(data);
        }
    }

    private static String guessContentType(String path) {
        if (path.endsWith(".html")) return "text/html; charset=utf-8";
        if (path.endsWith(".css")) return "text/css; charset=utf-8";
        if (path.endsWith(".js")) return "text/javascript; charset=utf-8";
        return "application/octet-stream";
    }

    private static void okJson(HttpExchange ex, String json) throws IOException {
        byte[] b = json.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        ex.sendResponseHeaders(200, b.length);
        ex.getResponseBody().write(b);
        ex.close();
    }

    private static void error(HttpExchange ex, int code, String msg) throws IOException {
        cors(ex);
        byte[] b = msg.getBytes(StandardCharsets.UTF_8);
        ex.sendResponseHeaders(code, b.length);
        ex.getResponseBody().write(b);
        ex.close();
    }

    private static String escJson(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\\' -> sb.append("\\\\");
                case '"' -> sb.append("\\\"");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default -> {
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /** Minimal JSON string extractor for "key":"value" with escapes. */
    private static String extractJsonString(String json, String key) {
        String needle = "\"" + key + "\"";
        int k = json.indexOf(needle);
        if (k < 0) return null;
        int colon = json.indexOf(':', k + needle.length());
        if (colon < 0) return null;
        int c = colon + 1;
        while (c < json.length() && Character.isWhitespace(json.charAt(c))) c++;
        if (c >= json.length() || json.charAt(c) != '"') return null;
        c++;
        StringBuilder sb = new StringBuilder();
        while (c < json.length()) {
            char ch = json.charAt(c++);
            if (ch == '\\') {
                if (c >= json.length()) break;
                char esc = json.charAt(c++);
                switch (esc) {
                    case 'n' -> sb.append('\n');
                    case 'r' -> sb.append('\r');
                    case 't' -> sb.append('\t');
                    case '\\', '"' -> sb.append(esc);
                    case 'u' -> {
                        if (c + 4 <= json.length()) {
                            String hex = json.substring(c, c + 4);
                            c += 4;
                            sb.append((char) Integer.parseInt(hex, 16));
                        }
                    }
                    default -> sb.append(esc);
                }
            } else if (ch == '"') {
                break;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
