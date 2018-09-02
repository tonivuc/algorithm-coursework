import java.util.Date;

/**
 * Created by Toni on 24.08.2017.
 */
public class Oppgave2v2 {
    //Hvor mange ganger ganger vi x^2 med seg selv?

    public static double rekursiv(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (!erPartall(n)) {
            return x*rekursiv(x*x,(n-1)/2); //Grunntall x^2, eksponent ...
        }
        else {
            return rekursiv(x*x,n/2);
        }
    }

    public static boolean erPartall(int input) {
        return (input % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println("Kek");

        /*
        long starttid1 = System.nanoTime();//START COUNTDOWN!
        long slutttid1 = System.nanoTime(); //End countdown!!

        long dur1 = slutttid1 - starttid1;
        System.out.println("Resultat: "+output);
        System.out.println("Tidsbruk: "+dur1);
        */

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            double output = rekursiv(1.001,6000);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
        System.out.println("Runder: "+runder);

    }
}
