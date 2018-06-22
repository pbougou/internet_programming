package iprog2016;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseMotionListener {
    private int x, y, rad = 5;
    private ArrayList<Dot> arr = new ArrayList<Dot>();
    public static int current = -1;
    private boolean fromMouse = false;

    public Canvas() {
        setPreferredSize(new Dimension(500, 500));
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);

        if(current >= arr.size()) {
            current = arr.size() - 1;
        }
        if(fromMouse) {
            Dot cur = new Dot(this.x, this.y);
            if (current == -1) {
                new MyThread(this).start();
                current = 0;
            }

            arr.add(cur);
            for (int i = 0; i < arr.size(); i++) {
                if (current == i) {
                    g.fillOval(arr.get(i).getX(), arr.get(i).getY(), 4 * rad, 4 * rad);
                } else {
                    g.fillOval(arr.get(i).getX(), arr.get(i).getY(), 2 * rad, 2 * rad);
                }
            }
            fromMouse = false;
        }
        else {
            for (int i = 0; i < arr.size(); i++) {
                if (current == i) {
                    g.fillOval(arr.get(i).getX(), arr.get(i).getY(), 4 * rad, 4 * rad);
                } else {
                    g.fillOval(arr.get(i).getX(), arr.get(i).getY(), 2 * rad, 2 * rad);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.x = (int) e.getX();
        this.y = (int) e.getY();
        this.fromMouse = true;
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
