import javax.swing.JFrame;

public class myFrame extends JFrame {
    myFrame() {
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Iran's Flag");
        this.setLayout(null);
        this.setResizable(false);
        this.add(new greenPanel());
        this.add(new redPanel());
        this.add(new whitePanel());

        this.setVisible(true);
    }
}
