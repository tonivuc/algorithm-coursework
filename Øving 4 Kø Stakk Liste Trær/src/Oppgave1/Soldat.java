package Oppgave1;
// 40 soldater, 1 skal overleve. Hvor skal han stå når hver

public class Soldat {
    int nr; //Plassen i rekka
    Soldat neste;

    public Soldat(int e, Soldat n) {
        nr = e;
        neste = n;
    }
    public int finnNr() {
        return nr;
    }

    public Soldat finnNeste() {
        return neste;
    }

    /*  Function to set link to next Node  */
    public void setNeste(Soldat n)
    {
        neste = n;
    }
}
