package oppgave2;

import oppgave1.Verktøy;

import java.util.Date;
import java.util.HashMap;

public class HashTabellTall {
    private int[] intTabell;
    private int toerPotens;
    private final long A = 2654435769L;
    private int kollisjoner = 0;
    private int elementerIArray = 0;
    private int tabellStørrelse = 0;

    public HashTabellTall(int størrelse) {
        Verktøy hjelp = new Verktøy();
        tabellStørrelse = hjelp.finnPassendeLengde(størrelse);
        intTabell = new int[tabellStørrelse];
    }

    public int getKollisjoner() {
        return kollisjoner;
    }

    public double getLastfaktor() {
        return (double)elementerIArray/(double)intTabell.length;
    }

    //Heltallsmultiplikasjon
    private int hash1(Integer key, int toerpotens) {
        long resultat = (key*A);
        return (int)((resultat >> (32 - toerpotens))%intTabell.length);
    }

    //Hash 2
    private int hash2(int key, int m) {
        //Returner et oddetall, som alltid er "prime" på tabelllengden 2^x
        return (2*Math.abs(key)+1) % m;
    }

    private int probe(int h1,int h2, int i, int m) {
        return (h1+i*h2)%m;
    }

    public int leggInnTall(int key) {

        int m = tabellStørrelse;
        int hash1 = (int)hash1(key, toerPotens);


        if (intTabell[hash1] == 0) {
            intTabell[hash1] = key;
            elementerIArray++;
            return 0;
        }
        else {
            int hash2 = hash2(key,m);
            for (int i = 0; i < m; i++) {
                kollisjoner++;
                int j = probe(hash1, hash2, i, m);
                if (intTabell[j] == 0) {
                    intTabell[j] = key;
                    //System.out.println(intTabell[j]+" KOLLISJON "+intTabell[hash1]+" på i: "+hash1+", lagt på i: "+j);
                    elementerIArray++;
                    return j;
                }
            }
        }
        System.out.println("Fullt");
        return -1; //Fullt
    }


    public int finnpos(int key) {
        int m = intTabell.length;
        int hash1 = (int)hash1(key, toerPotens);

        if (intTabell[hash1] == 0) {
            return -1;
        }
        if (intTabell[hash1]==key) {
            return hash1;
        }
        int hash2 = hash2(key, m);
        for (int i = 0; i < m; i++) {
            int j = probe(hash1,hash2,i,m);
            if(intTabell[j] == 0) {
                return -1;
            }
            if (intTabell[j]==key) {
                return j;
            }
        }
        System.out.println("Tabell full");
        return -1;
    }

    public static void main(String[] args) {
        RandomTall randomTall = new RandomTall();
        int tabellstørrelse = 3000000;
        int[] masseTall = randomTall.genererTall(tabellstørrelse,1,147483646); //max: 2147483647
        HashTabellTall tallTabell = new HashTabellTall(tabellstørrelse);
        //Tidtaking


        long tidSum = 0;

        Date start = new Date();
        int runder = 0;
        Date slutt;

        //do {
            int[] nyArray = Verktøy.deepKopiArray(masseTall);
            tallTabell = new HashTabellTall(tabellstørrelse);
            HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>(8388608);

            long før = System.nanoTime(); //Start tidtaking av sortering
            //Sett inn i inttabell med hash-funksjonene

            for (int i = 0; i < nyArray.length; i++) {
                //myMap.put(nyArray[i],nyArray[i]);
                tallTabell.leggInnTall(nyArray[i]);
            }
            long etter = System.nanoTime(); //Slutt tidtaking av sortering

            tidSum = etter-før;
                    //tidSum + (etter-før);
            //slutt = new Date();
            //++runder;
        //} while (slutt.getTime()-start.getTime() < 1000); //Vent til det har gått ett sekund

        long kjøretid = tidSum; /// runder;
        System.out.println("Kjøretid: "+kjøretid/1000/1000+" millisekund");
        System.out.println("Size:"+myMap.size());


        System.out.println("Kollisjoner:"+tallTabell.getKollisjoner());
        System.out.println("Lengde: "+tallTabell.intTabell.length);
        System.out.println("Elementer i arrayen: "+tallTabell.elementerIArray);
        System.out.println("Lastfaktor:"+tallTabell.getLastfaktor());

    }


}
