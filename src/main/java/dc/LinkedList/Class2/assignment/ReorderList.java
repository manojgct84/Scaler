package dc.LinkedList.Class2.assignment;

import dc.LinkedList.Class1.assignment.ListNode;

public class ReorderList {
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
        printNode(reorderList(node0));

        ListNode node00 = new ListNode(1);
        System.out.println();
        printNode(reorderList(node00));
        System.out.println();
        ListNode node000 = new ListNode(2);
        ListNode node001 = new ListNode(1);
        node000.next = node001;
        printNode(reorderList(node000));
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

    public static ListNode reorderList(ListNode head) {
        ListNode middle = middle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        middleNext = reverseLinkedList(middleNext);
        return merge(head, middleNext);
    }

    private static ListNode merge(ListNode head, ListNode middleNext) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        boolean flag = true;
        while (head != null && middleNext != null) {
            if (flag) {
                tail.next = head;
                tail = tail.next;
                head = head.next;
                flag = false;
            } else {
                tail.next = middleNext;
                tail = tail.next;
                middleNext = middleNext.next;
                flag = true;
            }
            tail.next = null;
        }
        if (head != null) {
            tail.next = head;
        }
        if (middleNext != null) {
            tail.next = middleNext;
        }
        return dummy.next;
    }

    private static ListNode reverseLinkedList(ListNode middleNext) {
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

    private static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
