package oppgave1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Verktøy {

    //Du kanke gange h2(k) med et tall og få lengden på tabellen. De må være "relativt prime"

    private BufferedReader loadFile(String filpath) {
        try {
            FileInputStream fstream = new FileInputStream(filpath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            return br;

        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
        return null;
    }

    public String returnerNavn(String filPath) {
        try {
            BufferedReader br = loadFile(filPath);
            StringBuilder sb = new StringBuilder();
            String linje;
            String[] splitlinje;

            int i = 0;
            while ((linje = br.readLine()) != null) {
                splitlinje = linje.split("\t");
                for (String word : splitlinje) {
                    //System.out.println(word+"kek");
                    sb.append(word);
                }
                sb.append(";");
                i++;
            }
            br.close();
            String all = sb.toString();
            return all;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int tellLinjer(String filPath) {
        int antallLinjer = 0;

        try {
            BufferedReader br = loadFile(filPath);

            while ((br.readLine()) != null)   {
                antallLinjer++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return antallLinjer;
    }

    int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base))+1;
    }

    public int finnPassendeLengde(String filPath) {
        int antallNavn = tellLinjer(filPath);
        int nyLengde = log(antallNavn, 2);
        // log2 av lengden, returnerer det du må opphøye 2 i for å få tabell-lengden. Rund av oppover.

        //Other stuff
        // Mod 2 er samme som å ta nederste bit til et tall? & er masking.
        return (int)Math.pow(2, nyLengde);
    }

    public int finnPassendeLengde(int kildeStørrelse) {
        int nyLengde = log(kildeStørrelse, 2);
        // log2 av lengden, returnerer det du må opphøye 2 i for å få tabell-lengden. Rund av oppover.

        return (int)Math.pow(2, nyLengde);
    }

    public int finnToerPotensNyTabell(String filPath) {
        int antallNavn = tellLinjer(filPath);
        return log(antallNavn, 2);
    }

    public static int[] deepKopiArray(int[] arrayInn) {
        int[] newArray = new int[arrayInn.length];
        for (int i = 0; i < arrayInn.length; i++) {
            newArray[i] = arrayInn[i];
        }
        return newArray;
    };

    public static void main(String[] args) {
        Verktøy kek = new Verktøy();
        System.out.println(kek.finnToerPotensNyTabell("src/resources/navn.txt"));
    }
}
