package models;

import processing.core.PApplet;

public class Nube extends Figura {

    public Nube() {
        super();
        this.dimension = new Dimension(80, 50);
        this.color = 255; // Nubes color blanco
    }

    @Override
    public void dibujar(PApplet p) {
        p.noStroke(); // Sin bordes, color puro
        p.fill(this.color);

        float x = this.posicion.getX();
        float y = this.posicion.getY();

        // Tres circulos
        p.ellipse(x, y, 50, 50);           // Central
        p.ellipse(x - 30, y + 10, 40, 40); // Izquierdo
        p.ellipse(x + 30, y + 10, 40, 40); // Derecho
        
        p.stroke(0);
    }
    
    @Override
    public boolean mouseIsOver(int coordMouseX, int coordMouseY) {
        return true; 
    }
}