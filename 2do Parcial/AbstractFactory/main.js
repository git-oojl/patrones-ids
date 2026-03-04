import { indexSpec } from "./index-spec.js";
import { newPageSpec } from "./new-page.js";
import { saveSubmission } from "./userLogger.js";

import { createFactoryByName, getAllFactories } from "./abstract-factory/FactoryRegistry.js";
import { renderFormHtml } from "./abstract-factory/FormRenderer.js";
import { getFamilyFromQuery, getSavedFamily, saveFamily, setThemeCss } from "./abstract-factory/ThemeManager.js";

const mainContent = document.getElementById("main-content");
if (!mainContent) {
  throw new Error('Falta <div id="main-content"></div> en el HTML.');
}

// --- Tema (familia) seleccionado ---
const queryFamily = getFamilyFromQuery();
const selectedFamilyName = queryFamily || getSavedFamily();
const factory = createFactoryByName(selectedFamilyName);

// Aplica el CSS del tema
setThemeCss(factory.getCssPath());

// Llena el <select> de temas (si existe)
const themeSelect = document.getElementById("theme-select");
if (themeSelect) {
  const factories = getAllFactories();
  themeSelect.innerHTML = factories
    .map((f) => `<option value="${f.getName()}">${f.getName()}</option>`)
    .join("");

  themeSelect.value = factory.getName();

  themeSelect.addEventListener("change", (e) => {
    const name = e.target.value;
    saveFamily(name);

    // recarga la página con el tema nuevo (simple y fácil)
    const url = new URL(window.location.href);
    url.searchParams.set("theme", name);
    window.location.href = url.toString();
  });
}

// Renderiza un formulario desde una especificación (fields, dropdown y button).
function renderFromSpec(spec) {
  mainContent.innerHTML = renderFormHtml(factory, spec, { offset: 3, col: 6 });
}

// Lee los valores actuales de los inputs definidos en la especificación.
function readValues(fieldList) {
  const data = {};
  fieldList.forEach(({ id }) => {
    data[id] = (document.getElementById(id)?.value ?? "").trim();
  });
  return data;
}

// Decide qué especificación usar según la ruta actual.
const isNewPage = window.location.pathname.includes("new-page");

if (isNewPage) {
  renderFromSpec(newPageSpec);

  // Guarda los datos y regresa a index.html.
  document.getElementById("btn-action-form")?.addEventListener("click", () => {
    const data = readValues(newPageSpec.fields);
    saveSubmission(data);
    window.location.href = "index.html?theme=" + encodeURIComponent(factory.getName());
  });
} else {
  renderFromSpec(indexSpec);

  // Cambia a la página nueva para mostrar el formulario grande.
  document.getElementById("btn-action-form")?.addEventListener("click", () => {
    window.location.href = "new-page.html?theme=" + encodeURIComponent(factory.getName());
  });
}
