/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */

public class Node<AnyType> {
    public AnyType data;
    public Node<AnyType> next;
    public Node (AnyType d, Node<AnyType> n) {
        data = d; next = n;
    }
}
