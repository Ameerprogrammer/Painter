/*
 *CSCI 185 Fall 2020 M01/2
 *Module 8 lab 1: GUI: Paint Program 
 *Ameer Ahmed, Javier Torres, Annie Zheng, Shajid Muntaser
 *Dec 9, 2020
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint {
    JButton clearBtn, eraseBtn, blackBtn, redBtn, blueBtn, greenBtn;
    Draw draw;

    ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == clearBtn) {
                    draw.clear();
                }
                else if(e.getSource() == eraseBtn) {
                    draw.erase();
                }
                else if(e.getSource() == blackBtn) {
                    draw.black();
                } 
                else if(e.getSource() == redBtn) {
                    draw.red();
                } 
                else if(e.getSource() == blueBtn) {
                    draw.blue();
                } 
                else if(e.getSource() == greenBtn) {
                    draw.green();
                } 
            }
        };

    public static void main(String[]args) {
        new Paint().show();
    }

    public void show() {
        JFrame frame = new JFrame("Paint Program");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        draw = new Draw();
        content.add(draw, BorderLayout.CENTER);
        JPanel panel = new JPanel();

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);

        eraseBtn = new JButton("Eraser");
        eraseBtn.addActionListener(actionListener);

        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);

        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionListener);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);

        //add to panel
        panel.add(blackBtn);
        panel.add(redBtn);
        panel.add(blueBtn);
        panel.add(greenBtn);
        panel.add(clearBtn);
        panel.add(eraseBtn);
        //add to content
        content.add(panel, BorderLayout.NORTH);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}