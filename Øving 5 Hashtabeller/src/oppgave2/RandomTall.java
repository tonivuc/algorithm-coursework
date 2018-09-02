package oppgave2;
import java.util.Random;

public class RandomTall {

    Random rand = new Random(3989);

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public int[] genererTall(int antall, int min, int max) {
        int[] tabell = new int[antall];
        for (int i = 0; i < antall; i++) {
            tabell[i]=randInt(min,max);
        }
        return tabell;
    }
}

