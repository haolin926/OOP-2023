package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		smooth();
		
	}

	void drawGrid()
	{
		int i =0;
		int num = -5;
		int horizontal_x1 = 100;
		int horizontal_y = 100;
		int horizontal_x2 = 900;
		int vertical_y1 = 100;
		int vertical_y2 = 900;
		int vertical_x = 100;

		for (i = 0; i<11; i++)
		{
			stroke(100,255,255);
			
			//text on left
			textSize(30);
			textAlign(RIGHT,CENTER);
			text(num,(horizontal_x1-30),horizontal_y);

			//text on top
			textAlign(CENTER,TOP);
			text(num,vertical_x,vertical_y1-50);

			//lines
			line(horizontal_x1,horizontal_y,horizontal_x2,horizontal_y);
			line(vertical_x,vertical_y1,vertical_x,vertical_y2);
			vertical_x += 80;
			horizontal_y += 80;
			num++;
		}
	}

	void drawGrid2()
	{
		int num = 10;
		float LRborder = (float)width/(num+2);
		float TBborder = (float)height/(num+2);

		float LRgap = (float)(width- 2.0*LRborder) / num;
		float TBgap = (float)(height - 2.0*TBborder) / num;

		int numgap_away = 50;//keep number away from point
		int numgap_center = 5;//keep number closer to center of point


		background(0);

		for(int i = -5; i <= 5;i++)
		{
			float x = LRborder + (LRgap*(i+5));
			float y = TBborder + (TBgap*(i+5));

			stroke(100,255,255);

			textSize(20);
			textAlign(CENTER,RIGHT);
			text(i,LRborder-numgap_away,y-numgap_center);//horizontal
			
			textAlign(TOP,CENTER);
			text(i,x-numgap_center,TBborder-numgap_away);//vertical

			line(LRborder,y,width-LRborder,y);//horizontal line
			line(x,TBborder,x,height-TBborder);//vertical line


		}

	}

	public void draw()
	{	
		drawGrid2();		
	}
}
