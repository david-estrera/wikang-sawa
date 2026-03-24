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
let traceEditor;
let traceLineHandle = null;
let diagMarkers = [];
let diagLineHandles = [];
let diagDebounce;

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

function scheduleDiagnostics() {
  clearTimeout(diagDebounce);
  diagDebounce = setTimeout(updateDiagnostics, 260);
}

function clearDiagnostics() {
  if (!editor) return;
  diagMarkers.forEach((m) => m.clear());
  diagMarkers = [];
  diagLineHandles.forEach((ln) => editor.removeLineClass(ln, 'background', 'cm-diag-line'));
  diagLineHandles = [];
}

function makeDiagMarker() {
  const marker = document.createElement('span');
  marker.className = 'cm-diag-gutter';
  marker.textContent = '●';
  return marker;
}

async function updateDiagnostics() {
  if (!editor) return;
  const source = editor.getValue();
  const diagList = document.getElementById('diag-list');
  clearDiagnostics();
  diagList.innerHTML = '';
  try {
    const j = await api('/api/diagnostics', { source });
    const items = j.diagnostics || [];
    if (items.length === 0) {
      const li = document.createElement('li');
      li.textContent = 'No errors.';
      diagList.appendChild(li);
      return;
    }
    items.forEach((d) => {
      const line = Math.max(1, Number(d.line || 1));
      const lineIdx = line - 1;
      editor.setGutterMarker(lineIdx, 'diag-gutter', makeDiagMarker());
      diagMarkers.push({
        clear: () => editor.setGutterMarker(lineIdx, 'diag-gutter', null),
      });
      editor.addLineClass(lineIdx, 'background', 'cm-diag-line');
      diagLineHandles.push(lineIdx);

      const li = document.createElement('li');
      li.textContent = `L${line}:${d.col || 1} - ${d.message || 'error'}`;
      li.addEventListener('click', () => {
        editor.focus();
        editor.setCursor({ line: lineIdx, ch: Math.max(0, (d.col || 1) - 1) });
        editor.scrollIntoView({ line: lineIdx, ch: 0 }, 80);
      });
      diagList.appendChild(li);
    });
  } catch (e) {
    const li = document.createElement('li');
    li.textContent = 'Diagnostics unavailable: ' + String(e);
    diagList.appendChild(li);
  }
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
    tree.textContent = j.ok ? renderBranchedTree(j.tree) : 'Parse errors — fix code first.';
  } catch (e) {
    tree.textContent = String(e);
  }
});

function renderBranchedTree(lispTree) {
  if (!lispTree || typeof lispTree !== 'string') return '';
  const root = parseLispTree(lispTree);
  if (!root) return lispTree;
  return treeToLines(root).join('\n');
}

function parseLispTree(src) {
  let i = 0;
  const n = src.length;

  function skipWs() {
    while (i < n && /\s/.test(src[i])) i += 1;
  }

  function readAtom() {
    skipWs();
    const start = i;
    while (i < n && !/\s|\(|\)/.test(src[i])) i += 1;
    return src.slice(start, i);
  }

  function readNode() {
    skipWs();
    if (i >= n) return null;

    if (src[i] === '(') {
      i += 1;
      skipWs();
      const label = readAtom() || '(group)';
      const node = { label, children: [] };
      while (i < n) {
        skipWs();
        if (i < n && src[i] === ')') {
          i += 1;
          break;
        }
        const child = readNode();
        if (!child) break;
        node.children.push(child);
      }
      return node;
    }

    const atom = readAtom();
    if (!atom) return null;
    return { label: atom, children: [] };
  }

  return readNode();
}

function treeToLines(root) {
  const lines = [root.label];

  function walk(node, prefix) {
    const kids = node.children || [];
    kids.forEach((child, idx) => {
      const isLast = idx === kids.length - 1;
      const branch = isLast ? '└── ' : '├── ';
      lines.push(prefix + branch + child.label);
      const nextPrefix = prefix + (isLast ? '    ' : '│   ');
      walk(child, nextPrefix);
    });
  }

  walk(root, '');
  return lines;
}

document.getElementById('btn-step-init').addEventListener('click', async () => {
  const source = editor.getValue();
  const stdin = document.getElementById('stdin').value;
  const step = document.getElementById('step');
  step.textContent = 'Starting…';
  currentSessionId = null;
  if (traceEditor) {
    traceEditor.setValue(source);
    if (traceLineHandle != null) {
      traceEditor.removeLineClass(traceLineHandle, 'background', 'cm-trace-current');
      traceLineHandle = null;
    }
  }
  updateMemory([]);
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
    highlightTraceLine(j.line);
    updateMemory(j.memory || []);
    step.textContent +=
      '\n---\nline ' + j.line + (j.done ? ' (done)' : '') + '\n' + (j.stdout || '') + (j.error || '');
    if (j.done) currentSessionId = null;
  } catch (e) {
    step.textContent += '\n' + e;
  }
});

function highlightTraceLine(line) {
  if (!traceEditor) return;
  if (traceLineHandle != null) {
    traceEditor.removeLineClass(traceLineHandle, 'background', 'cm-trace-current');
    traceLineHandle = null;
  }
  if (!line || line <= 0) return;
  const zero = line - 1;
  traceLineHandle = zero;
  traceEditor.addLineClass(zero, 'background', 'cm-trace-current');
  traceEditor.scrollIntoView({ line: zero, ch: 0 }, 80);
}

function updateMemory(memory) {
  const body = document.getElementById('memory-body');
  body.innerHTML = '';
  if (!memory || memory.length === 0) {
    const tr = document.createElement('tr');
    tr.innerHTML = '<td colspan="3">No variables yet.</td>';
    body.appendChild(tr);
    return;
  }
  memory.forEach((m) => {
    const tr = document.createElement('tr');
    tr.innerHTML =
      '<td>' +
      escapeHtml(m.name || '') +
      '</td><td>' +
      escapeHtml(m.address || '') +
      '</td><td>' +
      escapeHtml(m.value || '') +
      '</td>';
    body.appendChild(tr);
  });
}

function escapeHtml(s) {
  return String(s)
    .replaceAll('&', '&amp;')
    .replaceAll('<', '&lt;')
    .replaceAll('>', '&gt;')
    .replaceAll('"', '&quot;');
}

window.addEventListener('DOMContentLoaded', () => {
  editor = CodeMirror.fromTextArea(document.getElementById('code'), {
    lineNumbers: true,
    mode: null,
    theme: 'sawa',
    indentUnit: 4,
    gutters: ['CodeMirror-linenumbers', 'diag-gutter'],
  });
  editor.on('change', () => {
    scheduleHighlight();
    scheduleDiagnostics();
  });
  editor.on('cursorActivity', () => {
    cursorKeywordTip();
    runDiagnosticsLine();
  });
  traceEditor = CodeMirror.fromTextArea(document.getElementById('trace-code'), {
    lineNumbers: true,
    mode: null,
    theme: 'sawa',
    readOnly: true,
  });
  traceEditor.setValue(editor.getValue());
  updateMemory([]);
  applyHighlight();
  updateDiagnostics();
});
