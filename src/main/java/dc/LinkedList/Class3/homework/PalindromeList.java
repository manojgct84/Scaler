package dc.LinkedList.Class3.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(palindromeList(node0));
    }

    public static int palindromeList(ListNode head) {

        ListNode middle = findMiddleNode(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        middleNext = reverseMiddle(middleNext);
        return palindromeCheck(head, middleNext);

    }

    private static int palindromeCheck(ListNode head, ListNode middleNext) {
        ListNode left = head;
        ListNode right = middleNext;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return 0;
            }
            left = left.next;
            right = right.next;
        }
        return 1;
    }

    private static ListNode reverseMiddle(ListNode middleNext) {
        ListNode current = middleNext;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
