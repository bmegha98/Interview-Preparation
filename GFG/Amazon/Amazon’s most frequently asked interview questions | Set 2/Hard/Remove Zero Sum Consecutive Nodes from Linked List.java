/*
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
*/

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode p = dummy;
        while(p != null) {
            ListNode q = p.next;
            int s = 0;
            while(q != null) {
                s += q.val;
                if(s == 0) 
                    p.next = q.next;
                q = q.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
