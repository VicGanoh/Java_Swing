package myswingdemo_;

import javax.swing.*;

public class SimpleWindow extends JFrame {

    public SimpleWindow(){

        final int windowHeight = 350; //height of window
        final int windowWidth = 250; //width of window

        setSize(windowWidth, windowHeight); //set the size of the window

        setTitle("A Simple Window"); //set the  title

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true); //make window visible

    }

    public static void main(String[] args) {
         new SimpleWindow();
    }

}
