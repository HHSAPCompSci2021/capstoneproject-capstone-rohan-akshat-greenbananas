package greenbananas.game.physics;

import akshat.shapes.Line;
import akshat.shapes.Rectangle;
import processing.core.PApplet;

public class PhysicsLine extends PhysicsShape {

    private final Line l;

    public PhysicsLine(Line l) {
        super(l);
        this.l = l;
    }

    @Override
    public Rectangle getEnclosingRectangle() {
        return new Rectangle(l.getX(), l.getY(), (l.getX2() - l.getX()), (l.getY2() - l.getY()));
    }

    @Override
    public void act(PApplet surface) {
        return;
    }

    public double getAngle() {
        return Math.atan((l.getY() - l.getY2()) /( l.getX2() - l.getX()));
    }

    public double[] getNormalVelocityVector(double vx, double vy) {
        double velocity = Math.sqrt((vx * vx) + (vy * vy));
        double theta = getAngle();
        double normalX =  -velocity * Math.sin(theta);
        double normalY =  -velocity * Math.cos(theta);
        return new double[] {normalX, normalY};
    }
    
    public boolean intersects(PhysicsShape s) {
    	for(Line l2 : s.getEnclosingLines()) {
    		if(l.intersects(l2)) {
    			return true;
    		}
    	}
    	return false;
    }

    public Line getLine() {
        return l;
    }

    public void checkCollisions(PhysicsShape... shapes) {
        for(PhysicsShape s : shapes) {
            if(intersects(s)) {
                double[] currVelocity = s.getVelocityVector();
                double[] newVelocity = getNormalVelocityVector(currVelocity[0], currVelocity[1]);
                s.setVelocity(newVelocity[0], newVelocity[1]);
            }
        }
    }

    public void setPoint2(double x, double y) {
        l.setPoint2(x, y);
    }
    
}
