package advanced_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


/**
  The MenuWindow class demonstrates a menu system
 */
public class MenuWindow extends JFrame {
    private JLabel messageLabel; //displays a message
    private final int LABEL_WIDTH = 400; //label's width
    private final int LABEL_HEIGHT = 200; //Label's height

    //The following will reference menu components
    private JMenuBar menuBar; //The menu bar
    private JMenu fileMenu; //The file menu
    private JMenu textMenu; //The text menu
    private JMenuItem exitItem; //To exit
    private JRadioButtonMenuItem blackItem; //Makes text black
    private JRadioButtonMenuItem redItem; //Makes text red
    private JRadioButtonMenuItem blueItem; //Makes the text blue
    private JCheckBoxMenuItem visibleItem; //Toggle visibility

    /**
     Constructor
     */

    public MenuWindow(){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            //Set the title
            setTitle("Example Menu System");

            //Specify an action for the close button
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create the messageLabel label
            messageLabel = new JLabel("Use the Text Menu to " +
                    "change my color and make me invisible.", SwingConstants.CENTER);

            //Set the label's preferred size.
            messageLabel.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));

            //Set label's foreground color
            messageLabel.setForeground(Color.BLACK);

            //Add the label to the content pane.
            add(messageLabel);

            //Build the menu bar
            buildMenuBar();

            //pack and display the window
            pack();
            setVisible(true);

        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error setting " +
                 "Look and Feel.");
         System.exit(0);
        }



           }

    /**
     * The buildMenuBar method builds the menu bar.
     */
    private void buildMenuBar(){

        //create the menu bar
        menuBar = new JMenuBar();

        //Create the file and text menus.
        buildFileMenu();
        buildTextMenu();

        //Add the file and text menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(textMenu);

        //set the windows menu bar
        setJMenuBar(menuBar);

    }

    /**
     * The buildFileMenu method builds the File menu
     * and returns a reference to its JMenu object.
     */
    private void buildFileMenu(){

        //Create an Exit menu item
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener( e -> {
            System.exit(0);
        });

        //Create a JMenu object for the File menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        //Add the Exit menu item to the File menu
        fileMenu.add(exitItem);
    }

    /**
     * The buildTextMenu method builds the Text menu and returns
     * a reference to its JMenu object.
     */
    private void buildTextMenu(){

        //create the radio button menu items to change
        //the color of the text. Add an action listener
        //to each one.
        blackItem = new JRadioButtonMenuItem("Black",true);
        blackItem.setMnemonic(KeyEvent.VK_B);
        blackItem.addActionListener( e -> {
            if (blackItem.isSelected())
                messageLabel.setForeground(Color.BLACK);

        });

        redItem = new JRadioButtonMenuItem("Red");
        redItem.setMnemonic(KeyEvent.VK_R);
        redItem.addActionListener( e -> {
            if (redItem.isSelected())
                messageLabel.setForeground(Color.RED);
        });

        blueItem = new JRadioButtonMenuItem("Blue");
        blueItem.setMnemonic(KeyEvent.VK_U);
        blueItem.addActionListener(e -> {
            if (blueItem.isSelected())
                messageLabel.setForeground(Color.BLUE);
        });

        //Create a button group for the radio button items.
        ButtonGroup group = new ButtonGroup();
        group.add(blackItem);
        group.add(redItem);
        group.add(blueItem);

        //Create a check box menu item to make the text
        //visible or invisible
        visibleItem = new JCheckBoxMenuItem("Visible",true);
        visibleItem.setMnemonic(KeyEvent.VK_V);
        visibleItem.addActionListener(e -> {
            if (visibleItem.isSelected())
                messageLabel.setVisible(true);
            else
                messageLabel.setVisible(false);
        });

        //Create a JMenu object for the Text menu.
        textMenu = new JMenu("Text");
        textMenu.setMnemonic(KeyEvent.VK_T);

        //Add the menu items to the text menu.
        textMenu.add(blackItem);
        textMenu.add(redItem);
        textMenu.add(blueItem);
        textMenu.addSeparator();  //add a separator bar
        textMenu.add(visibleItem);
    }

    public static void main(String[] args) {
        MenuWindow mw = new MenuWindow();
    }
}
