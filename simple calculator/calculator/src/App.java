import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        ImageIcon image = new ImageIcon("calculator.png");

        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setIconImage(image.getImage());
        frame.setBounds(500, 200, 500, 500);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 60));
        myPanel.setBackground(new Color(100, 130, 20));
        myPanel.setPreferredSize(new Dimension(500, 150));

        JTextField firstField = new JTextField();
        JTextField secondField = new JTextField();

        // First Text Field
        firstField.setText("First Number...");
        firstField.setLayout(new FlowLayout());
        firstField.setPreferredSize(new Dimension(150, 30));
        firstField.setBackground(new Color(123, 50, 250));
        firstField.setHorizontalAlignment(JTextField.CENTER);

        // Second Text Field
        secondField.setText("Second Number...");
        secondField.setLayout(new FlowLayout());
        secondField.setPreferredSize(new Dimension(150, 30));
        secondField.setBackground(new Color(123, 50, 250));
        secondField.setHorizontalAlignment(JTextField.CENTER);

        // Change Listener
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                myPanel.requestFocusInWindow();
            }
        });
        // Focus Listener

        firstField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (firstField.getText().equals("First Number...")) {
                    firstField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (firstField.getText().trim().isEmpty()) {
                    firstField.setText("First Number...");
                }
            }
        });

        secondField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (secondField.getText().equals("Second Number...")) {
                    secondField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (secondField.getText().trim().isEmpty()) {
                    secondField.setText("Second Number...");
                }
            }
        });

        JButton plusButton = new JButton();
        plusButton.setText("Plus");
        plusButton.setBackground(new Color(123, 50, 250));

        myPanel.add(firstField);
        myPanel.add(secondField);
        frame.add(myPanel);
        frame.add(plusButton);

        frame.setVisible(true);

    }
}
