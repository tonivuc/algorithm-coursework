import java.util.ArrayList;

/**
 * Created by Toni on 21.08.2017.
 * Øving 1 Algoritmer og Datastrukturer
 * Øvingens formål:
 * Lag et program som finner de to beste punktene å kjøpe og selge en gitt aksje gitt historisk oversikt.
 * Programmer dette med lavest mulig kompleksitet.
 */
public class AksjeEndringer {


    //Bunnpunkt: Når endringen før var negativ og endringen etter var positiv
    //Toppunkt: Når endringen før var positiv og endringen etter var negativ
    //Terassepunkt: Når endringen før var positiv og endringen etter var positiv
    //              Når endringen før var negativ og endringen etter var negativ

    //Gå gjennom, lagre alle ekstremalpunkt
    //Sjekk differansen mellom første punkt med alle de andre punktene
    //Sjekk neste punkt med de andre, osv. osv.
    //Lagre differansen når den er > enn den som er lagret.
    //Lagre punktene som brukes.

    public static int[] genererTall(int antallTall) {
    int[] array0 = new int[antallTall];
        for (int i = 0; i < antallTall; i++) {
            int t = (int) Math.round(Math.random() * 10 - 5);
            array0[i] = t;
        }
        return array0;
    }

    public static void main(String[] args) {

        int størrelse = 10000;

        int[] endringer = genererTall(størrelse);
        ArrayList<Integer> ekstremalPunktDager = new ArrayList<Integer>(); //Dette burde kunne gjøres mer effektivt
        ArrayList<Integer> ekstremalPunktVerdi = new ArrayList<Integer>();

        //Initialiser verdier
        int minDag = 0; //Kjøp
        int maksDag = 0; //Selg
        int naapris = 0;
        double differanse = 0;

        long starttid1 = System.nanoTime();//START COUNTDOWN!


        for (int i = 0; i < størrelse; i++) {

            int endring = endringer[i];
            //System.out.println("Indeks: "+i+" Endring: "+endring);
            naapris = naapris + endring;

            if (endring == 0) { //Ekstremalpunkt
                ekstremalPunktDager.add(i); //Legg til dagen det er ekstremalpunkt
                ekstremalPunktVerdi.add(naapris); //Legg til verdien til ekstremalpunktet den dagen
            }
        }
        for (int i = 0; i < ekstremalPunktDager.size(); i++) {
            for (int j = i + 1; j < ekstremalPunktDager.size(); j++) {

                double arbDifferanse = ekstremalPunktVerdi.get(i) - ekstremalPunktVerdi.get(j); //Kan effektiviseres
                if (arbDifferanse > differanse) {
                    differanse = arbDifferanse;
                    minDag = ekstremalPunktDager.get(i); //Finn ut hvilken av de originale dagene ekstremalpunktet er fra
                    maksDag = ekstremalPunktDager.get(j);
                }

            }
        }

        long slutttid1 = System.nanoTime(); //End countdown!!
        long dur1 = slutttid1 - starttid1;
        System.out.println("Tidsbruk: "+dur1);
        System.out.println("Kjøpsdag: "+minDag);
        System.out.println("Salgsdag: "+maksDag);
    }
}

/**Konklusjon:
 * Ved lave verdier, typ 10 000, virker den lineær, 2. Ved store verdier blir den n^2
 * Hvis man bare har ekstremalpunkter er den n^2
 * Hvis man bare har ett vendepunkt er den n?
 */



/*
    public static void main(String[] args) {

        int arrayLengde = endringer.size();
        double naapris = 0;

        double minVerdi = 0;
        int minDag = 0;
        double maksVerdi = 0;
        int maksDag = 0;

        for (int i = 0; i < arrayLengde; i++) {
            double endring = endringer.get(i);
            naapris = naapris + endring;
            if (endring == 0) {
                if (endringer.get(i - 1) < 0 && endringer.get(i + 1) > 0 && naapris < minVerdi) { //Sjekk om bunnpunkt og ny pris er lavere enn den gamle
                    minVerdi = naapris;
                    minDag = i;
                } else if (endringer.get(i - 1) > 0 && endringer.get(i + 1) < 0 && naapris > maksVerdi) { //Sjekk om toppunkt og ny pris høyere enn den gamle
                    maksVerdi = naapris;
                    maksDag = i;
                }
            }
        }
    }
    */






    /*
    public int toppEllerBunn(int indeks) {
        if (endringer.get(indeks-1) > 0 && endringer.get(indeks+1) < 0) {
            return 1;
        }
        else if (endringer.get(indeks-1) < 0 && endringer.get(indeks+1) > 0) {
            return -1;
       }


        //-1 er bunn, 1 er topp, 0 er terassepunkt
    }
    */




















/*

            int dag2 = 0;


            double pris1 = 0;
            double dag2Verdi = naapris;

            //Sjekk verdi, om differansen mellom den og den forrige er høyere, lagre den

            for (int i = 0; i < arrayLengde; i++) {
        double endring = endringer.get(i);
        naapris = naapris + endring;

        if (endring == 0) { //Ekstremalpunkt
        //Sammenlign forrige dag med dagens dag, finn differansen
        //Hvis differansen >, lagre den og de to dagene. Hvis ikke, gå videre.
        //Sett dag2 = dagens dag

        if ((naapris - pris1) >= differanse) { //Hvis differansen mellom nyttpunkt er høyere enn den gamle
        differanse = naapris - pris1;
        pris1 = naapris;
        minDag = maksDag; //Sett det gamle ekstremalpunktet til å være nytt bunnpunkt
        maksDag = i; //Sett det nye ekstremalpunktet til å være nytt toppunkt
        }
        dag2 = i;
        dag2Verdi = naapris;
        */


                /*
                if (endringer.get(i - 1) < 0 && endringer.get(i + 1) > 0) { //Bunnpunkt
                    bunnVerdi = naapris;
                    minDag = i;
                } else if (endringer.get(i - 1) > 0 && endringer.get(i + 1) < 0) { //Topp punkt
                    maksVerdi = naapris;
                    maksDag = i;
                }
                double arbDifferanse = maksVerdi - minVerdi;
                if (arbDifferanse > 0 && arbDifferanse > differanse) {
                    differanse = arbDifferanse;

                }
                */