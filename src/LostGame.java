import java.awt.*;

public class LostGame {

    public LostGame() {}

    public void render(Graphics g, Graphics2D g2d){
        Font fnt2 = new Font("arial", Font.BOLD, 40);

        float thickness = 3;
        Stroke oldStroke = g2d.getStroke();

        g2d.setColor(Color.RED);

        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRect(453, (Game.HEIGHT / 2) - 80, 528, 64);
        g2d.setStroke(oldStroke);

        g.setColor(Color.BLACK);
        g.fillRect(453, (Game.HEIGHT / 2) - 80, 528, 64);
        g.setColor(Color.RED);
        g.setFont(fnt2);
        g.drawString("Sorry the sum don't add up", 459, (Game.HEIGHT / 2) - 35);
    }
}
