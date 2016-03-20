/**
 * Created by matthew on 3/19/16.
 */
public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {
    MyTreeNode parentNode;
    BinarySearchTree() {
        parentNode = new MyTreeNode(null, null, null, null, null, null, null, null);
    }

    public void insert(T x, T x1, T x2, T y1, T y2) {
        if (parentNode.ccw == null) {
            parentNode.ccw = x;
        } else {
            if (parentNode.lookup(x) == false) {
                parentNode.insert(x, x1, x2, y1, y2);
            }
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
