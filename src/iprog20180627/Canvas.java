package iprog20180627;

import iprog20150710.Dot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JLabel implements MouseListener, KeyListener {
    private int rad = 20, x = -1 ,y = -1;
    private ArrayList<Dot> arr = new ArrayList<>();
    public ArrayList<Dot> getArr() {
        return arr;
    }

    public Canvas() {
        setDoubleBuffered(false);
        this.setPreferredSize(new Dimension(600, 600));
        this.addMouseListener(this);

        JTextField tf = new JTextField();
        tf.addKeyListener(this);
        this.add(tf);
    }

    @Override
    public void paint(Graphics g) {
        if(x > 0 && y > 0) {
            for(int i = 0; i < arr.size(); i++) {
                g.setColor(arr.get(i).getColor());
                g.fillOval(arr.get(i).getX() , arr.get(i).getY(), 2 * arr.get(i).getRad(), 2 * arr.get(i).getRad());

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();

        Dot cur = new Dot(x, y, this.rad, Color.black);
        arr.add(cur);
        new MyThread(this, cur).start();
//        repaint();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(int i = 0; i < arr.size(); i++) {
            int xx = arr.get(i).getX();
            int yy = arr.get(i).getY();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1: {
                    this.rad = 10;
                    arr.set(i, new Dot(xx, yy, 10, Color.black));
                    break;
                }
                case KeyEvent.VK_2: {
                    this.rad = 20;
                    arr.set(i, new Dot(xx, yy, 20, Color.black));
                    break;
                }
                case KeyEvent.VK_3: {
                    this.rad = 30;
                    arr.set(i, new Dot(xx, yy, 30, Color.black));
                    break;
                }
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
