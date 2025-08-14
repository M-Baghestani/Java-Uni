import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyFrame() {

        ImageIcon image = new ImageIcon("login.jpg");
        this.setTitle("Login Page");
        this.setIconImage(image.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(600, 150, 400, 400);

        this.add(new MyLabel());
        this.add(new MyTextField());
        this.add(new MyButton(new MyTextField()));
        this.setVisible(true);
    }
}
