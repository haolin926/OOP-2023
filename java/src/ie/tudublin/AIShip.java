package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class AIShip extends Ship{
    private ArrayList<PVector> path;
    private PVector curr;

    public AIShip(float x, float y, float size, int c, PApplet p)
    {
        super(x, y, size, c, p);
        super.setC(0);
        path = new ArrayList<PVector>();
        for(int i = 0; i < 10; i++)
        {
            path.add(new PVector(p.random(-5, 5), p.random(-5, 5)));
        }
    }

    @Override
    public void render()
    {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.circle(this.pos.x, this.pos.y, this.size);
        int r = (int) p.random(10);
        curr = path.get(r);
        this.pos.x += curr.x;
        this.pos.y += curr.y;
        p.popMatrix();

        if(this.pos.x > p.width)
        {
            this.pos.x = 0;
        }
        if(this.pos.x < 0)
        {
            this.pos.x = p.width;
        }
        if(this.pos.y > p.height)
        {
            this.pos.y = 0;
        }
        if(this.pos.y < 0)
        {
            this.pos.y = p.height;
        }
    }
}
