package advanced_swing.slider;

import javax.swing.*;
import java.awt.*;

/**
  This class displays a window with a slider component.
 The user can convert the celsius temperature from 0
 through 100 to Fahrenheit by moving the slider.
 */
public class TempConverter extends JFrame {

    private JLabel label1, label2; //Message labels
    private JTextField fahrenheitTemp; //Fahrenheit temp
    private JTextField celsiusTemp; //celsius temp
    private JPanel fpanel; //Fahrenheit panel
    private JPanel cpanel; //celsius panel
    private JPanel sliderPanel; //slider panel
    private JSlider slider; //Temperature adjustment

    /**
     Constructor
     */
    public TempConverter(){

        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error setting "
                    + "the look and feel.");
            System.exit(0);
        }

        //Set the title
        setTitle("Temperatures");

        //Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the message labels.
        label1 = new JLabel("Fahrenheit: ");
        label2 = new JLabel("Celsius: ");

        //Create the read-only text fields
        fahrenheitTemp = new JTextField("32.0",10);
        fahrenheitTemp.setEditable(false);
        celsiusTemp = new JTextField("0.0",10);
        celsiusTemp.setEditable(false);

        //Create the slider
        slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
        slider.setMajorTickSpacing(20); //Major tick every 20
        slider.setMinorTickSpacing(5); //Minor tick every 5
        slider.setPaintTicks(true); //display tick marks
        slider.setPaintLabels(true); //display numbers
        slider.addChangeListener( e -> {
            double fahrenheit, celsius;

            //Get the slider value.
            celsius =  slider.getValue();

            //Convert the value to Fahrenheit
            fahrenheit = (9.0 / 5.0) * celsius + 32.0;

            //store the celsius temp in its display field
            celsiusTemp.setText(Double.toString(celsius));

            //Store the fahrenheit temp in its display field.
            fahrenheitTemp.setText(String.format("%.1f",fahrenheit));
        });

        //Create panels and place the components in them.
        fpanel = new JPanel();
        fpanel.add(label1);
        fpanel.add(fahrenheitTemp);
        cpanel = new JPanel();
        cpanel.add(label2);
        cpanel.add(celsiusTemp);
        sliderPanel = new JPanel();
        sliderPanel.add(slider);

        //Create a Gridlayout manager.
        setLayout(new GridLayout(3,1));

        //Add the panels to the content pane.
        add(fpanel);
        add(cpanel);
        add(sliderPanel);


        //Pack and display frame
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TempConverter();
    }
}
