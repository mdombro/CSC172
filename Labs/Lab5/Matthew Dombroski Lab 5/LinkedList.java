/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
public class LinkedList<AnyType> implements SimpleLinkedList<AnyType> {
    //declare first DoubleNode
    DoubleNode first, last;
    LinkedList() {
        first = new DoubleNode(null, last, null);
        last = new DoubleNode(null, null, first);
        first.next = last;  // last didn't exist at declaration of head
    }
    //Inserts a DoubleNode into the beginning of the linked list
    //Method is O(c) because it simply inserts at the beginning
    //of the list
    public void insert(AnyType x) {
      if (!contains(x)) {
        DoubleNode tmp = first.next;
        DoubleNode insert = new DoubleNode(x, first.next, first);
        tmp.prev = insert;
        first.next = insert;
      }
    }

    //Deletes
    public void delete(AnyType x) {
        // worst case runtime in this instance is O(N) - may have to go through the list twice
        if (contains(x)) {
            DoubleNode tmp = first;
            while (tmp.data != x) {
                tmp = tmp.next;
            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
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

    //Searches linked list for data, returns data if found
    //else returns null
    public AnyType lookup (AnyType x) {
        DoubleNode temp = first;
        while (temp.data != x) {
            if (temp.next == null) return null;
            temp = temp.next;
        }
        return x;
    }

    //checks to see if the linked list is empty
    // Checks if there are only two nodes - first and last - in the list
    // If so there is nothing in the list
    public boolean isEmpty() {
        if (first.next.next == null) return true;
        return false;
    }

    public void printList() {
        DoubleNode current = first.next;
        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printListRev() {
      DoubleNode current = last.prev;
      while (current.prev != null) {
          System.out.println(current.data);
          current = current.prev;
      }
    }
}
