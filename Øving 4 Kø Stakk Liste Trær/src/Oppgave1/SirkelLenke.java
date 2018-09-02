package Oppgave1;

public class SirkelLenke {
    protected Soldat start ;
    protected Soldat end ;
    public int size ;

    /* Constructor */
    public SirkelLenke()
    {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }

    /* Function to get size of the list */
    public int getSize()
    {
        return size;
    }

    /* Function to insert element at end */
    public void insertAtEnd(int val)
    {
        Soldat nySoldat = new Soldat(val,null);
        nySoldat.setNeste(start);
        if(start == null)
        {
            start = nySoldat;
            nySoldat.setNeste(start);
            end = start;
        }
        else
        {
            end.setNeste(nySoldat);
            end = nySoldat;
        }
        size++ ;
    }

    public Soldat getNåværendeSoldat() {
        return end;
    }

    public void drepSoldater(int hoppesOver) {
        int teller = 1;
        Soldat enKar = start;
        Soldat forrigeKar = start; //Ikke nåværende, men den før nå.
        while (size > 1) {

            if (teller != hoppesOver) { //Hvis man ikke er på 3. soldat. F.eks. hopp over 3 og 3. Da er hoppesOver = 3.
                forrigeKar = enKar; //Sett forrige til å være nåværende
                enKar = enKar.neste; //Naviger ett steg lengre inn i listen
                teller++; //Tell opp hvor mange man har hoppet over.
            }
            else { //Nå skal vi slette en Soldat
                //Sett forrige Soldat til å peke til neste soldat
                System.out.println("Dreper nr. "+enKar.finnNr());
                forrigeKar.setNeste(enKar.neste);

                size--; //Lista har mistet en soldat
                teller = 1;
            }

        }
        System.out.println(forrigeKar.neste.finnNr()); //Size er <= 1, bare 1 soldat igjen. (Size = 0 betyr ingen soldater)

    }
}
