import { IAbstractFactory } from "../../interfaces/IAbstractFactory.js";
import { NeobrutalismoFamilyInput } from "./NeobrutalismoFamilyInput.js";
import { NeobrutalismoFamilyDropdown } from "./NeobrutalismoFamilyDropdown.js";
import { NeobrutalismoFamilyButton } from "./NeobrutalismoFamilyButton.js";

export class NeobrutalismoFamily extends IAbstractFactory {
  getName() { return "NeobrutalismoFamily"; }
  getCssPath() { return "styles/neobrutalismo.css"; }

  createInput({ id, label, type = "text", placeholder = "" }) {
    return new NeobrutalismoFamilyInput({ id, label, type, placeholder });
  }

  createDropdown({ buttonText = "Dropdown", items = [] } = {}) {
    return new NeobrutalismoFamilyDropdown({ buttonText, items });
  }

  createButton({ id = "btn-action-form", text = "Enviar", className = "btn btn-primary mt-3" } = {}) {
    return new NeobrutalismoFamilyButton({ id, text, className });
  }
}
