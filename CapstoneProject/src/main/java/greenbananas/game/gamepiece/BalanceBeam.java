package greenbananas.game.gamepiece;

import akshat.shapes.Line;
import greenbananas.game.physics.PhysicsLine;
import processing.core.PApplet;

import java.awt.geom.Point2D.Double;
import java.util.List;

/**
 * Represents a balancing beam.
 * This is the part that the user controls through the phones rotation
 */
public class BalanceBeam {
    private final Double center;
    private final List<PhysicsLine> lines;

    private double angle;

    /**
     * 
     * @param center The point which the beam should rotate about
     * @param lines The lines that define the balance beam
     */
    public BalanceBeam(Double center, List<PhysicsLine> lines) {
        this.center = center;
        this.lines = lines;
        angle = 0;
    }

    /**
     * Sets the angle the beam should rotate
     * @param angle The angle, in DEGREES
     */
    public void setAngle(int angle) {
        this.angle = Math.toRadians(angle * 0.1);
    }

    private void rotate() {
        for(PhysicsLine pl : lines) {
            Line l = (Line) pl.getShape();
            double nx1 = Math.cos(angle) * (l.getX() - center.x) - Math.sin(angle) * (l.getY() - center.y) + center.x;
            double ny1 = Math.sin(angle) * (l.getX() - center.x) + Math.cos(angle) * (l.getY() - center.y) + center.y;
            double nx2 = Math.cos(angle) * (l.getX2() - center.x) - Math.sin(angle) * (l.getY2() - center.y) + center.x;
            double ny2 = Math.sin(angle) * (l.getX2() - center.x) + Math.cos(angle) * (l.getY2() - center.y) + center.y;
            l.setX(nx1);
            l.setY(ny1);
            l.setPoint2(nx2, ny2);
        }
    }

    /**
     * Draws the balance beam
     * @param surface The surface to draw the beam on
     */
    public void draw(PApplet surface) {
        rotate();
        surface.fill(0);
        surface.stroke(0);
        surface.ellipse((float) center.x, (float) center.y, 3, 3);
        for(PhysicsLine l : lines) {
            l.draw(surface);
        }
    }

    /**
     * Checks of the given gamePieces collide with the lines of the BalanceBeam.
     * If a gamePiece collides with the BalanceBeam, the relevant physics are applied
     * @param gamePieces The list of GamePieces, as maintained by the current {@link greenbananas.game.level.Level}
     */
    public void checkCollisions(List<GamePiece> gamePieces) {
        for(PhysicsLine l : lines) {
            for(GamePiece gamePiece : gamePieces) {
                l.checkCollisions(gamePiece.getShape());
            }
        }
    }
}
