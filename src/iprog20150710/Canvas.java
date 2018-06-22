package iprog20150710;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JLabel implements MouseListener {
    private Color color = Color.yellow;
    private int rad, x, y;
    private ArrayList<Dot> arr = new ArrayList<>();

    public ArrayList<Dot> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dot> arr) {
        this.arr = arr;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public Canvas() {
        setDoubleBuffered(false);
        this.setPreferredSize(new Dimension(600, 600));
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < arr.size(); i++) {
            g.setColor(arr.get(i).getColor());
            g.drawOval(arr.get(i).getX(), arr.get(i).getY(), 2*arr.get(i).getRad(), 2*arr.get(i).getRad());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        Dot dot = new Dot(x, y, rad, color);
        arr.add(dot);
        new MyThread(this, dot).start();
        repaint();
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
