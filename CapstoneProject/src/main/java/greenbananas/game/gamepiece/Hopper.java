package greenbananas.game.gamepiece;

import java.util.List;

import akshat.shapes.Rectangle;
import greenbananas.game.GameContext;
import processing.core.PApplet;
import java.awt.Color;

public class Hopper {
    private static final double WIDTH = 50;
    private Color color;
    private Rectangle r;

    private GameContext context = GameContext.getInstance();

    public Hopper(double x, double y, Color color) {
        this.color = color;
        r = new Rectangle(x, y, WIDTH, WIDTH, color);
        r.setFillColor(color);
    }

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

    public void draw(PApplet surface) {
        r.draw(surface);
    }
}
