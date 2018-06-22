package iprog20150710;

import java.awt.*;
import java.util.ArrayList;

public class MyThread extends Thread {
    Canvas canvas;
    Dot dot;

    public MyThread(Canvas canvas, Dot dot) {
        this.canvas = canvas;
        this.dot = dot;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Dot> dots = canvas.getArr();
            int i = dots.indexOf(dot);

            int x = dot.getX(), y = dot.getY(), rad = dot.getRad();
            Color color = dot.getColor();

            dots.remove(dot);
            dot = new Dot(x+10, y, rad, color);
            dots.add(i, dot);
            canvas.setArr(dots);
            canvas.repaint();
        }
    }
}
