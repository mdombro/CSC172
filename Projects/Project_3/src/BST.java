public interface BST<T extends Comparable<T>> {
    public void insert(Lines l);
    public void delete(T x);
    public boolean lookup(T x);
    public void printPreOrder();
    public void printInOrder();
    public void printPostOrder();
}