package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

    }

    float off = 0;

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        //for line on left right
        float left = cx - 250.0f;
        float top = cy - 250.0f;

        //for line on top bottom
        float top2 = cy - 250.0f;
        float left2 = cy - 250.0f;

        switch (mode) {
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
            case 1:
                background(0);
                for(int i = 0;i < ab.size(); i++)
                {
                    float c = map(i,0,ab.size(),0,255);
                    stroke(c,255,255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, halfH - f, i);
                    
                }            
                break;
            case 2:
                background(0);
                for(int i = 0; i<ab.size(); i++)
                {
                    float c = map(i,0,ab.size(),0,255);
                    stroke(c,255,255);
                    float f = ab.get(i) * halfH;

                    //x must 0, f
                    line(0,i,f,i);
                    line(width,i,width -f,i);
                    line(i,0,i,f);
                    line(i,height,i,height - f);
                }
                break;
            case 3:
                background(0);
                for(int i = 0; i<ab.size(); i++)
                {
                    float c = map(smoothedAmplitude,0,1,0,255);
                    float r = map(smoothedAmplitude,0,0.5f,100,2000);
                    stroke(c,255,255);

                    noFill();
                    circle(cx,cy,r);
                }
                break;
            case 4:
                background(0);
                for(int i = 0; i<ab.size(); i++)
                {
                    float c = map(smoothedAmplitude,0,1,0,255);
                    float r = map(smoothedAmplitude,0,0.5f,100,1000);
                    stroke(c,255,255);

                    noFill();
                    rectMode(CENTER);
                    rect(cx,cy,r,r);
                }
                break;
            
            case 5:
                background(0);
                for(int i = 0; i<ab.size();i++)
                {
                    float c = map(smoothedAmplitude,0,1,0,255);
                    
                    float r = map(smoothedAmplitude,0,0.5f,100,1000);
                    float f = ab.get(i) * halfH;
                    float lerpf = lerp(f,average,0.1f);

                    

                    stroke(c,255,255);

                    noFill();
                    rectMode(CENTER);
                    rect(cx,cy,500,500);


                    line(left,top,left-abs(f),top);
                    line(left+500,top,left+500+abs(f),top);
                    if(top <= 750)
                    {
                        top++;
                    }
                    line(left2,top2,left2,top2-abs(f));
                    line(left2,top2+500,left2,top2+500+abs(f));
                    if(left2 <= 750)
                    {
                        left2++;
                    }
                }
                
            
                

        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
