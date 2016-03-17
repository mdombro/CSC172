public class Lab10 {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(12);
        t.insert(9);
        t.insert(1);
        t.insert(10);
        t.insert(24);
        t.insert(37);
        t.insert(14);
        t.insert(100);
        System.out.println("InOrder");
        t.printInOrder();
        System.out.println();
        System.out.println("PreOrder");
        t.printPreOrder();
        System.out.println();
        System.out.println("PostOrder");
        t.printPostOrder();
        System.out.println("Looking up 24: " + t.lookup(24));
        System.out.println("Looking up 2: " + t.lookup(2));
        System.out.println("Can we insert 24 again?");
        t.insert(24);
        t.printInOrder();
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
            //System.out.println(x.compareTo(this.data));
            if (x.compareTo(this.data) < 0) {
                if (this.leftChild == null) {
                    MyTreeNode left = new MyTreeNode(x, null, null, this);
                    this.leftChild = left;
                }
                else {
                    this.leftChild.insert(x);
                }
            }
            else if (x.compareTo(this.data) > 0) {
                if (this.rightChild == null) {
                    MyTreeNode right = new MyTreeNode(x, null, null, this);
                    this.rightChild = right;
                }
                else {
                    this.rightChild.insert(x);
                }
            }
        }

        public boolean lookup(T x) {
            if (x.equals(this.data))
                return true;
            else if (x.compareTo(this.data) < 0) {
                if (this.leftChild == null)
                    return false;
                else
                    return this.leftChild.lookup(x);
            } else if (x.compareTo(this.data) > 0) {
                if (this.rightChild == null)
                    return false;
                else
                    return this.rightChild.lookup(x);
            }
            return false;
        }

        public void printPreOrder() {
            System.out.println(this.data);
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
            System.out.println(this.data);
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
            System.out.println(this.data);
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
                if (parentNode.lookup(x) == false) {
                    parentNode.insert(x);
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
}
