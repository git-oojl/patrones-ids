const KEY = "form_theme_family";

export function getSavedFamily() {
  return localStorage.getItem(KEY) || "MinimalistFamily";
}

export function saveFamily(name) {
  localStorage.setItem(KEY, name);
}

// Lee ?theme=GlassmorphismFamily (si existe)
export function getFamilyFromQuery() {
  const params = new URLSearchParams(window.location.search);
  return params.get("theme");
}

export function setThemeCss(cssPath) {
  const link = document.getElementById("theme-css");
  if (!link) return;
  link.setAttribute("href", cssPath);
}
