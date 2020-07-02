package myswingdemo_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KilometerConverter extends JFrame{
    private JPanel panel; //to reference a panel
    private JLabel messageLabel; //to reference a label
    private JButton calcButton; //to reference a button
    private JTextField kiloTextField; //to reference a text field
    final int windowWidth = 350 ;//window width
    final int windowHeight = 150; //window height

    //contructor
    public KilometerConverter(){
        //set the window title
        setTitle("Kilometer Converter");

        //set the size of the window
        setSize(windowWidth,windowHeight);

        //specify what happens when the close button is clicked
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Build the panel and add it to the frame
        buildPanel();

        //add the panel to the frame's content pane
        add(panel);

        //display the window
        setVisible(true);
    }

    public void buildPanel(){
        //create a label to display instructions
        messageLabel = new JLabel("Enter a distance in kilometers");

        //Create a text field 10 characters wide
        kiloTextField = new JTextField(10);

        //create a button with the caption "Calculate"
        calcButton = new JButton("Calculate");

        /**
         * The actionPerformed method executes when the user clicks on the calculate button
         * @param actionEvent the event object
         */
        calcButton.addActionListener((ActionEvent actionEvent) -> {
            double conversion = 0.6124;
            String input; // hold user's input
            double miles; //the number of miles

            input = kiloTextField.getText(); //get the text entered by user into text field

            //FOR DEBUGGING, DISPLAY THE TEXT ENTERED, AND
            //ITS VALUE CONVERTED TO A double
                    System.out.println("Reading " + input + " from text field.");
                    System.out.println("Converted value: " + Double.parseDouble(input));

            miles = Double.parseDouble(input); //convert the input into miles
            JOptionPane.showMessageDialog(null, input + " kilometers is " + miles + " miles"); //display the result

            //For debugging, display a message indicating the application is
            //ready for more input.
                    System.out.println("Ready for more input.");
        }
        );

//        //add an action listener to the calcButton
//        calcButton.addActionListener(new ActionListener() {
//            /**
//             * The actionPerformed method executes when the user clicks on the calculate button
//                      * @param actionEvent the event object
//                     */
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                final double CONVERSION = 0.6124;
//                String input; //to hold user's input
//                double miles; //the number of miles
//
//                //Get the text entered by the user into the test field
//                input = kiloTextField.getText();
//
//                //convert the input into miles
//                miles = Double.parseDouble(input);
//
//                //display message
//                JOptionPane.showMessageDialog(null, input + " kilometers is " + miles + " miles");
//            }
//        });

        //create a JPanel object and let the panel field reference it
        panel = new JPanel();

        //add the label, text field, and button to the panel
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
    }

    /**
     * CREATING A calcButton listener(inner class) class for the calcButton
     */

//    private class CalcButtonListener implements ActionListener{
//        /**
//         * The actionPerformed method executes when the user clicks on the calculate button
//         * @param actionEvent the event object
//         */
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            final double CONVERSION = 0.6124;
//            String input; //to hold the user's input
//            double miles; //the number of miles
//
//            //Get the text entered by the user into the text field
//            input = kiloTextField.getText();
//
//            //convert the input to miles
//            miles = Double.parseDouble(input) * CONVERSION;
//
//            //Display the result
//            JOptionPane.showMessageDialog(null,input + " kilometers is " + miles + " miles");
//        }
//    }

    public static void main(String[] args) {
        /*
        The KiloConverter class displays a JFrame that
        lets the user enter a distance in kilometers. When
        the Calculate button is clicked, a dialog box is
         displayed with the distance converted to miles. */

        new KilometerConverter();



    }


}
