package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship2;
	//generic container
	public ArrayList<Bullet> bullets = new ArrayList<>();

	public boolean[] keys = new boolean[1024];

	public void settings()
	{
		size(1024, 1024);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		ship = new Ship(width/2,height/2,70,50,this);
		ship2 = new Ship(width/2+100,height/2+100,20,70,this);
	}

	
	public void draw()
	{
		background(0);
		ship.render();
		ship.move();
		ship2.render();
		ship2.move();

		for(int i = bullets.size()-1;i>=0;i--)
		{
			bullets.get(i).render();
			bullets.get(i).move();
			bullets.get(i).check();
		}

		fill(255);
		text("bullets:" + bullets.size(),50,50);

	}
}
