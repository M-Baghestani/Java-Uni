import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

        plusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstField.getText().trim());
                int secondNumber = Integer.parseInt(secondField.getText().trim());
                JOptionPane.showMessageDialog(plusButton, "Your Result : "+(firstNumber+secondNumber));
            }
            
        });

        JButton minusButton = new JButton();
        minusButton.setText("Minus");
        minusButton.setBackground(new Color(123, 50, 250));

        minusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstField.getText().trim());
                int secondNumber = Integer.parseInt(secondField.getText().trim());
                JOptionPane.showMessageDialog(minusButton, "Your Result : "+(firstNumber-secondNumber));
            }
            
        });

        JButton multiButton = new JButton();
        multiButton.setBackground(new Color(123,50,250));
        multiButton.setText("Multiple");

        multiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstField.getText());
                int secondNumber = Integer.parseInt(secondField.getText());
                JOptionPane.showMessageDialog(multiButton, "Your Result : "+(firstNumber*secondNumber));
            }
        });

        JButton divideButton = new JButton("Divide");
        divideButton.setBackground(new Color(123,50,250));

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int secondNumber = Integer.parseInt(secondField.getText());

                if(secondNumber == 0){
                    JOptionPane.showMessageDialog(divideButton, "Error: Divided by Zero", "Error", 0);
                } else {
                    int firstNumber = Integer.parseInt(firstField.getText());
                    double result = (double) firstNumber/secondNumber;
                    JOptionPane.showMessageDialog(divideButton, "Your Result : "+ result, "Result", 1);
                }
            }
        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(plusButton);
        buttonsPanel.add(minusButton);
        buttonsPanel.add(multiButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.setLayout(new GridLayout(2,2));
        buttonsPanel.setPreferredSize(new Dimension(500,300));

        myPanel.add(firstField);
        myPanel.add(secondField);
        frame.add(myPanel);
        frame.add(buttonsPanel);

        frame.setVisible(true);

    }
}
