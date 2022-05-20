package greenbananas.game.level;
import java.util.List;

import greenbananas.game.GameContext;
import greenbananas.game.gamepiece.BalanceBeam;
import greenbananas.game.gamepiece.GamePiece;
import greenbananas.game.gamepiece.Generator;
import greenbananas.game.gamepiece.Hopper;
import processing.core.PApplet;

/**
 * Represents a Level. Each level has a balancing bean, which gets updated values through the GameContext.
 */
public abstract class Level {
    private final BalanceBeam balanceBeam;
    private final List<GamePiece> gamePieces;
    private final List<Generator> generators;
    private final List<Hopper> hoppers;
    private final GameContext context;

    /**
     * Constructs a new Level object
     * @param balanceBeam the balance bean
     * @param gamePieces the game peices
     */
    protected Level(BalanceBeam balanceBeam, List<GamePiece> gamePieces, List<Generator> generators, List<Hopper> hoppers) {
        this.balanceBeam = balanceBeam;
        this.gamePieces = gamePieces;
        this.generators = generators;
        this.hoppers = hoppers;
        context = GameContext.getInstance();
    }

    /**
     * Draws all the elements of the level
     * @param surface The surface on which to draw upon
     */
    public void draw(PApplet surface) {
        surface.background(255);
        balanceBeam.setAngle(context.getDeviceOrientation());
        balanceBeam.checkCollisions(gamePieces);
        balanceBeam.draw(surface);
        // for(GamePiece gamePiece : gamePieces) {
        //     gamePiece.act(surface);
        //     gamePiece.draw(surface);
        // }
        for(int i = 0; i < gamePieces.size(); i++) {
            GamePiece gamePiece = gamePieces.get(i);
            if(gamePiece.act(surface)) {
                gamePieces.remove(i--);
                gameOver();
            } else {
                gamePiece.draw(surface);
            }
        }
        for(Generator generator : generators) {
            generator.act(gamePieces);
            generator.draw(surface);
        }
        for(Hopper hopper : hoppers) {
            hopper.act(gamePieces);
            hopper.draw(surface);
        }
    }

    public abstract void reset();

    public List<GamePiece> getGamePieces() {
        return gamePieces;
    }

    public void incrementPoint() {
        System.out.println("increment points");
    }

    public void gameOver() {
        System.out.println("game over");
        reset();
    }
}
