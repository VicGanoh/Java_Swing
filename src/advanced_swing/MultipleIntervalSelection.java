package advanced_swing;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the List component in
 * multiple interval selection mode
 */

public class MultipleIntervalSelection extends JFrame {
    private JPanel monthPanel; //To hold components
    private JPanel selectedMonthPanel; // To hold components
    private JPanel buttonPanel; //To hold the button
    private JList monthList; //To hold months
    private JList selectedMonthList; //selected months
    private JScrollPane scrollPanel; //scroll pane - first list
    private JScrollPane scrollPanel2; // scroll pane - second list

    private JButton button; // a button

    private String[] months = {"January", "February", "March", "April", "May", "June"
            , "July", "August", "September", "October", "November", "December"};

    /**
     * Constructor
     */
    public MultipleIntervalSelection(){
        //set title.
        setTitle("List Demo");

        //specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a borderLayout manager
        setLayout(new BorderLayout());

        //Build the panels
        buildMonthPanel();
        buildSelectedMonthPanel();
        buildButtonPanel();

        //add the panels to the content pane
        add(monthPanel, BorderLayout.NORTH);
        add(selectedMonthPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        //pack and display the window
        pack();
        setVisible(true);
    }

    /**
  The buildMonthPanel method adds a list containing the
  names of the months to a panel.
    */
    private void buildMonthPanel(){
        //create a panel to hold the list
        monthPanel = new JPanel();

        //Create the list
        monthList = new JList(months);

        //Set the selection mode to multiple
        // interval selection
        monthList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Set the number of visible rows to 6
        monthList.setVisibleRowCount(6);

        //Add the list to scroll panel
        scrollPanel = new JScrollPane(monthList);

        //Add scroll pane to the panel
        monthPanel.add(scrollPanel);
    }

    /**
      The buildSelectedMonthsPanel method adds a list
      to a panel. This will hold the selected months.
      */
    private void buildSelectedMonthPanel(){
        //Create a panel to hold the list.
        selectedMonthPanel = new JPanel();

        //Create the list
        selectedMonthList = new JList();

        //set the number of rows visible to 6
        selectedMonthList.setVisibleRowCount(6);

        //Add the list to a scroll pane
        scrollPanel2 = new JScrollPane(selectedMonthList);

        //Add the scroll pane to the panel
        selectedMonthPanel.add(scrollPanel2);
    }

    /**
     The buildButtonPanel method adds a
     button to a panel.
    */
    private void buildButtonPanel(){
        //Create a panel to hold the list
        buttonPanel = new JPanel();

        //Create the button
        button = new JButton("Get selections");

        //Add an action listener to the button.
        button.addActionListener(e -> {
            //get the selected values
            Object[] selections = monthList.getSelectedValuesList().toArray();

            //Store the selected items in selectedMonthList.
            selectedMonthList.setListData(selections);
        });

        //add the button to the panel
        buttonPanel.add(button);
    }

    public static void main(String[] args) {
        new MultipleIntervalSelection();
    }
}
