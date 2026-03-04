import { IDropdown } from "../../interfaces/IDropdown.js";

export class NeobrutalismoFamilyDropdown extends IDropdown {
  constructor({ buttonText, items }) {
    super();
    this.buttonText = buttonText;
    this.items = items;
  }

  render() {
    return `
      <div class="mb-3 mt-3 dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${this.buttonText}
        </button>

        <ul class="dropdown-menu">
          ${this.items.map((txt) => `<li><a class="dropdown-item" href="#">${txt}</a></li>`).join("")}
        </ul>
      </div>
    `;
  }
}
