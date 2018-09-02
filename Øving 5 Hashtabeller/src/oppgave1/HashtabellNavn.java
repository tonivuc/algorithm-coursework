package oppgave1;

/**
 * Oppgave: Lag egen hastabell for navn
 *
 * Dette programmet leser en tekstfil
 * Finner nærmeste toerpotens større enn antall linjer i tekstfilen og lager en String[] for det
 * Lengden på String[] er dermed 2^x
 * Bruker heltallsmultiplikasjon som hash1
 * Bruker en oddetallproduserende funksjon som probe/hash2, som ikke har felles faktorer med m, siden m er 2^x
 */
public class HashtabellNavn {

    private String[] navnTabell;
    private int toerPotens;
    private final long A = 2654435769L; //Legg til 7 på slutten
    private int kollisjoner = 0;

    private String navnKildeLink;
    private Verktøy filLaster = new Verktøy();

    public HashtabellNavn(String filRessurs) {
        navnKildeLink = filRessurs;
        toerPotens = filLaster.finnToerPotensNyTabell(filRessurs);
        navnTabell = new String[filLaster.finnPassendeLengde(filRessurs)];
        fyllTabell();
    }

    public int getKollisjoner() {
        return kollisjoner;
    }

    public double getLastfaktor() {
        return filLaster.tellLinjer(navnKildeLink)/(double)navnTabell.length;
    }

    public void fyllTabell() {
        String[] splt = filLaster.returnerNavn(navnKildeLink).split(";");

        for (String word : splt) {
            leggInnNavn(word.substring(0, word.length() - 1));
        }
    }

    //Heltallsmultiplikasjon
    private int hash1(Integer key, int toerpotens) {
        long resultat = (key*A);
        return (int)((resultat >> (32 - toerpotens))%navnTabell.length);
    }

    //Hash 2
    private int probe(int key, int m) {
        //Returner et oddetall, som alltid er "prime" på tabelllengden 2^x
        return (2*Math.abs(key)+1) % m;
    }

    //Denne er testet og gir samme hver gang
    public int stringTilTall(String input) {
        int tall = 0;
        for (int i = 0; i < input.length(); i++) {
            tall = tall + (int)input.charAt(i)*i+1; //Finn ascii-verdi. i+1 er vekting.
        }
        return tall;
    }

    public int leggInnNavn(String key) {

        int k = stringTilTall(key);
        int m = navnTabell.length;
        int hash1 = (int)hash1(k, toerPotens);

        if (navnTabell[hash1] == null) {
            navnTabell[hash1] = key;
        }
        else {
            kollisjoner++;
            for (int i = 0; i < m; i++) {
                int j = probe(k, m);
                if (navnTabell[j] == null) {
                    navnTabell[j] = key;
                    System.out.println(navnTabell[j]+" KOLLISJON "+navnTabell[hash1]+" på i: "+hash1+", lagt på i: "+j);
                    return j;
                }
            }
        }

        return -1; //Fullt
    }


    public int finnpos(String key) {
        int k = stringTilTall(key);
        int m = navnTabell.length;
        int hash1 = (int)hash1(k, toerPotens);

        if (navnTabell[hash1] == null) {
            return -1;
        }
        if (navnTabell[hash1].equals(key)) {
            return hash1;
        }
        for (int i = 0; i < m; i++) {
            int j = probe(k, m);
            if(navnTabell[j] == null) {
                return -1;
            }
            if (navnTabell[j].equals(key)) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashtabellNavn tabell = new HashtabellNavn("src/resources/navn.txt");

        System.out.println("Lastfaktor: "+tabell.getLastfaktor());
        System.out.println("Kollisjoner: "+tabell.getKollisjoner());
        System.out.println("Er Kimia i faget? I såfall på indeks: "+tabell.finnpos("Kimia Abtahi"));
        System.out.println(tabell.finnpos("Knut Wiig"));

    }
}
