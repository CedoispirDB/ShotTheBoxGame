import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Font;


public class GameDesign {

    private boolean choose = false;

    private MouseInput mouseInput = new MouseInput(0);


    public GameDesign() {

    }

    public void render(Graphics2D g2d, Graphics g) {

        //Box
        g2d.setColor(Color.BLACK);
        float thickness = 3;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRect(261, 90, (Game.WIDTH - 260 * 2) - 1, Game.HEIGHT - 90 * 2);
        g2d.setStroke(oldStroke);


        // Numbers
        Color BiancaColor = new Color(159, 226, 191);
        Font fnt = new Font("arial", Font.BOLD, 70);

        int x = 168;
        int n = 1;

//        tools.d("option[0]: " + option[0]);

        g.setColor(Color.BLACK);
        g.setFont(fnt);

        tools.d("Option 1: " + mouseInput.option(0));

        if (mouseInput.option(0)) {
            g.drawString("1", x + 125, 165);
        }
        if (mouseInput.option(1)) {
            g.drawString("2", x + 125, 165);
        }
        if (mouseInput.option(2)) {
            g.drawString("3", x + 125, 165);
        }
        if (mouseInput.option(3)) {
            g.drawString("4", x + 125, 165);
        }
        if (mouseInput.option(4)) {
            g.drawString("5", x + 125, 165);
        }
        if (mouseInput.option(5)) {
            g.drawString("6", x + 125, 165);
        }
        if (mouseInput.option(6)) {
            g.drawString("7", x + 125, 165);
        }
        if (mouseInput.option(7)) {
            g.drawString("8", x + 125, 165);
        }
        if (mouseInput.option(8)) {
            g.drawString("9", x + 125, 165);
        }


        for (int i = 0; i < 9; i++) {
//            System.out.println(x + 95);
            g.setColor(BiancaColor);
            g.fillRect(x + 97, 50, 95, 190);
//            g.setColor(Color.BLACK);
//            g.setFont(fnt);
//            g.drawString(String.valueOf(n), x + 125, 165);
            x = x + 97;
            n += 1;
        }

        //Dices

        g.setColor(Color.BLACK);
        g.fillRect((Game.WIDTH / 2) - 75, Game.HEIGHT / 2, 64, 64);
        g.fillRect((Game.WIDTH / 2) + 75, Game.HEIGHT / 2, 64, 64);
    }

}
