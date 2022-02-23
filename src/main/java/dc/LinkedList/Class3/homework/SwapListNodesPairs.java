package dc.LinkedList.Class3.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class SwapListNodesPairs {

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

        printNode(swapPairs(node0));
        System.out.println();
    }

    public static void printNode(ListNode head) {
        // Output each element followed by a space
        ListNode current = head;
        System.out.print(current.val);
        current = current.next;
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            int val = current.val;
            current.val = current.next.val;
            current.next.val = val;
            current = current.next.next;
        }
        return head;
    }
}
