/**
 * Created by matthew on 3/19/16.
 */
public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {
    MyTreeNode parentNode;
    BinarySearchTree() {
        parentNode = new MyTreeNode(null, null, null, null);
    }

    public void insert(Lines l) {
        if (parentNode.line == null) {
            //System.out.println("Added first line");
            parentNode.line = l;
        } else {
            parentNode.insert(l);
        }
    }

    public void delete(T x) {

    }

    public boolean lookup(T x) {
        if (parentNode == null) {
            return false;
        } else {
            return parentNode.lookup(x);
        }
    }

    public void printPreOrder() {
        parentNode.printPreOrder();
    }

    public void printInOrder() {
        parentNode.printInOrder();
    }

    public void printPostOrder() {
        parentNode.printPostOrder();
    }
}
