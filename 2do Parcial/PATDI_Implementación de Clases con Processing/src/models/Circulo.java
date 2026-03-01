package models;

import processing.core.PApplet;

public class Circulo {
    
    private Posicion posicion;
    private Dimension dimension; // es posible hacer ovalos y elipses
    private int color;
    private Borde borde;
    
    // Default constructor
    public Circulo(){
        // Default: Circulo blanco @ 0,0 de tamaño 100x100
        this(new Posicion(), new Dimension(100,100), new Borde(), 255);
    }
    
    // Full constructor
    public Circulo(Posicion posicion, Dimension dimension, Borde borde, int color){
        this.posicion = posicion;
        this.dimension = dimension;
        this.borde = borde;
        this.color = color;
    }
    
    // Getters
    public Posicion getPosicion(){ return this.posicion; }
    public Dimension getDimension(){ return this.dimension; }
    public Borde getBorde(){ return this.borde; }
    public int getColor(){ return this.color; }
    
    // Setters
    public void setPosicion(Posicion nuevaPosicion){ this.posicion = nuevaPosicion; }
    public void setDimension (Dimension nuevaDimension) { this.dimension = nuevaDimension; }
    public void setBorde (Borde nuevoBorde){ this.borde = nuevoBorde; }
    
    public void setColor (int nuevoValor){
        if(nuevoValor < 0){
            System.out.println("Error: El número debe ser mayor o igual a 0...");
            return;
        }
        this.color = nuevoValor;
    }
    
    public void dibujar(PApplet p){
        p.stroke(this.borde.getColor());
        p.strokeWeight(this.borde.getAncho());
        p.fill(this.color);
        
        float x = this.posicion.getX();
        float y = this.posicion.getY();
        int ancho = this.dimension.getHorizontal();
        int alto = this.dimension.getVertical();
        
        p.ellipse(x, y, ancho, alto);
    }
}