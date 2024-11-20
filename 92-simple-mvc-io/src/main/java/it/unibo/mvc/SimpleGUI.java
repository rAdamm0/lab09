package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final String TITLE = "My first graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final int PROPORTION = 3;
    
    public SimpleGUI(){
        JPanel canva = new JPanel(new BorderLayout());
        JButton save = new JButton("Save");
        JTextArea text = new JTextArea();
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canva.add(save,BorderLayout.SOUTH);
        canva.add(text);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Controller co = new Controller();
                co.saveString(text.getText());
            }
            
        });
    }
    

    private void display(){
        final Dimension ss =  Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int)ss.getWidth();
        final int sh = (int)ss.getHeight();
        frame.setSize(sw/this.PROPORTION, sh/this.PROPORTION);
        //frame.pack();

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(final String... args){
        new SimpleGUI().display();
    }
}


