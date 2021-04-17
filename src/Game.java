import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static int WIDTH = 1400;
    public static int HEIGHT = 800;

    private Thread thread;
    private boolean running = false;

    private final ShotTheBox stb = new ShotTheBox();
    private final MouseInput mouseInput;
    private final GameDesign gameDesign = new GameDesign();

    private boolean waiting = true;


    public Game() {
        int sum = stb.startGame();
        mouseInput = new MouseInput(sum);

        this.addMouseListener(mouseInput);


        new Window(WIDTH, HEIGHT, "Shot The Box", this);

    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tick() {

        if (waiting) {
            boolean found = mouseInput.checkInputValue();
//            if (found) {
//            tools.d(found);
//            }
            if (found) {
                waiting = false;
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;


        gameDesign.render(g2d, g);


        g.dispose();
        bs.show();
    }


    public static void main(String[] args) {
        new Game();
    }
}
