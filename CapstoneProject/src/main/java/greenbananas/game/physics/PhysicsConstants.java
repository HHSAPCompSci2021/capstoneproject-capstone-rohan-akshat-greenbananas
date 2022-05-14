package greenbananas.game.physics;

/**
 * Constants to base physics around
 */
public class PhysicsConstants {
	/**
	 * Downward accerlation due to gravity
	 */
	public static final double A_GRAVITY = 0.35;
	
	/**
	 * The accleration due to friction when on the ground
	 */
	 public static final double A_FRICTION = 0.1;
	
	 /**
	 * The percent the velocity should be reduced upon collisions
	 */
	public static final double K_DAMPING = 0.6;
}
