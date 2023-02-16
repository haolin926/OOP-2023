package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
import processing.data.Table;
import java.util.ArrayList;

public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		loadStars();
		printStar();

		smooth();
		
	}
	void loadStars()
	{
		Table table = loadTable("HabHYG15ly.csv", "header");
		for(TableRow r:table.rows())
		{
			Star s = new Star(r);
			stars.add(s);
		}
	}

	void printStar()
	{
		System.out.println("Name\tHab\tDistance\txG\tyG\tzG\tabsMsg");
		for(int i =0;i<stars.size();i++)
		{
			System.out.println(stars.get(i));
		}
	}
	//not incapsulated
	void plotStar()
	{
		for(Star i : stars)
		{
			float x = map(i.getxG(),-5,5,50,width);
			float y = map(i.getyG(),-5,5,50,width);

			stroke(50,255,255);
			line(x-5,y,x+5,y);
			line(x,y-5,x,y+5);

			textAlign(LEFT,CENTER);
			textSize(15);
			text(i.getDisplayName(),x+20,y);
			stroke(10,255,255);
			noFill();
			circle(x,y,(i.getDistance())*5);
		}
	}

	void plotstars_2()
	{
		for(Star i :stars)
		{
			i.render(this);
		}
	}
	float origin_X;
	float origin_Y;
	float endX;
	float endY;
	boolean pressed = false;
	int x = 0;
	public void mousePressed()
	{
		switch(x){
			case 0:
				if(mousePressed==true)
				{
					origin_X = mouseX;
					origin_Y = mouseY;
					x = 1;
				}
				break;
			case 1:
				stroke(30,255,255);
				line(mouseX,mouseY,origin_X,origin_Y);
				if(mousePressed)
				{
					endX = mouseX;
					endY = mouseY;
					x = 2;
				}
				break;
			case 2:
				if(mousePressed)
				{
					x = 0;
				}
				break;
			default:
				break;
		}
	}

	void drawLine()
	{
		if ( x == 1)
		{
		text("Origin position: (" + origin_X + origin_Y + ")",20,970);
		stroke(30,255,255);
		line(mouseX,mouseY,origin_X,origin_Y);
		}
		else if (x == 2)
		{
			stroke(30,255,255);
			line(endX,endY,origin_X,origin_Y);
			float distance = dist(origin_X,origin_Y,endX,endY);
			text("Distance: "+distance,20,970);
		}
	}

		
	public void draw()
	{	
		strokeWeight(1);
		background(0);
		drawGrid2();
		plotstars_2();
		drawLine();
	}

	void drawGrid2()
	{
		int num = 10;
		float LRborder = 50.0f;
		float TBborder = 50.0f;

		float LRgap = (float)(width- 2.0*LRborder) / num;
		float TBgap = (float)(height - 2.0*TBborder) / num;

		int numgap_away = 30;//keep number away from point
		int numgap_center = 5;//keep number closer to center of point


		background(0);

		for(int i = -5; i <= 5;i++)
		{
			//x = map(i,-5,5,LBborder,width - LBborder)
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
	float map1(float a,float b,float c,float d,float e)
	{
		return a/(b-c)*(e-d);
	}
}
