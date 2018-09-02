import java.util.Date;

/**
 * Created by Toni on 28.08.2017.
 */
public class JavaPowTest {

    public static void main(String[] args) {
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            double output = Math.pow(1.001,100);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
        System.out.println("Runder: "+runder);
    }

}
