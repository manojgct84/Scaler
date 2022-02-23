package dc.LinkedList.Class2.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class MergeTwoSortedListsI {

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
        ListNode current1;
        ListNode current2;
        if (h1 == null) {
            return h2;
        }

        if (h2 == null) {
            return h1;
        }

        if (h1.val > h2.val) {
            ListNode temp = h2;
            h2 = h1;
            h1 = temp;
        }
        current1 = h1;
        current2 = h2;

        while (current2 != null) {
            ListNode temp = current2;
            if (current1.next == null && temp.next != null) {
                current1.next = temp;
                break;
            } else {
                current2 = current2.next;
                temp.next = current1.next;
                current1.next = temp;
            }
            current1 = current1.next.next;
            //current1 = temp.next - this or the above one.
        }
        return h1;
    }
}
