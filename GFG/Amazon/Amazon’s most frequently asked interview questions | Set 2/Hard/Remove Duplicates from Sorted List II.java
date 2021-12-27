/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list
sorted as well.
Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy, curr = head;
        while(curr != null) {
            ListNode aux = curr.next;
            while(aux != null && aux.val == curr.val)
                aux = aux.next;
            if(curr.next == aux) {
                prev = curr;
                curr = curr.next;
            }
            else {
                prev.next = aux;
                curr = aux;
            }
        }
        
        return dummy.next;
        
    }
}
