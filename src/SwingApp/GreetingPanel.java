package SwingApp;

import javax.swing.*;

public class GreetingPanel extends JPanel {
    /*
        The Greeting panel class displays a greeting in a panel.
     */

    private JLabel greeting; //To display a greeting

    public GreetingPanel(){
       //Create the label
       greeting = new JLabel("Welcome to VicGan's Bagel House");

       //add the label to the panel
        add(greeting);

    }
}
