package myswingdemo_.translator;

import javax.swing.*;
import java.awt.*;

/*
 The window
have three buttons, one for each Latin word. When the user clicks a button,
 the program displays the English translation in a label.
 */
public class LatinTranslator extends JFrame {
    private JPanel panel; // panel to hold components
    private JButton sinisterButton; // button that holds sinister latin word
    private JButton dexterButton; // button that hold dexter latin word
    private JButton mediumButton; // button that holds medium latin word
    private JLabel messageLabel; //to hold message

    /**
     * Constructor
     */
    public LatinTranslator(){
        //set title
        setTitle("Latin Translator");

        //set size
        setSize(600,250);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add built panel to window
        buildPanel();

        //add panel to window
        add(panel);

        //display window
        setVisible(true);
    }

    /**
     * buildPanel method to ad all components to panel
     */
    public void buildPanel(){
        //create buttons
        sinisterButton = new JButton("Translate SINISTER to English");
        dexterButton = new JButton("Translate DEXTER to English");
        mediumButton = new JButton("Translate MEDIUM to English");

        //create label
        messageLabel = new JLabel("Translate the following latin words,"
                + " SINISTER, DEXTER, AND MEDIUM " + " to English");

        //add an acton listener to all buttons
        sinisterButton.addActionListener((e -> {
            String englishWord1 = "LEFT"; //english word for sinister
            if(e.getSource() == sinisterButton){
                JOptionPane.showMessageDialog(null,
                        "English word for sinister is " + englishWord1);
            }
        }));

        dexterButton.addActionListener((e -> {
            String englishWord2 = "RIGHT"; //english word for dexter
            if (e.getSource() == dexterButton)
                JOptionPane.showMessageDialog(null,
                        "English word for dexter is " + englishWord2);
        }));

        mediumButton.addActionListener((e -> {
            String englishWord3 = "CENTER"; //english word for medium
            if (e.getSource() == mediumButton)
                JOptionPane.showMessageDialog(null,
                        "English word for medium is " + englishWord3);
        }));


        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLayout(new BorderLayout());

        //add components to panel
        panel = new JPanel();
        panel.add(messageLabel,BorderLayout.NORTH);
        panel.add(sinisterButton);
        panel.add(dexterButton);
        panel.add(mediumButton);
    }

    public static void main(String[] args) {

        new LatinTranslator();
    }
}
