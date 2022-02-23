package dc.LinkedList.Class3;

public class CopyList {

    public static void main(String[] args) {
        RandomListNode node0 = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);


        node0.next = node1;
        node0.random = node2;
        node1.next = node2;
        node1.random = node0;
        node2.random = node0;

        printNode(copyRandomList(node0));
    }

    public static void printNode(RandomListNode head) {
        // Output each element followed by a space
        RandomListNode current = head;
        if (current != null) {
            System.out.print(current.label);
            current = current.next;
        }
        while (current != null) {
            System.out.print(" " + current.label);
            current = current.next;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode current = head;

        while (current != null) {
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            current.next = temp;
            current = current.next.next;
        }

        current = createRandomPointer(head);
        return cloneObject(current);
    }

    private static RandomListNode cloneObject(RandomListNode head) {
        RandomListNode current = head;
        RandomListNode clone = current.next;
        RandomListNode temp = current.next;

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

    private static RandomListNode createRandomPointer(RandomListNode head) {
        RandomListNode current = head;
        while (current != null) {
            current.next.random = current.random != null ? current.random.next : current.random;
            current = current.next.next;
        }
        return head;
    }
}
