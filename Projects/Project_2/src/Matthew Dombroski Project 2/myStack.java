//******************************************//
//        Author: Matthew Dombroski         //
//              Project 2                   //
//         Stack implementation             //
//******************************************//

interface Stack<AnyType> {
    public boolean isEmpty();
    public void push(AnyType x);
    public AnyType pop();
    public AnyType peek();
}

public class myStack<AnyType> implements Stack<AnyType> {
    public static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;
        public Node (AnyType d, Node<AnyType> n) {
            data = d; next = n;
        }
    }
    //declare first node
    Node first = new Node(null, null);

    //Inserts a node into the beginning of the linked list
    //Method is O(c) because it simply inserts at the beginning
    //of the list
    public void push(AnyType x) {
        Node insert = new Node(x, first);
        first = insert;
    }

    // return the most recently added thing
    public AnyType pop() {
        if (!isEmpty()) {
            AnyType data = (AnyType)first.data;
            first = first.next;   // update the stack
            return data;
        }
        else return null;
    }

    //Searches linked list for data, returns data if found
    //else returns null
    public AnyType peek() {
        if (isEmpty()) {
            return null;
        }
        else {
            return (AnyType) first.data;
        }
    }

    //checks to see if the linked list is empty
    //empty if the first is empty and doesn't link anywhere
    public boolean isEmpty() {
        if (first.next == null && first.data == null) return true;
        return false;
    }
}

