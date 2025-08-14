import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyFrame() {
        ImageIcon image = new ImageIcon("logo.jpg");
        this.setSize(480, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Application");
        this.setResizable(false);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(123, 50, 250));
        FirstLabel f_Label = new FirstLabel();
        this.add(f_Label);
        this.pack();
        this.setVisible(true);

    }
}
