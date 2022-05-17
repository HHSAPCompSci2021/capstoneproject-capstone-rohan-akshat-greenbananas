package greenbananas.game;

import greenbananas.game.level.SampleLevel;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * Represents the DrawingSurface
 */
public class DrawingSurface extends PApplet {
    PImage qrcode = null;

    GameContext context;
    SampleLevel l = new SampleLevel();
    Blocks [] blocks;

    public DrawingSurface() {
        context = GameContext.getInstance();
        blocks=new Blocks[Blocks.numOfBlocks];
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup() {
        stroke(0);
        textSize(12);
        fill(0);

    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        background(255);   // Clear the screen with a white background
        
        if(context.getQrcode() != null && !context.isConnected()) {
            if(qrcode == null) {
                qrcode = loadImage(context.getQrcode());
            }
            image(qrcode, 0, 0, width, height);
        } else {
            l.draw(this);
        }
    }

}









