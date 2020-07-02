package advanced_swing;

import myswingdemo_.ToggleButtonDemo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * THis class demonstrates the List Component.
 */

public class JListDemo extends JFrame{

    /**
     The main method creates an instance of the
     ListWindow class which causes it to display
     its window.
     */
    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JListDemo();
            }
        });

    }





    private JPanel monthPanel; //To hold components
    private JPanel selectedMonthPanel; //to hold components
    private JList monthList; //hold the months
    private JScrollPane scrollPane; // hold month in with a scroll bar
    private JTextField selectedMonth; //The selected month
    private JLabel label; //A message

    //The following array holds the value that will
    // be displayed in the monthList list component.
    private String[] months = {"January", "February", "March", "April", "May", "June"
            , "July", "August", "September", "October", "November", "December",};

    /**
     * Constructor
     */
    public JListDemo(){

        //Set the title
        setTitle("List Demo");

        //Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a BorderLayout manager
        setLayout(new BorderLayout());

        //Build the month and selectedMonth panels
        buildMonthPanel();
        buildSelectedMonthPanel();

        //Add the panels to the content pane
        add(monthPanel,BorderLayout.CENTER);
        add(selectedMonthPanel,BorderLayout.SOUTH);


        //pack and display
        pack();
        setVisible(true);

    }

    /**
      The buildMonthPanel method adds a list containing
      the names of the months to a panel.
      */
    private void buildMonthPanel(){
        //Create a panel to hold the list.
        monthPanel = new JPanel();

        //Create the list
        monthList = new JList(months);

        //set number of rolls visible to scroll at a time
        monthList.setVisibleRowCount(4);

        //create the scroll pane
        scrollPane = new JScrollPane(monthList);


//        //Set the selection mode to single selection
//        monthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        monthList.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        //Register the list selection listener
        monthList.addListSelectionListener(e -> {
            //Get the selected month.
            String selection = (String) monthList.getSelectedValue();

            //Put the selected month in the text field.
            selectedMonth.setText(selection);
        });

        //Add the list to the panel
        monthPanel.add(scrollPane);
    }

    /**
      The buildSelectedMonthPanel method adds an
      uneditable text field to a panel.
     */
    private void buildSelectedMonthPanel(){
        //Create a panel to hold the list
        selectedMonthPanel = new JPanel();

        //Create the label
        label = new JLabel("You selected: ");

        //Create the text field.
        selectedMonth = new JTextField(10);

        //Make the text field uneditable
        selectedMonth.setEditable(false);

        //Add the label and text field to the panel
        selectedMonthPanel.add(label);
        selectedMonthPanel.add(selectedMonth);
    }



}
