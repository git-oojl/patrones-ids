import { IButton } from "../../interfaces/IButton.js";

export class MinimalistFamilyButton extends IButton {
  constructor({ id, text, className }) {
    super();
    this.id = id;
    this.text = text;
    this.className = className;
  }

  render() {
    return `
      <button id="${this.id}" class="${this.className}">
        ${this.text}
      </button>
    `;
  }
}
