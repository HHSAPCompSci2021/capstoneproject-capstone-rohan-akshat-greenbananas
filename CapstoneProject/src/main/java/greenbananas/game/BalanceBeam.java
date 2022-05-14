package greenbananas.game;

import akshat.shapes.Line;
import greenbananas.game.physics.PhysicsLine;
import processing.core.PApplet;

import java.awt.geom.Point2D.Double;
import java.util.List;

public class BalanceBeam {
    private Double center;
    private List<PhysicsLine> lines;
    private double angle;

    public BalanceBeam(Double center, List<PhysicsLine> lines) {
        this.center = center;
        this.lines = lines;
        angle = 0;
    }

    public void setAngle(int angle) {
        this.angle = Math.toRadians(angle * 0.1);
        System.out.println(this.angle);
    }

    private void rotate() {
        for(PhysicsLine pl : lines) {
            Line l = pl.getLine();
            double nx1 = Math.cos(angle) * (l.getX() - center.x) - Math.sin(angle) * (l.getY() - center.y) + center.x;
            double ny1 = Math.sin(angle) * (l.getX() - center.x) + Math.cos(angle) * (l.getY() - center.y) + center.y;
            double nx2 = Math.cos(angle) * (l.getX2() - center.x) - Math.sin(angle) * (l.getY2() - center.y) + center.x;
            double ny2 = Math.sin(angle) * (l.getX2() - center.x) + Math.cos(angle) * (l.getY2() - center.y) + center.y;
            l.setX(nx1);
            l.setY(ny1);
            l.setPoint2(nx2, ny2);
        }
    }

    public void draw(PApplet surface) {
        rotate();
        for(PhysicsLine l : lines) {
            System.out.println(l.getLine());
            l.draw(surface);
        }
    }
}
