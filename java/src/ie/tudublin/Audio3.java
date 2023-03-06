package ie.tudublin;

import java.util.ArrayList;

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
    ArrayList<Cube> cubes = new ArrayList<>();

    public void settings()
    {
        size(1024, 1024,P3D);
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
    float rot = 0.5f;
    float[] lerpedBuffer;
    public void draw()
    {

        float total = 0;
        for(int i = 0; i < ab.size();i++)
        {
            total += Math.abs(ab.get(i));
        }
        float average = total / (float) ab.size();

        float lerpedAvergae =0;
        lerpedAvergae = lerp(lerpedAvergae, average,0.1f);
        float c = map(lerpedAvergae,0,0.5f,0,255);
        background(0);
        colorMode(HSB);
        lights();
        stroke(c,255,255);
        strokeWeight(5);
        //fill(255);
        noFill();
        translate(width / 2, height / 2);
        rotateY(rot);
        rotateX(rot);
        rot += map(lerpedAvergae,0,1.0f,0,1);

        float boxSize = map(lerpedAvergae,0,0.5f,200,700);
        box(boxSize);


        //println(map(5, 2, 10, 1000, 2000));
        //println(map1(5, 2, 10, 1000, 2000));
    }
    public void keyPressed()
    {
        if (key == ' ')
        {
            if(ap.isPlaying())
            {
                ap.pause();
            }
            else
            {
                ap.play();
            }
        }
    }
}