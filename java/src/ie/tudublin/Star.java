package ie.tudublin;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    private boolean hab;
    private String displayName;
    private float distance;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;


    public Star(TableRow tr)
    {
        this(
            //if hab == 1 return true, else return false
 			tr.getInt("Hab?") == 1, 
 			tr.getString("Display Name"), 
 			tr.getFloat("Distance"),
 			tr.getFloat("Xg"),
 			tr.getFloat("Yg"),
 			tr.getFloat("Zg"),
 			tr.getFloat("AbsMag")
 		);
    }

    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag)
    {
        this.hab = hab;
 		this.displayName = displayName;
 		this.distance = distance;
 		this.xG = xG;
 		this.yG = yG;
 		this.zG = zG;
 		this.absMag = absMag;
    }

    public boolean isHab() {
        return hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public float getDistance() {
        return distance;
    }

    public float getxG() {
        return xG;
    }

    public float getyG() {
        return yG;
    }

    public float getzG() {
        return zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public String toString()
    {
        return this.displayName + "\t" + this.hab + "\t" + this.distance + "\t" +
         this.xG + "\t" + this.xG + "\t" + this.yG + "\t" + this.zG + "\t" + this.absMag;
    }
    public void render(PApplet p)
    {
        float border = 50.0f;
        float x = PApplet.map(xG, -5,5,border,p.width);
        float y = PApplet.map(yG, -5,5,border,p.height);

        p.stroke(30,255,255);
        p.line(x,y-5,x,y+5);
        p.line(x-5,y,x+5,y);
        p.stroke(50,255,255);
        p.circle(x, y, absMag);
        p.fill(255);
        p.textAlign(PApplet.LEFT, PApplet.CENTER);
        p.text(displayName,x,y);
        p.noFill();
    }   
}
