import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class FirstLabel extends JLabel {
    FirstLabel() {
        ImageIcon image = new ImageIcon("logo.jpg");
        Image originalImage = image.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imageScaled = new ImageIcon(originalImage);

        Border border = BorderFactory.createLineBorder(new Color(235, 130, 30), 3);

        this.setText("Hi! My Name Is Mohammad");
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setIcon(imageScaled);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setBorder(border);

        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
