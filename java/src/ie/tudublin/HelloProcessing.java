package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		// colorMode(HSB);
		 background(240,87,87);

		// x1 = random(0, width);
		// x2 = random(0, width);
		// y1 = random(0, height);
		// y2 = random(0, height);

		// float range = 5;

		// x1dir = random(-range, range);
		// x2dir = random(-range, range);
		// y1dir = random(-range, range);
		// y2dir = random(-range, range);

		// smooth();
		
	}

	float x1, y1, x2, y2;
	float x1dir, x2dir, y1dir, y2dir;
	float c = 0;
	
	public void draw()
	{	
		// strokeWeight(2);
		// stroke(c, 255, 255);
		// c = (c + 1f) % 255;
		// line(x1, y1, x2, y2);

		// x1 += x1dir;
		// x2 += x2dir;
		// y1 += y1dir;
		// y2 += y2dir;
		
		// if (x1 < 0 || x1 > width)
		// {
		// 	x1dir = - x1dir;
		// }
		// if (y1 < 0 || y1 > height)
		// {
		// 	y1dir = - y1dir;
		// }

		// if (x2 < 0 || x2 > width)
		// {
		// 	x2dir = - x2dir;
		// }
		// if (y2 < 0 || y2 > height)
		// {
		// 	y2dir = - y2dir;
		// }
		//line(10,10,100,100);//x1,y1,x2,y2
		fill(23,205,242);
		triangle(250, 0, 500, 450, 0, 450);
		fill(242,234,23);
		circle(250,270,300);//cx,cy,d
		fill(255,255,255);

		ellipse(250, 270, 200, 100);
		noStroke();
		fill(0,0,0);
		circle(250,270,100);
		noFill();
		//fill(255,0,0);
		//rect(10,300,20,100);//top left x, top left y,w, h

	}
}
