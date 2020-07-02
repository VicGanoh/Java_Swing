package myswingdemo_;

import javax.swing.*;
import java.awt.*;

public class CheckBoxDemo extends JFrame {
    private JLabel messageLabel; // a message to the user
    private JCheckBox yellowCheckbox; //to select yellow background
    private JCheckBox redCheckBox; //to select red background
    private final int window_width = 300; //window width
    private final int window_height = 100; //window height

    /**
     * Constructor
     */
    public CheckBoxDemo(){
        //set the text for the title bar.
        setTitle("Color Check Boxes");

        //set the size of the window
        setSize(window_width,window_height);

        //Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a label
        messageLabel = new JLabel("Select the check " + "boxes to change colors.");

        //Create the check boxes
        yellowCheckbox = new JCheckBox("Yellow Background");
        redCheckBox = new JCheckBox("Red Foreground");

        //Add an item listener to the check boxes.
        yellowCheckbox.addItemListener((itemEvent) -> {
            //determine which check box was clicked.
            if (itemEvent.getSource() == yellowCheckbox){
                //is the yellow check box selected? if so, we
                //want to set the background color to yellow
                if (yellowCheckbox.isSelected()){
                    getContentPane().setBackground(Color.YELLOW);
                    yellowCheckbox.setBackground(Color.YELLOW);
                    redCheckBox.setBackground(Color.YELLOW);
                }
                else{
                    //the yellow checkbox was deselected.Set the
                    //background color of the content pane and
                    //the two check boxes to light gray
                    getContentPane().setBackground(Color.LIGHT_GRAY);
                    yellowCheckbox.setBackground(Color.LIGHT_GRAY);
                    redCheckBox.setBackground(Color.LIGHT_GRAY);
                }
            }
        } );

        redCheckBox.addItemListener((itemListener) -> {
            if (itemListener.getSource() == redCheckBox){
                //is the red box selected? if so, we
                //want to set the foreground to red
                if (redCheckBox.isSelected()){
                    getContentPane().setForeground(Color.RED);
                    yellowCheckbox.setForeground(Color.RED);
                    redCheckBox.setForeground(Color.RED);
                }
                else{
                    //the red check box was deselected.Set the
                    //foreground color for the label and
                    //the two check boxes to black
                    getContentPane().setForeground(Color.BLACK);
                    yellowCheckbox.setForeground(Color.BLACK);
                    redCheckBox.setForeground(Color.BLACK);
                }
            }
        });

        //add a flowLayout manager to the content pane
        setLayout(new FlowLayout());

        //Add the label and check boxes to content pane
        add(messageLabel);
        add(yellowCheckbox);
        add(redCheckBox);

        //Display window
        setVisible(true);


    }

    /**
     * The main method creates an instance of the CheckBoxWindow Demo , displaying its window
     */
    public static void main(String[] args) {

        new CheckBoxDemo();

    }


}
