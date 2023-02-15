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
	void plotStar()
	{
		for(Star i : stars)
		{
			float x = map(i.xG,-5,5,50,width);
			float y = map(i.yG,-5,5,50,width);

			stroke(50,255,255);
			line(x-5,y,x+5,y);
			line(x,y-5,x,y+5);

			textAlign(LEFT,CENTER);
			textSize(15);
			text(i.displayName,x+20,y);
			stroke(10,255,255);
			noFill();
			circle(x,y,(i.distance)*5);
		}
	}
	float origin_X;
	float origin_Y;
	boolean pressed;
	public void mousePressed()
	{
		if(mousePressed==true)
		{
			origin_X = mouseX;
			origin_Y = mouseY;
			pressed = true;
		}
	}

	void drawLine()
	{
		stroke(30,255,255);
		float distance = dist(mouseX,mouseY,origin_X,origin_Y);
		text(distance,20,970);
		line(mouseX,mouseY,origin_X,origin_Y);
	}

		
	public void draw()
	{	
		strokeWeight(2);
		background(0);
		drawGrid2();
		plotStar();
		mousePressed();
		if(pressed == true)
		{
			drawLine();

		}
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
}
