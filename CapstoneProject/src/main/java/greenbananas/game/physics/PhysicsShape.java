package greenbananas.game.physics;
import processing.core.PApplet;
import akshat.shapes.Line;
import akshat.shapes.Rectangle;
import akshat.shapes.Shape;

public abstract class PhysicsShape {

	private Shape s;
	
	private double vx = 1, vy = 0;
	private double ax, ay;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		ay = PhysicsConstants.A_GRAVITY;
		ax = 0.00;
	}
	
	public void draw(PApplet surface) {
		// getEnclosingRectangle().draw(surface);
		s.draw(surface);
	}
	
	public abstract Rectangle getEnclosingRectangle();
	
	public abstract void act(PApplet surface);
	
	public double getVelocityMagnitude() {
		return Math.sqrt((vx * vx) + (vy * vy));
	}
	
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
	
	public double[] getVelocityVector() {
		return new double[] {vx, vy};
	}
	
	public double[] getAccelerationVector() {
		return new double[] {ax, ay};
	}
	
	public void setVelocity(double vx, double vy) {
		this.vy = vy;
		this.vx = vx;
	}

	public boolean isPointInside(int mouseX, int mouseY) {
		return s.isPointInside(mouseX, mouseY);
	}
	
	public String toString() {
		return s.toString() + "\t" + getEnclosingRectangle().toString() + "\n";
	}
	
	public Line[] getEnclosingLines() {
		Rectangle r = getEnclosingRectangle();
		return r.getEnclosingLines();
	}
	
}
