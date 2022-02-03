/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, 
should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        
        ListNode newHead;
        if(hasKNodes(head,k))
            newHead = getKPlusOneNode(head,k-1);
        else
            newHead = head;
        
        ListNode curr = head, aux, tail = null, tmp;
        while(curr != null && hasKNodes(curr,k)) {
            tmp = getKPlusOneNode(curr,k);
            ListNode join = curr;
            
            int i = 0;
            while(i<k) {
                aux = curr.next;
                curr.next = tmp;
                tmp = curr;
                curr = aux;
                i++;
            }
            
            if(tail != null)
                tail.next = tmp;
            tail = join;
        }
        return newHead;
    }
    
    private boolean hasKNodes(ListNode head, int k) {
        ListNode curr = head;
        int i=0;
        for(;i<k && curr != null;i++,curr = curr.next);
        
        return i>=k;
    }
    
    private ListNode getKPlusOneNode(ListNode head, int k) {
        ListNode curr = head;
        for(int i=0;i<k && curr != null;i++,curr = curr.next);
        return curr;
    }
}
    
