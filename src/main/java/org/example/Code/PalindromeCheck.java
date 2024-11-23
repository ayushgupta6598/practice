package org.example.Code;



public class PalindromeCheck {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {

            // Your implementation logic here

            return false; // Placeholder return
        }
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 2 -> 1
        ListNode node4 = new ListNode(1, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);
    }
}
