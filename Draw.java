/*
 *CSCI 185 Fall 2020 M01/2
 *Module 8 lab 1: GUI: Paint Program 
 *Ameer Ahmed, Javier Torres, Annie Zheng, Shajid Muntaser
 *Dec 9, 2020
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;

public class Draw extends JComponent{
    //image to be drawn
    private Image image;
    //used to draw on
    private Graphics2D g2;
    //mouse coordinates
    private int currentX, currentY, oldX, oldY;

    public Draw() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    //coord when mouse is pressed
                    oldX = e.getX();
                    oldY = e.getY();
                }
            });

        addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    //coord when mouse is dragged
                    currentX = e.getX();
                    currentY = e.getY();

                    if(g2 != null) {
                        //draw line if g2's not nulled
                        g2.drawLine(oldX,oldY,currentX,currentY);
                        //refresh drawn area
                        repaint();
                        //store coord
                        oldX = currentX;
                        oldY = currentY;
                    }
                }
            });
    }

    public void paintComponent(Graphics g) {
        if(image == null) {
            //created image
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            //antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        //fill white in drawing area for clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void erase() {
        //basically white paint as eraser
        g2.setPaint(Color.white);
    }
    //colors
    public void red () {
        g2.setPaint(Color.red);
    }

    public void black () {
        g2.setPaint(Color.black);
    }

    public void blue () {
        g2.setPaint(Color.blue);
    }

    public void green () {
        g2.setPaint(Color.green);
    }
}