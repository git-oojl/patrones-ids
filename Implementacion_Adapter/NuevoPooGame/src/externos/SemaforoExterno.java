package externos;

import processing.core.PApplet;

public class SemaforoExterno {

    public void renderizarSemaforo(PApplet p, int x, int y, String estado) {
        // Poste / base
        p.fill(70);
        p.rect(x, y, 30, 90);

        // Luz roja
        if ("rojo".equals(estado)) {
            p.fill(255, 0, 0);
        } else {
            p.fill(120);
        }
        p.ellipse(x + 15, y + 20, 18, 18);

        // Luz amarilla
        if ("amarillo".equals(estado)) {
            p.fill(255, 255, 0);
        } else {
            p.fill(120);
        }
        p.ellipse(x + 15, y + 45, 18, 18);

        // Luz verde
        if ("verde".equals(estado)) {
            p.fill(0, 255, 0);
        } else {
            p.fill(120);
        }
        p.ellipse(x + 15, y + 70, 18, 18);
    }
}