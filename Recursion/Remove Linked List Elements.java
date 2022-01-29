/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
*/

//Iterative
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        if(head.next == null)
            return head.val == val?null:head;
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(head != null) {
            if(head.val != val) {
                res.next = head;
                res = res.next;
            }
            head = head.next;
        }
        res.next = null;
        return dummy.next;
    }
}

//Recursive
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        if(head.next == null)
            return head.val == val?null:head;
        ListNode res = head;
        res.next = removeElements(head.next,val);
        if(head.val == val)
            return res.next;
        return res;
    }
}
