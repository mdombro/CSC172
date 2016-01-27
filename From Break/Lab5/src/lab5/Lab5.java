/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author matthew
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList1 list = new MyLinkedList1();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(15);
        list.insert(10);
        list.insert(5);
        list.insert("Hello WOrld");
        list.printList();
        System.out.println(list.isEmpty());
        System.out.println(list.lookup(5));
        System.out.println(list.lookup(10));
        System.out.println(list.lookup(15));
        System.out.println(list.lookup("Hello WOrld"));
        list.delete(5);
        list.delete(15);
        list.delete(26);
        list.printList();
    }
    
    public static class MyNode {
        public Object data;
        public MyNode next;
        
        MyNode (Object data, MyNode next) {
            this.data = data;
            this.next = next;
        } 
    } 
    
    public interface MyLinkedList {
        public void insert(Object x);
        public void delete(Object x);
        public boolean lookup(Object x);
        public boolean isEmpty();
        public void printList();
    } 
    
    public static class MyLinkedList1 implements MyLinkedList {
        
        MyNode head;
            
        MyLinkedList1() {
            head = new MyNode(null, null);
        }
        
        public void insert(Object x) {
            MyNode tmp = head;
            if (!this.lookup(x)) {
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new MyNode(x, null);
            }
        }
        
        public void delete(Object x) {
            MyNode tmp = head;
            MyNode tmpd;
            if (lookup(x)) {
                while (tmp.next != null) {
                    if (tmp.next.data == x) {
                        tmpd = tmp.next;
                        tmp.next = tmp.next.next;  // remove element from list
                        tmpd = null; 
                    }
                    tmp = tmp.next;
                }
            }
        }
        
        public boolean lookup(Object x) {
            MyNode tmp = head;
            while (tmp.next != null) {
                if (tmp.next.data == x) {
                    return true;
                }
                tmp = tmp.next;
            }
            return false;
        }
        
        public boolean isEmpty() {
            return head.next == null ? true : false;
        }
        
        public void printList() {
            MyNode tmp = head;
            while (tmp.next != null) {
                System.out.println(tmp.next.data);
                tmp = tmp.next;
            }
        }
    }
}
