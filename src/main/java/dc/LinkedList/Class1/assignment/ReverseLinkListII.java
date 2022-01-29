package dc.LinkedList.Class1.assignment;

public class ReverseLinkListII {

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

        printNode(reverseBetween(node0, 3, 5));
        System.out.println();
        printNode(reverseBetween(node0, 1, 6));
        System.out.println();
        ListNode node00 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node333 = new ListNode(4);
        ListNode node44 = new ListNode(5);
        ListNode node55 = new ListNode(6);
        node00.next = node11;
        node11.next = node22;
        node22.next = node333;
        node333.next = node44;
        node44.next = node55;
        printNode(reverseBetween(node00, 1, 3));
        System.out.println();
        ListNode node97 = new ListNode(97);
        ListNode node63 = new ListNode(63);
        ListNode node89 = new ListNode(89);
        ListNode node34 = new ListNode(34);
        ListNode node82 = new ListNode(82);
        ListNode node95 = new ListNode(95);
        ListNode node04 = new ListNode(4);
        ListNode node70 = new ListNode(70);
        ListNode node14 = new ListNode(14);
        ListNode node41 = new ListNode(41);
        ListNode node38 = new ListNode(38);
        ListNode node83 = new ListNode(83);
        ListNode node49 = new ListNode(49);
        ListNode node32 = new ListNode(32);
        ListNode node68 = new ListNode(68);
        ListNode node56 = new ListNode(56);
        ListNode node99 = new ListNode(99);
        ListNode node52 = new ListNode(52);
        ListNode node33 = new ListNode(33);
        ListNode node54 = new ListNode(54);
        node97.next = node63;
        node63.next = node89;
        node89.next = node34;
        node34.next = node82;
        node82.next = node95;
        node95.next = node04;
        node04.next = node70;
        node70.next = node14;
        node14.next = node41;
        node41.next = node38;
        node38.next = node83;
        node83.next = node49;
        node49.next = node32;
        node32.next = node68;
        node68.next = node56;
        node56.next = node99;
        node99.next = node52;
        node52.next = node33;
        node33.next = node54;
        printNode(reverseBetween(node97, 13, 15));
        System.out.println();
        printNode(reverseBetween(node00, 4, 5));

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

    public static ListNode reverseBetween(ListNode head, int B, int C) {
        ListNode current = head;
        ListNode prev = null;
        if (head == null) {
            return null;
        }
        ListNode pv = null;
        C = C - B + 1;
        //Store the first B position in previous Node.
        while (current != null && B > 1) {
            ListNode next = current.next;
            current.next = null;
            if (prev == null) {
                prev = current;
                pv = prev;
            } else {
                pv.next = current;
                pv = pv.next;
            }
            current = next;
            B--;
        }
        ListNode reverse = null;
        //Reverse the second half until C becomes 0.
        while (current != null && C > 0) {
            ListNode next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
            C--;
        }
        ListNode p = prev;
        while (p != null && p.next != null) { // move to the last node of prev node.
            p = p.next;
        }
        if (p != null) { //attach the prev and reverse node.
            p.next = reverse;
        }
        ListNode r = reverse;
        while (r != null && r.next != null) { //// move to the last node of reverse node.
            r = r.next;
        }
        if (r != null) { //attach the reverse and current node.
            r.next = current;
        }

        if (prev == null) { //if the B is less then one.
            return reverse;
        }

        return prev;
    }
}
