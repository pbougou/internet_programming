package iprog20170711_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas extends JLabel implements MouseListener {

    private int circles, limit = 5, max_rad = 40, sleeping_time = 2000;
    private int x, y, rad;

    public int getSleeping_time() {
        return sleeping_time;
    }

    public void setSleeping_time(int sleeping_time) {
        this.sleeping_time = sleeping_time;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMax_rad() {
        return max_rad;
    }

    public void setMax_rad(int max_rad) {
        this.max_rad = max_rad;
    }

    public int getCircles() {
        return circles;
    }

    public void setCircles(int circles) {
        this.circles = circles;
    }


    public Graphics2D getG2() {
        return g2;
    }

    public void setG2(Graphics2D g2) {
        this.g2 = g2;
    }

    private Graphics2D g2;
    private Image image;

    public Canvas(int circles, int x, int y, int rad) {
        setDoubleBuffered(false);
        this.circles = circles;
        this.x = x;
        this.y = y;
        this.rad = rad;
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        if(image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.drawImage(image, 0, 0, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.circles < limit) {
            x = e.getX();
            y = e.getY();

            g2.setColor(Color.black);
            g2.drawOval(x - rad, y - rad, 2 * rad, 2 * rad);
            repaint();

            circles ++;
            new MyThread(this, x, y, rad, sleeping_time).start();
        }
    }

    public int aux(int x, int y, int rad) {
        if(rad < max_rad) {
            g2.setColor(Color.white);
            g2.drawOval(x - rad, y - rad, 2 * rad, 2 * rad);
            repaint();
            g2.setColor(Color.black);
            rad = 2 * rad;
            g2.drawOval(x - rad, y - rad, 2 * rad, 2 * rad);
            repaint();
        }
        else if(rad == max_rad) {
            g2.setColor(Color.red);
            g2.drawOval(x - rad, y - rad, 2 * rad, 2 * rad);
            rad = 2*rad;
            repaint();
        }
        else {
            g2.setColor(Color.white);
            g2.drawOval(x - max_rad, y - max_rad, 2 * max_rad, 2 * max_rad);
            repaint();
            return -1;
        }
        return rad;
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
