package advanced_swing.images_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This class demonstrates how to use an ImageIcon
 * and a JLabel to display an image.
 */

public class NerdFaceImage extends JFrame {
    private JPanel imagePanel; // to hold the label
    private JPanel buttonPanel; // to hold a button
    private JLabel imageLabel; //To show an image
    private JButton button; //To get an image

    /**
     * Constructor
     */

    public NerdFaceImage(){
        //set the title.
        setTitle("My Nerd");

        //set size
        setSize(500,500);

        //Specify an action for close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a Border Layout manager
        setLayout(new BorderLayout());

        //Build the panels
        buildImagePanel();
        buildButtonPanel();

        //add panel to content pane
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        //pack and display the window
        pack();
        setVisible(true);
    }

    /**
     * The buildImagePanel method adds a label to a panel
     */
    private void buildImagePanel(){
        //Create a panel.
        imagePanel = new JPanel();

        //Create a label.
        imageLabel = new JLabel("Click the button to " +
                "see an image of a nerd emoji.");

        //Add the label to the panel
        imagePanel.add(imageLabel);
    }

    /**
     * The buildButtonPanel method adds
     * a button to a panel
     */
    private void buildButtonPanel(){
        //Create the panel.
        buttonPanel = new JPanel();

        //Create a button
        button = new JButton("Get Image");

        //add a tool tip
        button.setToolTipText("Click this button to see the emoji.");

        //add a mnemonic
        button.setMnemonic(KeyEvent.VK_I);

        //Register an action listener with the button
        button.addActionListener(e -> {
            //Read the image file into an Image Icon object
            ImageIcon imageIcon;
            imageIcon = new ImageIcon("C:\\image\\nerdface.gif");

            //display the image in the label
            imageLabel.setIcon(imageIcon);

            //remove the text from the label
            imageLabel.setText(null);
            
            //pack the frame again to accommodate the
            //new size of the label
            pack();
        });

        buttonPanel.add(button);
    }

    public static void main(String[] args) {
        new NerdFaceImage();
    }
}
