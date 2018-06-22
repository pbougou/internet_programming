package iprog20150710;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    Canvas canvas = new Canvas();

    public MyFrame() throws HeadlessException {
        super("Thema 2 - Eksetasi");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(canvas);
        getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        String [] options = {"Κίτρινο", "Μπλε" };
        JComboBox box = new JComboBox(options);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String color = (String)cb.getSelectedItem();
                if(color.equals("Κίτρινο")) {
                    canvas.setColor(Color.yellow);
                }
                else if(color.equals("Μπλε")) {
                    canvas.setColor(Color.blue);
                }
                else System.out.println("Unexpected option in combo box");
            }
        });
        panel.add(box);
        JTextField tf = new JTextField(20);
        panel.add(tf);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf_content = tf.getText();
                int rad = -1;
                try {
                    rad = Integer.parseInt(tf_content);
                } catch (NumberFormatException exc) {
                    System.out.println("String is not in integer format");
                    exc.printStackTrace();
                }
                canvas.setRad(rad);
            }
        });

        panel.add(ok);

        getContentPane().add(panel, BorderLayout.NORTH);
        pack();
    }

    public static void main(String [] args) {
        new MyFrame();
    }

}
