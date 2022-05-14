package greenbananas.game.level;
import akshat.shapes.*;

import greenbananas.game.BalanceBeam;
import greenbananas.game.GameContext;
import greenbananas.game.physics.PhysicsShape;
import processing.core.PApplet;

/**
 * Represents a Level. Each level has a balancing bean, which gets updated values through the GameContext.
 */
public abstract class Level {
    private final BalanceBeam balanceBeam;
    private PhysicsShape gamePieces;
    private final GameContext context;

    /**
     * Constructs a new Level object
     * @param balanceBeam the balance bean
     * @param gamePieces the game peices
     */
    protected Level(BalanceBeam balanceBeam, PhysicsShape gamePieces) {
        this.balanceBeam = balanceBeam;
        this.gamePieces = gamePieces;
        context = GameContext.getInstance();
    }

    /**
     * Draws all the elements of the level
     * @param surface The surface on which to draw upon
     */
    public void draw(PApplet surface) {
        surface.background(255);
        balanceBeam.setAngle(context.getDeviceOrientation());
        balanceBeam.draw(surface);
//        gamePieces.draw(surface);
    }
}
