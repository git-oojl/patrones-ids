// 05/02/26: Sesión de herencias

package models;

import nuevopoo.InterfaceFiguras;
import nuevopoo.Config; // Para leer tamaño de la ventana
import processing.core.PApplet;

public abstract class Figura implements InterfaceFiguras {
    
    protected Posicion posicion;
    protected Dimension dimension;
    protected Borde borde;
    protected int color;
    
    protected boolean controlManualHorizontal = true;
    protected boolean controlManualVertical = true;
    
    // Fisica
    protected boolean automatico = false; // true = se mueve por si solo, false = control con keyboard
    protected boolean rebota = false;     // true = rebote en las "paredes", false = sale de la pantalla
    protected float velocidadX = 0;       // Velocidad por defecto de movimiento automático
    protected float velocidadY = 0;

    public Figura() {
        this(new Posicion(), new Dimension(100, 100), new Borde(), 255);
    }

    public Figura(Posicion posicion, Dimension dimension, Borde borde, int color) {
        this.posicion = posicion;
        this.dimension = dimension;
        this.borde = borde;
        this.color = color;
    }

    // Configuraciones
    
    public void setModoAutomatico(boolean auto, boolean rebota, float vx, float vy) {
        this.automatico = auto;
        this.rebota = rebota;
        this.velocidadX = vx;
        this.velocidadY = vy;
    }
    
// NEW: Method to configure manual controls
    public void setControlManual(boolean permitirHorizontal, boolean permitirVertical) {
        this.controlManualHorizontal = permitirHorizontal;
        this.controlManualVertical = permitirVertical;
    }
    
        public boolean esAutomatico() {
        return this.automatico;
    }
    
    // Getters for the permissions
    public boolean puedeMoverHorizontal() { return this.controlManualHorizontal; }
    public boolean puedeMoverVertical() { return this.controlManualVertical; }

    // Lógica de movimiento
    // Manual: Usa el parametro 'delta' del teclado
    @Override
    public void moverHorizontal(float delta) {
        float nuevaX = this.posicion.getX() + delta;
        
        // 1. Check Left Edge (Prevent going below 0)
        if (nuevaX < 0) {
            nuevaX = 0;
        }
        
        // 2. Check Right Edge (Prevent going past Screen Width)
        // We subtract the object's width (dimension.getHorizontal()) 
        // to ensure the right side of the car doesn't leave the screen.
        else if (nuevaX + this.dimension.getHorizontal() > Config.ANCHO) {
            nuevaX = Config.ANCHO - this.dimension.getHorizontal();
        }
        
        this.posicion.setX(nuevaX);
    }
    
    @Override
    public void moverVertical(float delta) {
        float nuevaY = this.posicion.getY() + delta;
        
        // NEW: Clamp to Screen Height
        if (nuevaY < 0) {
            nuevaY = 0;
        } else if (nuevaY + this.dimension.getVertical() > Config.ALTO) {
            nuevaY = Config.ALTO - this.dimension.getVertical();
        }
        
        this.posicion.setY(nuevaY);
    }

    // Movimiento automático: usa valores de velocidad en X, Y
    public void moverAutomatico() {
        if (!automatico) return;

        // Aplicar velocidad
        float nuevaX = this.posicion.getX() + velocidadX;
        float nuevaY = this.posicion.getY() + velocidadY;

        // Rebote
        if (rebota) {
            // Leer bordes izquierda y derecha
            if (nuevaX + dimension.getHorizontal() > Config.ANCHO || nuevaX < 0) {
                velocidadX *= -1; // Reverse direction
                nuevaX += velocidadX; // Un-stick from wall
            }
            
            // Leer bordes superiores e inferiores
            if (nuevaY + dimension.getVertical() > Config.ALTO || nuevaY < 0) {
                velocidadY *= -1; // Invertir dirección
                nuevaY += velocidadY; // Despegar de borde
            }
        }

        // Aplicar cambios
        this.posicion.setX(nuevaX);
        this.posicion.setY(nuevaY);
    }

    // Getters, Setters, Drawing
    
    public Posicion getPosicion() { return this.posicion; }
    public Dimension getDimension() { return this.dimension; }
    public Borde getBorde() { return this.borde; }
    public int getColor() { return this.color; }

    public void setPosicion(Posicion nuevaPosicion) { this.posicion = nuevaPosicion; }
    public void setDimension(Dimension nuevaDimension) { this.dimension = nuevaDimension; }
    public void setBorde(Borde nuevoBorde) { this.borde = nuevoBorde; }
    
    public void setColor(int nuevoValor) {
        this.color = nuevoValor;
    }
    
    public abstract void dibujar(PApplet p);

    public void configurarPropiedades(PApplet p) {
        p.stroke(this.borde.getColor());
        p.strokeWeight(this.borde.getAncho());
        p.fill(this.color);
    }
}