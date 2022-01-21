import javax.swing.*;
import java.awt.*;

public class Snowflake3 extends JFrame{
    private JPanel panel1;
    private JPanel pnlCommand;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JPanel MainPanel;
    private JPanel pnlCanvas;

    public Snowflake3() {
        super("Снежинка");
        MainPanel.setSize(new Dimension(600, 400));
        pnlCanvas.setPreferredSize(new Dimension(600, 400));
        pnlCommand.setPreferredSize(new Dimension(600, 400));

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setContentPane(MainPanel);


    }

    public static void main(String[] args) {
        Snowflake3 sf3 = new Snowflake3();
    }
}
