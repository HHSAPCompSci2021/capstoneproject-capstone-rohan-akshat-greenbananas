package greenbananas.screens;
import java.util.ArrayList;
import processing.core.PApplet;
import greenbananas.screens.Screens;
public class MainScreen extends PApplet {
	

	private ArrayList<Screens> menu=new ArrayList<>();

	public void setup() {
		stroke(0);
		textSize(12);
		fill(0);
	}
	//types:
	/*
	Type 0 is level screen
	Type 1 is game screen
	Type 2 is main screen
	 */
	

	public void draw(PApplet drawer) {
		background(255);
		
		for(int i=0; i<4; i++) {
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screens(0,1,i*30,20));
			drawer.rect(i*30, 20, 20, 20);
		}
		for(int i=0; i<4; i++) {
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screens(0,1,i*30,50));

			drawer.rect(i*30, 50, 20, 20);
		}
		
	}

	// public void mousePressed(){
	// 	if()
	// }

}
