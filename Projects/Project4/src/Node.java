/***************************/
/***    Matt Dombroski  ****/
/***       Project 4    ****/

import java.util.ArrayList;

/***************************/

public class Node {
    Point location;             // x, y coords
    String ID;                  // name of the intersection
    Node from;                  // backpointer to reconstruct path
    double cost;
    ArrayList<Node> neighbors = new ArrayList<>();  // all connected nodes
    Node (String Id, double x, double y) {
        ID = Id;
        location = new Point(x, y);
        cost = Double.MAX_VALUE;
    }
}
