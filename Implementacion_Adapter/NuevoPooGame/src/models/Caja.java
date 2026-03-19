package models;
import processing.core.PApplet;

// Hereda todo de figura
public class Caja extends Figura {
    
    // Constructuor por defecto
    public Caja() {
        // Llama al constructor por defecto de Figura
        super();
    }
    
    public Caja(Posicion posicion, Dimension dimension, Borde borde, int color) {
        // Le da los valores al superconstructor de Figura
        super(posicion, dimension, borde, color);
    }
    
    @Override
    public void dibujar(PApplet p) {
        configurarPropiedades(p);
        float origenX = this.posicion.getX();
        float origenY = this.posicion.getY();
        int pixelesBase = this.dimension.getHorizontal();
        int pixelesAltura = this.dimension.getVertical();
        
        // Rectangulo
        p.rect(origenX, origenY, pixelesBase, pixelesAltura);
    }
    
    @Override
    public boolean mouseIsOver(int punteroX, int punteroY){
        return true;
    }
}