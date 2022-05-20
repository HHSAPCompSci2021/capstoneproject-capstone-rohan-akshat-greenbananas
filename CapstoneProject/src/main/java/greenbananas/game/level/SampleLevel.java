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
public class SampleLevel extends Level {

    private static ArrayList<PhysicsLine> lines;
    private static ArrayList<GamePiece> gamePieces;
    private static ArrayList<Generator> generators;
    private static ArrayList<Hopper> hoppers;
    static {
        lines = new ArrayList<>();
        lines.add(new PhysicsLine(new Line(100, 250, 400, 250)));

        gamePieces = new ArrayList<>();

        generators = new ArrayList<>();
        generators.add(new Generator(150, 20, 120, 10, new Color[] {Color.RED, Color.BLUE}, ColorMode.SEQUENTIAL));
        generators.add(new Generator(300, 20, 120, 10, new Color[] {Color.RED, Color.BLUE}, ColorMode.SEQUENTIAL));

        hoppers = new ArrayList<>();
        hoppers.add(new Hopper(75, 300, Color.RED));
        hoppers.add(new Hopper(425, 300, Color.BLUE));
    }

    public SampleLevel() {
        super(new BalanceBeam(new Point2D.Double(250, 250), lines), gamePieces, generators, hoppers);
    }

    @Override
    public void draw(PApplet surface) {
        super.draw(surface);
    }

    @Override
    public void reset() {
        lines.clear();
        lines.add(new PhysicsLine(new Line(100, 250, 400, 250)));

        gamePieces.clear();

        generators.clear();
        generators.add(new Generator(150, 20, 90, 5, new Color[] {Color.RED, Color.BLUE}, ColorMode.SEQUENTIAL));
        generators.add(new Generator(300, 20, 90, 5, new Color[] {Color.RED, Color.BLUE}, ColorMode.SEQUENTIAL));
    }
}
