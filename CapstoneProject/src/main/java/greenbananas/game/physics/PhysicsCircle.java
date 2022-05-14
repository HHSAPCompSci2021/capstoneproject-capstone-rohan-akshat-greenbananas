package greenbananas.game.physics;
import akshat.shapes.Circle;
import akshat.shapes.Rectangle;
import processing.core.PApplet;

public class PhysicsCircle extends PhysicsShape {
	private final Circle c;
	
	private int framesSinceLastHitY = 0;
	
	public PhysicsCircle(Circle c) {
		super(c);
		this.c = c;
	}

	@Override
	public Rectangle getEnclosingRectangle() {
		double rectX = c.getX() - c.getRadius();
		double rectY = c.getY() - c.getRadius();
		return new Rectangle(rectX, rectY, c.getRadius() * 2, c.getRadius() * 2);
	}
	
	@Override
	public void act(PApplet surface) {
		Rectangle r = getEnclosingRectangle();
		
		double[] acceleration = getAccelerationVector();
		double ax = acceleration[0];
		double ay = acceleration[1];
		// Accelerate shape
		double[] velocity = getVelocityVector();
		double vx = velocity[0];
		double vy = velocity[1];
		
		vx += ax;
		vy += ay;
		
		// Move shape
		c.setX(c.getX() + vx);
		c.setY(c.getY() + vy);
		
		// Check if shape is colliding with the edge of window
		if(r.getX() < 0) {
			// Over left edge of window
			c.setX(c.getRadius()); // Move shape back into bounds of window
			vx = -vx;
			vx *= PhysicsConstants.K_DAMPING;
		}
		
		if(r.getX() + r.getWidth() > surface.width) {
			// Over right edge of window
			c.setX(surface.width - c.getRadius()); // Move shape back into bounds of window
			vx = -vx;
			vx *= PhysicsConstants.K_DAMPING;
		}
		
		if(r.getY() < 0) {
			// Over top of window
			c.setY(c.getRadius()); // Move shape back in bounds of window
			vy = -vy;
			vy *= PhysicsConstants.K_DAMPING;
		}
		
		
		if(r.getY() + r.getHeight() > surface.height) {
			// At bottom of window
			c.setY(surface.height - c.getRadius()); // Move shape back in bounds of window
			if(framesSinceLastHitY <= 10) {
				vy = 0;
			}
			vy = -vy;
			vy *= PhysicsConstants.K_DAMPING;
			if(vx > 0) {
				vx -= PhysicsConstants.A_FRICTION;
			} else {
				vx += PhysicsConstants.A_FRICTION;
			}
			
			if (Math.abs(vx) <= 0.1) {
				vx = 0;
			}
			
			framesSinceLastHitY = 0;
		}
		
		framesSinceLastHitY++;
		setVelocity(vx, vy);
	}
}
