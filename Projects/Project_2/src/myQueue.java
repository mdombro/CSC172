//******************************************//
//        Author: Matthew Dombroski         //
//              Project 2                   //
//                Queue                     //
//******************************************//

// This file declares a custom Queue class

import java.util.*;
/**
 * Lab 7 CS 172 University of Rochester
 */
interface Queue<AnyType> {
    public boolean isEmpty();
    public void enqueue(AnyType x);
    public AnyType dequeue();
    public AnyType peek();
}

public class myQueue<AnyType> implements Queue<AnyType> {
    public static class DoubleNode<AnyType> {
        public AnyType data;
        public DoubleNode<AnyType> next;
        public DoubleNode<AnyType> prev;
        public DoubleNode (AnyType d, DoubleNode<AnyType> n, DoubleNode<AnyType> p) {
            data = d; next = n; prev = p;
        }
    }
    //declare first DoubleNode
    DoubleNode first, last;
    int size;
    myQueue() {
        first = new DoubleNode(null, last, null);
        last = new DoubleNode(null, null, first);
        first.next = last;  // last didn't exist at declaration of head
        size = 0;
    }

    //checks to see if the linked list is empty
    // Checks if there are only two nodes - first and last - in the list
    // If so there is nothing in the list
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public void enqueue(AnyType x) {
        DoubleNode i = new DoubleNode(x, last, last.prev);
        last.prev.next = i;
        last.prev = i;
        size++;
    }

    //Removes and returns the item at the front of the list
    //if list is empty, return empty
    public AnyType dequeue() {
        AnyType data = (AnyType)first.next.data;
        first.next.next.prev = first;
        first.next = first.next.next;
        size--;
        return data;
    }

    public AnyType peek() {
        if (!isEmpty()) return (AnyType)first.next.data;
        else return null;
    }
}
