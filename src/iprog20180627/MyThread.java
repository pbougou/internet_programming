package iprog20180627;


import iprog20150710.Dot;

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
        while (true) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Dot> arr = canvas.getArr();
            for(int i = 0; i < arr.size(); i++) {
                if(arr.get(i).getColor().equals(Color.red)) {
                    arr.set(i, new Dot(arr.get(i).getX() + 1, arr.get(i).getY(), arr.get(i).getRad(), Color.black));
                }
                else {
                    arr.set(i, new Dot(arr.get(i).getX() + 1, arr.get(i).getY(), arr.get(i).getRad(), Color.red));

                }
            }
            canvas.repaint();
        }

    }
}
