//Sort a linked list using insertion sort.

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
    
    ListNode getPrev(ListNode head,ListNode ele)
    {
        if(head == null || head == ele)
            return null;
        ListNode curr = head;
        while(curr != null && curr.next != ele)
            curr = curr.next;
        if(curr == null)
            return null;
        return curr;
    }
    public ListNode insertionSortList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode j,i=head.next,prevI = head;
        while(i != null)
        {
            ListNode aux = i.next;
            j = head;
            ListNode prevJ = null;
            while(j != i && j.val <= i.val)
            {
                prevJ = j;
                j = j.next;
            }
            if(j != i)
            {
                prevI.next = aux;
                i.next = j;
                if(prevJ == null)
                    head = i;
                else
                    prevJ.next = i;
            
            }
            i = aux;
            prevI = getPrev(head,i);
        }
        return head;
    }
}
