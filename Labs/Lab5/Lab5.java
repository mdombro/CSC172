/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
import java.util.*;
/**
 * Lab 5 CS 172 University of Rochester
 */

public class Lab4 {

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myLinkedList = new LinkedList();
        System.out.println("Empty test 1: " + String.valueOf(myLinkedList.isEmpty()));
        System.out.println("Inserting String 'item1' into List");
        myLinkedList.insert("item1");
        System.out.println("Empty test 2: " + String.valueOf(myLinkedList.isEmpty()));
        System.out.println("Inserting Int '100' into List");
        myLinkedList.insert(100);
        System.out.println("Printing the list: ");
        myLinkedList.printList();
        System.out.println("Testing that 100 cannot be reinserted");
        myLinkedList.insert(100);
        myLinkedList.printList();
        System.out.println("Looking up '100' results in: " + String.valueOf(myLinkedList.lookup(100)));
        System.out.println("Looking up '101' results in: " + String.valueOf(myLinkedList.lookup(101)));
        System.out.println("Testing to see if contains 'item1' is: " + String.valueOf(myLinkedList.contains("item1")));
        System.out.println("Deleting 'item1' and retesting.");
        myLinkedList.delete("item1");
        System.out.println("Testing to see if contains 'item1' is: " + String.valueOf(myLinkedList.contains("item1")));
    }

    // PART 1: Build successful //
    public static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;
        public Node<AnyType> prev;
        public Node (AnyType d, Node<AnyType> n, Node<AnyType> p) {
            data = d; next = n; prev = p;
        }
    }

    // PART 2:
    public interface SimpleLinkedList<AnyType>  {
        public void insert(AnyType x);
        public void delete(AnyType x);
        public boolean contains(AnyType x);
        public AnyType lookup(AnyType x);
        public boolean isEmpty();
        public void printList();
    }

    public static class LinkedList<AnyType> implements SimpleLinkedList<AnyType> {
        //declare first node
        Node first = new Node(null, null, null);
        Node last = new Node(null,null,null);

        //Inserts a node into the beginning of the linked list
        //Method is O(c) because it simply inserts at the beginning
        //of the list
        public void insert(AnyType x) {
          if (!contains(x)) {
            Node insert = new Node(x, first, prev);
            insert.next.prev = insert;
            first = insert;
          }
        }

        //Deletes
        public void delete(AnyType x) {
            Node temp = first;
            Node prev = null;
            while (temp.data != x) {
                if (temp.next != null) {    //make sure it's not the end of the list
                    prev = temp;
                    temp = temp.next;
                } else return;              //return if it is the end of the list
            }
            prev.next = temp.next;           //skip over the appropriate node
        }

        public boolean contains(AnyType x) {
            Node temp = first;
            while (temp.data != x) {
                if (temp.next == null) return false;    //reached the end of the list
                temp = temp.next;
            }
            return true;    //found the data somewhere
        }

        //Searches linked list for data, returns data if found
        //else returns null
        public AnyType lookup (AnyType x) {
            Node temp = first;
            while (temp.data != x) {
                if (temp.next == null) return null;
                temp = temp.next;
            }
            return x;
        }

        //checks to see if the linked list is empty
        //empty if the first is empty and doesn't link anywhere
        public boolean isEmpty() {
            if (first.next == null && first.data == null) return true;
            return false;
        }

        public void printList() {
            Node current = first;
            while (current.next != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
