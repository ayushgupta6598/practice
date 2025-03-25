//package org.example.Code;
//
////import jdk.internal.classfile.components.ClassPrinter;
//
//class AddTwoNumber02 {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class CoinChange {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode head = null;
//            ListNode temp = null;
//            int carry = 0;
//
//            while (l1 != null || l2 != null || carry != 0) {
//                int val1 = (l1 != null) ? l1.val : 0;
//                int val2 = (l2 != null) ? l2.val : 0;
//                int total = val1 + val2 + carry;
//                ListNode abc = new ListNode(total % 10);
//                carry = total / 10;
//                if (head == null) {
//                    head = abc;
//                    temp = abc;
//                } else {
//                    temp.next = abc;
//                    temp = temp.next;
//                }
//                if (l1 != null) {
//                    l1 = l1.next;
//                }
//
//                if (l2 != null) {
//                    l2 = l2.next;
//                }
//            }
//            return head;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        // Create first number: 342 (stored as 2 -> 4 -> 3)
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        // Create second number: 465 (stored as 5 -> 6 -> 4)
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//        AddTwoNumber02 solution = new AddTwoNumber02();
//        ListNode result = solution.addTwoNumbers(l1, l2);
//
//        // Print the resulting linked list (should represent 807, stored as 7 -> 0 -> 8)
//        printList(result);
//    }
//
//    // Helper method to print the linked list
//    public static void printList(ListNode node) {
//        while (node != null) {
//            System.out.print(node.val);
//            if (node.next != null) System.out.print(" -> ");
//            node = node.next;
//        }
//        System.out.println();
//    }
//
////    public static void reverseList(ListNode head) {
////         currNode=
////
////
////    }
//}
