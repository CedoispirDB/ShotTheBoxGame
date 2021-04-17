import java.sql.Timestamp;

public class tools {
    public static void d(Object x) {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " : " + x);
    }


}
