package AlgorithmBresenham;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {
    private Bresenham b;

    public DrawPanel() {
        b = new Bresenham(50, 200, 50, 200, Color.RED);


    }

    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;

        b.draw(g);
    }
}
