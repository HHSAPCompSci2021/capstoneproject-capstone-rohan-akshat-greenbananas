package greenbananas.game.physics;

import akshat.shapes.Line;
import akshat.shapes.Shape;
import processing.core.PApplet;

/**
 * Represents a line with physics
 */
public class PhysicsLine extends PhysicsShape {

    private final Line l;

    /**
	 * Constructs a new PhysicsLine based on the given line
	 * @param l The line
	 */
    public PhysicsLine(Line l) {
        this.l = l;
    }

    @Override
    public void act(PApplet surface) {
        return;
    }

    /**
     * Calculates the angle the line makes with the horizontal
     * @return The angle the line makes with the horizontal
     */
    public double getAngle() {
        return Math.atan((l.getY() - l.getY2()) /( l.getX2() - l.getX()));
    }

    /**
     * Calculates the resultant velocity vector of an object colliding with the line
     * @param vx The x component of the initial velocity of the object
     * @param vy The y component of the initial velocity of the object
     * @return An array, in [x,y] order, of the resulting velocity of a collision
     */
    public double[] getNormalVelocityVector(double vx, double vy) {
        double velocity = Math.sqrt((vx * vx) + (vy * vy)) * PhysicsConstants.K_DAMPING;
        double theta = getAngle();
        double normalX =  -velocity * Math.sin(theta);
        double normalY =  -velocity * Math.cos(theta);
        return new double[] {normalX, normalY};
    }
    
    /**
     * Checks if given shapes collide with the line, and apply collision physics if they do
     * @param shapes The shapes
     */
    public void checkCollisions(PhysicsShape... shapes) {
        for(PhysicsShape s : shapes) {
            // if(l.intersects(s.getShape())) {
                // double[] currVelocity = s.getVelocityVector();
                // double[] newVelocity = getNormalVelocityVector(currVelocity[0], currVelocity[1]);
                // s.setVelocity(newVelocity[0], newVelocity[1]);
            // }
            for(Line line : s.getShape().getEnclosingLines()) {
                if(l.intersects(line)) {
                    // s.getShape().setY(line.getIntersectionY(l) - 25);
                    double[] currVelocity = s.getVelocityVector();
                    double[] newVelocity = getNormalVelocityVector(currVelocity[0], currVelocity[1]);
                    s.setVelocity(newVelocity[0], newVelocity[1]);
                    break;
                }
            }
        }
    }

    @Override
    public Shape getShape() {
        return l;
    }
}
