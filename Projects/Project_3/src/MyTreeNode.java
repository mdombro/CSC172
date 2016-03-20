/**
 * Created by matthew on 3/19/16.
 */
public class MyTreeNode<T extends Comparable<T>> {
    public T ccw;
    public T x1;
    public T x2;
    public T y1;
    public T y2;
    public MyTreeNode<T> leftChild;
    public MyTreeNode<T> rightChild;
    public MyTreeNode<T> parent;
    MyTreeNode(T d, T X1, T X2, T Y1, T Y2, MyTreeNode<T> lc, MyTreeNode<T> rc, MyTreeNode<T> p) {
        ccw = d;
        x1 = X1;
        x2 = X2;
        y1 = Y1;
        y2 = Y2;
        leftChild = lc;
        rightChild = rc;
        parent = p;
    }

    public void insert(T x, T x1, T x2, T y1, T y2) {
        //System.out.println(x.compareTo(this.ccw));
        if (x.compareTo(this.ccw) < 0) {
            if (this.leftChild == null) {
                MyTreeNode left = new MyTreeNode(x, x1, x2, y1, y2, null, null, this);
                this.leftChild = left;
            }
            else {
                this.leftChild.insert(x, x1, x2, y1, y2);
            }
        }
        else if (x.compareTo(this.ccw) > 0) {
            if (this.rightChild == null) {
                MyTreeNode right = new MyTreeNode(x, x1, x2, y1, y2, null, null, this);
                this.rightChild = right;
            }
            else {
                this.rightChild.insert(x, x1, x2, y1, y2);
            }
        }
    }

    public boolean lookup(T x) {
        if (x.equals(this.ccw))
            return true;
        else if (x.compareTo(this.ccw) < 0) {
            if (this.leftChild == null)
                return false;
            else
                return this.leftChild.lookup(x);
        } else if (x.compareTo(this.ccw) > 0) {
            if (this.rightChild == null)
                return false;
            else
                return this.rightChild.lookup(x);
        }
        return false;
    }

    public void printPreOrder() {
        System.out.println(this.ccw);
        if (this.leftChild != null) {
            this.leftChild.printPreOrder();
        }
        if (this.rightChild != null) {
            this.rightChild.printPreOrder();
        }
    }

    public void printInOrder() {
        if (this.leftChild != null) {
            this.leftChild.printInOrder();
        }
        System.out.println(this.ccw);
        if (this.rightChild != null) {
            this.rightChild.printInOrder();
        }
    }

    public void printPostOrder() {
        if (this.leftChild != null) {
            this.leftChild.printPostOrder();
        }
        if (this.rightChild != null) {
            this.rightChild.printPostOrder();
        }
        System.out.println(this.ccw);
    }
}


