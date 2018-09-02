
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Dijkstras algoritme i Java. Tar inn veidata fra fil.
 * Skriver ut sortert graf. Mulig å finne korteste vei til sluttnode ved å følge "parent" noder bakover.
 * Bruker Java sin PriorityQueue.
 * Hvilken node som er startnode er hardkodet (men lett å endre).
 */
public class Graf {
    //Antall noder og kanter i grafen
    int N;
    int K;
    Node[] node; //Alle nodene, med vektede kanter som peker til de andre nodene.
    //Bruker også denne arrayen til å slå opp i

    Comparator<Node> comparator = new NodeSammenligner();
    PriorityQueue<Node> prioritetskø;

    //Innlesing av naboliste fra fil
    public void ny_vgraf(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //Siden første linje er antall noder og antall kanter
        K = Integer.parseInt(st.nextToken()); //Antall kanter totalt

        node = new Node[N];

        //For hver kant i filen, legg inn kanten i en node.

        for (int i = 0; i < K; i++) {
            //Vi har K kanter i filen vår. Gå gjennom filen og legg inn data for én og en.
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken()); //Noden kanten går fra
            int til = Integer.parseInt(st.nextToken()); //Noden kanten går til
            int vekt = Integer.parseInt(st.nextToken()); //Vektingen på kanten

            if (node[fra] == null) {
                node[fra] = new Node();
                node[fra].d = new Forgj();
                node[fra].id = fra;

                node[fra].kanter.add(new Kant(til,vekt));
                //System.out.println("Antall lagt inn "+node[fra].id);
            }
            else {
                node[fra].kanter.add(new Kant(til,vekt));
            }

            if (node[til] == null) {
                node[til] = new Node();
                node[til].d = new Forgj();
                node[til].id = til;
                //System.out.println("Antall lagt inn "+node[til].id);
            }

        }

    }

    //Gå gjennom node-tabellen og sett distansen til uendelig
    public void initforgj(int nodeNr) {
        ((Forgj)node[nodeNr].d).dist = 0; //Startnoden får avstanden 0.
        ((Forgj)node[nodeNr].d).forgj = null; //Startnoden har ingen forgjenger
    }

    /*
    Litt om Dijkstra:
    Vi følger veien med minst vekting. Hvis vi finner målnoden, og den har lavere vekting enn de andre nodene vi har igjen å sjekke,
    da har vi funnet den korteste veien. Unntaket er om noen andre veier har negativ vekting og vi ikke har funnet dem enda.
    Da må vi bruke en annen algoritme.
     */

    void dijkstra(int startNode) {
        initforgj(startNode);
        prioritetskø = new PriorityQueue<Node>(10, comparator);
        lag_priko(node);
        for (int i = 0; i < N; i++) {
            Node n = prioritetskø.poll(); //Hent node med lavest vekting
            //System.out.println("//////Poppet node "+n.id+" fra PriorityQueue///////");
            for (int kantNr = 0; kantNr < n.kanter.size(); kantNr++) {
                forkort(n,kantNr); //Dette endrer nodene, som eksisterer originalt i node-arrayen.
            }
        }

    }

    //Det er tilNoden som forkortes, ikke nodeInn
    void forkort(Node nodeInn, int kantNr) {
        int tilNodeNr = nodeInn.kanter.get(kantNr).tilNode;
        int vekt = nodeInn.kanter.get(kantNr).vekt;

        Forgj fraNode = (Forgj)nodeInn.d; //Franoden
        Forgj tilNode = (Forgj)node[tilNodeNr].d; //Tilnoden

        if (tilNode.dist > fraNode.dist + vekt) { //Hvis distansen til noden vi ser på (nd2) er større enn distansen til nåværende node + vektingen til kanten som kobler dem sammen
            tilNode.dist = fraNode.dist + vekt; //Distansen til node 2 er lik denne kortere veien
            tilNode.forgj = nodeInn; //nd2 sin forgjenger settes til noden som gjør veien kortere

            //prioritetskø.remove(node[tilNodeNr]); //Er dette strengt nødvendig?
            /*
            System.out.println("--------------------------------------");
            System.out.println("Forgjenger til node "+tilNodeNr+" satt til å være node "+nodeInn.id);
            System.out.println("Øverste node i prioritetskøen før innsetting av node "+tilNodeNr+" er node "+prioritetskø.peek().id);
            System.out.println(prioritetskø);
            */
            prioritetskø.add(node[tilNodeNr]); //Legger noden med ny distanse inn i prioritetskøen igjen
            /*
            System.out.println("Øverste node i prioritetskøen etter innsetting av node "+tilNodeNr+" er node "+prioritetskø.peek().id);
            System.out.println(prioritetskø);
            */
        }
    }


    void lag_priko(Node[] nodeliste) {

        int i = 0;
        for (Node item : nodeliste) {
            if (item != null) {
                prioritetskø.add(item);
            }
            else {
                System.out.println("Node nr. "+i+" finnes ikke i nodelisten");
            }
            i++;
        }
    }

    /*
    Vi har den originale listen med noder. Deres distanse endres.
    Oppdatering av prioritetskøen:
    "You have to remove and re-insert,
    as the queue works by putting new elements in the appropriate position when they are inserted"
     */

    public void skrivUtGraf() {
        dijkstra(0);
        System.out.println("Antall noder: "+N+" antall kanter: "+K);
        System.out.println("Node  Forgj  Dist");
      for (int i = 0; i < node.length; i++) {

            System.out.print(i+"      ");
            if (node[i] == null) {
                System.out.println("Noden eksisterer ikke");
            }
            else {
                if (((Forgj)node[i].d).forgj != null) {
                    System.out.print(((Forgj)node[i].d).forgj.id+"       ");
                }
                else {
                    System.out.print("ingen   ");
                }
                System.out.print(((Forgj) node[i].d).dist);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Verktøy verktøy = new Verktøy();
        BufferedReader fil = verktøy.loadFile("filer/vg1"); //vg1, vg2, vg3, vg4, vgSkandinavia
        Graf testGraf = new Graf();
        try {
            testGraf.ny_vgraf(fil);
            testGraf.skrivUtGraf();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
