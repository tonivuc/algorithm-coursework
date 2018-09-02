import java.util.Comparator;

public class NodeSammenligner implements Comparator<Node> {

    @Override
    public int compare(Node første, Node andre) {
        //Returnerer positivt hvis første > andre
        //Returnerer 0 hvis distansen er lik
        //Returnerer negativt hvis første < andre
        Forgj førsteForgj = (Forgj)første.d;
        Forgj andreForgj = (Forgj)andre.d;
        return førsteForgj.dist - andreForgj.dist;
    }
}
