package dc.LinkedList;

/**
 * Even Odd number for linked-list.
 */
public class OddAndEven
{
    
    public static void main (String[] args)
    {
        LinkedListNode node = new LinkedListNode (1);
        node.next = new LinkedListNode (2);
        node.next.next = new LinkedListNode (3);
        node.next.next.next = new LinkedListNode (4);
        node.next.next.next.next = new LinkedListNode (5);
        node.next.next.next.next.next = new LinkedListNode (6);
        node.next.next.next.next.next.next = new LinkedListNode (7);
        System.out.println (oddAndEven (node).toString ());
    }
    
    public static LinkedListNode oddAndEven (LinkedListNode head)
    {
        
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        LinkedListNode even = new LinkedListNode (-1);
        LinkedListNode evenTail = even;
        LinkedListNode odd = new LinkedListNode (-1);
        LinkedListNode oddTail = odd;
        
        LinkedListNode curr = head;
        while (curr != null) {
              if (curr.val % 2 == 0) {
                  evenTail.next = curr;
                  curr = curr.next;
                  evenTail = evenTail.next;
                  evenTail.next = null;
              } else {
                  oddTail.next = curr;
                  curr = curr.next;
                  oddTail = oddTail.next;
                  oddTail.next = null;
              }
        }
        evenTail.next = odd.next;
        return even.next;
    }
    
    static class LinkedListNode
    {
        @Override
        public String toString ()
        {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
        
        public int val;
        public LinkedListNode next;
        
        public LinkedListNode (int x)
        {
            this.val = x;
            this.next = null;
        }
        
    }
}
