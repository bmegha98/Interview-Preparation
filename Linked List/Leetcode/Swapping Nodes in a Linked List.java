/*
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
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
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode first = head;
        for(int i =1;i<k;i++)
            first = first.next;
        ListNode slow = head,fast = head;
        while(fast != null && k > 0)
        {
            fast = fast.next;
            k--;
        }
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        int tmp = first.val;
        first.val = slow.val;
        slow.val = tmp;
        return head;
    }
}
