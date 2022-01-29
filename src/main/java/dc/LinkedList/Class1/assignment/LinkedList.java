package dc.LinkedList.Class1.assignment;

public class LinkedList {
    static ListNode head;

    public static void main(String[] args) {
        insert_node(0, 1);
        insert_node(1, 2);
        insert_node(0, 3);
        insert_node(2, 4);
        insert_node(3, 5);
        insert_node(4, 6);
        insert_node(2, 10);
        print_ll();
        System.out.println();
        delete_node(3);
        print_ll();
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (head == null) {
            head = new ListNode(value);
            System.out.println("insert " + head.toString());
            return;
        }
        ListNode node = new ListNode(value);
        if (position == 0) {
            node.next = head;
            head = node;
            System.out.println("insert " + head.toString());
            return;
        }

        ListNode current = head;
        if (current.next == null && position == 1) {
            current.next = node;
            return;
        }
        position--;
        while (current.next != null && position > 0) {
            current = current.next;
            position--;
        }
        node.next = current.next;
        current.next = node;

    }

    public static void delete_node(int position) {
        // @params position, integer
        if (head == null) {
            return;
        }
        if (head.next == null && position == 1) {
            return;
        }

        if (head.next == null && position == 0) {
            head = null;
        }
        ListNode current = head;
        while (current != null && position > 0) {
            current = current.next;
            position--;
        }
        if (current != null) {
            current.next = current.next.next;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode current = head;
        System.out.print(current.val);
        current = current.next;
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
    }
}
