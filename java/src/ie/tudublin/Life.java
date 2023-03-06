package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	lifeBoard board;
	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		board = new lifeBoard(200,this);
		board.randomise();
		
	}

	
	
	public void draw()
	{
		background(0);
		board.render();
			board.applyrules();

	}
}
