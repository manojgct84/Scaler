package dc.LinkedList.Class3.homework;

import dc.LinkedList.Class1.assignment.ListNode;
import java.util.ArrayList;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ArrayList<ListNode> input = new ArrayList<>();

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

        ListNode node8 = new ListNode(22);
        ListNode node9 = new ListNode(10);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(8);


        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        input.add(node0);
        input.add(node2);
        input.add(node8);
        System.out.println(mergeKLists(input));
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {

        if (a.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int i = 0; i < a.size(); i++) {
            tail.next = a.get(i);
            while (tail.next != null) {
                tail = tail.next;
            }

        }
        return mergeSortLinkedList(dummy.next);
    }

    private static ListNode mergeSortLinkedList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode middle = middleNode(head);
        ListNode middleNode = middle.next;
        middle.next = null;

        ListNode left = mergeSortLinkedList(head);
        ListNode right = mergeSortLinkedList(middleNode);
        return mergeList(left, right);

    }

    private static ListNode mergeList(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
            tail.next = null;
        }

        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }

    private static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
