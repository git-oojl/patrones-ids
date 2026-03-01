package models;

public class Borde {
    private int ancho;
    private int color;
    
    public Borde(int ancho, int color){
        this.ancho = ancho;
        this.color = color;
    }
    
    public Borde(){
        this.ancho = 5;
        this.color = 0;
    }
    
    public void setAncho(int ancho){
        if (ancho<10){
            this.ancho = ancho;
        }
        else{
            System.err.println("Error: el ancho no debe sobrepasar a 10");
        }
    }
    
    public void setColor(int color){
        this.color = color;
    }
    
    public int getAncho(){
        return this.ancho;
    }
    
    public int getColor(){
        return this.color;
    }
}
