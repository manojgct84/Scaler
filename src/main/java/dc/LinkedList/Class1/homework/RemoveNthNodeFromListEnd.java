package dc.LinkedList.Class1.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        // ListNode node5 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;
        printNode(removeNthFromEnd(node0, 5));
        System.out.println();
        ListNode node00 = new ListNode(1);
        printNode(removeNthFromEnd(node00, 1));
        System.out.println();
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

    /**
     * For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node
     * from the end, the linked list becomes 1->2->3->5.
     */
    public static ListNode removeNthFromEnd(ListNode head, int backPos) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        System.out.println("len " + len);
        current = head;
        if (len < backPos && current != null && current.next != null) {
            return head.next;
        }
        int k = (len - backPos);
        if (backPos == 1 && len == 1) { // when there is only one node.
            return null;
        }
        if (k == 0 && len > 0) { // When we need to remove the first node.
            return head.next;
        }
        System.out.println(k);
        while (current != null && k > 1) { //K should stop before the node that  you need to
            // remove as it is zero base indexing.
            current = current.next;
            k--;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }
}
