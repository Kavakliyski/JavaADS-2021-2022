import javax.swing.*;
import java.awt.*;

public class Snowflake4 extends JFrame {
    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;
    private final Color color = Color.BLUE;

    private JPanel mainJPanel;
    private JPanel controlJPanel;


    private JLabel Depth;
    private JLabel Size;
    private JLabel SidesCount;

    private JTextField txtDepth;
    private JTextField txtSize;
    private JTextField txtNumberOfSides;

    private JButton btnClear;
    private JButton btnDraw;


    Snowflake4() {
        super("Kill me");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        this.setContentPane();

        controlJPanel = new JPanel();
//        setColorJBu
        controlJPanel.add(Depth);
        Depth = new JLabel("Depth: ");
        controlJPanel.add(Depth);
    }

    public static void main(String[] args) {
        Snowflake4 sf4 = new Snowflake4();
    }
}
