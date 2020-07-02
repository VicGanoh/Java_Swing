package myswingdemo_;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EventObjectWindow{

    public static void main(String[] args) {

        JFrame eventObject = new JFrame();

        JButton button1; //button 1
        JButton button2; //button 2
        JButton button3; //button 3

        JPanel panel = new JPanel(); //panel to hold components

        final int windowHeight = 300; //window height
        final int windowWidth = 150; //window width

        //set the title
        eventObject.setTitle("Event Object Demonstration");

        //set the size of the window
        eventObject.setSize(windowWidth,windowHeight);

        //what the close button does
        eventObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");

        //register an event listener with all three buttons
        button1.addActionListener((ActionEvent e) -> {
            String actionCommand = e.getActionCommand();

            if (actionCommand == "Button 1"){
                JOptionPane.showMessageDialog(null,"You pressed Button 1.");
            }
        });

        button2.addActionListener((ActionEvent e) -> {
            String actionCommand = e.getActionCommand();

            if (actionCommand == "Button 2"){
                JOptionPane.showMessageDialog(null,"You pressed Button 2.");
            }
        });

        button3.addActionListener((ActionEvent e) -> {
            String actionCommand = e.getActionCommand();

            if (actionCommand == "Button 3"){
                JOptionPane.showMessageDialog(null,"You pressed Button 3.");
            }
        });

        //add components to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        //add panel to the window pane
        eventObject.add(panel);

        //display the window
        eventObject.setVisible(true);
    }
}
