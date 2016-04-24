/**
 * Created by matthew on 4/23/16.
 */
public class Edge {
    Node a;
    Node b;
    double cost;
    String ID;
    Edge(String id, Node A, Node B, double Cost) {
        a = A;
        b = B;
        cost = Cost;
        ID = id;
    }
}
