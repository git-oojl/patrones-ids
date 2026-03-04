import { NeobrutalismoFamily } from "./families/neobrutalismo/NeobrutalismoFamily.js";
import { GlassmorphismFamily } from "./families/glassmorphism/GlassmorphismFamily.js";
import { DarktechFamily } from "./families/darktech/DarktechFamily.js";
import { MinimalistFamily } from "./families/minimalist/MinimalistFamily.js";

export function getAllFactories() {
  return [
    new MinimalistFamily(),
    new NeobrutalismoFamily(),
    new GlassmorphismFamily(),
    new DarktechFamily(),
  ];
}

export function createFactoryByName(name) {
  switch (name) {
    case "NeobrutalismoFamily": return new NeobrutalismoFamily();
    case "GlassmorphismFamily": return new GlassmorphismFamily();
    case "DarktechFamily": return new DarktechFamily();
    case "MinimalistFamily":
    default: return new MinimalistFamily();
  }
}
