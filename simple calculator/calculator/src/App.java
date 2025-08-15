import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.StrokeBorder;

public class App implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private String operator;
    private double number1;
    private double number2;

    public App() throws FontFormatException, IOException {
        Font customFont = Font
                .createFont(Font.TRUETYPE_FONT,
                        new File("G:\\Java Uni\\simple calculator\\calculator\\Folktale.ttf"))
                .deriveFont(28f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
        ImageIcon image = new ImageIcon("G:\\Java Uni\\simple calculator\\calculator\\calculator.png");

        frame = new JFrame();
        frame.setTitle(("Calculator"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(image.getImage());
        textField = new JTextField();
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(0, 80));
        frame.add(textField, BorderLayout.NORTH);
        panel = new JPanel();
        // Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        // textField.setBorder(border);
        textField.setFont(customFont);
        textField.setBackground(new Color(255, 248, 230));
        textField.setForeground(new Color(87, 75, 67));

        String[][] buttons = {
                { "7", "8", "9", "/", },
                { "4", "5", "6", "*", },
                { "1", "2", "3", "-", },
                { "0", "C", "=", "+", },
        };

        // for (String text : buttons) {
        // JButton button = new JButton(text);
        // button.setFont(new Font("Arial", Font.PLAIN, 24));
        // button.addActionListener(this);
        // panel.add(button);
        // }
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        float[] dashPattern = { 2f, 2f };
        Stroke dashed = new BasicStroke(
                1f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10f,
                dashPattern,
                0f);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                JButton btn = new JButton(buttons[row][col]);
                // btn.setFont(new Font("Jake Stencil Thin", Font.PLAIN, 32));

                btn.setFont(customFont);

                btn.setBackground(new Color(255, 248, 230));
                btn.setForeground(new Color(87, 75, 67));
                btn.setBorder(new StrokeBorder((BasicStroke) dashed, new Color(150, 131, 120)));
                btn.addActionListener(this);
                panel.add(btn, gbc);
            }
        }

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            number1 = number2 = 0;
            textField.setText("");
            operator = "";
        } else if (command.equals("=")) {
            number2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+" -> textField.setText(String.valueOf(number1 + number2));
                case "-" -> textField.setText(String.valueOf(number1 - number2));
                case "/" -> textField.setText(String.valueOf(number1 / number2));
                case "*" -> textField.setText(String.valueOf(number1 * number2));
            }
            operator = "";
        } else {
            operator = command;
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");

        }
    }

    public static void main(String[] args) throws FontFormatException, IOException {
        new App();
    }
}