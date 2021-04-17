import java.util.Random;

public class ShotTheBox {

    private int die1;
    private int die2;
    private int sum;

    public int rollDie() {

        Random r = new Random();

        return r.nextInt(6) + 1;
    }

    public int startGame() {
        int die1 = rollDie();
        int die2 = rollDie();
        System.out.println(die1);
        System.out.println(die2);
        return die1 + die2;
    }

    public int getSum() {
        return sum;
    }


    public static void main(String[] args) {
        ShotTheBox x = new ShotTheBox();


    }

}
