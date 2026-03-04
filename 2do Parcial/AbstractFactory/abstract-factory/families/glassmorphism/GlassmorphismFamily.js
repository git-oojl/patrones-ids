import { IAbstractFactory } from "../../interfaces/IAbstractFactory.js";
import { GlassmorphismFamilyInput } from "./GlassmorphismFamilyInput.js";
import { GlassmorphismFamilyDropdown } from "./GlassmorphismFamilyDropdown.js";
import { GlassmorphismFamilyButton } from "./GlassmorphismFamilyButton.js";

export class GlassmorphismFamily extends IAbstractFactory {
  getName() { return "GlassmorphismFamily"; }
  getCssPath() { return "styles/glassmorphism.css"; }

  createInput({ id, label, type = "text", placeholder = "" }) {
    return new GlassmorphismFamilyInput({ id, label, type, placeholder });
  }

  createDropdown({ buttonText = "Dropdown", items = [] } = {}) {
    return new GlassmorphismFamilyDropdown({ buttonText, items });
  }

  createButton({ id = "btn-action-form", text = "Enviar", className = "btn btn-primary mt-3" } = {}) {
    return new GlassmorphismFamilyButton({ id, text, className });
  }
}
