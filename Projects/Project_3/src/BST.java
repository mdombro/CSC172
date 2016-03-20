public interface BST<T extends Comparable<T>> {
    public void insert(T x, T x1, T x2, T y1, T y2);
    public void delete(T x);
    public boolean lookup(T x);
    public void printPreOrder();
    public void printInOrder();
    public void printPostOrder();
}