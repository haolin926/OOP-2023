package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PVector forward;
    private int c;
    private float size;
    private float halfSize;
    private float rot;
    PApplet p;

    public PVector getPos() {
        return pos;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
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
    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);
        if(p.keyPressed)
        {
            if(p.keyCode == PApplet.LEFT)
            {
                this.rot -= 0.1f;
            }
            if(p.keyCode == PApplet.RIGHT)
            {
                this.rot += 0.1f;
            }
            if(p.keyCode == PApplet.UP)
            {
                pos.x += forward.x;
                pos.y += forward.y;
            }
            if(p.keyCode == PApplet.DOWN)
            {
                pos.x -= forward.x;
                pos.y -= forward.y;
            }

            if(p.key == ' ')
            {
                PVector inFront = PVector.add(pos,PVector.mult(forward,20));
                Bullet b = new Bullet(inFront.x,inFront.y,p,rot,c);

                ((YASC)p).bullets.add(b);
            }
        }
    }

    
    public Ship(float x,float y, int c, float size, PApplet p)
    {
        this.pos = new PVector(x,y);
        this.forward = new PVector(0,1);
        this.c = c;
        this.size = size;
        this.p = p;
        this.halfSize = size/2;
        this.rot = 0;
    }

    public void render()
    {
        p.pushMatrix();
        p.stroke(c,255,255);
        p.translate(pos.x,pos.y);
        p.rotate(rot);
        p.noFill();

        p.line(-halfSize, halfSize, 0, -halfSize);
        p.line(0, - halfSize, halfSize, halfSize);
        p.line(- halfSize, halfSize, 0, 0);
        p.line(0, 0, halfSize, halfSize);
        p.popMatrix();
    }

}
