/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
import java.util.*;
/**
 * Lab 6 CS 172 University of Rochester
 */

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




        // System.out.println("Testing that 100 cannot be reinserted");
        // myStack.insert(100);
        // myStack.printList();
        // System.out.println("Looking up '100' results in: " + String.valueOf(myStack.lookup(100)));
        // System.out.println("Looking up '101' results in: " + String.valueOf(myStack.lookup(101)));
        // System.out.println("Testing to see if contains 'item1' is: " + String.valueOf(myStack.contains("item1")));
        // System.out.println("Deleting 'item1' and retesting.");
        // myStack.delete("item1");
        // System.out.println("Testing to see if contains 'item1' is: " + String.valueOf(myStack.contains("item1")));/
    }

    // PART 1: Build successful //
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

        //Searches linked list for data, returns data if found
        //else returns null
        public AnyType peek() {
            return (AnyType)first.data;
        }

        //checks to see if the linked list is empty
        //empty if the first is empty and doesn't link anywhere
        public boolean isEmpty() {
            if (first.next == null && first.data == null) return true;
            return false;
        }

        // public void printList() {
        //     Node current = first;
        //     while (current.next != null) {
        //         System.out.println(current.data);
        //         current = current.next;
        //     }
        // }
    }
}
