/*****************************/
/*    Matthew Dombroski      */
/*        Project 3          */
/*****************************/

public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {
    MyTreeNode parentNode;
    BinarySearchTree() {
        parentNode = new MyTreeNode(null, 0, null, null, null);
    }

    public int numLeaves() {
        if (parentNode.leftChild == null && parentNode.rightChild == null) {
            return 0;
        }
        else {
            return parentNode.numLeaves();
        }
    }
    public float avgPathLength() {
        int numLeaves = parentNode.numLeaves();
        int lengthSum;
        if (numLeaves == 0) {
            lengthSum = -1;
        }
        else {
            lengthSum = parentNode.pathLengthSum();
        }
        return lengthSum/(float)numLeaves;
    }

    public void insert(Lines l, int id) {
        if (parentNode.line == null) {
            //System.out.println("Added first line");
            parentNode.line = l;
            parentNode.parentLineID = id;
        } else {
            parentNode.insert(l, id);
        }
    }

    public void delete(T x) {

    }

    public int lookup(Point p1, Point p2) {
        if (parentNode.line == null) {
            return -1;
        } else {
            //System.out.println("Yo");
            return parentNode.lookup(p1, p2);
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
