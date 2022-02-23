package dc.LinkedList.Class2.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class MergeTwoSortedListsII {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        // ListNode node7 = new ListNode(7);

        node0.next = node3;
        node3.next = node5;
        //node5.next = node7;


        ListNode node2 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);


        node2.next = node4;
        node4.next = node6;
        node6.next = node7;
        printNode(mergeTwoLists(node0, node2));
    }

    public static void printNode(ListNode head) {
        // Output each element followed by a space
        ListNode current = head;
        if (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                tail.next = h1;
                tail = tail.next;
                h1 = h1.next;
            } else {
                tail.next = h2;
                tail = tail.next;
                h2 = h2.next;

            }
            tail.next = null;
        }
        if (h1 != null) {
            tail.next = h1;
        }
        if (h2 != null) {
            tail.next = h2;
        }
        return dummy.next;
    }
}
