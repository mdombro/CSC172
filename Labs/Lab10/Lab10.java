public class Lab10 {
    public static void main(String[] args) {
    }


    public static class MyTreeNode<T extends Comparable<T>> {
        public T data;
        public MyTreeNode<T> leftChild;
        public MyTreeNode<T> rightChild;
        public MyTreeNode<T> parent;
        MyTreeNode(T d, MyTreeNode<T> lc, MyTreeNode<T> rc, MyTreeNode<T> p) {
            data = d;
            leftChild = lc;
            rightChild = rc;
            parent = p;
        }

        public void insert(T x) {
            if (x.compareTo(this.data) > 0) {
                if (this.leftChild == null) {
                    MyTreeNode left = new MyTreeNode(x, null, null, this);
                }
                else {
                    this.leftChild.insert(x);
                }
            }
            else if (x.compareTo(this.data) < 0) {
                if (this.rightChild == null) {
                    MyTreeNode right = new MyTreeNode(x, null, null, this);
                }
                else {
                    this.rightChild.insert(x);
                }
            }
        }
    }

    public static interface BST<T extends Comparable<T>> {
        public void insert(T x);
        public void delete(T x);
        public boolean lookup(T x);
        public void printPreOrder();
        public void printInOrder();
        public void printPostOrder();
    }

    public static class BinarySearchTree<T extends Comparable<T>> implements BST<T> {
        MyTreeNode parentNode;
        BinarySearchTree() {
            parentNode = new MyTreeNode(null, null, null, null);
        }

        public void insert(T x) {
            if (parentNode.data == null) {
                parentNode.data = x;
            } else {
                parentNode.insert(x);
            }
        }

        public void delete(T x) {
        }

        public boolean lookup(T x) {
            return true;
        }

        public void printPreOrder() {
        }

        public void printInOrder() {
        }

        public void printPostOrder() {
        }
    }
}
