package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private float rot;
    private int c;
    private float size;
    PApplet p;

    public PVector getPos() {
        return pos;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
    }

    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Ship(){

    }
    
    public Ship(float x,float y, float rot, int c, float size, PApplet p)
    {
        this.pos = new PVector(x,y);
        this.rot = rot;
        this.c = c;
        this.size = size;
        this.p = p;
    }

}
