package iprog2015;

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
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Dot> arr = canvas.getArr();
            int x = dot.getX(), y = dot.getY(), rad = dot.getRad();

            if(!arr.contains(dot))
                break;

            if(rad == 20) rad = 40;
            else rad = 20;

            int i = arr.indexOf(dot);
            arr.remove(i);
            this.dot = new Dot(x, y, rad);
            arr.add(i, dot);

            canvas.setArr(arr);
            canvas.repaint();
        }
    }
}
