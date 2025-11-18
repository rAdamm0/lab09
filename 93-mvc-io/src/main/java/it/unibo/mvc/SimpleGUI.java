package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

    private final JFrame frame = new JFrame();
    private final int PROPORTION = 5;

    private final Controller control = new SimpleController();

    public SimpleGUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canva = new JPanel();
        canva.setLayout(new BorderLayout());

        frame.setContentPane(canva);

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        JTextField messageField = new JTextField();

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());

        JButton print = new JButton("Print");
        JButton history = new JButton("Show History");

        buttons.add(print, BorderLayout.CENTER);
        buttons.add(history, BorderLayout.LINE_END);

        canva.add(historyArea);
        canva.add(messageField, BorderLayout.NORTH);
        canva.add(buttons, BorderLayout.SOUTH);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.setMessage(messageField.getText());
                try {
                    control.printOUt();
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(canva, ex.getMessage(),
                            "Error in the message ", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = String.join("\n", control.getHistory());
                historyArea.setText(text);

            }
        });

    }

    public void display() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = (int) screenSize.width / PROPORTION;
        int sh = (int) screenSize.height / PROPORTION;

        frame.setSize(sw, sh);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
