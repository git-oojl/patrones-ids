// Esta especificación define qué campos y componentes se construyen en new-page.html.

export const newPageSpec = {
  fields: [
    { id: "field-name", label: "Nombre(s):" },
    { id: "field-last-name", label: "Apellidos:" },
    { id: "field-telefono", label: "Teléfono" },
    { id: "field-e-mail", label: "Correo Electrónico" },
    { id: "field-domicilio", label: "Domicilio" },
  ],
  dropdown: {
    buttonText: "Dropdown button",
    items: ["Acción 1", "Acción 2", "Acción 3"],
  },
  button: { id: "btn-action-form", text: "Crear y acceder" },
};