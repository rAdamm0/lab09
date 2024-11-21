package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

    private final String TITLE = "Model-View-Controller";

    private final JFrame frame = new JFrame(TITLE);
    private final int PROPORTION = 3; 
    
    public SimpleGUI(){
        final SimpleController control = new SimpleController();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel canvas = new JPanel(new BorderLayout());
        frame.setContentPane(canvas);
        
        final JTextField field = new JTextField(300);
        final JTextArea history = new JTextArea();
        history.setEditable(false);

        final JPanel buttons = new JPanel(new BorderLayout());
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        buttons.add(print);
        buttons.add(showHistory,BorderLayout.WEST);

        canvas.add(field,BorderLayout.NORTH);
        canvas.add(history,BorderLayout.CENTER);
        canvas.add(buttons,BorderLayout.SOUTH);

        

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                control.setNextString(field.getText());
                control.currentString();
            }
            
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0){
                for(String s : control.history()){
                    history.append(s);
                    history.append("\n");
                }
            }
        });
    }

    public void display(){

        frame.pack();

        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = (int)ss.getWidth();
        int sh = (int)ss.getHeight();
        frame.setSize(sw/this.PROPORTION,sh/this.PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String... args){
        new SimpleGUI().display();
    }

}
