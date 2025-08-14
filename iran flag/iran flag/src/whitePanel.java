import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class whitePanel extends JPanel {
    whitePanel() {
        this.setBackground(new Color(255, 255, 255));
        this.setBounds(0, 200, 500, 200);
        this.setLayout(new BorderLayout());
        this.add(new allahLabel());
    }

}
