import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    private Canvas canvas;

    Display(int width, int height) {

        setTitle("Bee Display");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        Rectangle rectangle = game.getRectangle();
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int) rectangle.getX(), (int) rectangle.getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());

        graphics.dispose();
        bufferStrategy.show();
    }
}
