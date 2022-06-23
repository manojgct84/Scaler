package dc.LinkedList.Class1.assignment;

public class DeleteNthNodeLinkedList {

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

        printNode(deleteNthNodeLinkedList(node0, 6));

    }

    private static void printNode(ListNode head) {
        System.out.println(head.toString());
    }

    private static ListNode deleteNthNodeLinkedList(ListNode head, int k) {

        ListNode current = head;
        int index = 1;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        if (len < k) return head;

        current = head;
        while (current != null && index < k - 1) {
            current = current.next;
            index++;
        }

        if (current != null) {
            current.next = current.next.next;
        }
        return head;
    }
}
