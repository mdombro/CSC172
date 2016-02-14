/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
public class DoubleNode<AnyType> {
    public AnyType data;
    public DoubleNode<AnyType> next;
    public DoubleNode<AnyType> prev;
    public DoubleNode (AnyType d, DoubleNode<AnyType> n, DoubleNode<AnyType> p) {
        data = d; next = n; prev = p;
    }
}
