import java.util.Date;

/**
 * Created by Toni on 24.08.2017.
 */
public class Oppgave1 {

    public static double rekursjon(double x, int n) {
        if (n == 0) return 1;
        return rekursjon(x,n-1) * x;
    }

    public static void main(String[] args) {
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            double output = rekursjon(1.001,6000);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
        System.out.println("Runder: "+runder);
    }
}

