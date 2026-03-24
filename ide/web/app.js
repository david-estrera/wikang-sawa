/* global CodeMirror */

const KEYWORDS = {
  baryabol: 'Variable declaration',
  konstant: 'Constant (cannot reassign)',
  magpakita: 'Print to output',
  magbasa: 'Read one line from input',
  kung: 'If condition',
  kundi: 'Else branch',
  habang: 'While loop',
  para: 'Count loop with hanggang (inclusive)',
  hanggang: 'End bound (para) or until condition (gawin)',
  gawin: 'Repeat body until hanggang is totoo',
  habang_magbasa: 'Run body once per stdin line until EOF',
  punsyon: 'Function',
  balik: 'Return value',
  tapos: 'End block / end function',
  gamitin: 'Import (no-op in runtime)',
  istraktura: 'Struct type',
  bagong: 'Create struct instance',
  totoo: 'Boolean true',
  mali: 'Boolean false',
  wala: 'Null',
  at: 'Logical AND',
  o: 'Logical OR',
  hindi: 'Logical NOT',
};

let editor;
let highlightMarks = [];
let currentSessionId = null;

function api(path, body) {
  return fetch(path, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body),
  }).then((r) => r.json());
}

function clearMarks() {
  if (!editor) return;
  highlightMarks.forEach((m) => m.clear());
  highlightMarks = [];
}

async function applyHighlight() {
  const source = editor.getValue();
  clearMarks();
  try {
    const j = await api('/api/highlight', { source });
    const map = {
      'tok-keyword': 'keyword',
      'tok-number': 'number',
      'tok-string': 'string',
      'tok-bool': 'bool',
      'tok-id': 'id',
      'tok-op': 'op',
      'tok-comment': 'comment',
    };
    editor.operation(() => {
      (j.tokens || []).forEach((t) => {
        const cmClass = map[t.class] || 'id';
        if (t.end <= t.start) return;
        const from = editor.posFromIndex(t.start);
        const to = editor.posFromIndex(t.end);
        const m = editor.markText(from, to, { className: 'cm-' + cmClass });
        highlightMarks.push(m);
      });
    });
  } catch (e) {
    console.warn('highlight', e);
  }
}

let debounce;
function scheduleHighlight() {
  clearTimeout(debounce);
  debounce = setTimeout(applyHighlight, 220);
}

function showTab(id) {
  document.querySelectorAll('.panel').forEach((p) => p.classList.remove('active'));
  document.querySelectorAll('.tabs button').forEach((b) => b.classList.remove('active'));
  document.getElementById('panel-' + id).classList.add('active');
  document.querySelector('.tabs button[data-tab="' + id + '"]').classList.add('active');
}

function cursorKeywordTip() {
  const tip = document.getElementById('hover-tip');
  const cur = editor.getCursor();
  const line = editor.getLine(cur.line);
  const ch = cur.ch;
  const left = line.slice(0, ch);
  const m = left.match(/([a-zA-Z_][a-zA-Z0-9_]*)$/);
  if (m && KEYWORDS[m[1]]) {
    tip.textContent = m[1] + ' — ' + KEYWORDS[m[1]];
    tip.classList.add('visible');
  } else {
    tip.classList.remove('visible');
  }
}

async function runDiagnosticsLine() {
  const source = editor.getValue();
  const cur = editor.getCursor();
  try {
    const j = await api('/api/diagnostics', { source });
    const tip = document.getElementById('hover-tip');
    const at = (j.diagnostics || []).find(
      (d) => d.line === cur.line + 1 && d.col <= cur.ch + 1
    );
    if (at) {
      tip.textContent = at.message;
      tip.classList.add('visible');
    }
  } catch (_) {}
}

document.querySelectorAll('.tabs button').forEach((btn) => {
  btn.addEventListener('click', () => showTab(btn.dataset.tab));
});

document.getElementById('btn-run').addEventListener('click', async () => {
  const source = editor.getValue();
  const stdin = document.getElementById('stdin').value;
  const out = document.getElementById('out');
  out.textContent = 'Running…';
  try {
    const j = await api('/api/run', { source, stdin });
    out.textContent =
      'exit ' +
      j.exitCode +
      '\n\n--- stdout ---\n' +
      j.stdout +
      '\n--- stderr ---\n' +
      j.stderr;
  } catch (e) {
    out.textContent = String(e);
  }
});

document.getElementById('btn-tree').addEventListener('click', async () => {
  const source = editor.getValue();
  const tree = document.getElementById('tree');
  tree.textContent = 'Loading…';
  try {
    const j = await api('/api/parse-tree', { source });
    tree.textContent = j.ok ? j.tree : 'Parse errors — fix code first.';
  } catch (e) {
    tree.textContent = String(e);
  }
});

document.getElementById('btn-step-init').addEventListener('click', async () => {
  const source = editor.getValue();
  const stdin = document.getElementById('stdin').value;
  const step = document.getElementById('step');
  step.textContent = 'Starting…';
  currentSessionId = null;
  try {
    const j = await api('/api/step/init', { source, stdin });
    if (!j.ok) {
      step.textContent = 'Cannot step: ' + (j.error || 'unknown');
      return;
    }
    currentSessionId = j.sessionId;
    step.textContent = 'Session ready. Click “Next line”.';
  } catch (e) {
    step.textContent = String(e);
  }
});

document.getElementById('btn-step-next').addEventListener('click', async () => {
  if (!currentSessionId) {
    document.getElementById('step').textContent = 'Start a session first.';
    return;
  }
  const step = document.getElementById('step');
  try {
    const j = await api('/api/step/next', { sessionId: currentSessionId });
    step.textContent +=
      '\n---\nline ' + j.line + (j.done ? ' (done)' : '') + '\n' + (j.stdout || '') + (j.error || '');
    if (j.done) currentSessionId = null;
  } catch (e) {
    step.textContent += '\n' + e;
  }
});

window.addEventListener('DOMContentLoaded', () => {
  editor = CodeMirror.fromTextArea(document.getElementById('code'), {
    lineNumbers: true,
    mode: null,
    theme: 'sawa',
    indentUnit: 4,
  });
  editor.on('change', scheduleHighlight);
  editor.on('cursorActivity', () => {
    cursorKeywordTip();
    runDiagnosticsLine();
  });
  applyHighlight();
});
