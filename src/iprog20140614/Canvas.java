package iprog20140614;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JLabel {
    private int key = -1;
    private String input = "", output = "";

    public Canvas() {
        setDoubleBuffered(false);
        setPreferredSize(new Dimension(800, 800));
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void encrypt() {
        this.output = "";
        for(int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                char ch = (char)(((int)input.charAt(i) +
                        key - 65) % 26 + 65);
                output += Character.toString(ch);
            }
            else {
                char ch = (char)(((int)input.charAt(i) +
                        key - 97) % 26 + 97);
                output += Character.toString(ch);
            }
        }
        repaint();
    }

    public void decrypt() {
        this.output = "";
        for(int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                char ch = (char)(((int)input.charAt(i) -
                        key - 65) % 26 + 65);
                output += Character.toString(ch);
            }
            else {
                char ch = (char)(((int)input.charAt(i) -
                        key - 97) % 26 + 97);
                output += Character.toString(ch);
            }
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(output, 200, 200);
    }

}
