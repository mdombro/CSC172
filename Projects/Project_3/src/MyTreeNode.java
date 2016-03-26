/**
 * Created by matthew on 3/19/16.
 */

public class MyTreeNode<T extends Comparable<T>> {
    static final int COUNTERCLOCKWISE = -1;
    static final int CLOCKWISE = 1;
    static final int COLINEAR = 0;
    public T ccw;
    public Lines line;
    public int parentLineID;
    public MyTreeNode<T> leftChild;
    public MyTreeNode<T> rightChild;
    public MyTreeNode<T> parent;
    MyTreeNode(Lines l, int id, MyTreeNode<T> lc, MyTreeNode<T> rc, MyTreeNode<T> p) {
        line = l;
        parentLineID = id;
        leftChild = lc;
        rightChild = rc;
        parent = p;
    }

    public void insert(Lines l, int id) {
        int side = ccw(l.midpoint(), this.line.p1, this.line.p2);
        //System.out.println("CCW or CW: " + side);
        if (side == COUNTERCLOCKWISE) {
            if (this.leftChild != null) {
                this.leftChild.insert(l, id);
            } else {
                MyTreeNode left = new MyTreeNode(l, 0, null, null, this);
                this.leftChild = left;
                this.leftChild.parentLineID = id;
            }
        }
        if (side == CLOCKWISE) {
            if (this.rightChild != null) {
                this.rightChild.insert(l, id);
            } else {
                MyTreeNode right = new MyTreeNode(l, 0, null, null, this);
                this.rightChild = right;
                this.rightChild.parentLineID = id;
            }
        }
    }

    public int numLeaves() {
        int tmp = 0;
        if (this.rightChild == null && this.leftChild == null) {
            return 1;
        }
        if (this.rightChild != null) {
            tmp += this.rightChild.numLeaves();
        }
        if (this.leftChild != null) {
            tmp += this.leftChild.numLeaves();
        }
        return tmp;
    }

    public int pathLengthSum() {
        int tmp = 0;
        if (this.rightChild == null && this.leftChild == null) {
            return getPathLength();
        }
        if (this.rightChild != null) {
            tmp += this.rightChild.pathLengthSum();
        }
        if (this.leftChild != null) {
            tmp += this.leftChild.pathLengthSum();
        }
        return tmp;
    }

    public int getPathLength() {
        if (this.parent == null) {
            return 0;
        }
        return this.parent.getPathLength() + 1;
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

    public int lookup(Point p1, Point p2) {
        int sideP1 = ccw(p1, this.line.p1, this.line.p2);
        int sideP2 = ccw(p2, this.line.p1, this.line.p2);
        if (sideP1 != sideP2) {
            return this.parentLineID;
        }
        if (sideP1 == COUNTERCLOCKWISE) {
            if (this.leftChild != null) {
                return this.leftChild.lookup(p1,p2);
            }
        }
        else if (sideP1 == CLOCKWISE) {
            if (this.rightChild != null) {
                return this.rightChild.lookup(p1,p2);
            }
        }
        return 0;
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
        System.out.printf("%f %f %f %f Parent line ID: %d \n", this.line.p1.x, this.line.p1.y, this.line.p2.x, this.line.p2.y, this.parentLineID);
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
