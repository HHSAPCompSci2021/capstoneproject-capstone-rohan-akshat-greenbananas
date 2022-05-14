package greenbananas.game.level;

import akshat.shapes.Line;
import greenbananas.game.BalanceBeam;
import greenbananas.game.physics.PhysicsLine;
import processing.core.PApplet;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Represents a sample level
 */
public class SampleLevel extends Level {

    private static ArrayList<PhysicsLine> lines;
    static {
        lines = new ArrayList<>();
        lines.add(new PhysicsLine(new Line(100, 200, 300, 200)));
    }

    public SampleLevel() {
        super(new BalanceBeam(new Point2D.Double(200, 200), lines), null);
    }

    @Override
    public void draw(PApplet surface) {
        super.draw(surface);
    }
}
