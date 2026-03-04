const KEY = "form_submissions";

// Guarda un registro nuevo en localStorage.
export function saveSubmission(data) {
  const current = readSubmissions();
  current.push({ ...data, savedAt: new Date().toISOString() });
  localStorage.setItem(KEY, JSON.stringify(current));
}

// Lee todos los registros guardados en localStorage.
export function readSubmissions() {
  try {
    return JSON.parse(localStorage.getItem(KEY)) ?? [];
  } catch {
    return [];
  }
}