/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list
sorted as well.
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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode curr = head,prev = dummy;
        while(curr != null)
        {
            while(curr.next != null && curr.val == curr.next.val)
                curr = curr.next;
            if(prev.next == curr)
                prev = curr;
            else
                prev.next = curr.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
