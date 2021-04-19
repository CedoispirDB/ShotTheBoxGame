import java.util.*;

public class ShotTheBox {

    private int die1;
    private int die2;
    private int sum;
    private final Random r = new Random();

    private int roll1() {
        return r.nextInt(6) + 1;
    }

    private int roll2() {
        return r.nextInt(6) + 1;
    }

    public int rollDie() {


        die1 = roll1();
        die2 = roll2();

//        System.out.println(die1);
//        System.out.println(die2);

        return die1 + die2;

    }

    public int getDie1() {
//        tools.d("die1: " + die1);
        return die1;
    }

    public int getDie2() {
//        tools.d("die2: " + die2);
        return die2;
    }



}
