package advanced_swing;

import javax.swing.*;
import java.awt.*;

public class ComboBoxDemo extends JFrame {
    private JPanel namePanel; // to hold components
    private JPanel selectedNamePanel; // to hold components
    private JLabel messageLabel; //To hold message
    private JTextField selectedNameField; // selected name
    private JComboBox namesList; //to hold names

    private String[] names = {"Michael", "Freda", "Denis", "Andy", "Martha", "Daniel",
    "Joseph", "Nigel", "Lucky"};


    /**
     * Constructor
     */
     public ComboBoxDemo(){
         //set the title
         setTitle("Combo Box Demo");

         //set size
         setSize(300,300);

         //specify an action for close button
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         //set BorderLayout manager
         setLayout(new BorderLayout());

         //build panel
         buildNamePanel();
         buildSelectedNamePanel();

         //add panel to content pane
         add(namePanel, BorderLayout.NORTH);
         add(selectedNamePanel, BorderLayout.SOUTH);


         //pack and set visible
         pack();
         setVisible(true);
     }

     private void buildNamePanel(){
         //create a panel to hold the list
         namePanel = new JPanel();

         //create the list
         namesList = new JComboBox(names);

         namesList.addActionListener(e -> {
             String selection;

             //Get the selected item
             selection = (String) namesList.getSelectedItem();

             //Display the selected coffee in the text field
             selectedNameField.setText(selection);
         });

            //Add the  combo box to the panel
         namePanel.add(namesList);
     }

    /**
     * The buildSelectedNamesPanel method adds a
     * read-only text field to a panel
     */
    private void buildSelectedNamePanel(){
        //create a panel to hold components
        selectedNamePanel = new JPanel();

        //Create the label.
        messageLabel = new JLabel("You selected: ");

        //Create the uneditable text field.
        selectedNameField = new JTextField(10);
        selectedNameField.setEditable(false);

        //Add the label and text field to the panel
        selectedNamePanel.add(messageLabel);
        selectedNamePanel.add(selectedNameField);
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        new ComboBoxDemo();
    }
}
