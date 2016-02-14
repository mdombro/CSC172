/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
import java.util.*;
/**
 * Lab 4 CS 172 University of Rochester
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
}
