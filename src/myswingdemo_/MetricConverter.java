package myswingdemo_;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetricConverter extends JFrame {

    public static void main(String[] args) {

        new MetricConverter();
    }

    private JPanel panel; //holding a panel
    private JLabel messageLabel; //a message to the user
    private JTextField kiloTextField; //to hold user input
    private JRadioButton milesButton; //to convert to miles
    private JRadioButton feetButton; //to convert to feetButton
    private JRadioButton inchesButton; //to convert to inches
    private ButtonGroup radioButtonGroup; // to group radio button
    private final int windowHeight = 100;
    private final int windowWidth =  400;

    public MetricConverter(){
        //set the title
        setTitle("Metric Converter");

        //set the size of the window
        setSize(windowWidth,windowHeight);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //build the panel and add it to the frame
        buildPanel();

        //add the panel to the frame
        add(panel);

        //display the window
        setVisible(true);
    }

    public void buildPanel(){
        //create label,text field, and the three buttons to a panel
        messageLabel = new JLabel("Enter a distance in kilometers ");
        milesButton = new JRadioButton("Convert to miles");
        feetButton = new JRadioButton("Convert to feet");
        inchesButton = new JRadioButton("Convert to inches");
        kiloTextField = new JTextField(10);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(milesButton);
        radioButtonGroup.add(feetButton);
        radioButtonGroup.add(inchesButton);

        //add action listeners to buttons
        milesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input; //to hold user input
                String converter = ""; //the unit we are converting to
                double result = 0.0; //to hold the conversion

                //get the kilometers entered
                input = kiloTextField.getText();

                //determine which radio button was clicked
              //  String actionCommand = e.getActionCommand();
                if (e.getSource() == milesButton){
                    converter = " miles.";
                    result = Double.parseDouble(input) * 0.6214;
                }

                JOptionPane.showMessageDialog(null, input + " km " + "is " + result + converter);
            }
        });

        feetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input; //to hold user input
                String converter = ""; //the unit we are converting to
                double result = 0.0; //to hold the conversion

                //get the kilometers entered
                input = kiloTextField.getText();

                //determine which radio button was clicked
                //  String actionCommand = e.getActionCommand();
                if (e.getSource() == feetButton){
                    converter = " feet.";
                    result = Double.parseDouble(input) * 3281.0;
                }
                JOptionPane.showMessageDialog(null, input + " km " + "is " + result + converter);
            }
        });

        inchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input; //to hold user input
                String converter = ""; //the unit we are converting to
                double result = 0.0; //to hold the conversion

                //get the kilometers entered
                input = kiloTextField.getText();

                //determine which radio button was clicked
                //  String actionCommand = e.getActionCommand();
                if (e.getSource() == inchesButton){
                    converter = " inches.";
                    result = Double.parseDouble(input) * 39370.0;
                }
                JOptionPane.showMessageDialog(null, input + " km " + "is " + result + converter);
            }
        });

        panel = new JPanel();
        //add components to panel
        panel.setBorder(BorderFactory.createTitledBorder("Converter"));
     //   panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(milesButton);
        panel.add(feetButton);
        panel.add(inchesButton);




    }



}
