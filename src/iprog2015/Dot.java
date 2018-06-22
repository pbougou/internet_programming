package iprog2015;

public class Dot {
    private int x;
    private int y;

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    private int rad;

    public Dot(int x, int y, int rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
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
}
