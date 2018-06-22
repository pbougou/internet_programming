package iprog20140614;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    Canvas canvas = new Canvas();
    private String action = "encrypt";

    public MyFrame() throws HeadlessException {
        super("Encryption");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(canvas);
        getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();

        String [] options = { "encrypt", "decrypt" };
        JComboBox box = new JComboBox(options);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String action = (String)cb.getSelectedItem();
                if(action.equals("encrypt")) {
                    canvas.encrypt();
                    action = "encrypt";
                }
                else if(action.equals("decrypt")) {
                    canvas.decrypt();
                    action = "decrypt";
                }
            }
        });
        panel.add(box);
        JTextField n = new JTextField(5);
        n.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '\n') {
                    String input = n.getText();
                    int key = -1;
                    try {
                        key = Integer.parseInt(input);
                    } catch (NumberFormatException exc) {
                        exc.printStackTrace();
                    }
                    if(key > 0) {
                        canvas.setKey(key);
                    }
                }
            }
        });
        panel.add(n);
        JTextField text = new JTextField(20);
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String typed = text.getText();
                canvas.setInput(typed);
                if(action.equals("encrypt")) {
                    canvas.encrypt();
                }
                else canvas.decrypt();
            }
        });
        panel.add(text);
        getContentPane().add(panel, BorderLayout.NORTH);


        pack();
    }
    public static void main(String [] args) {
        new MyFrame();
    }
}
