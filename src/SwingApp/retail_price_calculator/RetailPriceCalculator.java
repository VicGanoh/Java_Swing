package myswingdemo_.retail_price_calculator;

/*
This application or program calculates the retail price of an item
when wholesale cost price and markup % are given
 */

import javax.swing.*;

public class RetailPriceCalculator extends JFrame {
    private JPanel panel; //panel to hold all components
    private JLabel messageLabel1; //to hold message
    private JLabel messageLabel2; // to hold message
    private JTextField costPriceTextField; // to hold user input for wholesale cost of item
    private JTextField markUp_percentageTextField2; //to hold user input for markup %
    private JButton calcButton; //button to calculate retail price
    private final int window_width = 400;
    private final int window_height = 250;
    private double costPrice = 0.0;
    private double markUpPercentage = 0.0;




    /**
     * Constructor
     */
    public RetailPriceCalculator(){
        //set title
        setTitle("Retail Price Calculator");

        //set the size of window
        setSize(window_width,window_height);

        //specify an action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the panel built to the frame
        buildPanel();

        //add panel to pane
        add(panel);

        //display the window
        setVisible(true);
    }


    //build a panel to hold components
    public void buildPanel(){
        //creating labels, text fields and buttons
        messageLabel1 = new JLabel("Enter the wholesale cost of the item ($):"); // to display message to user
        messageLabel2 = new JLabel("Enter the markup %:"); //to display message to user

        //create text field
        costPriceTextField = new JTextField(10); //to reference text field
        markUp_percentageTextField2 = new JTextField(10); //to reference text field

        //create button
        calcButton = new JButton("Calculate Retail Price"); //button to calculate retail price


        //add and register an action listener to the button
        /**
         * The actionPerformed method executes when the user clicks on the calculate button
         * @param actionEvent the event object
         */
        calcButton.addActionListener((actionEvent) -> {
            getInput(); //holds the input of cost price and markup percentage price

            if (actionEvent.getSource() == calcButton){
                getRetailPrice();
            }

            JOptionPane.showMessageDialog(null,
                    String.format("Retail price is $%,.2f",getRetailPrice()));
        });

        //add components to panel
        panel = new JPanel();
        panel.add(messageLabel1);
        panel.add(costPriceTextField);
        panel.add(messageLabel2);
        panel.add(markUp_percentageTextField2);
        panel.add(calcButton);
    }


    /**
     * The getRetailPrice method
     * @return The retail price of an item
     */
    public double getRetailPrice(){
        double retailPrice = 0.0;
        double markUpPercentagePrice = 0.0;
        markUpPercentagePrice = costPrice * markUpPercentage;
        retailPrice = markUpPercentagePrice + costPrice;

        return retailPrice;
    }

    /**
     * getInput method
     * @return the input of cost price and markUp percentage
     */
    public String getInput(){
        String costInput; // to hold user input for cost price
        String markUpPercentageInput; // to hold user input for markup %

        //get cost price text entered
        costInput = costPriceTextField.getText();
        costPrice = Double.parseDouble(costInput);

        //get markup % text entered
        markUpPercentageInput = markUp_percentageTextField2.getText();
        markUpPercentage = Double.parseDouble(markUpPercentageInput) / 100;

        return (double)costPrice + ", " + markUpPercentage;
    }


    //create an instance for the application
    public static void main(String[] args) {
        new  RetailPriceCalculator();
    }

}
