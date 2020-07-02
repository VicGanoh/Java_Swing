package myswingdemo_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToggleButtonDemo extends JFrame {

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleButtonDemo();
            }
        });
    }



    private JLabel messageLabel;
    private JToggleButton toggleButton;


    public ToggleButtonDemo(){

        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error setting"+
                    " Look and Feel.","Erroe",JOptionPane.ERROR_MESSAGE);
        }
        //set the title
        setTitle("Toggle Button");

        //Set size of the frame
        setSize(500,500);

        //specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set layout
        setLayout(new FlowLayout());

        //Create the label
        messageLabel = new JLabel("Button is off");

        //Create a toggle button
        toggleButton = new JToggleButton("ON/OFF");
        //add an actionListener to button
        toggleButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton.isSelected()){
                    //set label text to button is on
                    messageLabel.setText("Button is on.");
                }
                else
                    messageLabel.setText("Button is off.");
            }
        });

        //Add components to content pane
        add(toggleButton);
        add(messageLabel);

        //display the frame
        setVisible(true);

    }

}
