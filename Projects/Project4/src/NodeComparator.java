import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override public int compare(Node x, Node y) {
        if (y.cost == x.cost)
            return 0;
        else if (y.cost < x.cost)
            return 1;
        else
            return -1;
        //eturn 0;
    }
}
