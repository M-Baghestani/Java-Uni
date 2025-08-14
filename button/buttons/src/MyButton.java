import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyButton extends JButton implements ActionListener {
    private MyTextField myField;

    MyButton(MyTextField field) {
        this.myField = field;
        this.setText("Login");
        this.setFont(new Font("MV Boli", Font.PLAIN, 14));
        this.setBounds(150, 150, 100, 40);
        this.setBackground(new Color(60, 75, 230));
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = myField.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pls Enter Your Username");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome!");
        }
    }
}
