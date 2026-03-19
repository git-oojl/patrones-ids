package models;

import processing.core.PApplet;

public class Elipse extends Figura {
    
    public Elipse() {
        super();
    }
    
    @Override
    public void dibujar(PApplet p) {
        configurarPropiedades(p);
        
        float origenX = this.posicion.getX();
        float origenY = this.posicion.getY();
        int ancho = this.dimension.getHorizontal();
        int altura = this.dimension.getVertical();
        
        // Declarar elipse
        p.ellipse(origenX, origenY, ancho, altura);
    }
    
    @Override
    public boolean mouseIsOver(int punteroX, int punteroY){
    return true;
    }
}