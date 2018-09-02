import java.util.ArrayList;

public class Node {
    public ArrayList<Kant> kanter;
    public int id;
    public Object d; //Andre nodedata. oppgave1.Forgj?

    public Node() {
        kanter = new ArrayList<Kant>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
