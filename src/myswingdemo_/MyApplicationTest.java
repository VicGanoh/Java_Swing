package myswingdemo_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyApplicationTest extends JFrame {

    public static void main(String[] args) {

        new MyApplicationTest();
    }

    private JLabel messageLabel; //message to display to user
    private JLabel messageLabel2; //message to display to user
    private JRadioButton radioButton1; //first answer button
    private JRadioButton radioButton2; //second button
    private JRadioButton radioButton3; // third radio button
    private ButtonGroup groupButton;
    private JPanel panel;
    private final int windowHeight = 500;
    private final int windowWidth = 350;

    public MyApplicationTest(){
        //title of the widow
        setTitle("Math Quiz");

        //set size of window
        setSize(windowWidth,windowHeight);

        //specify what the close button does
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //build panel
        buildPanel();


        //add panel to window
        add(panel);

        //display window
        setVisible(true);


    }

    public void buildPanel(){
        //add components to panel
        messageLabel = new JLabel("Choose the correct answer.\n\n\n");
        messageLabel2 = new JLabel("What is 43 x 5");
        radioButton1 = new JRadioButton("546");
        radioButton2 = new JRadioButton("215");
        radioButton3 = new JRadioButton("321");
        groupButton = new ButtonGroup();

        setLayout(new FlowLayout(FlowLayout.LEFT));

        groupButton.add(radioButton1);
        groupButton.add(radioButton2);
        groupButton.add(radioButton3);





        //action listener for button
        radioButton1.addActionListener((ActionEvent e) -> {
            if (e.getSource() == radioButton1){
                JOptionPane.showMessageDialog(null,"Your answer is incorrect.");
            }
        });

        radioButton2.addActionListener((ActionEvent e) -> {
            if (e.getSource() == radioButton2){
                JOptionPane.showMessageDialog(null,"Your answer is correct.");
            }
        });

        radioButton3.addActionListener((ActionEvent e) -> {
            if (e.getSource() == radioButton3){
                JOptionPane.showMessageDialog(null, "Your answer is incorrect.");
            }
        });


        //add to panel
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(messageLabel2);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

    }

}
