
/**
 * Created by Toni on 04.09.2017.
 * Oppgave:
 * Lag en variasjon av QuickSort der man bytter til en mer lettvekt algoritme
 * mot slutten av sorteringen.
 *
 * Laget to versjoner, en med median3sort og en med innsettingssortering.
 * Tid det tok å sortere 300.000 tilfeldig genererte tall på min laptop.
 * QuickSort m. median3sort: 19.850.747 ns
 * QuickSort m. innsetting: 21.901.998 ns
 * Ren Innsetting: 8.974.927.822 ns
 */


public class SorteringsMetoderv2 {

    //Find pivot
    //Everything bigger than pivot goes into array 2
    //Everything smaller than pivot goes into array 1
    //Find pivot again, repeat

    //Combine all the arrays

    public static void quickSort(int[] tabell, int venstre, int høyre) { //Venstre og høyre er posisjoner i tabellen
        if (høyre - venstre > 2) {
            int delepos = splitt(tabell, venstre, høyre);
            quickSort(tabell, venstre, delepos - 1);
            quickSort(tabell, delepos + 1, høyre);
        } else {
            median3sort(tabell, venstre, høyre);
        }
    }

    public static void quickSortInnsetting(int[] tabell, int venstre, int høyre) { //Venstre og høyre er posisjoner i tabellen
        if (høyre - venstre > 300) {
            int delepos = splitt(tabell, venstre, høyre);
            quickSortInnsetting(tabell, venstre, delepos - 1);
            quickSortInnsetting(tabell, delepos + 1, høyre);
        } else {
            innsettingssort(tabell,venstre,høyre);
        }
    }

    private static int splitt(int[] tabell, int venstre, int høyre) { //Venstre og høyre er steder i tabellen
        int indeksVenstre, indeksHøyre;
        int m = median3sort(tabell, venstre, høyre);
        int delingsVerdi = tabell[m];
        bytt(tabell,m,høyre - 1);
        for(indeksVenstre = venstre, indeksHøyre = høyre -1;;) {
            while (tabell[++indeksVenstre] < delingsVerdi);
            while (tabell[--indeksHøyre] > delingsVerdi);
            if (indeksVenstre >= indeksHøyre) break;
            bytt(tabell, indeksVenstre,indeksHøyre);
        }
        bytt(tabell,indeksVenstre, høyre - 1);
        return indeksVenstre;

    }

    private static int median3sort(int[] tabell, int venstre, int høyre) { //3 tall går inn
        int m = (venstre+høyre)/2; //m er indeksen til midtpunktet. Blir null når array inneholder 2 verdier.
        if (tabell[venstre] > tabell[m]) bytt(tabell,venstre,m);
        if (tabell[m] > tabell[høyre]) {
            bytt(tabell,m,høyre);
            if (tabell[venstre] > tabell[m]) bytt(tabell,venstre,m);
        }
        return m;
    }

    private static void bytt(int[] tabell, int venstre, int høyre) { //Venstre og høyre skal være indekser
        int buffer = tabell[venstre];
        tabell[venstre] = tabell[høyre];
        tabell[høyre] = buffer;
    }

    public static void innsettingssort(int[] tabell, int v, int h) {
        for (int j = v+1; j < h; ++j) {
            int bytt = tabell[j];
            //Sett tabell[j] på rett plass
            int i = j - 1;
            while (i >= 0 && tabell[i] > bytt) {
                tabell[i+1] = tabell[i];
                i--;
            }
            tabell[i + 1] = bytt;
        }
    }

    public static void main(String[] args) {

        /*
        * Teste quickSort m.
         */
        int[] tall1 = {0,1,5,3,7,5,6,10,6,3};
        quickSort(tall1, 0, tall1.length-1);
        for (int i = 0; i < tall1.length; i++) {
            System.out.println(tall1[i]);
        }

        int[] tall2 = {0,1,5,3,7,5,6,10,6,3};
        quickSortInnsetting(tall2,0,tall2.length-1);
        for (int i = 0; i < tall1.length; i++) {
            System.out.println(tall2[i]);
        }


    }
}

//Mediansort til senere
        /*
        if (arrayInput.length < 3) {
            median3sort(arrayInput, arrayInput[0], arrayInput[arrayInput.length-1]);
        }
        */