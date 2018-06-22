package iprog_20170711;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
    private int curX, curY, oldX, oldY;
    private Graphics2D g2;
    private Image image;
    private final SizedStack<Image> undoStack = new SizedStack<Image>(15);
    private Image background;

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;

    public Canvas() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                undoStack.push(copyImage(image));
                oldX = e.getX();
                oldY = e.getY();            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curX = e.getX();
                curY = e.getY();
                if(g2 != null) {
                    g2.drawLine(oldX, oldY, curX, curY);
                }
                repaint();
                oldX = curX;
                oldY = curY;
            }
        });
    }

    public void undo() {
        if(undoStack.size() > 0) {
            setImage(undoStack.pop());
        }
    }

    private void setImage(Image img) {
        g2 = (Graphics2D) img.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(color);
        image = img;
        repaint();
    }

    public void setBackground(Image img) {
        background = copyImage(img);
        setImage(copyImage(img));
    }

    private BufferedImage copyImage(Image img) {
        BufferedImage copyOfImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        Graphics g = copyOfImage.createGraphics();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        return copyOfImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(color);
        repaint();
    }

    public void red() {
        g2.setPaint(Color.red);
    }

    public void yellow() {
        g2.setPaint(Color.yellow);
    }

    public void green() {
        g2.setPaint(Color.green);
    }
}
