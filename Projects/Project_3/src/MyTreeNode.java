/**
 * Created by matthew on 3/19/16.
 */

public class MyTreeNode<T extends Comparable<T>> {
    static final int COUNTERCLOCKWISE = -1;
    static final int CLOCKWISE = 1;
    static final int COLINEAR = 0;
    public T ccw;
    public Lines line;
    public MyTreeNode<T> leftChild;
    public MyTreeNode<T> rightChild;
    public MyTreeNode<T> parent;
    MyTreeNode(Lines l, MyTreeNode<T> lc, MyTreeNode<T> rc, MyTreeNode<T> p) {
        line = l;
        leftChild = lc;
        rightChild = rc;
        parent = p;
    }

    public void insert(Lines l) {
        int side = ccw(l.midpoint(), this.line.p1, this.line.p2);
        //System.out.println("CCW or CW: " + side);
        if (side == COUNTERCLOCKWISE) {
            if (this.leftChild != null) {
                this.leftChild.insert(l);
            } else {
                MyTreeNode left = new MyTreeNode(l, null, null, this);
                this.leftChild = left;
            }
        }
        if (side == CLOCKWISE) {
            if (this.rightChild != null) {
                this.rightChild.insert(l);
            } else {
                MyTreeNode right = new MyTreeNode(l, null, null, this);
                this.rightChild = right;
            }
        }
    }

    public int ccw(Point p0, Point p1, Point p2) {
        double dx1 = p1.x - p0.x;
        double dy1 = p1.y - p0.y;
        double dx2 = p2.x - p0.x;
        double dy2 = p2.y - p0.y;
        if (dx1*dy2 > dy1*dx2) return COUNTERCLOCKWISE;
        else if (dx1*dy2 < dy1*dx2) return CLOCKWISE;
        else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return CLOCKWISE;
        else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return COUNTERCLOCKWISE;
        else return COLINEAR;
    }

    public boolean lookup(T x) {

//        if (x.equals(this.ccw))
//            return true;
//        else if (x.compareTo(this.ccw) < 0) {
//            if (this.leftChild == null)
//                return false;
//            else
//                return this.leftChild.lookup(x);
//        } else if (x.compareTo(this.ccw) > 0) {
//            if (this.rightChild == null)
//                return false;
//            else
//                return this.rightChild.lookup(x);
//        }
        return false;
    }

    public void printPreOrder() {
        System.out.printf("%f %f %f %f \n", this.line.p1.x, this.line.p1.y, this.line.p2.x, this.line.p2.y);
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
        System.out.printf("%f %f %f %f \n", this.line.p1.x, this.line.p1.y, this.line.p2.x, this.line.p2.y);
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
        System.out.printf("%f %f %f %f \n", this.line.p1.x, this.line.p1.y, this.line.p2.x, this.line.p2.y);
    }
}


