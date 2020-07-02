package myswingdemo_;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutWindow extends JFrame {
    public static void main(String[] args) {
        /*The main method creates an instance of the FlowWindow
        class, causing it to display its window.
         */
        new FlowLayoutWindow();

    }

    private int windowHegiht = 105; //window width
    private int windowWidth = 200; //window height

    public FlowLayoutWindow(){

        //set the title bar text
        setTitle("Flow Layout");

        //set the size
        setSize(windowWidth, windowHegiht);

        //specify an action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a flowOut mamager to the content pane
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        //create three buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        //add three buttons to the content pane
        add(button1);
        add(button2);
        add(button3);

        //display window
        setVisible(true);



    }
}
