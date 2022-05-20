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

    private static ArrayList<PhysicsLine> lines;
    private static ArrayList<GamePiece> gamePieces;
    private static ArrayList<Generator> generators;
    private static ArrayList<Hopper> hoppers;
    static {
        lines = new ArrayList<>();
        lines.add(new PhysicsLine(new Line(112, 162, 388, 162)));

        gamePieces = new ArrayList<>();

        generators = new ArrayList<>();
        generators.add(new Generator(230, 20, 120, 5, new Color[] {Color.RED}, ColorMode.SINGLE));

        hoppers = new ArrayList<>();
        hoppers.add(new Hopper(16, 306, Color.RED));
        hoppers.add(new Hopper(388, 306, Color.BLUE));
    }

    public Level1() {
        super(new BalanceBeam(new Point2D.Double(250, 162), lines), gamePieces, generators, hoppers);
    }

    @Override
    public void draw(PApplet surface) {
        super.draw(surface);
    }

    @Override
    public void reset() {
        gamePieces.clear();

        generators.clear();
        generators.add(new Generator(230, 20, 120, 5, new Color[] {Color.RED}, ColorMode.SINGLE));
    }
}
