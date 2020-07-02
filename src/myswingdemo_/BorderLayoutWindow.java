package myswingdemo_;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutWindow extends JFrame {
    public static void main(String[] args) {
        /*
        The main method creates an instance of the BorderWindow
        class, causing it to display its window.
         */
        new BorderLayoutWindow();

    }

    private final int windowHeight = 300; //window height
    private  final int windowWidth = 400; //window width

    public BorderLayoutWindow(){

        //set the title
        setTitle("Border Layout");

        //set the size of the window
        setSize(windowWidth,windowHeight);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a border layout
        setLayout(new BorderLayout(5,5));

        //create five buttons
        JButton button1 = new JButton("North Button");
        JButton button2 = new JButton("South Button");
        JButton button3 = new JButton("East Button");
        JButton button4 = new JButton("West Button");
        JButton button5 = new JButton("Center Button");

        //add five buttons to content pane
        add(button1,BorderLayout.NORTH);
        add(button2,BorderLayout.SOUTH);
        add(button3,BorderLayout.EAST);
        add(button4,BorderLayout.WEST);
        add(button5,BorderLayout.CENTER);

        //make window visible
        setVisible(true);

    }
}
