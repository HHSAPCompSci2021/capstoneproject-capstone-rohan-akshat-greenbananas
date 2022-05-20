package greenbananas.game.physics;
import processing.core.PApplet;
import akshat.shapes.Shape;

/**
 * Represents a shape with physics
 */
public abstract class PhysicsShape {	
	private double vx = 0, vy = 0;
	private double ax, ay;
	
	public PhysicsShape() {
		ay = PhysicsConstants.A_GRAVITY;
		ax = 0.00;
	}
	
	/**
	 * Draws the shape
	 * @param surface The surface on which to draw the shape
	 */
	public void draw(PApplet surface) {
		// getEnclosingRectangle().draw(surface);
		getShape().draw(surface);
	}
	
	/**
	 * Gets called frequently, and updates to the shape are processed here
	 * @param surface The surface on which the shapes are drawn
	 */
	public abstract void act(PApplet surface);
	
	/**
	 * Returns the magnitute of the velocity vector of the current shape
	 * @return The magnitute of the velocity vector of the current shape
	 */
	public double getVelocityMagnitude() {
		return Math.sqrt((vx * vx) + (vy * vy));
	}
	
	/**
	 * Returns the angle from the horizontal of the shapes current velocity
	 * @return The angle from the horizontal of the shapes current velocity
	 */
	public double getHeadingAngle() {
		if(Math.abs(getVelocityMagnitude()) <= 0.001) {
			return 0;
		}
		double theta = Math.atan(Math.abs(vy / vx));
		
		if(vy < 0) {
			theta +=  (1.5 * Math.PI);
		}
		
		if(vx < 0) {
			theta += (0.5 * Math.PI);
		}
		
		return theta;
	}
	
	/**
	 * Returns the velocity vector of the shape
	 * @return The velocity vector of the shape
	 */
	public double[] getVelocityVector() {
		return new double[] {vx, vy};
	}
	
	/**
	 * Returns the acceleration vector of the shape
	 * @return The acceleration vector of the shape
	 */
	public double[] getAccelerationVector() {
		return new double[] {ax, ay};
	}
	
	/**
	 * Sets the velocity of the shape
	 * @param vx The x component of the velocity
	 * @param vy The y component of the velocity
	 */
	public void setVelocity(double vx, double vy) {
		this.vy = vy;
		this.vx = vx;
	}

	public String toString() {
		return getShape().toString() + "\t" + getShape().getEnclosingRect().toString() + "\n";
	}
	
    /**
	 * Returns the shape the Physics shape represents
	 * @return The shape the Physics shape represents
	 */
	public abstract Shape getShape();
}
