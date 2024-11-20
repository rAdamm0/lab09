package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final String TITLE = "My second java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final int PROPORTION = 3;
    private Controller co = new Controller();

    public SimpleGUIWithFileChooser(){
        /*Creates the general Panel to put on frame */
        JPanel canva = new JPanel(new BorderLayout());
        /*Creates a secondary Panel to handle the file search and PATH display output */
        JPanel search = new JPanel(new BorderLayout());
        JButton browse = new JButton("Browse...");
        JTextField filePath = new JTextField(co.getPATH());
        filePath.setEditable(false);
        search.add(filePath,BorderLayout.CENTER);
        search.add(browse, BorderLayout.LINE_END);

        /*Action of the button choose, opens a pop up window to select a file in the home folder */
        JFileChooser choose = new JFileChooser();
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int retVal = choose.showSaveDialog(browse);
                if( retVal == JFileChooser.APPROVE_OPTION){
                    co.setFile(choose.getSelectedFile().getName());
                    filePath.setText(co.getPATH());
                }
                if(retVal == JFileChooser.CANCEL_OPTION){

                }
                if(retVal==JFileChooser.ERROR_OPTION){
                    JOptionPane.showMessageDialog(search, "Error has occured", "ERROR:", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        /*Creates the area of the gui that controls the text input an saves it in the file */
        JPanel textToSave = new JPanel(new BorderLayout());
        JTextArea text = new JTextArea();
        JButton save = new JButton("Save");
        textToSave.add(text);
        textToSave.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                co.saveString(text.getText());
            }
            
        });

        /*Adds the 2 secondary panels to the main one  */
        canva.add(search,BorderLayout.NORTH);
        canva.add(textToSave);

        /*Set the main panel as the displayed */
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        
        final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int sh = (int)ss.getHeight();
        int sw = (int)ss.getWidth();
        frame.setSize(sw / this.PROPORTION, sh / this.PROPORTION);

        //frame.pack();
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main (String... args){
        new SimpleGUIWithFileChooser().display();
    }
}
