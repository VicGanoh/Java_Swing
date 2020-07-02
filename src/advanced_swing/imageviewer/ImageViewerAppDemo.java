package advanced_swing.imageviewer;

import advanced_swing.JListDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class ImageViewerAppDemo extends JFrame {

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageViewerAppDemo();
            }
        });
    }



    private JMenuBar menuBar; //to hold menu bar
    private JMenu fileMenu; //to hold file menu
    private JMenuItem uploadImageMenuItem; //to hold an image
    private JMenuItem exitMenuItem; //exit
    private JFileChooser fileChooser; //to hold a file

    /**
     * Constructor
     */
    public ImageViewerAppDemo(){


       try{

           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           SwingUtilities.updateComponentTreeUI(this);

           setSize(500,500);

            //Set the title
            setTitle("Image Viewer");

            //specify an action for close button
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           //add built menu bar to content pane
           buildMenuBar();

            //pack and display window
           pack();
           setVisible(true);


       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error setting " +
                    "Look and Feel.","Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
       }

    }


    /**
     The method buildMenuBar build the menu and adds
     its menu item
     */
    private void buildMenuBar(){
        //Create menu bar
        menuBar = new JMenuBar();

        //Create the file menu
        buildFileMenu();

        //add file menu to menu bar
        menuBar.add(fileMenu);


        //set the windows menu bar
        setJMenuBar(menuBar);

    }

    /**
     * The buildFileMenu method build the file menu
     * and returns a reference to its JMenu object
     */
    private void buildFileMenu(){
        //create the file menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        //create fileChooser
        fileChooser = new JFileChooser();

        //Create the exit and image
        uploadImageMenuItem = new JMenuItem("Upload and View Image");
        uploadImageMenuItem.setMnemonic(KeyEvent.VK_U);
        uploadImageMenuItem.addActionListener( e -> {
            int status;
            String filename;
            ImageIcon imageIcon = new ImageIcon();
            status = fileChooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                filename = selectedFile.getPath();

                JOptionPane.showMessageDialog(null,"You selected " +
                        filename);

            }

        });


        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.addActionListener( e -> {

                System.exit(0);
        });

        //add menu item to file menu
        fileMenu.add(uploadImageMenuItem);
        fileMenu.addSeparator(); //space components out
        fileMenu.add(exitMenuItem);

    }

}
