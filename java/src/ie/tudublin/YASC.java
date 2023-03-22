package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;
	AIShip ship2;


	public void settings()
	{
		size(1024, 1024);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		ship2 = new AIShip(100, 100, 50, 0, this);
		colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		// ship1.render();
		// ship1.move();
		ship2.render();
	}
}
