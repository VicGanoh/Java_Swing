package myswingdemo_;

import javax.swing.*;
import java.awt.*;

public class GridLayoutWindow extends JFrame {
    public static void main(String[] args) {

        new GridLayoutWindow();
    }

    private final int windowHeight = 200;
    private final  int windowWidth = 400;

    public GridLayoutWindow(){
        //set title
        setTitle("Grid Layout");

        //set window size
        setSize(windowWidth,windowHeight);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add a grid layout
        setLayout(new GridLayout(3,2));

        //create button
        JButton button1 = new JButton("Grid 1");
        JButton button2 = new JButton("Grid 2");
        JButton button3 = new JButton("Grid 3");
        JButton button4 = new JButton("Grid 4");
        JButton button5 = new JButton("Grid 5");
        JButton button6 = new JButton("Grid 6");

        //add button to pane
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        //display window
        setVisible(true);
    }
}
