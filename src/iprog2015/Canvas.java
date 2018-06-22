package iprog2015;

import iprog2015.Dot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Canvas extends JLabel implements KeyListener {
    private int x, y, rad = 20;

    public ArrayList<Dot> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dot> arr) {
        this.arr = arr;
    }

    private ArrayList<Dot> arr = new ArrayList<Dot>();
    private Random rand = new Random();

    public Canvas() {
        setPreferredSize(new Dimension(500, 500));
        JTextField tf = new JTextField();

        tf.addKeyListener(this);
        this.add(tf, BorderLayout.NORTH);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        for(int i = 0; i < arr.size(); i++) {
            g.fillRect(arr.get(i).getX(), arr.get(i).getY(), 2*arr.get(i).getRad(), 2*arr.get(i).getRad());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void addSquare() {
        Dot cur = new Dot(this.x, this.y, this.rad);
        arr.add(cur);
        new MyThread(this, cur).start();
    }

    public void deleteRecentSquare() {
        if(arr.size() > 0) {
            arr.remove(arr.size() - 1);
        }
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                this.x = rand.nextInt(400) + 1;
                this.y = rand.nextInt(400) + 1;
                addSquare();
                break;
            case KeyEvent.VK_R:
                deleteRecentSquare();
                break;
            default:
                System.out.println(e.getKeyChar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
