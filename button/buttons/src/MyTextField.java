import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class MyTextField extends JTextField {
    MyTextField() {
        this.setText("Pls Enter Username...");
        this.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(300, 50));
        this.setBackground(new Color(123, 50, 250));
        this.setBounds(100,85,200,30);
        this.setHorizontalAlignment(CENTER);
        this.setFont(new Font("MV Boli",Font.PLAIN,14));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getText().equals("Pls Enter Username...")) {
                    setText("");
                    setForeground(Color.WHITE);
                }
            }
        });
    }
}
