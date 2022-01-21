import java.awt. *;
import javax.swing. *;
import java.awt.event. *;

/**
 * @Title Koch snowflake
 * @Author Sun Kun
 * @Date 2013-11-23
 * @At XUST
 * @All Copyright by Sun Kun
 *
 */
public class Snowflake2 extends JFrame {//Koch snowflake overall design
    private final static int WIDTH = 600;
    private final static int HEIGHT = 700;
    private final static int MIN_DEPTH = 0;//minimum recursion depth
    private Color color = Color.BLUE;

    private JButton increaseDepthJButton;//Increase recursive depth button
    private JButton decreaseDepthJButton;//decrease the recursion depth button
    private JButton setColorJButton;//Set color button
    private JPanel mainJPanel;
    private JPanel controlJPanel;
    private Snowflake2  drawSpace;//An object of Koch snowflake fractal concrete algorithm class
    private JLabel depthJLabel;//record the recursive depth of the label

    public Snowflake2 () {

        //add title
        super ("Koch snowflake");

        //Add button
        controlJPanel = new JPanel ();
        setColorJButton = new JButton ("Set color");
        increaseDepthJButton = new JButton ("Increase recursion depth");
        decreaseDepthJButton = new JButton ("decrease recursion depth");
        controlJPanel.add (setColorJButton);
        controlJPanel.add (increaseDepthJButton);
        controlJPanel.add (decreaseDepthJButton);



        depthJLabel = new JLabel ("depth: 0");
        controlJPanel.add (depthJLabel);


        mainJPanel = new JPanel ();
        mainJPanel.setLayout (new BorderLayout ());
        mainJPanel.add (controlJPanel, BorderLayout.NORTH);

        add (mainJPanel);
        setSize (WIDTH, HEIGHT);
        setVisible (true);
    }

    public static void main (String args []) {
        Snowflake2 sf2 = new Snowflake2();
        sf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}