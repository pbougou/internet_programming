package iprog_20170711;

public class MyThread extends Thread{
    public final Canvas canvas;

    public MyThread(Canvas canvas) {
        this.canvas = canvas;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
            canvas.clear();
        }
    }
}
