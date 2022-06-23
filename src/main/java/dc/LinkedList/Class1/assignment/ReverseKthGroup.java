package dc.LinkedList.Class1.assignment;

import java.util.List;

public class ReverseKthGroup {

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

        printNode(reverseKthGroup(node0, 3));

    }

    private static void printNode(ListNode head) {
        System.out.println(head.toString());
    }

    private static ListNode reverseKthGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        int index = k;
        while (curr != null && index > 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            index--;
        }
        if (temp != null) {
            head.next = reverseKthGroup(temp, k);
        }
        return prev;
    }
}
