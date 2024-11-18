package org.example.Code;


class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode iter = head;
//        int count = 0;
//
//        // Count the total number of nodes in the list
//        while (iter != null) {
//            iter = iter.next;
//            count++;
//        }
//
//        // Calculate the position from the start (0-based index)
//        int deleteNode = count - n;
//
//        // Special case: if deleteNode is 0, we need to remove the head node
//        if (deleteNode == 0) {
//            return head.next;
//        }
//
//        // Reset the iterator to the head
//        iter = head;
//        count = 0;
//
//        // Traverse to the node just before the one to delete
//        while (count < deleteNode - 1) {
//            iter = iter.next;
//            count++;
//        }
//
//        // Remove the nth node from the end
//        iter.next = iter.next.next;
//        return head;
//    }

/*        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]*/

        int count=0;
        ListNode dummy= head;
        while (dummy!=null){
            dummy=dummy.next;
            count++;
        }
        int deleteNode = count-n ;
        if (deleteNode==0){
            return head.next;
        }
        count=0;
        dummy=head;
        while (count!=deleteNode-1){
            dummy=dummy.next;
            count++;
        }

        dummy.next=dummy.next.next;


        return head;
    }
}

public class Nineteen {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Node to remove from the end

        Solution solution = new Solution();
        head = RemoveNthFromEnd.removeNthFromEnd(head, n);

        // Print the updated linked list
        printList(head);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
