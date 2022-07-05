package greenbananas.game.gamepiece;
import java.awt.Color;

import akshat.shapes.Circle;
import greenbananas.game.physics.PhysicsCircle;
import greenbananas.game.physics.PhysicsShape;
import processing.core.PApplet;

/**
 * Represents a GamePiece.
 */
public class GamePiece {
    private PhysicsCircle c;
    private Color color;

    public GamePiece(double x, double y, double r, Color color) {
        c = new PhysicsCircle(new Circle(x, y, r, color));
        c.getShape().setFillColor(color);
        this.color = color;
    }

    public void draw(PApplet surface) {
        c.draw(surface);
    }

    public boolean act(PApplet surface) {
        c.act(surface);
        Circle circle = (Circle) c.getShape();
        if(Math.abs(circle.getRadius() + circle.getY() - surface.height) <= 0.01) {
            return true;
        }
        return false;
    }

    public PhysicsShape getShape() {
        return c;
    }

    public Color getColor() {
        return color;
    }
}
