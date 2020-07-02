package SwingApp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/*
    The BagelPanel class allows the user to select either a white or
    whole wheat bagel
 */

public class BagelPanel extends JPanel {

    //The following constants are used to
    // indicate the cost of each type of bagel.
    public final double WHITE_BAGEL = 1.25;
    public final double WHEAT_BAGEL = 1.50;

    private JRadioButton whiteBagel; //to select white
    private JRadioButton wheatBagel; //to select wheat
    private ButtonGroup buttonGroup; //Radio button group

    /*
    Constructor
     */
    public BagelPanel(){
        //Create a gridlayout manager with
        // two rows and one column;
        setLayout(new GridLayout(2,1));

        //Create radio buttons
        whiteBagel = new JRadioButton("White", true);
        wheatBagel = new JRadioButton("Wheat");

        //Group radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(whiteBagel);
        buttonGroup.add(wheatBagel);

        //add a border around the panel
        setBorder(BorderFactory.createTitledBorder("Bagel"));

        //add radio buttons to the panel
        add(whiteBagel);
        add(wheatBagel);
    }

    /**
     * getBagelCost method
     * @return The cost of the selected bagel
     */
    public double getBagelCost(){
        double bagelCost = 0.0;

        if (whiteBagel.isSelected())
            bagelCost = WHITE_BAGEL;
        else
            bagelCost = WHEAT_BAGEL;

        return bagelCost;

    }
}
