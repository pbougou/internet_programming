package iprog20170711_1;

import java.awt.*;

public class MyThread extends Thread {
    public final Canvas canvas;
    public int x, y, rad = 5, sleeping_time;

    public MyThread(Canvas canvas, int x, int y, int rad, int sleeping_time) {
        this.canvas = canvas;
        this.setDaemon(true);
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.sleeping_time = sleeping_time;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(sleeping_time);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                e.printStackTrace();
            }

            this.rad = canvas.aux(x,y,rad);
            if(rad == -1) {
                canvas.setCircles(canvas.getCircles() - 1);
                break;
            }
        }
    }
}
