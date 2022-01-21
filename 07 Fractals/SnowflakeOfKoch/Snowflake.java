import javax.swing.*;
import java.awt.*;

public class Snowflake extends JFrame{
    private JPanel pnlCanvas;
    private JButton buttonClear;
    private JButton buttonDraw;
    private JTextField textFieldDepth;
    private JTextField textFieldSize;
    private JTextField textFieldNumberOfSides;
    private JPanel JPanelMain;
    private JButton buttonPolygon;
    private JButton buttonFlake;

    Snowflake() {
        super("Снежинка на Кох");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setContentPane(JPanelMain);
        pnlCanvas.setSize(800, 600);
        pnlCanvas.setPreferredSize(new Dimension(800, 600));
        this.pack();


        buttonClear.addActionListener(e -> {
            Graphics g = pnlCanvas.getGraphics();
            Color bgrColor = new Color(0, 0, 100);
            pnlCanvas.setBackground(bgrColor);
            pnlCanvas.repaint();

            textFieldDepth.setText("1");
            textFieldSize.setText("1");
            textFieldNumberOfSides.setText("1");
        });


        buttonDraw.addActionListener(e -> {
            try {
                // input data
                String strLevel = textFieldDepth.getText();
                int level = Integer.parseInt(strLevel);
                String strSize = textFieldSize.getText();
                int size = Integer.parseInt(strSize);
                String strN = textFieldNumberOfSides.getText();
                int n = Integer.parseInt(strN);

                // panel's params
                Graphics g = pnlCanvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                int w = pnlCanvas.getWidth();
                int h = pnlCanvas.getHeight();

                GradientPaint grCol = new GradientPaint(0, h, Color.red, w, 0, Color.green);
                g2d.setPaint(grCol);

                Stroke lineStyle = new BasicStroke(3);
                g2d.setStroke(lineStyle);

                polyFlake(g2d, n, size, level);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Попълни внимателно всички полета.", "Грешка!", JOptionPane.ERROR_MESSAGE);
                textFieldDepth.setText("");
                textFieldSize.setText("");
                textFieldNumberOfSides.setText("");
                textFieldDepth.grabFocus();
            }
        });

        buttonFlake.addActionListener(e -> {
            try {
                // input data
                String strLevel = textFieldDepth.getText();
                int level = Integer.parseInt(strLevel);
                String strSize = textFieldSize.getText();
                int size = Integer.parseInt(strSize);
                String strN = textFieldNumberOfSides.getText();
                int n = Integer.parseInt(strN);

                // panel's params
                Graphics g = pnlCanvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                int w = pnlCanvas.getWidth();
                int h = pnlCanvas.getHeight();

                GradientPaint grCol = new GradientPaint(0, h, Color.red, w, 0, Color.green);
                g2d.setPaint(grCol);

                Stroke lineStyle = new BasicStroke(3);
                g2d.setStroke(lineStyle);

//                g2d.drawLine(0, h, w, 0); // testov
                flake(level, 0, h, w, 0, g2d);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Попълни внимателно всички полета.", "Грешка!", JOptionPane.ERROR_MESSAGE);
                textFieldDepth.setText("");
                textFieldSize.setText("");
                textFieldNumberOfSides.setText("");
                textFieldDepth.grabFocus();
            }
        });

        buttonPolygon.addActionListener(e -> {
            try {
                // input data
                String strLevel = textFieldDepth.getText();
                int level = Integer.parseInt(strLevel);
                String strSize = textFieldSize.getText();
                int size = Integer.parseInt(strSize);
                String strN = textFieldNumberOfSides.getText();
                int n = Integer.parseInt(strN);

                // panel's params
                Graphics g = pnlCanvas.getGraphics();
                Graphics2D g2d = (Graphics2D) g;
                int w = pnlCanvas.getWidth();
                int h = pnlCanvas.getHeight();

                GradientPaint grCol = new GradientPaint(0, h, Color.red, w, 0, Color.green);

                g2d.setPaint(grCol);

                Stroke lineStyle = new BasicStroke(3);
                g2d.setStroke(lineStyle);

                polygon(g2d, n, size);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Попълни внимателно всички полета.", "Грешка!", JOptionPane.ERROR_MESSAGE);
                textFieldDepth.setText("");
                textFieldSize.setText("");
                textFieldNumberOfSides.setText("");
                textFieldDepth.grabFocus();
            }
        });
    }

    private void flake(int level, double x0, double y0, double x1, double y1, Graphics2D g2d){
        if (level == 1){
            g2d.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
            return;
        }

        double x2 = (2 * x0 + x1) / 3;
        double y2 = (2* y0 + y1) / 3;

        double x3 = (x0 + 2 * x1) / 3;
        double y3 = (y0 + 2 * y1) / 3;


        double x = x3 - x2;
        double y = y3 - y2;
        double x4 = x2 + x * Math.cos(-Math.PI / 3) - y * Math.sin(-Math.PI / 3);
        double y4 = y2 + x * Math.sin(-Math.PI / 3) + y * Math.cos(-Math.PI / 3);


        flake(level - 1, x0, y0, x2, y2, g2d);
        flake(level - 1, x2, y2, x4, y4, g2d);
        flake(level - 1, x4, y4, x3, y3, g2d);
        flake(level - 1, x3, y3, x1, y1, g2d);
    }


    private void polygon(Graphics2D g2d, int n, int size){
        // Център на фигурата - съвпада с центъра на панела
        double xCenter = pnlCanvas.getWidth() /2;
        double yCenter = pnlCanvas.getHeight() /2;

        // R - size
        // Кординати на точка A
        double x0 = xCenter + size;
        double y0 = yCenter;

        // Запазване на предходната точка
        double x1 = x0;
        double y1 = y0;
        double x2;
        double y2;
        double alpha = 2 * Math.PI / n;

        for (double fi = 0; fi <= 2 * Math.PI; fi += alpha){
            x2 = xCenter + size * Math.cos(fi);
            y2 = yCenter + size * Math.sin(fi);
            g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            x1 = x2;
            y1 = y2;
        }

        g2d.drawLine((int) x1, (int) y1, (int) x0, (int) y0);
    }


    private void polyFlake(Graphics2D g2d, int n, int size, int level){
        double xCenter = pnlCanvas.getWidth() /2;
        double yCenter = pnlCanvas.getHeight() /2;

        double x0 = xCenter + size;
        double y0 = yCenter;

        double x1 = x0;
        double y1 = y0;
        double x2;
        double y2;
        double alpha = 2 * Math.PI / n;

        for (double fi = 0; fi <= 2 * Math.PI; fi += alpha){
            x2 = xCenter + size * Math.cos(fi);
            y2 = yCenter + size * Math.sin(fi);

            flake(level, x1, y1, x2, y2, g2d);
            x1 = x2;
            y1 = y2;
        }

        flake(level, x1, y1, x0, y0, g2d);
    }


    public static void main (String[]args){
        Snowflake flake = new Snowflake();

    }

}