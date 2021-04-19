import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private int inputValueRec = 0;
    private int sum;
    public int totalSum = 0;

    private final Game game;

    private final ShotTheBox shotTheBox;

    private static final boolean[] option = new boolean[9];
    public boolean canClick = false;
    public boolean exceed = false;

    public MouseInput(ShotTheBox shotTheBox, Game game) {

        this.shotTheBox = shotTheBox;
        this.game = game;

        option[0] = true;
        option[1] = true;
        option[2] = true;
        option[3] = true;
        option[4] = true;
        option[5] = true;
        option[6] = true;
        option[7] = true;
        option[8] = true;
    }

    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 70, (Game.HEIGHT / 2), 96, 60)) {
            sum = shotTheBox.rollDie();
//            System.out.println("dice1: " + shotTheBox.getDie1());
//            System.out.println("dice2: " + shotTheBox.getDie2());
            inputValueRec = 0;
            canClick = true;
            game.started = true;
            game.found = false;
            game.waiting = true;

        }
        if (canClick) {
            int inputValue;
            if (mouseOver(mx, my, 256, 50, 95, 190) && option[0]) {
                inputValue = 1;
                option[0] = false;
            } else if (mouseOver(mx, my, 362, 50, 95, 190) && option[1]) {
                inputValue = 2;
                option[1] = false;
            } else if (mouseOver(mx, my, 459, 50, 95, 190) && option[2]) {
                inputValue = 3;
                option[2] = false;
            } else if (mouseOver(mx, my, 556, 50, 95, 190) && option[3]) {
                inputValue = 4;
                option[3] = false;
            } else if (mouseOver(mx, my, 653, 50, 95, 190) && option[4]) {
                inputValue = 5;
                option[4] = false;
            } else if (mouseOver(mx, my, 750, 50, 95, 190) && option[5]) {
                inputValue = 6;
                option[5] = false;
            } else if (mouseOver(mx, my, 847, 50, 95, 190) && option[6]) {
                inputValue = 7;
                option[6] = false;
            } else if (mouseOver(mx, my, 944, 50, 95, 190) && option[7]) {
                inputValue = 8;
                option[7] = false;
            } else if (mouseOver(mx, my, 1041, 50, 95, 190) && option[8]) {
                inputValue = 9;
                option[8] = false;
            } else {
                inputValue = 0;
            }

            inputValueRec = inputValueRec + inputValue;
//            System.out.println("inputValue: " + inputValue);
//            System.out.println("inputValueRec: " + inputValueRec);
//            System.out.println("Sum: " + sum);
//            tools.l(" ");
            totalSum = totalSum + inputValue;
        }



    }
    public boolean checkInputValue() {
//        tools.d(sum);
        if (inputValueRec > sum) {
            exceed = true;
        }
        return inputValueRec == sum;

    }

    public boolean option(int x) {
        return option[x];
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else {
            return false;
        }
    }

}
