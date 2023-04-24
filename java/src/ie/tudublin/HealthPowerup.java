package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class HealthPowerUp extends GameObject implements PowerUp{

    float w;
    float half_w;
    public HealthPowerUp(float x, float y, float rot, int c, YASC p) {
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
    }

    @Override
    public void render() {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.rectMode(PApplet.CENTER);
        p.rect(0, 0, half_w, half_w);
        p.line(0,-20,0,20);
        p.line(-20,0,20,0);
        p.popMatrix();
    }
    
    
}
