//Given a linked list, swap every two adjacent nodes and return its head.

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
    public ListNode swapPairs(ListNode head) 
    {
        
        if(head == null || head.next == null)
            return head;
        /*
        ListNode tmp = head.next;
        ListNode rem = tmp.next;
        tmp.next = head;
        head.next = swapPairs(rem);
        return tmp;
        */
        ListNode newHead = head.next;
        ListNode curr = head,aux,tmp,tail = null;
        while(curr != null && curr.next != null)
        {
            ListNode join = curr;
            aux = curr.next;
            tmp = aux.next;
            
            aux.next = curr;
            curr.next = tmp;
            
            curr = tmp;
            if(tail != null)
                tail.next = aux;
            tail = join;
        }
        return newHead;
    }
}
