import { IInput } from "../../interfaces/IInput.js";

export class DarktechFamilyInput extends IInput {
  constructor({ id, label, type, placeholder }) {
    super();
    this.id = id;
    this.label = label;
    this.type = type;
    this.placeholder = placeholder;
  }

  render() {
    return `
      <div class="mb-3">
        <label for="${this.id}" class="form-label">${this.label}</label>
        <input id="${this.id}" type="${this.type}" class="form-control" placeholder="${this.placeholder}">
      </div>
    `;
  }
}
