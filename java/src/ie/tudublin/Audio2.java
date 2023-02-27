package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.AudioInput;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;


public class Audio2 extends PApplet{
    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    FFT fft;

    public void setup()
    {
                colorMode(HSB);

        m = new Minim(this);
        //reading from microphone, in 1024 size buffer hz 44100 bit 16
        ai = m.getLineIn(Minim.MONO,width,44100,16);
        ab = ai.mix;
        lerpedBuffer = new float[1024];

        fft = new FFT(width,44100);
    }

    public void settings()
    {
        size(1024,1024,P3D);
    }
    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        float c;
        float half = height / 2;
        for(int i = 0; i<ab.size();i++)
        {
            lerpedBuffer[i] = lerp(lerpedBuffer[i],ab.get(i),0.1f);
            c = map1(i,0,ab.size(),0,255);
            stroke(c,255,255);
            float f = abs(lerpedBuffer[i] * half * 3.0f);
            line(i,half-f,i, half + f);
        }

        fft.forward(ab);
        int highestIndex = 0;
        for(int i = 0; i < fft.specSize();i++)
        {
            if(fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);

        float y = map(freq, 1000, 2500, height, 0);
        float lerpy = 0;
        lerpy = lerp(lerpy,y,0.1f);
        fill(255);
        text("frequency" + freq,50,50);
        noFill();
        stroke(255);
        circle(200,y,50);
        circle(500,lerpy,50);
    }

    float map1(float a, float b, float c,float d, float e)
    {
        return (a-b)/(c-b)*(e-d) + d;
    }
}
