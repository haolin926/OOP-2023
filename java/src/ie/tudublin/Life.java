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
		board = new lifeBoard(250,this);
		board.randomise();
		
	}

	public void keyPressed()
	{
		switch(key)
		{
			case ' ':
				state += 1;
				state %= 2;
				break;
			case '1':
				board.randomise();
				break;
			case '2':
				board.clear();
				break;
			case '3':
				board.cross();
				break;
		}
	}
	int state = 0;
	
	public void draw()
	{
		background(0);
		board.render();
		if(state == 0)
		{
			board.applyrules();
		}
	}
}
