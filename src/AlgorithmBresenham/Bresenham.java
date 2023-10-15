package AlgorithmBresenham;

import java.awt.*;

public class Bresenham {
    private final Color c;
    private int x1, x2, y1, y2; // координаты начала и конца

    public Bresenham(int x1, int x2, int y1, int y2, Color c) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.c = c;
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
                g.fillRect(x, y, 1, 1);
            }
        }
    }
    private int sign(int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }
}