

//Ekstra opplysninger om hver node
public class Forgj implements Comparable<Forgj> {

    int dist; //Avstanden mellom denne noden og startnoden
    Node forgj; //Forgjengeren (parent) i BFS-treet
    static int uendelig = 1000000000;

    public Forgj() {
        dist = uendelig; //Når vi lager en node er dist uendelig (vi vet ikke enda)
    }

    public int finn_dist() {
        return dist;
    }
    public Node finn_forgj() {
        return forgj;
    }

    // Overriding the compareTo method
    public int compareTo(Forgj d) {
        return this.dist - d.dist;
    }
}
