package greenbananas.screens;
import java.util.ArrayList;
import processing.core.PApplet;
import greenbananas.screens.Screens;
public class MainScreen {
	

	public static ArrayList<Screens> menu=new ArrayList<>();
	//types:
	/*
	Type 0 is level screen
	Type 1 is game screen
	Type 2 is main screen
	 */
	

	public void draw(PApplet drawer) {
		drawer.background(255);
		drawer.stroke(0);
		drawer.textSize(12);
		drawer.fill(0);
		
		drawer.textSize(40);
		drawer.text("LEVEL SELECTION", 80, 38);
		
		
		for(int i=0; i<2; i++) {
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screens(i*210+43, 300, 200, 140));
			drawer.rect(i*210+43, 300, 200, 140);
			
		}
		for(int i=0; i<2; i++) {
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screens(i*210+43, 100, 200, 140));

			drawer.rect(i*210+43, 100, 200, 140);
		}
		
	}

	// public void mousePressed(){
	// 	if()
	// }

}
