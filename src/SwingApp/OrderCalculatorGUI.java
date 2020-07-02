package SwingApp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
  The OrderCalculatorGUI class creates the GUI for the
  Brandi's Bagel House application.
 */

public class OrderCalculatorGUI extends JFrame {

    private BagelPanel bagelPanel; // Bagel panel
    private ToppingPanel toppingPanel; //Topping panel
    private CoffeePanel coffeePanel; //coffee panel
    private GreetingPanel greetingPanel; //To display a greeting
    private JPanel buttonPanel; //TO hold buttons
    private JButton calcButton; //To calculate the cost
    private JButton exitButton; //To exit application
    private final double TAX_RATE = 0.06; //sales tax rate
    public final int window_width = 500;
    public final int window_height = 400;

    /**
     * Constructor
     */

    public OrderCalculatorGUI(){
        //Display a title
        setTitle("Order Calculator");

        //set the size of the window
        setSize(window_width,window_height);

        //Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a BorderLayout manager
        setLayout(new BorderLayout());

        //Create custom panels.
        greetingPanel = new GreetingPanel();
        bagelPanel = new BagelPanel();
        toppingPanel = new ToppingPanel();
        coffeePanel = new CoffeePanel();

        //create the button panel
        buildButtonPanel();

        // Add components to the content pane.
        add(greetingPanel, BorderLayout.NORTH);
        add(bagelPanel, BorderLayout.WEST);
        add(toppingPanel, BorderLayout.CENTER);
        add(coffeePanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);


        //Pack the contents of the window and display it
        pack();
        setVisible(true);

    }

    private void buildButtonPanel(){
        //Create a panel for the buttons
        buttonPanel = new JPanel();

        //Create Buttons
        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        //Register Actionlisteners
        calcButton.addActionListener((e) -> {
            //variables to hold the subtotal, tax, and total
            double subtotal, tax, total;

            //Calculate the subtotal.
            subtotal = bagelPanel.getBagelCost() + toppingPanel.getToppingCost() +
                    coffeePanel.getCoffeeCost();

            //Calculate the sales tax
            tax = subtotal * TAX_RATE;

            //Calculate the total
            total = subtotal + tax;

            //Display the charges.
            JOptionPane.showMessageDialog(null,
                    String.format("Subtotal: $%,.2f\n Tax: $%,.2f\n Total: $%,.2f",
                            subtotal,  tax, total));
        });

        exitButton.addActionListener((e) -> {
            System.exit(0);
        });

        //add components to panel
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }

    public static void main(String[] args) {

        new OrderCalculatorGUI();
    }
}
