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
 * Represents level 1
 */
public class Level1 extends Level {
    public Level1() {
    	 BalanceBeam balanceBeam;
         ArrayList<PhysicsLine> lines = new ArrayList<>();
         ArrayList<GamePiece> gamePieces = new ArrayList<>();
         ArrayList<Generator> generators = new ArrayList<>();
         ArrayList<Hopper> hoppers = new ArrayList<>();
         
         lines.add(new PhysicsLine(new Line(112, 162, 388, 162)));
         balanceBeam = new BalanceBeam(new Point2D.Double(250, 162), lines);
         generators.add(new Generator(230, 20, 120, 5, new Color[] {Color.RED}, ColorMode.SINGLE));
         hoppers.add(new Hopper(16, 306, Color.RED));
         hoppers.add(new Hopper(388, 306, Color.BLUE));
         
         setup(balanceBeam, gamePieces, generators, hoppers);  
    }  
}
