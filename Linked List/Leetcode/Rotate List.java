//Given the head of a linked list, rotate the list to the right by k places.

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
    
    int getLength(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null ||head.next == null|| k == 0)
            return head;
        int n = getLength(head);
        k = k%n;
        if(k == 0)
            return head;
        int rem = n-k;
        ListNode first = head,prev = null;
        while(rem-- > 0)
        {
            prev = first;
            first = first.next;
        }
        if(prev != null)
            prev.next = null;
        ListNode newHead = first;
        while(first.next != null)
            first = first.next;
        first.next = head;
        return newHead;
    }
}
