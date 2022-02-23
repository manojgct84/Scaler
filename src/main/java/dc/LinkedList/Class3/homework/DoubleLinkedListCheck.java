package dc.LinkedList.Class3.homework;

public class DoubleLinkedListCheck {

    static Node head;

    public static void main(String[] args) {
        insertNode(5);
        insertNode(4);
        insertNode(3);
        insertNode(2);
        insertNode(1);
        printNode(reverse(head));
        System.out.println();
    }

    public static void printNode(Node head) {
        // Output each element followed by a space
        Node current = head;
        if (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

    public static void insertNode(int x) {
        Node node = new Node(x);
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            current.prev = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
}
