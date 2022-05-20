package greenbananas.game.level;

import akshat.shapes.Line;
import greenbananas.game.physics.PhysicsLine;
import greenbananas.game.gamepiece.BalanceBeam;
import greenbananas.game.gamepiece.GamePiece;
import greenbananas.game.gamepiece.Generator;
import greenbananas.game.gamepiece.Hopper;
import greenbananas.game.gamepiece.Generator.ColorMode;
import processing.core.PApplet;
import java.awt.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Represents a sample level
 */
public class Level1 extends Level {

    private BalanceBeam balanceBeam;
    private ArrayList<PhysicsLine> lines = new ArrayList<>();
    private ArrayList<GamePiece> gamePieces = new ArrayList<>();
    private ArrayList<Generator> generators = new ArrayList<>();
    private ArrayList<Hopper> hoppers = new ArrayList<>();

    public Level1() {
        init();
        setup(balanceBeam, gamePieces, generators, hoppers);
    }

    @Override
    public void draw(PApplet surface) {
        super.draw(surface);
    }

    @Override
    public void reset() {
        gamePieces.clear();
        for(Generator generator : generators) {
            generator.reset();
        }
    }

    @Override
    public void init() {
        lines.add(new PhysicsLine(new Line(112, 162, 388, 162)));
        balanceBeam = new BalanceBeam(new Point2D.Double(250, 162), lines);
        generators.add(new Generator(230, 20, 120, 5, new Color[] {Color.RED}, ColorMode.SINGLE));
        hoppers.add(new Hopper(16, 306, Color.RED));
        hoppers.add(new Hopper(388, 306, Color.BLUE));        
    }
}
