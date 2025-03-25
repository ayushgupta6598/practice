package org.example.Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {
//    public  static  void  main(String[] args){
//        List<Integer> list=new ArrayList<>();
//        list.add(2);
//
//        list.add(4);
//        list.add(3);
//        List<Integer> list1=new ArrayList<>();
//        list1.add(5);
//        list1.add(6);
//        list1.add(4);
//
//
//        addTwoNumbers(list, list1);
//
//    }
//
//    private static void addTwoNumbers(List<Integer> list, List<Integer> list1) {
//        LinkedList<Integer> ll=new LinkedList<>();
//
//    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class LinkedList {
        ListNode head;

        // Insert a node at the end of the list
        public void insertAtEnd(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Delete a node with a specific value
        public void deleteNode(int val) {
            if (head == null) return;

            if (head.val == val) {
                head = head.next;
                return;
            }

            ListNode current = head;
            while (current.next != null && current.next.val != val) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        // Print the entire linked list
        public void printList() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // Implement your custom logic here
        public void solve() {
            // CoinChange logic
        }

        public void main(String[] args) {
//            LinkedList list = new LinkedList();
//
//            // Insert test values
//            list.insertAtEnd(1);
//            list.insertAtEnd(2);
//            list.insertAtEnd(3);
//
//            // Call the solve method
//            list.solve();
//
//            // Print the list after operation
//            list.printList();

//            LinkedList list1=new LinkedList();
//            list1
        }
    }

}
