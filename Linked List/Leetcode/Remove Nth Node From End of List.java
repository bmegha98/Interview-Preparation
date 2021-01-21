/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode slow = head,fast = head;
        while(n > 0 && fast != null)
        {
            fast = fast.next;
            n--;
        }
        if(n > 0)
            return null;
        ListNode prev = null;
        while(fast != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prev == null)
            return slow.next;
        prev.next = slow.next;
        return head;
    }
}
