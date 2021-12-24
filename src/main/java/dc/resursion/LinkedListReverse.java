package dc.resursion;

public class LinkedListReverse {
    static Node head;

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        head = node;
        System.out.println(reverse(head).toString());
    }

    private static Node reverse(Node head) {

        if (head == null || head.next == null)
            return head;

        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}