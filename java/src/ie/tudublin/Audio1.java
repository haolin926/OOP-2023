package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import java.lang.Math;

public class Audio1 extends PApplet{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    int frameSize = 1024;

    //array contain all the samples
    AudioBuffer ab;

    public void settings()
	{
		size(1024, 1000);
	}

	public void setup() {
		colorMode(HSB);
        background(0);

        minim = new Minim(this);

        //open microphone, set buffer size in 1024, read sample in 44100hz in 16 bit per sample
        ai = minim.getLineIn(Minim.MONO,frameSize,44100,16);
        ab = ai.mix;

        smooth();
	}

	
	public void draw()
	{	
		background(0);
        stroke(255);
        float half = height/2;
        float cgap = 255 / (float)ab.size();
        float sum=0;
        float average = 0;

        for(int i = 0; i < ab.size(); i++)
        {
            sum = sum + Math.abs(ab.get(i));
            stroke(255);
            line(i,height / 2,i, half+ ab.get(i)* half);
        }

        noFill();
        average = sum / ab.size();
        float r = average*10000;
        lerpedr = lerp(lerpedr, r,0.1f);
        circle(500,800,lerpedr);

        //smoothing linear interprelation
        // lerp(a,b,t);
        // map();

        //t stands percantage beetween a and b
        // float lerp(float a, float b, float t)
        // {
        //     return a + (b-a)*t;
        // }

	}
    float lerpedr = 0;
}
