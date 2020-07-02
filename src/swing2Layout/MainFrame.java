package swing2Layout;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JTextArea textArea;
    private JButton btn;



    public MainFrame(){
        super("Hello World");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click me");

        add(textArea,BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
