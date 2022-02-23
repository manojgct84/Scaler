package dc.LinkedList.Class3.homework;

import dc.LinkedList.Class1.assignment.ListNode;

public class AddTwoNumbersListsI {

    public static void main(String[] args) {
        ListNode node0 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node3.next = node4;
        node4.next = node6;

        printNode(addTwoNumbers(node0, node3));
        System.out.println();
        ListNode node00 = new ListNode(9);
        ListNode node01 = new ListNode(9);


        node00.next = node01;

        ListNode node = new ListNode(1);

        printNode(addTwoNumbers(node00, node));

        System.out.println();
        ListNode node000 = new ListNode(9);

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(9);
        ListNode node_3 = new ListNode(9);
        node_1.next = node_2;
        node_2.next = node_3;
        printNode(addTwoNumbers(node000, node_1));
    }

    public static void printNode(ListNode head) {
        // Output each element followed by a space
        ListNode current = head;
        if (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode currA = A;
        ListNode prev = A;
        ListNode currB = B;
        int carry = 0;
        while (currA != null && currB != null) {
            int sum = currA.val + currB.val + carry;
            if (sum > 9) {
                currA.val = sum % 10;
                carry = sum / 10;
            } else {
                currA.val = sum;
                carry = 0;
            }
            prev = currA;
            currA = currA.next;
            currB = currB.next;
        }
        while (currA != null) {
            int sum = carry + currA.val;
            if (sum > 9) {
                currA.val = sum % 10;
                carry = sum / 10;
            } else {
                currA.val = sum;
                carry = 0;
            }
            if (currA.next == null) {
                break;
            }
            currA = currA.next;
        }

        if (carry !=0 && currA != null && currA.next == null) {
            currA.next = new ListNode(carry);
            carry = 0;
        }
        while (currB != null) {
            int sum = carry + currB.val;
            if (sum > 9) {
                prev.next = new ListNode(sum % 10);
                carry = sum / 10;
            } else {
                prev.next = new ListNode(sum);
                carry = 0;
            }
            prev = prev.next;
            currB = currB.next;
        }
        if (carry !=0) {
            prev.next = new ListNode(carry);
        }
        return A;
    }
}
