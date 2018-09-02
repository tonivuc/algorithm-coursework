/**
 * Created by Toni on 27.08.2017.
 */
public class Testing {
    //n! = n*(n-1)*(n-1)*(n-1)... til n <= 0
    static int beregnFakultet(int n) {
        if (n <= 0) {
            return 1;
        }
        else {
            return n*beregnFakultet(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(beregnFakultet(4));
        System.out.println(4*3*2*1);
    }


}

class SorteringsMetoder {

    static String byttRekkefølge(String inputString) {
        int n = inputString.length();
        char[] charArray = inputString.toCharArray();
        char[] newArray = new char[n];
        System.out.println("Lengde: "+n);

        for (int i = 0; i < n; i++) {

            newArray[i] = charArray[n-1-i];
        }
        return String.valueOf(newArray);
    }


    static String rekkefølgeRekursiv(String inputString) {
        int n = inputString.length();
        char[] charArray = inputString.toCharArray();
        char[] newArray = new char[n];
        int i = 0;

        return String.valueOf(rekursiv(n, i, charArray, newArray));
    }

    //Rekursiv switch av tallene?
    static char[] rekursiv(int n, int i, char[] charArray, char[] newArray) {
        if (n > 0) {
            newArray[n-1] = charArray[i];
            return rekursiv(n-1, i+1, charArray, newArray);
        }
        else {
            return newArray;
        }
    }

    //CharArray
    //CharArray i =

    public static void main(String[] args) {
        //System.out.println(byttRekkefølge("Far sin elefant"));
        //System.out.println(byttRekkefølge("Far sin elefant"));
        System.out.println(rekkefølgeRekursiv("Homle"));
    }
}

class TallSummering {

    static int sum(int[] t, int a, int b) {
        //Summer f.o.m. a t.o.m. b-1
        int m = (a+b)/2;
        if (b-a <= 0) return 0;
        if (b-a == 1) return t[a];
        return sum(t,a,m) + sum(t,m,b);
    }

    private static int summer(int[] t) {
        return sum(t, 0, t.length);
    }

    public static void main(String[] args) {
        int[] tall = {10,20,30,40,50,60,71,80,90,91};

        System.out.println(summer(tall));
    }
}

