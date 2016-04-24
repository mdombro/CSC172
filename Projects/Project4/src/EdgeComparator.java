/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/
/***************************/

import java.util.Comparator;


public class EdgeComparator implements Comparator<Edge> {
    @Override public int compare(Edge x, Edge y) {
        if (y.cost == x.cost)
            return 0;
        else if (y.cost < x.cost)
            return 1;
        else
            return -1;
        //eturn 0;
    }
}
