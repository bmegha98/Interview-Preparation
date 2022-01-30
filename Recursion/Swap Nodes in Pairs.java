/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only 
nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
*/

//Recursive
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tmp = head.next, aux = head.next.next;
        tmp.next = head;
        head.next = swapPairs(aux);
        return tmp;
    }
}

//Iterative
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode res = head.next;
        ListNode curr = head,tail = null,aux;
        while(curr != null && curr.next != null) {
            ListNode tmp = curr.next;
            aux = tmp.next;
            ListNode join = curr;
            
            curr.next = aux;
            tmp.next = curr;
            curr = aux;
            
            if(tail != null)
                tail.next = tmp;
            tail = join;
        }
        return res;
    }
}
