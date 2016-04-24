/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/
/***************************/

import java.util.ArrayList;

/***************************/

public class Node {
    Point location;             // x, y coords
    String ID;                  // name of the intersection
    Node from;                  // backpointer to reconstruct path
    double cost;
    double priority;
    ArrayList<Node> neighbors = new ArrayList<>();  // all connected nodes
    Boolean visited;
    Node (String Id, double x, double y) {
        ID = Id;
        location = new Point(x, y);
        cost = Double.MAX_VALUE;
        visited = false;
        priority = Double.MAX_VALUE;
    }
}
