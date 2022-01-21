import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class Mandelbrot extends JFrame {
    public final int WIDTH = 800;
    public final int HEIGHT = 600;
    public final int ITERATIONS = 100;
    public static final float SCALE = 250;

    private float hueOffSet = 0;

    private BufferedImage buffer;

    public Mandelbrot() {

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        JFrame frame = new JFrame("Mandelbrot Set");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
//        this.setContentPane();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void addNotify() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(buffer, 0,0, null);
    }

    public void renderMandelbrotSet() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {

                int color = calculatePoint((x - WIDTH/2f)/SCALE, (y - WIDTH/2f)/SCALE);

                buffer.setRGB(x, y , color);

            }
        }
    }

    public int calculatePoint(float x, float y){
        float cx = x;
        float cy = y;

        int i = 0;

        for (; i < ITERATIONS; i++) {

            float nx = x * x - y * y + cx;
            float ny = 2 * x * y + cy;
            x = nx;
            y = ny;

            if (x * x + y * y < 4)
                break;
        }

        if (i == ITERATIONS)
            return 0x00000000;
        return Color.HSBtoRGB(((float)i / ITERATIONS + hueOffSet), 0.5f, 1);
    }


    public static void main(String[] args) {
        Mandelbrot mb = new Mandelbrot();
    }

}

