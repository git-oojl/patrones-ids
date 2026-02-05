package nuevopoo;

import processing.core.PApplet;
import models.Caja;
import models.Circulo;

public class NuevoPoo extends PApplet {
    
    // partes del cuerpo
    Circulo base, body, head;
    Caja hatBrim, hatTop;
    
    // detalles del cuerpo
    Circulo eyeLeft, eyeRight;
    Caja nose;
    Circulo button1, button2, button3;
    Circulo smile1, smile2, smile3;

    @Override
    public void settings() {
        size(Config.ANCHO, Config.ALTO);
    }

    @Override
    public void setup() {
        float centerX = width / 2.0f;

        // Cuerpo
        base = new Circulo();
        base.getDimension().setHorizontal(160);
        base.getDimension().setVertical(160);
        base.getPosicion().setX(centerX);
        base.getPosicion().setY(450);

        body = new Circulo();
        body.getDimension().setHorizontal(110);
        body.getDimension().setVertical(110);
        body.getPosicion().setX(centerX);
        body.getPosicion().setY(330);
        
        head = new Circulo();
        head.getDimension().setHorizontal(80);
        head.getDimension().setVertical(80);
        head.getPosicion().setX(centerX);
        head.getPosicion().setY(245);

        // Sombrero
        hatBrim = new Caja();
        hatBrim.setColor(50);
        hatBrim.getDimension().setHorizontal(100);
        hatBrim.getDimension().setVertical(10);
        hatBrim.getPosicion().setX(centerX - 50);
        hatBrim.getPosicion().setY(205);

        hatTop = new Caja();
        hatTop.setColor(50);
        hatTop.getDimension().setHorizontal(60);
        hatTop.getDimension().setVertical(70);
        hatTop.getPosicion().setX(centerX - 30);
        hatTop.getPosicion().setY(135);

        // Ojos
        eyeLeft = new Circulo();
        eyeLeft.setColor(0); // Black
        eyeLeft.getDimension().setHorizontal(10);
        eyeLeft.getDimension().setVertical(10);
        eyeLeft.getPosicion().setX(centerX - 15);
        eyeLeft.getPosicion().setY(235);

        eyeRight = new Circulo();
        eyeRight.setColor(0); 
        eyeRight.getDimension().setHorizontal(10);
        eyeRight.getDimension().setVertical(10);
        eyeRight.getPosicion().setX(centerX + 15);
        eyeRight.getPosicion().setY(235);

        // Nariz
        nose = new Caja();
        nose.setColor(color(255, 140, 0)); // relleno naranja
        nose.getDimension().setHorizontal(25);
        nose.getDimension().setVertical(8);
        // Posición
        nose.getPosicion().setX(centerX - 2);  
        nose.getPosicion().setY(245);

        // Botones
        button1 = new Circulo(); button2 = new Circulo(); button3 = new Circulo();
        
        setupButton(button1, centerX, 315);
        setupButton(button2, centerX, 335);
        setupButton(button3, centerX, 355);
        
        // Sonrisa
        smile1 = new Circulo(); smile2 = new Circulo(); smile3 = new Circulo();
        
        setupSmileDot(smile1, centerX - 12, 260);
        setupSmileDot(smile2, centerX, 265);
        setupSmileDot(smile3, centerX + 12, 260);
    }
    
    // Ayudante para botones
    private void setupButton(Circulo btn, float x, float y) {
        btn.setColor(0);
        btn.getDimension().setHorizontal(8);
        btn.getDimension().setVertical(8);
        btn.getPosicion().setX(x);
        btn.getPosicion().setY(y);
    }

    // Ayudante para sonrisa
    private void setupSmileDot(Circulo dot, float x, float y) {
        dot.setColor(0);
        dot.getDimension().setHorizontal(5);
        dot.getDimension().setVertical(5);
        dot.getPosicion().setX(x);
        dot.getPosicion().setY(y);
    }

    @Override
    public void draw() {
        background(20, 25, 50); // Fondo de noche
        
        // Dibujar cuerpo
        base.dibujar(this);
        body.dibujar(this);
        head.dibujar(this);
        
        // Dibujar cara y botones
        eyeLeft.dibujar(this);
        eyeRight.dibujar(this);
        
        button1.dibujar(this);
        button2.dibujar(this);
        button3.dibujar(this);
        
        smile1.dibujar(this);
        smile2.dibujar(this);
        smile3.dibujar(this);
        
        nose.dibujar(this); // Dibujamos nariz al final para que tome prioridad
        
        // Sombrero
        hatTop.dibujar(this);
        hatBrim.dibujar(this);
    }
    
    public static void main(String[] args) {
        PApplet.main("nuevopoo.NuevoPoo");
    }
}