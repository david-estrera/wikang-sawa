# Wikang Sawa web IDE (local)

Child-friendly browser UI with syntax highlighting, diagnostics, run (with stdin), stepping, and parse tree. Palette: forest greens + sand + orange accents.

## Run

From the project root (where `antlr-4.13.1-complete.jar` and `.java` sources live):

```bash
javac -cp ".;antlr-4.13.1-complete.jar" *.java
java -cp ".;antlr-4.13.1-complete.jar" IdeServer
```

Optional port:

```bash
java -cp ".;antlr-4.13.1-complete.jar" IdeServer 9000
```

Open **http://localhost:8787/** (or your port).

## APIs (POST JSON)

| Path | Body fields | Description |
|------|-------------|-------------|
| `/api/highlight` | `source` | Token spans + CSS classes for the editor |
| `/api/diagnostics` | `source` | Parse + semantic issues |
| `/api/parse-tree` | `source` | LISP-style tree string |
| `/api/run` | `source`, `stdin` | Full pipeline; returns `exitCode`, `stdout`, `stderr` |
| `/api/step/init` | `source`, `stdin` | Start stepping session → `sessionId` |
| `/api/step/next` | `sessionId` | Execute one top-level statement |

## Static files

Served from `ide/web/` (`index.html`, `style.css`, `app.js`).

## Behavior notes

- **`magbasa`**: one line trimmed; tries integer, then decimal, else string (`README` sa repo root para sa detalye).
- **`habang_magbasa`**: bawat iteration ay kumokonsumo ng **isang** linya ng stdin bago tumakbo ang body (para sa `magbasa` sa loob, kailangan ng karagdagang linya bawat read).
