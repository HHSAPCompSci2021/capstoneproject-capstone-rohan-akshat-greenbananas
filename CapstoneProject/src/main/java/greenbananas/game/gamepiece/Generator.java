package greenbananas.game.gamepiece;
import java.util.List;

import akshat.shapes.Rectangle;
import processing.core.PApplet;
import java.awt.Color;
import java.awt.geom.Point2D.Double;

/**
 * Represents a Generator. Generators generate game pieces at a given interval.
 * The color and order of the generated game pieces can be modified along with the
 * interval and the total amount of generated game pieces.
 */
public class Generator {
    private static final double SIZE = 20;

    private final int framesPerGenerate;
    private final Rectangle rectangle;
    private final int maxGenerations;
    private final Color[] colors;
    private final ColorMode colorMode;

    private int currentFrame;
    private int generatedCount;

    /**
     * Creates a new Generator Object
     * @param x The X-coordinate of the generator
     * @param y The Y-coordinate of the generator
     * @param framesPerGenerate The amount of frames that pass between generations
     * @param maxGenerations The total amount of GamePieces the generator should produce
     * @param colors The colors of the generated GamePieces
     * @param colorMode How colors of generated game pieces are determined
     */
    public Generator(double x, double y, int framesPerGenerate, int maxGenerations, Color[] colors, ColorMode colorMode) {
        this.framesPerGenerate = framesPerGenerate;
        this.maxGenerations = maxGenerations;
        this.colorMode = colorMode;
        this.colors = colors;
        currentFrame = 0;
        generatedCount = 0;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    /**
     * Generates a new {@link GamePiece} if the conditions are right
     * @param gamePieces The list of GamePieces maintained by a {@link greenbananas.game.level.Level}
     * @post A new GamePiece may be added to the {@code gamePieces} list
     */
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
        int selectedIndex;
        switch(colorMode) {
            case RANDOM:
                selectedIndex = (int) (Math.random() * colors.length);
                break;
            case SEQUENTIAL:
                selectedIndex = generatedCount % colors.length;
                break;
            default:
                selectedIndex = 0;
                break;
        }
        Double center = rectangle.getCenter();
        gamePieces.add(new GamePiece(center.x, center.y, 20, colors[selectedIndex]));
    }

    /**
     * Draws the Generator on the given surface
     * @param surface The surface on which to draw the Generator
     */
    public void draw(PApplet surface) {
        rectangle.draw(surface);
        Double center = rectangle.getCenter();
        surface.text('G', (float) center.x, (float) center.y);
    }

    /**
     * Resets the generator
     */
    public void reset() {
        generatedCount = 0;
        currentFrame = 0;
    }

    /**
     * The various ways colors of generated {@link GamePiece GamePieces} are determined
     */
    public enum ColorMode {
        /**
         * The generator will randomly pick a color from the Color array
         */
        RANDOM,
        /**
         * The generator will go through the Color array in sequential order,
         * looping back after reaching the end
         */
        SEQUENTIAL,
        /**
         * The generator will pick the first color of the Color array
         */
        SINGLE
    }
}
