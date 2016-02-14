
package lab7;

/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
import java.util.*;
/**
 * Lab 7 CS 172 University of Rochester
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        QueueLinkedList myQueue = new QueueLinkedList();


        System.out.println("Empty test 1: " + String.valueOf(myQueue.isEmpty()));
        System.out.println("Inserting String 'item1' into List");
        myQueue.enqueue("item1");
        System.out.println("Empty test 2: " + String.valueOf(myQueue.isEmpty()));
        System.out.println("Inserting Int '100' into List");
        myQueue.enqueue(100);

        System.out.println("Peeking list: " + myQueue.peek());
        System.out.println("Dequeueing: " + myQueue.dequeue());

        System.out.println("Peeking list: " + myQueue.peek());
        System.out.println("Dequeueing: " + myQueue.dequeue());

        System.out.println("Peeking list: " + myQueue.peek());
        //myStack.printList();

    }

    public static class DoubleNode<AnyType> {
        public AnyType data;
        public DoubleNode<AnyType> next;
        public DoubleNode<AnyType> prev;
        public DoubleNode (AnyType d, DoubleNode<AnyType> n, DoubleNode<AnyType> p) {
            data = d; next = n; prev = p;
        }
    }


    public static interface Queue<AnyType> {
        public boolean isEmpty();
        public void enqueue(AnyType x);
        public AnyType dequeue();
        public AnyType peek();
    }

    public static class QueueLinkedList<AnyType> implements Queue<AnyType> {
        //declare first DoubleNode
        DoubleNode first, last;
        QueueLinkedList() {
            first = new DoubleNode(null, last, null);
            last = new DoubleNode(null, null, first);
            first.next = last;  // last didn't exist at declaration of head
        }

        //checks to see if the linked list is empty
        // Checks if there are only two nodes - first and last - in the list
        // If so there is nothing in the list
        public boolean isEmpty() {
            if (first.next == last && last.data == null && first.data == null) return true;
            return false;
        }

        public void enqueue(AnyType x) {
            if (isEmpty()) {            //if empty, start queue
                insertBegin(x);
            } else if (last.data == null) {     //if last link is empty, insert
                last.data = x;
            } else {
                insertEnd(x);       //else, create new end node and insert
            }
        }

        //Removes and returns the item at the front of the list
        //if list is empty, return empty
        public AnyType dequeue() {
            if (isEmpty()) return null;
            AnyType firstData = (AnyType)first.data;
            deleteFirst();
            return firstData;
        }

        public AnyType peek() {
            return (AnyType)first.data;
        }

        //Inserts a DoubleNode into the beginning of the linked list
        //Method is O(c) because it simply inserts at the beginning
        //of the list
        public void insertBegin(AnyType x) {
            if (!contains(x)) {
                if (first.data == null) {
                    first.data = x;
                } else {
                    DoubleNode insert = new DoubleNode(x, first, null);
                    first = insert;
                }
            }
        }
        //Inserts a DoubleNode at the end of the linked list
        //Method is O(c) because it simply inserts at the end
        //of the list
        public void insertEnd(AnyType x) {
            if (!contains(x)) {
                if (last.data == null) {
                    last.data = x;
                } else {
                    DoubleNode insert = new DoubleNode(x, null, last);
                    last = insert;
                }
            }
        }

        //Deletes the first element in the list
        public void deleteFirst() {
            if (first.next == last) {
                first.data = last.data;
                last.data = null;
            } else {
                first = first.next;
            }
        }
        //Deletes the last element in the list
        public void deleteLast() {
            if (last.prev == first) {
                last.data = first.data;
                first.data = null;
            } else {
                last = last.prev;
            }
        }

        public boolean contains(AnyType x) {
            DoubleNode temp = first;
            while (temp.data != x) {
               if (temp.next == null) return false;    //reached the end of the list
                temp = temp.next;
            }
            return true;    //found the data somewhere
        }

    }
}
