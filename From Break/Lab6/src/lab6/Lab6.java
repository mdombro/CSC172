/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author matthew
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDoubleLinkedList1 list = new MyDoubleLinkedList1();
        System.out.println(list.isEmpty());
        list.insert(15);
        list.insert("Hello");
        list.insert(20);
        list.printList();
        list.printListRev();
        System.out.println(list.isEmpty());
        System.out.println("Looking for 15 and Hello...");
        System.out.println(list.lookup(15));
        System.out.println(list.lookup("Hello"));
        System.out.println("looking for 25 and Boo");
        System.out.println(list.lookup(25));
        System.out.println(list.lookup("Boo"));
        list.insert(15);
        list.insert(35);
        list.insert("Hello");
        list.printList();
        
        System.out.println();
        list.delete(15);
        list.printList();
        
        System.out.println();
        list.delete(35);
        list.printList();
        
        System.out.println();
        list.delete("Hello");
        list.printList();
        
        System.out.println();
        list.delete(20);
        list.printList();
        
        System.out.println(list.isEmpty());
    }
    
    public static class MyDoubleNode {
        public Object data ;
        public MyDoubleNode next;
        public MyDoubleNode prev;
        
        MyDoubleNode (Object data, MyDoubleNode next, MyDoubleNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public interface MyDoubleLinkedList {
        public void insert(Object x);
        public void delete(Object x);
        public boolean lookup(Object x);
        public boolean isEmpty();
        public void printList();
        public void printListRev();
    } 
    
    public static class MyDoubleLinkedList1 implements MyDoubleLinkedList {
        
        private MyDoubleNode head, tail;
        
        MyDoubleLinkedList1() {
            head = new MyDoubleNode(null, tail, null);
            tail = new MyDoubleNode(null, null, head); 
            head.next = tail;  // tail did not exist at declaration of head
        }
        
        public void insert(Object x) {
            if (!this.lookup(x)) {
                MyDoubleNode tmp = tail.prev; 
                MyDoubleNode in = new MyDoubleNode(x, tail, tail.prev);
                tmp.next = in;
                tail.prev = in;
            }
        }
        
        public void delete(Object x) {
            if (this.lookup(x)) {
                MyDoubleNode tmp = head;
                while (tmp.data != x) {
                    tmp = tmp.next;
                }
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
            }
        }
        
        public boolean lookup(Object x) {
            MyDoubleNode tmp = head;
            while (tmp.next != null) {
                if (tmp.next.data == x) {
                    return true;
                }
                tmp = tmp.next;
            }
            return false;
        }
        
        public boolean isEmpty() {
            return (head.next == tail) ? true : false;
        }
        
        public void printList() {
            MyDoubleNode tmp = head.next;
            while(tmp.next != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
        
        public void printListRev() {
            MyDoubleNode tmp = tail.prev;
            while(tmp.prev != null) {
                System.out.println(tmp.data);
                tmp = tmp.prev;
            }
        }
    }
}
    

