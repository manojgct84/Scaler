package dc.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateNumberLinkedList
{
    
    public static void main (String[] args)
    {
        LinkedListNode node = new LinkedListNode (1);
        node.next = new LinkedListNode (2);
        node.next.next = new LinkedListNode (3);
        node.next.next.next = new LinkedListNode (4);
        node.next.next.next.next = new LinkedListNode (4);
        node.next.next.next.next.next = new LinkedListNode (3);
        node.next.next.next.next.next.next = new LinkedListNode (2);
        System.out.println (firstDuplicateNumberLinkedList (node));
        System.out.println (firstDuplicateNumberLinkedListNoSC (node));
    }
    
    //TC O(N);
    //SC O(N);
    private static int firstDuplicateNumberLinkedList (LinkedListNode head)
    {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 0;
        }
        
        Map <Integer, Integer> freq = new HashMap <> ();
        LinkedListNode curr = head;
        while (curr != null) {
            
            if (!freq.containsKey (curr.val)) {
                freq.put (curr.val ,
                          1);
            }
            else {
                freq.put (curr.val ,
                          freq.get (curr.val) + 1);
                
            }
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            if (freq.containsKey (curr.val) && freq.get (curr.val) > 1) {
                return curr.val;
            }
            curr = curr.next;
        }
        
        return 0;
    }
    
    private static int firstDuplicateNumberLinkedListNoSC (LinkedListNode head)
    {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 0;
        }
        
        LinkedListNode iCurr = head;
        LinkedListNode jCurr;
        while (iCurr != null) {
            jCurr = iCurr.next;
            while (jCurr != null) {
                if (jCurr.val == iCurr.val) {
                    return jCurr.val;
                }
                jCurr = jCurr.next;
            }
            iCurr = iCurr.next;
        }
        return 0;
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
