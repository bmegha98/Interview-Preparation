/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        while(curr != null) {
            ListNode aux = curr.next;
            while(aux != null && aux.val == curr.val)
                aux = aux.next;
            curr.next = aux;
            curr = curr.next;
        }
        return head;
    }
}
