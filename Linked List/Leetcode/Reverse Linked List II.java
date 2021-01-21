/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = head,second =head,prev = dummy;
        int i = 1;
        while(i < m)
        {
            prev = first;
            first = first.next;
            second = second.next;
            i++;
        }
        while(i < n)
        {
            second = second.next;
            i++;
        }
        ListNode aux,tmp,rem;
        tmp = rem = second.next;
        
        while(first != rem)
        {
            aux = first.next;
            first.next = tmp;
            tmp = first;
            first = aux;
        }
        prev.next = tmp;
        return dummy.next;
    }
}
