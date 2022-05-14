package greenbananas.game.physics;

import akshat.shapes.Line;
import akshat.shapes.Rectangle;
import processing.core.PApplet;

public class PhysicsRectangle extends PhysicsShape {
	private final Rectangle r;
	private int framesSinceLastHitY;

	public PhysicsRectangle(Rectangle r) {
		super(r);
		this.r = r;
	}

	@Override
	public Rectangle getEnclosingRectangle() {
		return r;
	}

	@Override
	public void act(PApplet surface) {
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
		r.setX(r.getX() + vx);
		r.setY(r.getY() + vy);
		
		// Check if shape is colliding with the edge of window
		if(r.getX() < 0) {
			// Over left edge of window
			r.setX(0); // Move shape back into bounds of window
			vx = -vx;
			vx *= PhysicsConstants.K_DAMPING;
		}
		
		if(r.getX() + r.getWidth() > surface.width) {
			// Over right edge of window
			r.setX(surface.width - r.getWidth()); // Move shape back into bounds of window
			vx = -vx;
			vx *= PhysicsConstants.K_DAMPING;
		}
		
		if(r.getY() < 0) {
			// Over top of window
			r.setY(r.getHeight()); // Move shape back in bounds of window
			vy = -vy;
			vy *= PhysicsConstants.K_DAMPING;
		}
		
		if(r.getY() + r.getHeight() > surface.height) {
			// At bottom of window
			r.setY(surface.height - r.getHeight()); // Move shape back in bounds of window
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
