package greenbananas;

import greenbananas.game.DrawingSurface;
import greenbananas.game.GameContext;
import greenbananas.networking.Session;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Session.createSession();
            DrawingSurface drawing = new DrawingSurface();
            PApplet.runSketch(new String[] { "" }, drawing);
            PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
            PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
            JFrame window = (JFrame) canvas.getFrame();
            window.setSize(500, 500);
            window.setMinimumSize(new Dimension(100, 100));
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(true);

            window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("Starting delete session");
                    Session session = GameContext.getInstance().getSession();
                    session.closeSession();
                    do {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    } while (session.hasSessionClosed());
                }
            });

            window.setVisible(true);
            canvas.requestFocus();

        } catch (FileNotFoundException e) {
            System.err.println("Could not read credentials file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
