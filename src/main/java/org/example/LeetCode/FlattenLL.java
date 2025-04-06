package org.example.LeetCode;

//public class FlattenLL {
//}
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

class Solution {
    // Function to flatten a linked list
    Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case
        }

        // Use an iterative bottom-up merge
//        Node current = head;

//        while (current.next != null) {
//            Node nextList = current.next;
//            current.next = nextList.next; // Skip the next node in the chain
            Node nextList=flatten(head.next);
            // Merge current list and the next list
            head = mergeLL(head, nextList);
//        }

        return head; // Return the fully flattened list
    }

    // Helper function to merge two sorted linked lists
    Node mergeLL(Node head1, Node head2) {
        Node dummyNode = new Node(-1); // Dummy node for easier handling
        Node current = dummyNode;

        // Merge two sorted lists
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.bottom = head1;
                head1 = head1.bottom;
            } else {
                current.bottom = head2;
                head2 = head2.bottom;
            }
            current = current.bottom; // Move the pointer forward
        }

        // Attach remaining nodes
        if (head1 != null) current.bottom = head1;
        if (head2 != null) current.bottom = head2;

        return dummyNode.bottom; // Skip the dummy node
    }
}

public class FlattenLL {
    public static void printFlattenedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Flatten the list
        CoinChange solution = new CoinChange();
//        Node flattenedList = solution.flatten(head);

        // Print the flattened list
        System.out.println("Flattened linked list:");
//        printFlattenedList(flattenedList);
    }
}
