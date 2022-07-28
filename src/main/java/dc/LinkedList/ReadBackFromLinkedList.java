package dc.LinkedList;


public class ReadBackFromLinkedList {


    static LinkedNode head;
    static LinkedNode tail;

    public static void main(String[] args) {
        readBackFromLinkedList(1);
        readBackFromLinkedList(2);
        readBackFromLinkedList(3);
        readBackFromLinkedList(4);
        readBackFromLinkedList(5);
        readBackFromLinkedList(6);
        readBackFromLinkedList(7);
        readBackFromLinkedList(8);
        readBackFromLinkedList(9);
        readFromBackOfLinkedList(head);
    }

    private static void readBackFromLinkedList(int value) {
        insertLinkedNode(value);
        System.out.println(head);
    }

    //Traversing the single linked list in reverse order
    private static void readFromBackOfLinkedList(LinkedNode head) {
        LinkedNode curr = head;
        LinkedNode prev = tail;
        //O(N^2)
        while (curr != prev) {
            while (curr.next != prev) {
                curr = curr.next;
            }
            System.out.println("prev " + prev.data);
            prev = curr;
            curr = head;
        }
        System.out.println("prev " + prev.data);
    }

    private static void insertLinkedNode(int value) {
        LinkedNode node = new LinkedNode(value);

        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
        }
        head = node;
    }


    static class LinkedNode {
        @Override
        public String toString() {
            return "LinkedNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public LinkedNode(int data) {
            this.data = data;
            this.next = null;
        }

        int data;
        LinkedNode next;
    }
}
