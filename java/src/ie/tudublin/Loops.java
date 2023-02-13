package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {
	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
	}


	void if_statement() {
		int topleftx = 500;
		int toplefty = 0;
		int bottomrightx = 250;
		int bottomrighty = 1000;
		stroke(0);

		if (mouseX > 500 )
		{
			bottomrightx = 250;
		}
		else if (mouseX < 500)
		{
			bottomrightx = -250;
		}

		if (mouseY < 200)
		{
			bottomrighty = 300;
		}
		else if(mouseY > 600)
		{
			toplefty = 700;

		}
		rect(topleftx, toplefty, bottomrightx, bottomrighty);
	}

	void forloop1() {
		int i =0;
		for (i = 0; i<256; i+=25)
		{
			fill(i,255,255);
			rect(i*4,0,100,1000);
		}
	}
	void forloop2()
	{
		int i =0;
		int startpoint = 0;
		for(i = 0; i<256; i+=25)
		{
			fill(i,255,255);
			rect(i*4,startpoint,100,100);
			startpoint += 100;
		}
	}

	void forloop3() {
		int i =0;
		int startpoint1 = 0;
		int startpoint2 =100;
		for(i = 0; i<10; i++)
		{
			fill(i*25,255,255);
			rect(i*100,startpoint1,100,100);
			rect(1000-(i*100),startpoint2,-100,-100);

			startpoint1 +=100;
			startpoint2 +=100;
		}
	}

	void loop4()
	{
		int i =0;

		for(i=10;i>0;i--)
		{
			stroke(i*20,255,255);
			fill(i*20,255,255);
			ellipse(500, 500, i*100, i*100);
		}
	}

	void loop5()
	{
		int i = 0;
		int center = 50;
		for(i=0;i<10;i++)
		{
			stroke(i*20,255,255);
			fill(i*20,255,255);
			ellipse(center,500,100,100);
			center+=100;
		}
	}

	void loop6()
	{
		int i = 0;
		int j = 0;
		// int numcircles = (int)(max(1,mouseX/50));
		int numcircles = 20;
		int centerX = (width / numcircles) / 2;
		int centerY = (height / numcircles) / 2;
		float diameter = width / (float)numcircles;

		background(255);

		for(i=0;i<numcircles;i++)
		{
			centerX = 50;
			for(j=0;j<numcircles;j++)
			{
				//(i+j)*x: x decided how different are colour of circles
				float c = ((i + j) /((numcircles - 1) * 2.0f))*255.0f;
				float timec = ((i+j)*5+(frameCount)) % 256.0f;

				stroke(timec,255,255);
				fill(timec,255,255);
				ellipse(centerX,centerY,diameter,diameter);
				centerX+=diameter;
			}
			centerY+=diameter;
		}
	}

	void loop7()
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

	void loop8()
	{
		int i = 0;
		int j = 0;
		for(i=0;i<20;i++)
		{
			for (j=0;j<20;j++)
			{
				if ((j % 2 == 0 && i%2 == 1) || (j % 2 ==1 && i%2 == 0))
				{
					fill(180,255,255);
					stroke(180,255,255);
				}
				else
				{
					fill(150,255,255);
					stroke(150,255,255);
				}
				rect(j*50,i*50,50,50);
			}
		}
	}

	void sin_cos()
	{
		int i = 0;
		int degree = 90;
		int length = 300;
		float center = width / 2.0f;
		for(i=0;i<5;i++)
		{
			stroke(255);
			// noFill();
			// circle(500,500,600);
			// line(0,500,1000,500);
			// line(500,0,500,1000);
			float opp, adja;
			opp = center - sin(degree_to_rad(degree))*length;
			adja = cos(degree_to_rad(degree))*length + center;
			line(center,center,adja,opp);
			degree+=72;

		}
	}

	void sin_cos2()
	{
		int i = 0;
		int degree = 90;
		int length = 300;
		int diff = 72;
		
		for(i=0;i<5;i++)
		{
			stroke(255);
			float x1,y1,x2,y2;
			x1 = cos(degree_to_rad(degree))*length+500;
			x2 = cos(degree_to_rad(degree+diff))*length+500;
			y1 = 500-(sin(degree_to_rad(degree))*length);
			y2 = 500-(sin(degree_to_rad(degree+diff))*length);

			line(x1,y1,x2,y2);
			degree += diff;
		}

	}

	float degree_to_rad(int x)
	{
		return x*(PI/180);
	}

	void stars()
	{
		int i = 0;
		int numstars = 2;
		int c=200;
		float centerX,centerY,random_centerX,random_centerY;
		centerX = (float)500.0;
		centerY = (float)500.0;
		int star_angle = 5;

		//randomize the position of star
		// centerX = random(1000);
		// centerY = random(1000);
		// c = (int)random(255);


		for(i=0;i<numstars;i++)
		{
			//star_angle = (int) random(5,9);
			star_angle =(int)7;
			//how many degree should angle increase to make a star
			int diff = 360/star_angle;

			int out_start_degree = 90;
			int inner_start_degree = 270-(diff*2);

			//randomize the length of star;
			//int length = (int)random(50,150);
			int length = 200;
			float small_length = length / 3;

			int num_jump = star_angle - 4;
			
			for(i=0;i<star_angle;i++)
			{
				stroke(c,255,255);
				float x1,y1,x2,y2;
				float sx1,sx2,sy1,sy2;
				//outer point
				x1 = cos(degree_to_rad(out_start_degree))*length+centerX;
				y1 = centerY-(sin(degree_to_rad(out_start_degree))*length);
				x2 = cos(degree_to_rad(out_start_degree+diff))*length+centerX;
				y2 = centerY-(sin(degree_to_rad(out_start_degree+diff))*length);


				//inner point
				sx1 = cos(degree_to_rad(inner_start_degree))*small_length+centerX;
				sy1 = centerY-(sin(degree_to_rad(inner_start_degree))*small_length);
				sx2 = cos(degree_to_rad(inner_start_degree-diff))*small_length+500;
				sy2 = 500-(sin(degree_to_rad(inner_start_degree-diff))*small_length);

				float sx3 =cos(degree_to_rad(inner_start_degree-num_jump*diff))*small_length+500;
				float sy3 = 500-(sin(degree_to_rad(inner_start_degree-num_jump*diff))*small_length);
	
				// line(x1,y1,x2,y2);
				// line(sx2,sy2,sx1,sy1);
				line(x1,y1,sx1,sy1);
				line(x1,y1,sx3,sy3);
				out_start_degree += diff;
				inner_start_degree += diff;


			}
			


		}
	}
	void drawstars()
	{

	}

	public void keyPressed() {
		
	}


	public void draw() {
		background(0);
		fill(255);
		//if_statement();
		stars();
	}
}
