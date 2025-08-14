import java.awt.Color;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
    MyLabel() {
        this.setText("Login Form");
        this.setForeground(new Color(150, 23, 230));
        this.setBounds(170,15,80,80);
    }
}
