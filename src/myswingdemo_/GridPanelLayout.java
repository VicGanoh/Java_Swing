package myswingdemo_;

import javax.swing.*;
import java.awt.*;

public class GridPanelLayout extends JFrame {
    public static void main(String[] args) {

        new GridPanelLayout();

    }

    private final int windowHeight = 200;
    private final  int windowWidth = 400;

    public GridPanelLayout(){
        //set title
        setTitle("Grid Layout");

        //set window size
        setSize(windowWidth,windowHeight);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add a grid layout
        setLayout(new GridLayout(2,3));

        //create button
        JButton button1 = new JButton("Grid 1");
        JButton button2 = new JButton("Grid 2");
        JButton button3 = new JButton("Grid 3");
        JButton button4 = new JButton("Grid 4");
        JButton button5 = new JButton("Grid 5");
        JButton button6 = new JButton("Grid 6");

        // create label
        JLabel label1 = new JLabel("This is cell 1.");
        JLabel label2 = new JLabel("This is cell 2.");
        JLabel label3 = new JLabel("This is cell 3.");
        JLabel label4 = new JLabel("This is cell 4.");
        JLabel label5 = new JLabel("This is cell 5.");
        JLabel label6 = new JLabel("This is cell 6.");

        //create panel for each grid
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        //add label to panel
        panel1.add(label1);
        panel2.add(label2);
        panel3.add(label3);
        panel4.add(label4);
        panel5.add(label5);
        panel6.add(label6);

        //add the to panel
        panel1.add(button1);
        panel2.add(button2);
        panel3.add(button3);
        panel4.add(button4);
        panel5.add(button5);
        panel6.add(button6);


        //add button to pane
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);

        //display window
        setVisible(true);
    }

}
