package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		playerX = 250;
		playerY = 500;
		playerWidth = 10;
		bugX = random(30,470);
		bugY = 20;
		bugW = 30;
		
	}

	float playerX,playerY,playerWidth;
	float bugX, bugY,bugW,buginitX;
	int score = 0;
	int gamestate = 0;
	
	public void draw()
	{	
		background(0);
		switch(gamestate)
		{
			case 0:
				splashscreen();
				break;
			case 1:
				drawPlayer(playerX,playerY,playerWidth);
				drawbug(bugX,bugY,bugW);
				score();
				gameover_chk();
				break;
			case 2:
				gameover();
				break;
		}
	}
	public void drawPlayer(float x, float y,float w)
	{
		stroke(255);
		fill(0);
		triangle(x-w,y-10,x+w,y-10,x,y-20);
	}
	public void keyPressed()
	{
		if(keyCode == LEFT)
		{
			//System.out.println("Left arrow pressed");
			if(playerX != 10)
			{
				playerX -=10;
			}
			else
			{
				playerX = 10;
			}
		}
		if (keyCode == RIGHT)
		{
			//System.out.println("Right arrow pressed");
			if(playerX != 490)
			{
				playerX+=10;
			}
			else
			{
				playerX = 490;
			}
		}
		if (key == ' ')
		{
			if(gamestate == 0 || gamestate ==2)
			{
				gamestate=1;
				bugY = 20;
				score = 0;
			}
			//System.out.println("SPACE key pressed");
			
			else if(gamestate == 1)
			{
				stroke(255);
				line(playerX,playerY-20,playerX,0);

				if(playerX > bugX - 20 && playerX < bugX + 20)
				{
					bugX = random(30,470);
					bugY = 20;
					System.out.println("hitted");
					score++;
				}
			}
		}
	}
	public void drawbug(float x,float y,float w)
	{
		if (frameCount % 60 == 0)
		{
			bugX = random(bugX - 20,bugX + 20);
			bugY+=50;
			System.out.println(bugY);
		}
		stroke(255);
		fill(0);
		ellipse(x, y, w, w-10);
	}
	public void gameover_chk()
	{
		if(bugY > 480)
		{
			gamestate=2;
		}
	}
	public void gameover()
	{
		background(1);
		fill(255);
		textSize(40);
		text("game over.Press space to restart", 250, 250);
	}
	public void score()
	{
		fill(255);
		textSize(20);
		text("Score:"+score,410,450);
	}
	public void splashscreen()
	{

		fill(255);
		textSize(40);
		text("Press space to start game.",250,250);
	}
}


