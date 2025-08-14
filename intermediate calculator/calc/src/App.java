import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    private JFrame frame;
    private JTextField textField;
    private String operator;
    private double number1, number2;

    public App() {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Calculator");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("MV Boli", Font.PLAIN, 24));

        JPanel panel = new JPanel();

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+",
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("MV Boli", Font.PLAIN, 24));
            button.setBackground(new Color(123, 50, 250));
            button.setForeground(new Color(255, 255, 255));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        panel.setLayout(new GridLayout(4, 4));

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    public class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                textField.setText(textField.getText() + command);
            } else if (command.equals("C")) {
                textField.setText("");
                operator = "";
                number1 = number2 = 0;
            } else if (command.equals("=")) {
                number2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+" -> textField.setText(String.valueOf(number1 + number2));
                    case "-" -> textField.setText(String.valueOf(number1 - number2));
                    case "*" -> textField.setText(String.valueOf(number1 * number2));
                    case "/" -> textField.setText(String.valueOf(number1 / number2));
                }
                operator = "";
            } else {
                operator = command;
                number1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
