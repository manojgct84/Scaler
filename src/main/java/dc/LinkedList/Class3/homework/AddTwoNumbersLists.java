package dc.LinkedList.Class3.homework;

import java.util.List;

import dc.LinkedList.Class1.assignment.ListNode;

public class AddTwoNumbersLists {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node3.next = node4;
        node4.next = node6;

        printNode(addTwoNumbers(node0, node3));
        printNode(addTwoRecursive(node0, node3));
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

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode current1 = A;
        ListNode current2 = B;
        StringBuilder sb1 = new StringBuilder();
        while (current1 != null) {
            sb1.append(current1.val);
            current1 = current1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while (current2 != null) {
            sb2.append(current2.val);
            current2 = current2.next;
        }

        long sum1 = Long.parseLong(sb1.toString());
        long sum2 = Long.parseLong(sb2.toString());
        long total = sum1 + sum2;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (total > 0) {
            int t = (int) (total % 10);
            tail.next = new ListNode(t);
            tail = tail.next;
            total /= 10;
        }

        return reverse(dummy);
    }

    private static ListNode reverse(ListNode dummy) {
        ListNode curr = dummy;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == -1) {
                curr = curr.next;
            }
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    private static ListNode addTwoRecursive(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(-1);
        ListNode res = result;
        recursive(node1, node2, res);
        return result.next;
    }

    private static int recursive(ListNode node1, ListNode node2, ListNode res) {
        if (node1 == null) {
            return 0;
        }
        int val = node1.val + node2.val + recursive(node1.next, node2.next, res);
        ListNode node = new ListNode(val % 10);
        node.next = res.next;
        res.next = node;
        return val / 10;
    }
}
