package dc.LinkedList.Class3.homework;

public class FlattenALinkedList {

    public static void main(String[] args) {
        DListNode node0 = new DListNode(3);
        DListNode node1 = new DListNode(4);
        DListNode node2 = new DListNode(20);
        DListNode node3 = new DListNode(20);
        DListNode node4 = new DListNode(30);

        node0.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        DListNode node7 = new DListNode(7);
        node0.down = node7;
        DListNode node07 = new DListNode(7);
        node7.down = node07;
        DListNode node04 = new DListNode(4);
        node1.down = node04;
        DListNode node22 = new DListNode(22);
        node2.down = node22;
        DListNode node44 = new DListNode(44);
        node4.down = node44;

        printNode(flatten(node0));
    }

    public static void printNode(DListNode head) {
        // Output each element followed by a space
        DListNode current = head;
        if (current != null) {
            System.out.print(current.val);
            current = current.right;
        }
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.right;
        }
    }

    private static DListNode flatten(DListNode root) {
        DListNode curr = root;
        DListNode dummy = new DListNode(-1);
        DListNode tail = dummy;

        while (curr != null) {
            DListNode temp = new DListNode(curr.val);
            tail.right = temp;
            tail = tail.right;
            curr = curr.right;
        }
        curr = root;
        DListNode currRoot = curr;
        tail = dummy;
        tail = tail.right;
        DListNode prev = tail;
        while (curr != null) {
            while (tail !=null && tail.right != null && curr.down.val > tail.val) {
                prev = tail;
                tail = tail.right;
            }
            if (curr.down != null) {
                DListNode temp = new DListNode(curr.down.val);
                temp.right = prev.right;
                prev.right = temp;
            }
            curr = curr.down;
            if (curr != null && curr.down == null) {
                currRoot = currRoot.right;
                curr = currRoot;
            }
        }
        if (currRoot != null && currRoot.right != null) {
            curr = currRoot.right.down;
            while (prev.right != null) {
                prev = prev.right;
            }
            prev.right = curr;
        }
        return dummy.right;
    }
}
