package iprog_20170711;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    Canvas canvas = new Canvas();
    MyThread timer = new MyThread(canvas);

    public MyFrame() throws HeadlessException {
        super("This is my frame");

        getContentPane().add(canvas, BorderLayout.CENTER);

        JPanel panel = new JPanel();

        String [] options = { "Επιλέξτε χρώμα...", "Κόκκινο", "Κίτρινο", "Πράσινο" };

        JComboBox box = new JComboBox(options);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String color = (String)cb.getSelectedItem();
                if(color.equals("Κόκκινο")) {
                    canvas.red();
                    canvas.setColor(Color.red);
                }
                else if(color.equals("Κίτρινο")) {
                    canvas.yellow();
                    canvas.setColor(Color.yellow);
                }
                else if(color.equals("Πράσινο")) {
                    canvas.green();
                    canvas.setColor(Color.green);
                }
                else if(color.equals("Διαλέξτε χρώμα...")) {
                    canvas.red();
                    canvas.setColor(Color.red);
                }
                else {
                    System.out.println("Μη αναμενόμενο σφάλμα!");
                }
            }
        });

        panel.add(box);

        JButton undo = new JButton("Undo");

        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.undo();

            }
        });
        panel.add(undo);

        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.clear();
            }
        });

        panel.add(reset);
        getContentPane().add(panel, BorderLayout.NORTH);
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        timer.start();


    }

    public static void main(String [] args) {
        new MyFrame();
    }

}
