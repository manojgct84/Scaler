package dc.LinkedList.Class1.assignment;

public class ListNode {
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

}
