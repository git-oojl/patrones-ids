package models;

public class Posicion {
    private float x;
    private float y;
    
    public Posicion(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public Posicion(){
        this(0,0);
    }
    
    public float getX(){
        return x;
    }   
    
    public float getY(){
        return y;
    }
    
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}