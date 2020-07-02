package myswingdemo_.long_distance_calls;

import javax.swing.*;
import java.awt.*;

/* A GUI application that allows the user to select a rate category (from a set of radio
buttons), and enter the number of minutes of the call into a text field. A dialog box should
display the charge for the call.
 */
public class CallWindow extends JFrame{
    private JPanel panel; // panel to hold exponents
    private JRadioButton daytimeButton; // radiobutton for daytime
    private JRadioButton eveningButton; //// radiobutton for evening
    private JRadioButton offPeakButton; // radiobutton for Off-Peak
    private ButtonGroup buttonGroup; // component to group buttons
    private final int window_width = 350; //size of the window's width
    private final int window_height = 500; //size of the window's height

    /**
     * Constructor
     */
    public CallWindow(){
        //set window title
        setTitle("Long-Distance Call Provider");

        //set size of the window
        setSize(window_width,window_height);

        //specify an action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add built panel
        buildPanel();

        //add panel to frame
        add(panel);

        //display window
        setVisible(true);
    }

    /**
     * buildPanel method
     * To build and add all components to panel
     */
    public void buildPanel(){
        //create radio buttons
        daytimeButton = new JRadioButton("Daytime(6:00 A.M. - 5:59 P.M.)");
        eveningButton = new JRadioButton("Evening(6:00 P.M. - 11:59 P.M.)");
        offPeakButton = new JRadioButton("Off-Peak(12:00 A.M. - 5:59 A.M.)");

        buttonGroup = new ButtonGroup(); //to hold all radio buttons

        //group all radio buttons
        buttonGroup.add(daytimeButton);
        buttonGroup.add(eveningButton);
        buttonGroup.add(offPeakButton);

        //add and register all buttons to action listener
        daytimeButton.addActionListener(e -> {
            String minuteInput; //to hold input of minute
            double chargeAmount = 0.0;  //to hold total charges for call
            final double daytimeRatePerMinute = 0.07; //rate per minute for daytime charge

            if (e.getSource() == daytimeButton){
                if (daytimeButton.isSelected()){
                    minuteInput = JOptionPane.showInputDialog("Enter the number " + " \nof minute(s) for " +
                            "daytime call category");
                    chargeAmount = Double.parseDouble(minuteInput); //convert the minute in string into double
                    chargeAmount *= daytimeRatePerMinute; //calculate the charge of the call
                    JOptionPane.showMessageDialog(null,
                            String.format("Your charge for the call is $%,.2f",
                                    chargeAmount));

                    System.exit(0);
                }

            }
        });

        eveningButton.addActionListener(e -> {
            String minuteInput; //to hold input
            double chargeAmount = 0.0; //to hold total charges for call
            final double eveRatePerMinute = 0.12; //rate per minute for evening charge

            if (e.getSource()==eveningButton)
                if (eveningButton.isSelected()){
                   minuteInput =  JOptionPane.showInputDialog("Enter the number " + "\nof minute(s) for " +
                            "evening call category");
                    chargeAmount = Double.parseDouble(minuteInput);
                    chargeAmount = chargeAmount * eveRatePerMinute; //calculate the charge of the call

                    JOptionPane.showMessageDialog(null,
                            String.format("Your charge for the call is $%,.2f",
                                    chargeAmount));

                    System.exit(0);
                }

        });

        offPeakButton.addActionListener(e -> {
            String minuteInput; //to hold input
            double chargeAmount = 0.0;  //to hold total charges for call
            final double off_peakRatePerMinute = 0.05; //rate per minute for Off-Peak charge

            if (e.getSource() == offPeakButton)
                if (offPeakButton.isSelected()){

                    minuteInput = JOptionPane.showInputDialog("Enter the number " + "\nof minute(s) for " +
                            "evening call category");
                    chargeAmount = Double.parseDouble(minuteInput) * off_peakRatePerMinute;

                    JOptionPane.showMessageDialog(null,
                            String.format("Your charge for the call is $%,.2f",
                                    chargeAmount));

                    System.exit(0);
                }

        });
        //create panel
        panel = new JPanel();

       //set border
        panel.setBorder(BorderFactory.createTitledBorder("Call Rate Category"));

        //set layout
        setLayout(new GridLayout(3,1));

        //add all components to panel
        panel.add(daytimeButton);
        panel.add(eveningButton);
        panel.add(offPeakButton);
    }


    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {

        new CallWindow();

    }
}
