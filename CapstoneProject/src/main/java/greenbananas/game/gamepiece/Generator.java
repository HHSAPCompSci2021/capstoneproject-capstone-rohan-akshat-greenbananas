package greenbananas.game.gamepiece;
import java.util.List;

import akshat.shapes.Rectangle;
import javafx.geometry.Point2D;
import processing.core.PApplet;
import java.awt.Color;
import java.awt.geom.Point2D.Double;

public class Generator {
    private static final double GENERATOR_WIDTH = 20;
    private int framesPerGenerate;
    private int currentFrame;
    private Rectangle rectangle;
    private int generatedCount;
    private int maxGenerations;

    private Color[] colors;
    private ColorMode colorMode;

    public Generator(double x, double y, int framesPerGenerate, int maxGenerations, Color[] colors, ColorMode colorMode) {
        this.framesPerGenerate = framesPerGenerate;
        this.maxGenerations = maxGenerations;
        this.colorMode = colorMode;
        this.colors = colors;
        currentFrame = 0;
        generatedCount = 0;
        rectangle = new Rectangle(x, y, GENERATOR_WIDTH, GENERATOR_WIDTH);
    }

    public void act(List<GamePiece> gamePieces) {
        if(generatedCount < maxGenerations) {
            if(++currentFrame == framesPerGenerate) {
                generate(gamePieces);
                currentFrame = 0;
                generatedCount++;
            }   
        }
    }

    private void generate(List<GamePiece> gamePieces) {
        int selectedIndex = -1;
        switch(colorMode) {
            case RANDOM:
                selectedIndex = (int) (Math.random() * colors.length);
                break;
            case SEQUENTIAL:
                selectedIndex = generatedCount % colors.length;
                break;
            case SINGLE:
                selectedIndex = 0;
                break;
        }
        Double center = rectangle.getCenter();
        gamePieces.add(new GamePiece(center.x, center.y, 20, colors[selectedIndex]));
    }

    public void draw(PApplet surface) {
        rectangle.draw(surface);
        Double center = rectangle.getCenter();
        surface.text('G', (float) center.x, (float) center.y);
    }

    public enum ColorMode {
        RANDOM,
        SEQUENTIAL,
        SINGLE
    }
}
