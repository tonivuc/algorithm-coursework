package Oppgave1;

public class Main {

    public static void main(String[] args) {

        SirkelLenke soldatLenke = new SirkelLenke();
        for (int i = 1; i < 11; i++) {
            soldatLenke.insertAtEnd(i);
            //System.out.println("Soldat "+soldatLenke.getNåværendeSoldat().finnNr()+" er lagt i lenken med lengde "+soldatLenke.size);
        }

        soldatLenke.drepSoldater(4);
    }
}
