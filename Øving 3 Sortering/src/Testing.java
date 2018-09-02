import java.util.Date;
import java.util.Random;

/**
 * Created by Toni on 04.09.2017.
 * Se SorteringsMetoderv2 for dokumentasjon.
 */
public class Testing {

    static Random random = new Random();

    public static int[] genererTall(int antallTall) {
        int[] array0 = new int[antallTall];
        for (int i = 0; i < antallTall; i++) {
            array0[i] = random.nextInt(1000);
        }
        return array0;
    }

    public static int[] deepKopiArray(int[] arrayInn) {
        int[] newArray = new int[arrayInn.length];
        for (int i = 0; i < arrayInn.length; i++) {
            newArray[i] = arrayInn[i];
        }
        return newArray;
    };

    //long s = System.nanoTime();
    public static void main(String[] args) {

        int[] intArray = genererTall(300000);
        int[] kopiertArray;


        long tidSum = 0;

        Date start = new Date();
        int runder = 0;
        Date slutt;

        do {
            kopiertArray = deepKopiArray(intArray);
            long før = System.nanoTime(); //Start tidtaking av sortering

            //SorteringsMetoderv2.quickSortInnsetting(kopiertArray,0,intArray.length-1);
            SorteringsMetoderv2.quickSort(kopiertArray,0,intArray.length-1); //Median3Sort
            //SorteringsMetoderv2.innsettingssort(kopiertArray,0,intArray.length-1);

            long etter = System.nanoTime(); //Slutt tidtaking av sortering

            tidSum = tidSum + (etter-før);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 3000); //Vent til det har gått ett sekund

        long kjøretid = tidSum / runder;
        System.out.println("Hver sortering tar: "+kjøretid + " nanosekunder");
        System.out.println("Runder "+ runder);

    }
}
