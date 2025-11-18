package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;

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

    /* Global fields creation */
    private final Controller control = new Controller();

    private final int PROPORTION = 5;

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
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

        /* File Choosing EXERCISE */

        /* Creation of new components */
        JPanel browsing = new JPanel();
        browsing.setLayout(new BorderLayout());
        JTextField pathField = new JTextField(control.getPath());
        pathField.setEditable(false);
        JButton browseBtn = new JButton("Browse");

        browsing.add(pathField, BorderLayout.CENTER);
        browsing.add(browseBtn, BorderLayout.LINE_END);
        /* Insertion of new components in GUI */
        canva.add(browsing, BorderLayout.NORTH);

        /* Implementation of the browseBtn */
        browseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored) {
                try {
                    JFileChooser fc = new JFileChooser();
                    int sf = fc.showDialog(browseBtn, null);
                    if (sf == JFileChooser.APPROVE_OPTION) {
                        control.setFile(fc.getSelectedFile());
                        pathField.setText(control.getPath());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        new SimpleGUIWithFileChooser().display();
    }

}
