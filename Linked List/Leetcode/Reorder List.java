/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.
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
    
    ListNode reverse(ListNode head)
    {
        ListNode curr = head,prev = null,aux;
        while(curr != null)
        {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
    public void reorderList(ListNode head) 
    {
        if(head == null || head.next == null)
            return;
        ListNode slow = head,fast = head.next;
        while(fast != null)
        {
            fast = fast.next;
            if(fast != null)
            {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode f = head,s = slow.next;
        slow.next = null;
        s = reverse(s);
        ListNode res = new ListNode(-1);
        head = res;
        while(s != null)
        {
            res.next = f;
            res = res.next;
            f = f.next;
            res.next = s;
            res = res.next;
            s = s.next;
        }
        res.next = f;
        head =head.next;
    }
}
