/*
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) 
    {
        if(head == null || (head.next == null && head.val == 0))
            return null;
        ListNode dummy = new ListNode(0,head);
        /*
        //T(n) = O(n^2) , space = O(1)
        ListNode p = dummy,q = null;
        while(p != null)
        {
            q = p.next;
            int s = 0;
            while(q != null)
            {
                s += q.val;
                if(s == 0)
                    p.next = q.next;
                q = q.next;
            }
            p = p.next;
        }
        return dummy.next;
        */
        
        //T(n) = O(n) , space = O(1)
        Map<Integer,ListNode> m = new HashMap<>();
        ListNode curr = dummy;
        int s = 0;
        while(curr != null)
        {
            s += curr.val;
            m.put(s,curr);
            curr = curr.next;
        }
        curr = dummy;
        s = 0;
        while(curr != null)
        {
            s += curr.val;
            if(m.containsKey(s))
            {
                ListNode tmp = m.get(s);
                if(tmp != curr)
                    curr.next = tmp.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
