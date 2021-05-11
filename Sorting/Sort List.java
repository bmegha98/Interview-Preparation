/*
Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
    private ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head,fast = head.next;
        while(fast != null){
            fast = fast.next;
            if(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    private ListNode mergeLists(ListNode a , ListNode b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while(a != null && b != null) {
            if(a.val <= b.val) {
                res.next = a;
                a = a.next;
            }
            else {
                res.next = b;
                b = b.next;
            }
            res = res.next;
        }
        if(a != null)
            res.next = a;
        else
            res.next = b;
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode m = getMiddle(head);
        ListNode s = m.next;
        m.next = null;
        
        ListNode first = sortList(head);
        ListNode second = sortList(s);
        return mergeLists(first,second);
    }
}
