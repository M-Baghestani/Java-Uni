import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

    JTextField ta, tb;
    JLabel lc;

    public App() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.add(new JLabel("a"));
        ta = new JTextField(15);
        panel.add(ta);
        panel.add(new JLabel("b"));
        tb = new JTextField(15);
        panel.add(tb);

        JButton btn = new JButton("GCD");
        panel.add(btn);
        btn.addActionListener(this);
        lc = new JLabel("");
        panel.add(lc);
        frame.setSize(200, 300);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(ta.getText());
        int b = Integer.parseInt(tb.getText());
        int c = gcd(a, b);
        lc.setText(c + "");

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
