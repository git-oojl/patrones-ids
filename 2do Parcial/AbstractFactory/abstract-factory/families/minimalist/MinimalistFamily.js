import { IAbstractFactory } from "../../interfaces/IAbstractFactory.js";
import { MinimalistFamilyInput } from "./MinimalistFamilyInput.js";
import { MinimalistFamilyDropdown } from "./MinimalistFamilyDropdown.js";
import { MinimalistFamilyButton } from "./MinimalistFamilyButton.js";

export class MinimalistFamily extends IAbstractFactory {
  getName() { return "MinimalistFamily"; }
  getCssPath() { return "styles/minimalist.css"; }

  createInput({ id, label, type = "text", placeholder = "" }) {
    return new MinimalistFamilyInput({ id, label, type, placeholder });
  }

  createDropdown({ buttonText = "Dropdown", items = [] } = {}) {
    return new MinimalistFamilyDropdown({ buttonText, items });
  }

  createButton({ id = "btn-action-form", text = "Enviar", className = "btn btn-primary mt-3" } = {}) {
    return new MinimalistFamilyButton({ id, text, className });
  }
}
