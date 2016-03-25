public interface BST<T extends Comparable<T>> {
    public void insert(Lines l, int id);
    public void delete(T x);
    public int lookup(Point x, Point y);
    public void printPreOrder();
    public void printInOrder();
    public void printPostOrder();
}
