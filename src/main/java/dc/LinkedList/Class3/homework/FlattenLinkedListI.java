package dc.LinkedList.Class3.homework;

public class FlattenLinkedListI {

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
        node7.down = new DListNode(7);
        node1.down = new DListNode(4);
        node2.down = new DListNode(22);
        node4.down = new DListNode(44);

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
        DListNode dummy = curr;
        DListNode prev = null;
        while (curr != null) {
            DListNode merged = mergeList(curr, prev);
            curr = curr.right;
            prev = merged;
        }
        DListNode res = new DListNode(-1);
        DListNode tail = res;
        if (dummy != null) {
            tail.val = dummy.val;
            while (dummy.down != null) {
                tail.right = new DListNode(dummy.down.val);
                dummy = dummy.down;
                tail = tail.right;
            }
        }
        if (dummy == null) {
            return null;
        }
        return res;
    }

    private static DListNode mergeList(DListNode curr, DListNode prev) {
        DListNode tail = null;
        if (curr == null) {
            return prev;
        }
        if (prev == null) {
            return curr;
        }
        if (prev.val < curr.val) {
            tail = prev;
            prev = prev.down;
        } else {
            tail = curr;
            curr = curr.down;
        }
        DListNode temp = tail;
        while (prev != null && curr != null) {
            if (prev.val < curr.val) {
                temp.down = prev;
                prev = prev.down;
            } else {
                temp.down = curr;
                curr = curr.down;
            }
            temp = temp.down;
        }
        if (curr != null) {
            temp.down = curr;
        }
        if (prev != null) {
            temp.down = prev;
        }
        return tail;
    }
}
