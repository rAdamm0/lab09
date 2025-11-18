package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    /* Global fields creation */
    private final Controller control = new Controller();

    private final int PROPORTION = 5;

    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        /* JFrame finalization */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My first java graphical interface");
        /* JPanel Creation */
        JPanel canva = new JPanel();
        frame.setContentPane(canva);
        canva.setLayout(new BorderLayout());

        /* JTextArea and Button Creation */
        JTextArea textArea = new JTextArea();
        JButton saveBtn = new JButton("Save");
        canva.add(textArea);
        canva.add(saveBtn, BorderLayout.SOUTH);

        /* Implementation of the JButton */
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                saveBtn.setEnabled(false);
                control.writeToFile(textArea.getText());
                System.out.println("Text written succesfully");
                saveBtn.setEnabled(true);
            }
        });

    }

    public void display() {
        /* Makes the displayed window to a 5th of the Screen */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screenSize.getWidth() / PROPORTION;
        final int sh = (int) screenSize.getHeight() / PROPORTION;
        frame.setSize(sw, sh);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
