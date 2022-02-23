package dc.LinkedList.Class1.homework;

import dc.LinkedList.Class1.assignment.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNode(deleteDuplicates(node0));

        ListNode node00 = new ListNode(1);
        System.out.println();
        printNode(deleteDuplicates(node00));
        System.out.println();
        ListNode node000 = new ListNode(1);
        ListNode node001 = new ListNode(1);
        node000.next = node001;
        printNode(deleteDuplicates(node000));

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

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val != current.next.val) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return head;
    }
}
