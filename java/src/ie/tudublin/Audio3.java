package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio3 extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    float lerpedY = 0;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }

    public void setup()
    {
        
        m = new Minim(this);
        // ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix;
        lerpedBuffer = new float[width];

        ap = m.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;

        fft = new FFT(width, 44100);
    }

    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        
        



        //println(map(5, 2, 10, 1000, 2000));
        //println(map1(5, 2, 10, 1000, 2000));
    }
}