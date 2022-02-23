package dc.LinkedList.Class3.homework;

public class CloneLinkedList {

    public static void main(String[] args) {
        DoubleListNode node0 = new DoubleListNode(1);
        DoubleListNode node1 = new DoubleListNode(2);
        DoubleListNode node2 = new DoubleListNode(3);


        node0.next = node1;
        node0.random = node2;
        node1.next = node2;
        node1.random = node0;
        node2.random = node0;

        printNode(cloneList(node0));
    }

    public static void printNode(DoubleListNode head) {
        // Output each element followed by a space
        DoubleListNode current = head;
        if (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
    }

    public static DoubleListNode cloneList(DoubleListNode head) {
        DoubleListNode current = head;

        while (current != null) {
            DoubleListNode node = new DoubleListNode(current.val);
            node.next = current.next;
            current.next = node;
            current = current.next.next;
        }

        DoubleListNode clone = randomCloneObj(head);

        return cloneLinkedList(clone);
    }

    private static DoubleListNode cloneLinkedList(DoubleListNode head) {
        DoubleListNode current = head;
        DoubleListNode temp = current.next;
        DoubleListNode clone = current.next;

        while (current != null) {
            current.next = current.next.next;
            current = current.next;
            if (current != null) {
                temp.next = temp.next.next;
                temp = temp.next;
            }
        }
        return clone;
    }

    private static DoubleListNode randomCloneObj(DoubleListNode head) {
        DoubleListNode curr = head;

        while (curr != null) {
            curr.random.next = curr.random != null ? curr.random.next : curr.random;
            curr = curr.next.next;
        }
        return head;
    }
}

class DoubleListNode {
    public int val;
    public DoubleListNode next;
    public DoubleListNode random;

    public DoubleListNode(int x) {
        val = x;
        next = random = null;
    }
}