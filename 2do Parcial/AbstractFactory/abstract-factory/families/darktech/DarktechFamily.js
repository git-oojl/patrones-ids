import { IAbstractFactory } from "../../interfaces/IAbstractFactory.js";
import { DarktechFamilyInput } from "./DarktechFamilyInput.js";
import { DarktechFamilyDropdown } from "./DarktechFamilyDropdown.js";
import { DarktechFamilyButton } from "./DarktechFamilyButton.js";

export class DarktechFamily extends IAbstractFactory {
  getName() { return "DarktechFamily"; }
  getCssPath() { return "styles/darktech.css"; }

  createInput({ id, label, type = "text", placeholder = "" }) {
    return new DarktechFamilyInput({ id, label, type, placeholder });
  }

  createDropdown({ buttonText = "Dropdown", items = [] } = {}) {
    return new DarktechFamilyDropdown({ buttonText, items });
  }

  createButton({ id = "btn-action-form", text = "Enviar", className = "btn btn-primary mt-3" } = {}) {
    return new DarktechFamilyButton({ id, text, className });
  }
}
