/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode first = head;
        ListNode second = getRemaining(head);
        second = reverse(second);
        
        head = mergeLists(first,second);
    }
    
    private ListNode getRemaining(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null) {
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head,prev = null,aux;
        while(curr != null) {
            aux = curr.next;
            curr.next = prev;
            prev = curr;
            curr = aux;
        }
        return prev;
    }
    
    private ListNode mergeLists(ListNode a, ListNode b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while(a != null && b!=null) {
            res.next = a;
            a = a.next;
            res = res.next;
            res.next = b;
            b = b.next;
            res = res.next;
        }
        if(a != null)
            res.next = a;
        else
            res.next = b;
        return dummy.next;
    }
}
