// Interfaz (contrato) de Abstract Factory
// Cada familia debe poder crear los mismos "productos":
// Input, Dropdown y Button.
export class IAbstractFactory {
  createInput() { throw new Error("createInput() not implemented"); }
  createDropdown() { throw new Error("createDropdown() not implemented"); }
  createButton() { throw new Error("createButton() not implemented"); }

  // Opcional: nombre del tema (útil para UI)
  getName() { return "Unknown"; }
  // Opcional: ruta del CSS del tema
  getCssPath() { return ""; }
}
