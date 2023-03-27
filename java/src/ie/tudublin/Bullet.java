package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Bullet {
    private PVector pos;
    private float speed;
    private PVector forward;
    private float rot;
    PApplet p;
    private int c;

    public Bullet(float x, float y, PApplet p, float rot, int c) {
        this.pos = new PVector(x, y);
        this.forward = new PVector(0, -1);
        this.speed = 5;
        this.p = p;
        this.rot = rot;
        this.c = c;
    }

    public void render() {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.stroke(c,255,255);
        p.line(0,-5,0,-5);
        p.popMatrix();
    }

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);
        pos.add(PVector.mult(forward, speed));
    }
    public void check()
    {
        if(pos.x < 0 || pos.x > p.width || pos.y < 0 || pos.y > p.height)
        {
            ((YASC)p).bullets.remove(this);
        }
    }


}
