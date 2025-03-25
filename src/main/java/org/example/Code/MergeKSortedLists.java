package org.example.Code;

// Definition for a singly-linked list node.


public class MergeKSortedLists {

    // Method placeholder for merging k sorted lists.
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode second = lists[i];
            head = mergeLists(head, second);
        }
        return head;

    }

    public ListNode mergeLists(ListNode head, ListNode second) {
        ListNode dummy =new ListNode(-1);
        ListNode temp = dummy;
        while (head != null && second != null) {
            if (head.val <= second.val) {
               temp.next= head;
                head = head.next;
            } else {
                temp.next= second;
                second = second.next;
            }
            temp= temp.next;
        }
        if (head != null) {
           temp.next= head;
        }

        if (second != null) {
           temp.next= second;
        }
        return dummy.next;
    }

    // Helper method to print the linked list.
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        // Creating some example sorted linked lists.
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {list1, list2, list3};

        // Merge the k sorted lists (call your merge function here)
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged list.
        solution.printList(mergedList);
    }
}
