package dc.LinkedList.Class1.assignment;

public class FirstKReverseLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(6);
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(8);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printNode(reverseList(node0, 3));

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

    public static ListNode reverseList(ListNode head, int B) {
        ListNode current = head;
        ListNode prev = null;
        if (head == null && B > 0 || head == null && B == 0) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        while (current != null && B > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
             B--;
        }
        head.next = current;
        head = prev;
        return head;

    }
}
