package models;

import externos.SemaforoExterno;
import processing.core.PApplet;

public class SemaforoAdapter extends Figura {

    private SemaforoExterno semaforo;
    private String estado;

    public SemaforoAdapter(SemaforoExterno semaforo, String estado) {
        super();
        this.semaforo = semaforo;
        this.estado = estado;

        // Tamaño lógico del semáforo dentro del juego
        this.dimension = new Dimension(30, 90);

        // No se mueve solo
        this.setModoAutomatico(false, false, 0, 0);

        // No queremos moverlo con teclado
        this.setControlManual(false, false);
    }

    @Override
    public void dibujar(PApplet p) {
        semaforo.renderizarSemaforo(
            p,
            (int) this.posicion.getX(),
            (int) this.posicion.getY(),
            this.estado
        );
    }

    @Override
    public boolean mouseIsOver(int coordMouseX, int coordMouseY) {
        return coordMouseX >= this.posicion.getX()
            && coordMouseX <= this.posicion.getX() + this.dimension.getHorizontal()
            && coordMouseY >= this.posicion.getY()
            && coordMouseY <= this.posicion.getY() + this.dimension.getVertical();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}