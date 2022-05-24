package greenbananas.game.level;
import greenbananas.game.DrawingSurface;

import java.util.List;

import greenbananas.game.GameContext;
import greenbananas.game.gamepiece.BalanceBeam;
import greenbananas.game.gamepiece.GamePiece;
import greenbananas.game.gamepiece.Generator;
import greenbananas.game.gamepiece.Hopper;
import processing.core.PApplet;
import akshat.shapes.Rectangle;
import processing.event.MouseEvent;

/**
 * Represents a Level. Each level has a balancing bean, which gets updated values through the GameContext.
 */
public abstract class Level {
    private BalanceBeam balanceBeam;
    private List<GamePiece> gamePieces;
    private List<Generator> generators;
    private List<Hopper> hoppers;
    private final GameContext context;

    private Rectangle levelSelectBtn;

    /**
     * Constructs a new Level object
     */
    protected Level() {
        context = GameContext.getInstance();
        levelSelectBtn = new Rectangle(10, 10,87, 25);
    }

    /**
     * Sets up the level with the apporopirate game elements
     * @param balanceBeam The balance beam
     * @param gamePieces The list of gamepieces
     * @param generators The list of generators
     * @param hoppers The list of hoppers
     */
    protected void setup(BalanceBeam balanceBeam, List<GamePiece> gamePieces, List<Generator> generators, List<Hopper> hoppers) {
        this.balanceBeam = balanceBeam;
        this.gamePieces = gamePieces;
        this.generators = generators;
        this.hoppers = hoppers;
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
        levelSelectBtn.draw(surface);
        surface.fill(0);
        surface.textSize(10);
        
       
        surface.text("BACK TO MENU", 15,20);
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

    /**
     * Resets the level
     */
    public void reset() {
    	gamePieces.clear();
        for(Generator generator : generators) {
            generator.reset();
        }
    }

    /**
     * Returns the current levels gamepieces
     * @return The current levels gamepieces
     */
    public List<GamePiece> getGamePieces() {
        return gamePieces;
    }

    /**
     * Increments this level's points
     */
    public void incrementPoint() {
        System.out.println("increment points");
    }

    /**
     * Ends the current level and resets the game
     */
    public void gameOver() {
        
        reset();
    }

    public void mouseClick(MouseEvent e, DrawingSurface surface) {
        if(levelSelectBtn.isPointInside(e.getX(), e.getY())) {
            reset();
            surface.showMenu();
          
        }
    }
}
