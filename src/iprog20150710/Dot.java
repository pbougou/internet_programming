package iprog20150710;

import java.awt.*;

public class Dot {
    private int x, y, rad;
    private Color color;

    public Dot(int x, int y, int rad, Color color) {
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.color = color;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
