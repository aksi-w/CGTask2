package AlgorithmBresenham;

import java.awt.*;

public class Bresenham {
    private int x1, x2, y1, y2; // координаты начала и конца
    private Color sC,eC;


    public Bresenham(int x1, int x2, int y1, int y2, Color sC, Color eC) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.sC = sC;
        this.eC = eC;
    }

    public void draw(Graphics2D g) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int ddx = sign(x2 - x1);
        int ddy = sign(y2 - y1);

        int x = x1;
        int y = y1;

        g.fillRect(x, y, 1, 1); // Начальная точка

        if (dx > dy) {
            int e = dx / 2;

            while (x != x2) {
                x += ddx;
                e -= dy;
                if (e < 0) {
                    y += ddy;
                    e += dx;
                }
                float t = (float) (x - x1) / (x2 - x1);
                Color currentColor = interpolateColor(sC, eC, t);
                g.setColor(currentColor);
                g.fillRect(x, y, 1, 1);
            }
        } else {
            int e = dy / 2;

            while (y != y2) {
                y += ddy;
                e -= dx;
                if (e < 0) {
                    x += ddx;
                    e += dy;
                }
                float t = (float) (y - y1) / (y2 - y1);
                Color currentColor = interpolateColor(sC, eC, t);
                g.setColor(currentColor);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
    private int sign(int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }
    private Color interpolateColor(Color start, Color end, float t) {
        int red = (int) (start.getRed() + t * (end.getRed() - start.getRed()));
        int green = (int) (start.getGreen() + t * (end.getGreen() - start.getGreen()));
        int blue = (int) (start.getBlue() + t * (end.getBlue() - start.getBlue()));
        return new Color(red, green, blue);
    }
}