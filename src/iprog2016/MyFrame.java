package iprog2016;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    Canvas canvas = new Canvas();

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    public MyFrame() throws HeadlessException {
        super("Thema 2 - Eksetasi");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(canvas);
        getContentPane().setBackground(Color.WHITE);


        pack();


    }

}