package dc.LinkedList.Class1.assignment;

import java.util.Objects;

public class DeleteLinkedList {

    //Delete the middle node.

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printNode(Objects.requireNonNull(solve(node0)));

    }

    private static void printNode(ListNode head) {
        System.out.println(head.toString());
    }

    public static ListNode solve(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        if (len == 1) {
            return null;
        }
        int mid = len >> 1;
        current = head;
        len = 1;
        while (current != null && len < mid) {
            current = current.next;
            len++;
        }
        if (current != null) {
            current.next = current.next.next;
        }
        return head;
    }
}
