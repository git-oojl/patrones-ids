package models;

public class Dimension {
    private int vertical;
    private int horizontal;
    
    public Dimension(){
        this(0,0);
    }
    
    public Dimension(int w, int h){
        this.vertical = h;
        this.horizontal = w;
    }
    
    public int getVertical(){
        return vertical;
    }
    
    public int getHorizontal(){
        return horizontal;
    }
    
    public void setVertical(int vertical) {
        this.vertical = vertical;
    }
    
    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }
}