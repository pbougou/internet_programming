package iprog2016;

public class MyThread extends Thread {

    public final Canvas canvas;

    public MyThread(Canvas canvas) {
        this.canvas = canvas;
        this.setDaemon(true);

    }

    public void run() {
        while (true) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                e.printStackTrace();
            }
            canvas.current += 1;
            canvas.repaint();
        }
    }
}
