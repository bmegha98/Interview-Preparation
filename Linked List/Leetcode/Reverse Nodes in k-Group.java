/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, 
should remain as it is.
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
    
    boolean hasKNodes(ListNode curr,int k)
    {
        for(int i = 1;i<=k;i++)
        {
            if(curr == null)
                return false;
            curr = curr.next;
        }
        return true;
    }
    ListNode getKPlusOneNode(ListNode curr,int k)
    {
        for(int i = 1;i<=k;i++)
        {
            if(curr == null)
                return null;
            curr = curr.next;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(k < 2 || head == null || head.next == null)
            return head;
        ListNode newHead;
        if(hasKNodes(head,k))
            newHead = getKPlusOneNode(head,k-1);
        else
            newHead = head;
        
        ListNode curr = head,tmp,aux,tail = null;
        while(curr != null && hasKNodes(curr,k))
        {
            ListNode join = curr;
            tmp = getKPlusOneNode(curr,k);
            int i = 0;
            while(i<k)
            {
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
}
