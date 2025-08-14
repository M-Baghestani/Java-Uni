import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class allahLabel extends JLabel {
    allahLabel() {
        this.setText("الله");
        this.setForeground(new Color(0, 0, 0));
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        // this.setBounds(300,300,75,75);
        this.setFont(new Font("MV Bilo", Font.BOLD, 50));

    }
}
