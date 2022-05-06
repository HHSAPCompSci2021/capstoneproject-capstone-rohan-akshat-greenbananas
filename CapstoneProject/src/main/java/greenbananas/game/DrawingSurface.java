package greenbananas.game;

import processing.core.PApplet;
import processing.core.PImage;


/**
 * Represents the DrawingSurface
 */
public class DrawingSurface extends PApplet {
    PImage qrcode = null;

    GameContext context;

    public DrawingSurface() {
        context = GameContext.getInstance();
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
            text(context.getDeviceOrientation() + "",0,15);
        }
    }

}









