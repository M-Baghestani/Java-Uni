import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {

    private JFrame frame;
    private JPanel panel;
    private JLabel username, password, login;
    private JTextField userField;
    private JPasswordField passField;
    private JButton btn;

    public App() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);

        userField = new JTextField(20);
        userField.setHorizontalAlignment(JTextField.CENTER);

        passField = new JPasswordField(20);
        passField.setHorizontalAlignment(JTextField.CENTER);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // login label
        login = new JLabel("Login");
        login.setFont(new Font("MV Boli", Font.PLAIN, 36));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(login, gbc);
        gbc.gridwidth = 1;

        gbc.fill = GridBagConstraints.BOTH;

        // Username customize
        gbc.insets = new Insets(150, 10, 10, 10);

        username = new JLabel("Username : ");
        username.setFont(new Font("MV Boli", Font.PLAIN, 24));

        // Password customize

        password = new JLabel("Password : ");
        password.setFont(new Font("MV Boli", Font.PLAIN, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(username, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userField, gbc);

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passField, gbc);

        btn = new JButton("Login");
        btn.setPreferredSize(new Dimension(200, 40));
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btn.setFont(new Font("MV Boli",Font.PLAIN,24));

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;

        btn.addActionListener(e -> submit());

        panel.add(btn, gbc);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);

    }
    public void submit() {
        if (userField.getText().equals("") && passField.getPassword().length == 0){
            JOptionPane.showMessageDialog(frame, "Wrong Input!");
        } else {
            JOptionPane.showMessageDialog(frame, "Welcome", "Logged In", 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
