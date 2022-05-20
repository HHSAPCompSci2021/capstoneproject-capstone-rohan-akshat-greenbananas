tmr package greenbananas.screens;

import processing.core.PApplet;

public class MainScreen extends PApplet {
	public void setup() {
		stroke(0);
		textSize(12);
		fill(0);
	}
	
	public void draw(PApplet drawer) {
		background(255);
		
		for(int i=0; i<4; i++) {
			drawer.rectMode(PApplet.CORNER);
			drawer.rect(i*30, 20, 20, 20);
		}
		for(int i=0; i<4; i++) {
			drawer.rectMode(PApplet.CORNER);
			drawer.rect(i*30, 50, 20, 20);
		}
		
	}

}
