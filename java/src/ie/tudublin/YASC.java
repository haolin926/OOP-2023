package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship2;
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
	}
}
