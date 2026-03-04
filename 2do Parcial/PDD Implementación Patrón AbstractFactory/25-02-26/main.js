import { BuilderForm } from "./builderForm.js";
import { indexSpec } from "./index-spec.js";
import { newPageSpec } from "./new-page.js";
import { saveSubmission } from "./userLogger.js";

const mainContent = document.getElementById("main-content");
if (!mainContent) {
  throw new Error('Falta <div id="main-content"></div> en el HTML.');
}

const builder = new BuilderForm();

// Renderiza un formulario desde una especificación (campos, dropdown y botón).
function renderFromSpec(spec) {
  builder.reset().setLayout({ offset: 3, col: 6 });

  spec.fields.forEach((f) => builder.addInput({ ...f, type: "text" }));

  if (spec.dropdown) builder.addDropdown(spec.dropdown);

  builder.setButton(spec.button);

  mainContent.innerHTML = builder.build();
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
    window.location.href = "index.html";
  });
} else {
  renderFromSpec(indexSpec);

  // Cambia a la página nueva para mostrar el formulario grande.
  document.getElementById("btn-action-form")?.addEventListener("click", () => {
    window.location.href = "new-page.html";
  });
}