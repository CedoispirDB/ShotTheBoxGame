import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Font;


public class GameDesign {

    private final MouseInput mouseInput = new MouseInput(null, null);
    private final ShotTheBox shotTheBox = new ShotTheBox();

    private boolean exceed = false;

    public GameDesign() {

    }

    public void getValue(boolean exceed) {
        this.exceed = exceed;
    }

    public void render(Graphics2D g2d, Graphics g, int die1, int die2) {

        //BackGround
        g.setColor(new Color(170, 131, 71));
        g.fillRect(261, 90, (Game.WIDTH - 260 * 2) - 1, Game.HEIGHT - 90 * 2);
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
        Font fnt2 = new Font("arial", Font.BOLD, 40);
        Font fnt3 = new Font("arial", Font.BOLD, 20);

        int x = 168;

//        tools.d("option[0]: " + option[0]);


        for (int i = 0; i < 9; i++) {
//            System.out.println(x + 95);
            g.setColor(BiancaColor);
            g.fillRect(x + 97, 50, 95, 190);
//            g.setColor(Color.BLACK);
//            g.setFont(fnt);
//            g.drawString(String.valueOf(n), x + 125, 165);
            x = x + 97;
        }


        g.setColor(Color.BLACK);
        g.setFont(fnt);

        if (mouseInput.option(0)) {
            g.drawString("1", 293, 165);
        }
        if (mouseInput.option(1)) {
            g.drawString("2", 390, 165);
        }
        if (mouseInput.option(2)) {
            g.drawString("3", 487, 165);
        }
        if (mouseInput.option(3)) {
            g.drawString("4", 584, 165);
        }
        if (mouseInput.option(4)) {
            g.drawString("5", 681, 165);
        }
        if (mouseInput.option(5)) {
            g.drawString("6", 778, 165);
        }
        if (mouseInput.option(6)) {
            g.drawString("7", 875, 165);
        }
        if (mouseInput.option(7)) {
            g.drawString("8", 972, 165);
        }
        if (mouseInput.option(8)) {
            g.drawString("9", 1069, 165);
        }

        //Wrong sum


        if (this.exceed) {


        }

        //Dices

        g.setColor(Color.BLACK);
        g.fillRect((Game.WIDTH / 2) - 75, Game.HEIGHT / 2, 64, 64);
        g.fillRect((Game.WIDTH / 2) + 75, Game.HEIGHT / 2, 64, 64);

        g.setFont(fnt2);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(die1), (Game.WIDTH / 2) - 55, (Game.HEIGHT / 2) + 47);
        g.drawString(String.valueOf(die2), (Game.WIDTH / 2) + 95, (Game.HEIGHT / 2) + 47);

        //Roll dices button

        g.setColor(Color.RED);
        g.fillRect(70, (Game.HEIGHT / 2), 96, 60);
        g.setColor(Color.BLACK);
        g.setFont(fnt3);
        g.drawString("Roll Die", 80, (Game.HEIGHT / 2) + 35);
//        653, 50, 95, 190


    }


}
