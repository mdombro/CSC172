/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/
/***************************/

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override public int compare(Node x, Node y) {
        if (y.priority == x.priority)
            return 0;
        else if (y.priority < x.priority)
            return 1;
        else
            return -1;
    }
}
