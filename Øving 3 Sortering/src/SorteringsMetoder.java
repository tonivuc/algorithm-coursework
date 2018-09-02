import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Toni on 04.09.2017.
 * Se SorteringsMetoderv2 for dokumentasjon.
 */


public class SorteringsMetoder {

    //Find pivot
    //Everything bigger than pivot goes into array 2
    //Everything smaller than pivot goes into array 1
    //Find pivot again, repeat

    //Combine all the arrays

    public static int[] quickSort(int[] arrayInput) {
        //Find pivot
        int pivot = median3sort(arrayInput, 0, arrayInput.length-1);
        int[] arraySmaller = new int[arrayInput.length/2];
        int[] arrayBigger = new int[arrayInput.length/2];



        if (arrayInput.length < 2) {
            return arrayInput;
        }

        int s = 0; //Smaller index
        int b = 0; //Bigger index
        for (int i = 0; i < arrayInput.length; i++) {

            if (arrayInput[i] < pivot) {
                arraySmaller[s] = arrayInput[i];
                s++;
            }
            else {
                arrayBigger[b] = arrayInput[i];
                b++;
            }
        }
        return adderArrays(quickSort(arraySmaller), quickSort(arrayBigger));
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

    private static int[] adderArrays(int[] a, int[] b) { //Denne funker nå
        int totalLengde = a.length + b.length;
        int[] nyArray = new int[totalLengde];
        int index;
        for (index = 0; index < a.length; index++) {
            nyArray[index] = a[index];
        }
        for (int i = 0; i < b.length; i++) {
            nyArray[index] = b[i];
            index++;
        }
        return nyArray;
    }


    public static void main(String[] args) {
        int[] tall1 = {0,1,5,3,7,5,6,10,6,3};
        int[] nyArray = quickSort(tall1);
        for (int i = 0; i < nyArray.length; i++) {
            System.out.println(nyArray[i]);
        }

        //int[] nyArray = adderArrays(tall1,tall2);


        /*
        for (int i = 0; i < nyArray.length; i++) {
            System.out.println(nyArray[i]);
        }

        int[] noenTall = {3,4};
        System.out.println(noenTall[0]);
        bytt(noenTall, noenTall[0],noenTall[1]);
        System.out.println(noenTall[0]);
         */
    }
}

        //Mediansort til senere
        /*
        if (arrayInput.length < 3) {
            median3sort(arrayInput, arrayInput[0], arrayInput[arrayInput.length-1]);
        }
        */