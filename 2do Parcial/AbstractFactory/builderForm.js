export class BuilderForm {
  // Esta clase arma formularios de forma dinámica y reutilizable.
  constructor() {
    this.reset();
  }

  // Reinicia el builder para empezar un formulario nuevo.
  // reset() asegura que cada vez empiezas desde cero, como si fuera “un builder nuevo”, pero sin crear otro objeto.
  
  reset() {
    this._fields = [];
    this._dropdown = null;
    this._button = { id: "btn-action-form", text: "Enviar", className: "btn btn-primary mt-3" };
    this._layout = { offset: 3, col: 6 };
    return this;
  }

  // Define el layout de Bootstrap (centrado y ancho).
  setLayout({ offset = 3, col = 6 } = {}) {
    this._layout = { offset, col };
    return this;
  }

  // Agrega un input al formulario con id, etiqueta y placeholder.
  addInput({ id, label, type = "text", placeholder = "" }) {
    this._fields.push({ kind: "input", id, label, type, placeholder });
    return this;
  }

  // Agrega un dropdown opcional con su lista de opciones.
  addDropdown({ buttonText = "Dropdown", items = [] } = {}) {
    this._dropdown = { buttonText, items };
    return this;
  }

  // Define el botón principal del formulario.
  setButton({ id = "btn-action-form", text = "Enviar", className = "btn btn-primary mt-3" } = {}) {
    this._button = { id, text, className };
    return this;
  }

// Genera el HTML final del formulario según lo configurado.
build() {
  const { offset, col } = this._layout;  // Lee el layout de Bootstrap para centrar y definir el ancho.

  // Convierte la lista de campos (_fields) en un solo string de HTML.
  // Usa map() para transformar cada definición de campo en su bloque <label + input>.
  // Usa join("") para pegar todos los bloques en un solo texto sin comas.

  const fieldsHtml = this._fields
    .map((f) => {
      // Aquí filtramos por tipo de componente.
      // Si en el futuro agregas otros componentes (ej. textarea), esto evita errores.
      if (f.kind !== "input") return "";

      // Template string: se rellenan id/label/type/placeholder dinámicamente.
      // Esto hace que el formulario cambie sin tener que escribir el HTML del archivo.
      return `
        <div class="mb-3">
          <label for="${f.id}" class="form-label">${f.label}</label>
          <input id="${f.id}" type="${f.type}" class="form-control" placeholder="${f.placeholder}">
        </div>
      `;
    })
    .join("");

  // Construye el HTML del dropdown solo si existe _dropdown.
  // Si no hay dropdown configurado, devolvemos un string vacío.
  const dropdownHtml = this._dropdown
    ? `
      <div class="mb-3 mt-3 dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${this._dropdown.buttonText}
        </button>

        <!-- Items del menú: se convierten desde un arreglo a <li> -->
        <ul class="dropdown-menu">
          ${this._dropdown.items
            .map((txt) => `<li><a class="dropdown-item" href="#">${txt}</a></li>`)
            .join("")}
        </ul>
      </div>
    `
    : "";

  // Construye el botón final usando la configuración guardada en _button.
  // El id sirve para poder agregar el addEventListener desde main.js.

  const buttonHtml = `
    <button id="${this._button.id}" class="${this._button.className}">
      ${this._button.text}
    </button>
  `;

  // Ensambla el formulario completo: campos + dropdown (si existe) + botón.
  // También aplica el layout de Bootstrap para centrar el contenido.
  
  return `
    <div class="row">
      <div class="offset-${offset} col-${col}">
        ${fieldsHtml}
        ${dropdownHtml}
        ${buttonHtml}
      </div>
    </div>
  `;
}
}