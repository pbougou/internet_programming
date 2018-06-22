package iprog20170711_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    Canvas canvas = new Canvas(0, 0, 0, 5);

    public MyFrame() throws HeadlessException {
        super("This is my frame");
        getContentPane().add(canvas, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addCircle = new JButton("AddCircle");
        addCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setLimit(canvas.getLimit() * 2);
            }
        });
        JButton addTime = new JButton("AddTime");
        addTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSleeping_time(canvas.getSleeping_time() * 2);
            }
        });

        panel.add(addCircle);
        panel.add(addTime);

        getContentPane().add(panel, BorderLayout.NORTH);

        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String [] args) {
        new MyFrame();
    }
}
