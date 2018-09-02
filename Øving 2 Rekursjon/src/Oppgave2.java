/**
 * Created by Toni on 24.08.2017.
 */
public class Oppgave2 {
    //Hvor mange ganger ganger vi x^2 med seg selv?

    public static int rekursiv(int x, int n) {
        if (n == 0) {
            return 1;
        }
        else if (!isPartall(n)) {
            return x*x*rekursiv(x,n-1); //Det er jo en slags kvadratrot.
        }
        else {
            return x*rekursiv(x,n-1);
        }
    }

    public static boolean isPartall(int input) {
        if ((input % 2) == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(rekursiv(2,2));
    }
}
