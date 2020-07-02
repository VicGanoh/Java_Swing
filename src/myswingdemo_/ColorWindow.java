package myswingdemo_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class demonstrates how to set the background color of a panel and the foreground color of
 * a label
 */
public class ColorWindow extends JFrame {
    public static void main(String[] args) {

        new ColorWindow();
    }

    private JLabel messageLabel; //to display a message
    private JButton redButton; //changes color to red
    private JButton blueButton; //changes color to blue
    private JButton yellowButton; //changes color to yellow
    private JPanel panel; //panel to hold components
    private final int windowHeight = 200; //window height
    private final int windowWidth = 125; //window width


    //constructor
    public ColorWindow(){

        //set title bar test
        setTitle("Colors");

        //set the size of the window
        setSize(windowWidth, windowHeight);

        //specify an action for close button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Create a label
        messageLabel = new JLabel("Click a button to " + "select a color.\n");

        //create three button
        redButton = new JButton("Red");
        blueButton = new JButton("Blue");
        yellowButton = new JButton("Yellow");

        //Register an event listener with all three buttons.
        redButton.addActionListener((ActionEvent e) -> { panel.setBackground(Color.RED);
                messageLabel.setForeground(Color.BLUE);
        });

        blueButton.addActionListener((ActionEvent e) -> {
            panel.setBackground(Color.BLUE);
            messageLabel.setForeground(Color.WHITE);

        });
        yellowButton.addActionListener((ActionEvent e) -> {
            panel.setBackground(Color.YELLOW);
            messageLabel.setForeground(Color.BLACK);
        });

        //create a panel and add all components
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(redButton);
        panel.add(blueButton);
        panel.add(yellowButton);

        //aad panel to the window
        add(panel);

        //make visible
        setVisible(true);
    }
}
