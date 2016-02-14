/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
import java.util.*;
/**
 * Lab 5 CS 172 University of Rochester
 */

public class Lab5 {

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
        System.out.println("Inserting More data");
        myLinkedList.insert(220);
        myLinkedList.insert("Hello");
        myLinkedList.insert(1000);
        myLinkedList.printList();
        System.out.println("Looking up '100' results in: " + String.valueOf(myLinkedList.lookup(100)));
        System.out.println("Looking up '101' results in: " + String.valueOf(myLinkedList.lookup(101)));
        System.out.println("Testing to see if contains 'Hello' is: " + String.valueOf(myLinkedList.contains("Hello")));
        System.out.println("Deleting 'Hello' and retesting.");
        myLinkedList.delete("Hello");
        System.out.println("Testing to see if contains 'Hello' is: " + String.valueOf(myLinkedList.contains("Hello")));
        System.out.println("Printing list reversed");
        myLinkedList.printListRev();
    }
}
