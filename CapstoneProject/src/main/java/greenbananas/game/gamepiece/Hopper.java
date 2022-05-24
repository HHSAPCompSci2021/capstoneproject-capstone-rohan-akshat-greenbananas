package greenbananas.game.gamepiece;

import java.util.List;

import akshat.shapes.Rectangle;
import greenbananas.game.GameContext;
import greenbananas.game.level.Level;
import processing.core.PApplet;
import java.awt.Color;

/**
 * Represents a hopper.
 * Game pieces are collected in the same color hopper for points.
 */
public class Hopper {
    private static final double SIZE = 50;
    private Color color;
    private Rectangle r;

    private GameContext context = GameContext.getInstance();

    /**
     * Constructs a new Hopper object
     * @param x The x-coordinate of the hopper
     * @param y The y-cooridnate of the hopper
     * @param color The color of the hopper
     */
    public Hopper(double x, double y, Color color) {
        this.color = color;
        r = new Rectangle(x, y, SIZE, SIZE, color);
        r.setFillColor(color);
    }

    /**
     * Checks if any gamePiece collides with the current Hopper. If it does, and is the same color,
     * the current level's points are incremented else the level is reset. 
     * @param gamePieces The list of GamePieces, as maintained by the {@link Level}
     */
    public void act(List<GamePiece> gamePieces) {
        for(int i = 0; i < gamePieces.size(); i++) {
            GamePiece gamePiece = gamePieces.get(i);
            if(r.intersects(gamePiece.getShape().getShape())) {
                if(gamePiece.getColor().equals(color)) {
                    context.getLevel().incrementPoint();
                } else {
                    context.getLevel().gameOver();
                }
                gamePieces.remove(gamePiece);
                i--;
            }
        }
    }

    /**
     * Draws the hopper
     * @param surface The surface on which to draw the hopper.
     */
    public void draw(PApplet surface) {
        r.draw(surface);
    }
}
