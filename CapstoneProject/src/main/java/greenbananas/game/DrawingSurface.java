package greenbananas.game;

import greenbananas.game.level.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import processing.event.MouseEvent;

import greenbananas.screens.MainScreen;


/**
 * Represents the DrawingSurface
 */
public class DrawingSurface extends PApplet {
    PImage qrcode = null;

    
    private Level current;
    


    GameContext context;
    Level l1=new Level1();
    Level l2 = new Level2();
    Level l3=new Level3();
    Level l4=new Level4();
    MainScreen m=new MainScreen();
    private ArrayList<Level> screens=new ArrayList<>(Arrays.asList(l1,l2,l3,l4));
    // Blocks [] blocks;

    public DrawingSurface() {
        context = GameContext.getInstance();
        context.setLevel(l1);
        // blocks=new Blocks[Blocks.numOfBlocks];

        //add levels here into screens arraylsit

    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup() {
        stroke(0);
        textSize(12);
        fill(0);

    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKey() == 'r') {
            l1.reset();
        }
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        
        if(context.getQrcode() != null && !context.isConnected()) {
            if(qrcode == null) {
                qrcode = loadImage(context.getQrcode());
            }
            image(qrcode, 0, 0, width, height);

            
        } else {
            background(255);   // Clear the screen with a white background
            m.draw(this);
            if(current!=null){
                current.draw(this);
            }
            
        }
    }

    public void switchScreens(int i){
        current=screens.get(i-1);
        GameContext.getInstance().setLevel(current);
    }

    public void mousePressed(){
        
    }

    public void mousePressed(MouseEvent e) {
        if(current != null) {
            current.mouseClick(e, this);
        } else {
          
        if(mouseX>43&&mouseX<200&&mouseY>100&&mouseY<240){
            switchScreens(1);
            System.out.println("hi");
        }
        else if(mouseX>253&&mouseX<453&&mouseY>100&mouseY<240){
            switchScreens(2);
            System.out.println("hi2");
        }
        else if(mouseX>43&&mouseX<200&&mouseY>300&&mouseY<440){
            switchScreens(3);
            System.out.println("hi3");
        }
        else if(mouseX>253&&mouseX<453&&mouseY>300&&mouseY<440){
            switchScreens(4);
            System.out.println("hi4");
        }
        }
    }

    public void showMenu() {
        current = null;
    }
}









