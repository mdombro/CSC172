/*
 * Programmers: Greg Hunkins and Matt Dombroski
 * Partner: Greg Hunkins
 */
public class LinkedList<AnyType> implements SimpleLinkedList<AnyType> {
    //declare first node
    Node first = new Node(null, null);

    //Inserts a node into the beginning of the linked list
    //Method is O(c) because it simply inserts at the beginning
    //of the list
    public void insert(AnyType x) {
      if (!contains(x)) {
        Node insert = new Node(x, first);
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
