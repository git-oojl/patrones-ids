package models;

import processing.core.PApplet;

public class Carro extends Figura {

    public Carro() {
        super();
        // Tamaño por defecto de carros
        this.dimension = new Dimension(100, 40); 
    }

    @Override
    public void dibujar(PApplet p) {
        configurarPropiedades(p);

        float x = this.posicion.getX();
        float y = this.posicion.getY();
        
        // 1. Cuerpo
        p.rect(x, y, dimension.getHorizontal(), dimension.getVertical());

        // 2. Dibujar ruedas
        p.fill(0); // Ruedas negras
        
        // Rueda izquierda
        p.ellipse(x + 15, y + dimension.getVertical(), 20, 20); // Posiciones relativas al X, Y del carro
        
        // Rueda derecha
        p.ellipse(x + dimension.getHorizontal() - 15, y + dimension.getVertical(), 20, 20); // Posiciones relativas al X, Y del carro
        
        p.fill(this.color); 
    }
    
    @Override
    public boolean mouseIsOver(int coordMouseX, int coordMouseY) {
        return true; 
    }
}