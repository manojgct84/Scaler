package dc.LinkedList.Class2.assignment;

import dc.LinkedList.Class1.assignment.ListNode;

public class RemoveLoopFromLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNode(removeLoopInLinkedList(node0));

        ListNode node00 = new ListNode(1);
        System.out.println();
        printNode(removeLoopInLinkedList(node00));
        System.out.println();
        ListNode node000 = new ListNode(1);
        ListNode node001 = new ListNode(1);
        node000.next = node001;
        printNode(removeLoopInLinkedList(node000));
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

    public static ListNode removeLoopInLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean loop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loop = true;
                break;
            }
        }

        if (!loop) {
            return head;
        }

        slow = head;
        while (slow != fast) {
            if (slow.next == fast.next) {
                fast.next = null;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }
}
