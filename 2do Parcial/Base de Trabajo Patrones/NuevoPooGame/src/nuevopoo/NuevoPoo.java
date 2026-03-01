package nuevopoo;

import processing.core.PApplet;
import models.*;
import java.util.ArrayList; // Para poder usar arreglos

public class NuevoPoo extends PApplet {
    
    // Lista donde se almacenan todas las figuras
    ArrayList<Figura> figuras;

    @Override
    public void settings() {
        size(Config.ANCHO, Config.ALTO);
    }

    @Override
    public void setup() {
        figuras = new ArrayList<>();
        
        // Nubes de fondo (automáticas, sin rebote)
        Nube nube1 = new Nube();
        nube1.setPosicion(new Posicion(50, 80));
        nube1.setModoAutomatico(true, false, 0.2f, 0); 
        figuras.add(nube1);

        Nube nube2 = new Nube();
        nube2.setPosicion(new Posicion(500, 150));
        nube2.setModoAutomatico(true, false, -0.2f, 0); 
        figuras.add(nube2);

        // Automobiles automáticos
        
        // Sin rebote
        Carro taxi = new Carro();
        taxi.setPosicion(new Posicion(50, 400));
        taxi.setColor(color(255, 0, 0)); 
        taxi.setModoAutomatico(true, true, 5, 0); 
        figuras.add(taxi);

        // Con rebote
        Carro viejo = new Carro();
        viejo.setPosicion(new Posicion(500, 250));
        viejo.setColor(color(0, 0, 200)); 
        viejo.setModoAutomatico(true, false, -0.5f, 0); 
        figuras.add(viejo);


        // Automobil manual
        Carro jugador = new Carro();
        jugador.setPosicion(new Posicion(250, 500));
        jugador.setColor(color(0, 255, 0)); 
        jugador.setModoAutomatico(false, false, 0, 0); 
        figuras.add(jugador);
        
        jugador.setControlManual(true, false);
    }

    @Override
    public void draw() { 
        background(100, 200, 255);
        
        // Draw the road
        fill(50);
        rect(0, 200, width, 400);
        
        // Recorrido de todas las figuras
        for (Figura f : figuras) {
            // Dibujar cada una
            f.dibujar(this);
            
            // Si es automatica, dejar que sea automatica
            if (f.esAutomatico()) {
                f.moverAutomatico();
            }
        }
    }
    
    // Controles
    @Override
    public void keyPressed() {
    float velocidadManual = 5; // pasos por cada tecleado

    for (Figura f : figuras) {
        // Solo mueve objetos no automatizados
        if (!f.esAutomatico()) {

            // check permissions before moving
            if (keyCode == UP && f.puedeMoverVertical()) {
                f.moverVertical(-velocidadManual);  // Negativo en Y desplaza hacia ARRIBA
            } 
            else if (keyCode == DOWN && f.puedeMoverVertical()) {
                f.moverVertical(velocidadManual);   // Positivo en Y desplaza hacia ABAJO
            } 
            else if (keyCode == LEFT && f.puedeMoverHorizontal()) {
                f.moverHorizontal(-velocidadManual);    // Negativo en X desplaza hacia IZQUIERDA
            } 
            else if (keyCode == RIGHT && f.puedeMoverHorizontal()) {
                f.moverHorizontal(velocidadManual);     // Positivo en X desplaza hacia DERECHA
            }
        }  
    }    
}       
    
    public static void main(String[] args) {
        PApplet.main("nuevopoo.NuevoPoo");
    }
}
    