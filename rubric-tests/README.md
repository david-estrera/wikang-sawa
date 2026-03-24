# Wikang Sawa Rubric Tests

Each `.sawa` file is a small test aligned to one rubric item.

## Legend

| Tag in filename / header | Meaning |
|--------------------------|---------|
| **`*_PASS.sawa`** | Must **parse**, pass **semantic** checks, and **run** (exit 0) with `WikangSawaPipeline.runFileQuiet` / `RubricRunner`. |
| **`21`–`26` negative demos** | Must **fail** with a specific **exit code** and message patterns (see `RubricRunner.java`). |

### Exit codes (`runSourceQuiet` / `runFileQuiet`)

| Code | Stage |
|------|--------|
| `0` | Success |
| `1` | Parse error |
| `2` | Semantic error |
| `3` | Runtime / interpreter error |

## Run a single file

```bash
javac -cp ".;antlr-4.13.1-complete.jar" *.java
java -cp ".;antlr-4.13.1-complete.jar" ParserDriver rubric-tests/<file>.sawa
```

## Run full rubric automation

```bash
java -cp ".;antlr-4.13.1-complete.jar" RubricRunner
```

- All `rubric-tests/*_PASS.sawa` must exit **0** (stdin for `08` and `12` is supplied by the runner).
- Files `21_*` … `26_*` must exit **2** or **3** and stderr/stdout must contain the substrings checked in `RubricRunner`.

## Input (`magbasa`)

Programs using **`magbasa`** need stdin (e.g. pipe a line). The **IDE** `/api/run` and stepping APIs accept a **`stdin`** string for reproducible runs.
