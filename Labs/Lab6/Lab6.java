/*
 * Programmers: Matt Dombroski and Greg Hunkins
 * Partner: Greg Hunkins
 */
import java.util.*;

public class Lab6 {

    public static void main(String[] args) {
        // TODO code application logic here

        StackLinkedList myStack = new StackLinkedList();
        System.out.println("Empty test 1: " + String.valueOf(myStack.isEmpty()));
        System.out.println("Inserting String 'item1' into List");
        myStack.push("item1");
        System.out.println("Empty test 2: " + String.valueOf(myStack.isEmpty()));
        System.out.println("Inserting Int '100' into List");
        myStack.push(100);

        System.out.println("Peeking list: " + myStack.peek());
        System.out.println("Popping off stack: " + myStack.pop());

        System.out.println("Peeking list: " + myStack.peek());
        System.out.println("Popping off stack: " + myStack.pop());

        System.out.println("Peeking list: " + myStack.peek());
        //myStack.printList();
    }

    public static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;
        public Node (AnyType d, Node<AnyType> n) {
            data = d; next = n;
        }
    }

    public static interface Stack<AnyType> {
      public boolean isEmpty();
      public void push(AnyType x);
      public AnyType pop();
      public AnyType peek();
    }


    public static class StackLinkedList<AnyType> implements Stack<AnyType> {
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

        public AnyType peek() {
            if (isEmpty())
            {
              return null;
            }
            else {
              return (AnyType)first.data;
            }
        }

        public boolean isEmpty() {
            if (first.next == null && first.data == null) return true;
            return false;
        }
    }
}
