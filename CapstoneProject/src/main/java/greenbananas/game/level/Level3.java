package greenbananas.game.level;

import akshat.shapes.Line;
import greenbananas.game.physics.PhysicsLine;
import greenbananas.game.gamepiece.BalanceBeam;
import greenbananas.game.gamepiece.GamePiece;
import greenbananas.game.gamepiece.Generator;
import greenbananas.game.gamepiece.Hopper;
import greenbananas.game.gamepiece.Generator.ColorMode;
import java.awt.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Represents a level 3
 */
public class Level3 extends Level {

    public Level3() {
    	BalanceBeam balanceBeam;
	    ArrayList<PhysicsLine> lines = new ArrayList<>();
	    ArrayList<GamePiece> gamePieces = new ArrayList<>();
	    ArrayList<Generator> generators = new ArrayList<>();
	    ArrayList<Hopper> hoppers = new ArrayList<>();
	    
        lines.add(new PhysicsLine(new Line(135, 198, 410, 198)));
        // lines.add(new PhysicsLine(new Line(410, 36, 410, 198)));
        balanceBeam = new BalanceBeam(new Point2D.Double(410, 198), lines);
        generators.add(new Generator(230, 20, 120, 10, new Color[] {Color.RED, Color.BLUE}, ColorMode.SEQUENTIAL));
        hoppers.add(new Hopper(93, 179, Color.BLUE));
        hoppers.add(new Hopper(93, 279, Color.RED));
        setup(balanceBeam, gamePieces, generators, hoppers);
    }
}
