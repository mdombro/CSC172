import java.util.Comparator;

/**
 * Created by matthew on 4/23/16.
 */
public class NodeComparator implements Comparator<Node> {
    @Override public int compare(Node x, Node y) {
        return (int)y.cost - (int)x.cost;
    }
}
