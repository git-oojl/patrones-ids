// Arma un formulario usando un AbstractFactory
// y una "spec" (la misma que ya tenías en builder pattern).
export function renderFormHtml(factory, spec, layout = { offset: 3, col: 6 }) {
  const { offset, col } = layout;

  const inputsHtml = spec.fields
    .map((field) => factory.createInput(field).render())
    .join("");

  const dropdownHtml = spec.dropdown
    ? factory.createDropdown(spec.dropdown).render()
    : "";

  const buttonHtml = factory.createButton(spec.button).render();

  return `
    <div class="row">
      <div class="offset-${offset} col-${col}">
        ${inputsHtml}
        ${dropdownHtml}
        ${buttonHtml}
      </div>
    </div>
  `;
}
