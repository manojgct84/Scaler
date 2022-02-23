package dc.LinkedList.Class2.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class SortList {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNode(sortList(node0));

        ListNode node00 = new ListNode(1);
        System.out.println();
        printNode(sortList(node00));
        System.out.println();
        ListNode node000 = new ListNode(2);
        ListNode node001 = new ListNode(1);
        node000.next = node001;
        printNode(sortList(node000));
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


    public static ListNode sortList(ListNode A) {

        if (A == null || A.next == null) {
            return A;
        }
        return mergeSort(A);

    }

    private static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
       /* ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        return merge(left, right);*/
        head = mergeSort(head);
        middleNext = mergeSort(middleNext);
        return merge(head, middleNext);
    }

    private static ListNode merge(ListNode head, ListNode head1) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (head != null && head1 != null) {
            if (head.val < head1.val) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
            } else {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;

            }
            tail.next = null;
        }

        if (head != null) {
            tail.next = head;
        }
        if (head1 != null) {
            tail.next = head1;
        }

        return dummy.next;
    }

    private static ListNode findMiddle(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

       /*while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }*/
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
