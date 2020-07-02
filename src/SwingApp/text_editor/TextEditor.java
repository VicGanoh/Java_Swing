package SwingApp.text_editor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * A Simple Text Editor
 */
public class TextEditor extends JFrame {


    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextEditor();
            }
        });

    }

    //Below are the fields for the menu system
    //Beginning with the menu bar
    private JMenuBar menuBar;

    //The menus
    private JMenu fileMenu;
    private JMenu fontMenu;

    //Menu items
    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem saveAsItem;
    private JMenuItem exitItem;

    //The radio button menu items
    private JRadioButtonMenuItem monoItem;
    private JRadioButtonMenuItem serifItem;
    private JRadioButtonMenuItem sansSerifItem;

    //The checkbox menu item
    private JCheckBoxMenuItem italicItem;
    private JCheckBoxMenuItem boldItem;

    private String fileName; //to hold file name
    private JTextArea editorText; //to display text
    private final int NUM_OF_LINES = 20; //lines to display
    private final int NUM_OF_CHAR = 40; //character per line

    /**
     * Constructor
     */
    public TextEditor(){

        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error Setting" +
                    " Look and Feel.", "Error",JOptionPane.ERROR_MESSAGE);
        }

        //set the title
        setTitle("Text Editor");

        //Specify what the happens when
        //the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create text Area
        editorText = new JTextArea(NUM_OF_LINES,NUM_OF_CHAR);

        //Turn line wrapping on.
        editorText.setLineWrap(true);
        editorText.setWrapStyleWord(true);

        //Create a scroll panel and add the text area to it
        JScrollPane scrollPane = new JScrollPane(editorText);

        //Add the scroll pane to the the content pane.
        add(scrollPane);

        //Build the menu bar.
        buildMenuBar();

        //pack and display
        pack();
        setVisible(true);
    }

    /**
     The buildMenuBar method creates a menu bar and calls the createFileMenu
     method to create the file menu
     */

    private void buildMenuBar(){

        //Build the file and font menus.
        buildFileMenu();
        buildFontMenu();

        //Create the menu bar
        menuBar = new JMenuBar();

        //Add the file and font menus to the menu bar.
        menuBar.add(fileMenu);
        menuBar.add(fontMenu);

        //set the menu bar for this frame
        setJMenuBar(menuBar);
    }

    /**
     The buildFileMenu method creates the file menu and
     populates it with its menu items
     */

    private void buildFileMenu(){

        //Create the New menu item.
        newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editorText.setText("");
                fileName = null;
            }
        });

        //Create the Open Menu Item
        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int status;

                JFileChooser chooseFile = new JFileChooser();
                status = chooseFile.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION){

                    //Get a reference to the selected file.
                    File selectedFile = chooseFile.getSelectedFile();

                    //Get the path of the selected file
                    fileName = selectedFile.getPath();

                    //Open the file.
                    if (!openFile(fileName)){
                        JOptionPane.showMessageDialog(null,"Error reading" +
                                fileName,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //Create the save menu item
        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int status;

                //if user selected Save As, or the contents
                //of the editor have not been saved, use a file
                //chooser to get the file name. Otherwise, save
                //the file under the current file name.
                if (e.getSource() == saveAsItem || fileName == null){

                    JFileChooser chooser = new JFileChooser();
                    status = chooser.showSaveDialog(null);

                    if (status == JFileChooser.APPROVE_OPTION){
                        File selectedFile = chooser.getSelectedFile();

                        //Get the path of the selected file.
                        fileName = selectedFile.getPath();
                    }

                    //Save the file
                    if (!saveFile(fileName)){

                        JOptionPane.showMessageDialog(null, "Error saving"
                        + fileName, "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });

        //Create Save As menu Item
        saveAsItem = new JMenuItem("Save As");
        saveAsItem.setMnemonic(KeyEvent.VK_A);
        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int status;

                //if user selected Save As, or the contents
                //of the editor have not been saved, use a file
                //chooser to get the file name. Otherwise, save
                //the file under the current file name.
                if (e.getSource() == saveAsItem || fileName == null){

                    JFileChooser chooser = new JFileChooser();
                    status = chooser.showSaveDialog(null);

                    if (status == JFileChooser.APPROVE_OPTION){
                        File selectedFile = chooser.getSelectedFile();

                        //Get the path of the selected file.
                        fileName = selectedFile.getPath();
                    }

                    //Save the file
                    if (!saveFile(fileName)){

                        JOptionPane.showMessageDialog(null, "Error saving"
                                + fileName, "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //Create exit menu item.
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Create a menu for the items created
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        //Add items and some separator bars to the menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    }

    /**
     The saveFile method saves the contents of the text area to a file.
     The method returns true if the file was saved successfully, or false if an error
     occured.
     @param filename The name of the file.
     @return true if successful, false otherwise
     */
    private boolean saveFile(String filename){
        boolean success;
        String editorString;
        PrintWriter outputFile;

        try {
            //Open the file
            outputFile = new PrintWriter(filename);

            //Write the contents of text area
            //to the file.
            editorString = editorText.getText();
            outputFile.print(editorString);

            ///Close the file
            outputFile.close();

            //Indicate that everything went OK
            success = true;
        }
        catch (IOException e){
            //Something went wrong
            success = false;
        }
        //return our status
        return success;
    }

    /**
     The openFile method opens the file specified by
     filename and reads its contents into the text
     area. The method returns true if the file was
     opened and read successfully, or false if an
     error occurred.
     @param filename The name of the file to open
     */
    private boolean openFile(String filename){
       boolean success;
       String inputLine;
       String editorString = "";

       try{
           //Open the file
           File file = new File(filename);
           Scanner inputFile = new Scanner(file);

           //Read the file contents into the editor.
           while (inputFile.hasNext()){
              //Read a line from the file
               inputLine = inputFile.nextLine();

           //Append it to the string to display
           //in the editor
           editorString = editorString + inputLine + "\n";
       }

           //Display the String that was read from the
           //file in the editor
           editorText.setText(editorString);

           //close the file
           inputFile.close();

           //Indicate that everything went ok
           success = true;
    }
       catch (Exception e){
       //Something went wrong
           success = false;
       }

       return success;
    }

    /**
     The buildFontMenu method creates the font menu
     with its menu items
     */
    private void buildFontMenu(){

        //Create the monospaced menu item.
        monoItem = new JRadioButtonMenuItem("Monospaced");
        monoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the current font
                Font textFont = editorText.getFont();

                //Retrieve the font name and size
                String fontName = textFont.getName();
                int fontSize = textFont.getSize();

                //Start with plain style.
                int fontStyle = Font.PLAIN;

                //Determine which font is selected.
                if (monoItem.isSelected())
                    fontName = "Monospaced";

                //Determine whether Italic is selected
                if (italicItem.isSelected())
                    fontStyle += Font.ITALIC;
                //Determine whether bold is selected
                if (boldItem.isSelected())
                    fontStyle += Font.BOLD;

                //Set the font as selected.
                editorText.setFont(new Font(fontName,fontStyle,fontSize));
            }
        });

        //Create the serif menu item.
        serifItem = new JRadioButtonMenuItem("Serif");
        serifItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the current font text
                Font textFont = editorText.getFont();

                //Retrieve the font name and size
                String fontName = textFont.getName();
                int fontSize = textFont.getSize();

                //Start with plain style.
                int fontStyle = Font.PLAIN;

                //Determine which font is selected.
                if (serifItem.isSelected())
                    fontName = "Serif";

                //Determine whether Italic is selected
                if (italicItem.isSelected())
                    fontStyle += Font.ITALIC;
                //Determine whether bold is selected
                if (boldItem.isSelected())
                    fontStyle += Font.BOLD;

                //Set the font as selected.
                editorText.setFont(new Font(fontName,fontStyle,fontSize));
            }
        });

        //Create the SansSerif menu item.
        sansSerifItem = new JRadioButtonMenuItem("SansSerif",true);
        sansSerifItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get the current font text
                Font textFont = editorText.getFont();

                //Retrieve the font name and size
                String fontName = textFont.getName();
                int fontSize = textFont.getSize();

                //Start with plain style.
                int fontStyle = Font.PLAIN;

                //Determine which font is selected.
                if (sansSerifItem.isSelected())
                    fontName = "SansSerif";

                //Determine whether Italic is selected
                if (italicItem.isSelected())
                    fontStyle += Font.ITALIC;
                //Determine whether bold is selected
                if (boldItem.isSelected())
                    fontStyle += Font.BOLD;

                //Set the font as selected.
                editorText.setFont(new Font(fontName,fontStyle,fontSize));
            }
        });

        //Group the radio button menu items.
        ButtonGroup group = new ButtonGroup();
        group.add(monoItem);
        group.add(serifItem);
        group.add(sansSerifItem);

        //Create the Italic menu item
        italicItem = new JCheckBoxMenuItem("Italic");
        italicItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the current font text
                Font textFont = editorText.getFont();

                //Retrieve the font name and size
                String fontName = textFont.getName();
                int fontSize = textFont.getSize();

                //Start with plain style.
                int fontStyle = Font.PLAIN;

                //Determine which font is selected.
                if (monoItem.isSelected())
                    fontName = "Monospaced";
                else if (serifItem.isSelected())
                    fontName = "Serif";
                else if (serifItem.isSelected())
                    fontName = "Serif";

                //Determine whether Italic is selected
                if (italicItem.isSelected())
                    fontStyle += Font.ITALIC;

                //Determine whether bold is selected
                if (boldItem.isSelected())
                    fontStyle += Font.BOLD;

                //Set the font as selected.
                editorText.setFont(new Font(fontName,fontStyle,fontSize));
            }
        });

        //Create the bold menu item
        boldItem = new JCheckBoxMenuItem("Bold");
        boldItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the current font text
                Font textFont = editorText.getFont();

                //Retrieve the font name and size
                String fontName = textFont.getName();
                int fontSize = textFont.getSize();

                //Start with plain style.
                int fontStyle = Font.PLAIN;

                //Determine which font is selected.
                if (monoItem.isSelected())
                    fontName = "Monospaced";
                else if (serifItem.isSelected())
                    fontName = "Serif";
                else if (serifItem.isSelected())
                    fontName = "Serif";

                //Determine whether Italic is selected
                if (italicItem.isSelected())
                    fontStyle += Font.ITALIC;

                //Determine whether bold is selected
                if (boldItem.isSelected())
                    fontStyle += Font.BOLD;

                //Set the font as selected.
                editorText.setFont(new Font(fontName,fontStyle,fontSize));
            }
        });

        //Create a menu for the items we just created.
        fontMenu = new JMenu("Font");
        fontMenu.setMnemonic(KeyEvent.VK_T);

        //Add the items and some separator bars to the menu
        fontMenu.add(monoItem);
        fontMenu.add(serifItem);
        fontMenu.add(sansSerifItem);
        fontMenu.addSeparator(); //separator bar
        fontMenu.add(italicItem);
        fontMenu.add(boldItem);


    }


}
