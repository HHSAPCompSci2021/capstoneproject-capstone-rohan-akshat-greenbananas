package greenbananas.screens;

import java.util.ArrayList;
import processing.core.PApplet;
public class MainScreen {

	public static ArrayList<Screen> menu = new ArrayList<>();
	// types:
	/*
	 * Type 0 is level screen
	 * Type 1 is game screen
	 * Type 2 is main screen
	 */

	public void draw(PApplet drawer) {
		drawer.background(255);
		drawer.stroke(0);
		drawer.textSize(12);
		drawer.fill(0);

		drawer.textSize(40);
		drawer.text("LEVEL SELECTION", 80, 38);

		for (int i = 0; i < 2; i++) {
			drawer.fill(255);
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screen(i * 210 + 43, 300, 200, 140));
			drawer.rect(i * 210 + 43, 300, 200, 140);
			int x = i + 3;
			drawer.fill(0);
			drawer.textSize(35);
			drawer.text("LEVEL " + x, i * 210 + 75, 400);

		}
		for (int i = 0; i < 2; i++) {
			drawer.fill(255);
			drawer.rectMode(PApplet.CORNER);
			menu.add(new Screen(i * 210 + 43, 100, 200, 140));

			drawer.rect(i * 210 + 43, 100, 200, 140);
			int x = i + 1;
			drawer.fill(0);
			drawer.textSize(40);
			drawer.text("LEVEL " + x, i * 210 + 75, 200);
		}

	}

	// public void mousePressed(){
	// if()
	// }

}
