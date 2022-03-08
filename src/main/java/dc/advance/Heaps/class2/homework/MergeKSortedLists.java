package dc.advance.Heaps.class2.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ArrayList<ListNode> input = new ArrayList<>();

        ListNode node0 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        // ListNode node7 = new ListNode(7);

        node0.next = node3;
        node3.next = node5;
        //node5.next = node7;


        ListNode node2 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);


        node2.next = node4;
        node4.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(22);
        ListNode node9 = new ListNode(10);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(8);


        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        input.add(node0);
        input.add(node2);
        input.add(node8);
        System.out.println(mergeKLists(input));
    }

    public static ListNode mergeKLists(ArrayList<ListNode> list) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val >= o2.val ? 1 : -1;
            }
        });


        for (int i = 0; i < list.size(); i++) {
            ListNode curr = list.get(i);
            while (curr != null) {
                ListNode next = curr.next;
                minHeap.add(curr);
                curr.next = null;
                curr = next;
            }
        }
        System.out.print(minHeap.toString());

        return mergeLinkedList(minHeap);
    }

    private static ListNode mergeLinkedList(PriorityQueue<ListNode> minHeap) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
        }
        return dummy.next;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    //", next=" + next +
                    '}';
        }
    }
}
