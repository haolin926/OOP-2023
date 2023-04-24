package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class HealthPowerup extends GameObject implements PowerUp{

    float w;
    float half_w;
    public HealthPowerup(float x, float y, float rot, int c, YASC p) {
        //constructor chain
        super(x, y, rot, c, p);
        w = 50;
        half_w = w/2;

        forward.x = p.random(-1, 1);
        forward.y = p.random(-1, 1);
        forward.normalize();
    }

    @Override
    public void update() {
        rot += 0.01f;
        pos.add(PVector.mult(forward,1));

        if (pos.x < 0)
        {
            pos.x = p.width;
        }
        if (pos.y < 0)
        {
            pos.y = p.height;
        }
        if (pos.x > p.width)
        {
            pos.x = 0;
        }

        if (pos.y > p.height)
        {
            pos.y = 0;
        }
    }

    @Override
    public void render() {
        p.pushMatrix();
        p.noFill();
        p.stroke(255);
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.rectMode(PApplet.CENTER);
        p.rect(0, 0, half_w, half_w);
        p.line(0,-20,0,20);
        p.line(-20,0,20,0);
        p.popMatrix();
    }
    
    
}
