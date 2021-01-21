/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
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
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode lessNode = new ListNode();
        ListNode greaterNode = new ListNode();
        ListNode lHead = lessNode,gHead = greaterNode;
        while(head != null)
        {
            if(head.val < x)
            {
                lessNode.next = head;
                lessNode = lessNode.next;
            }
            else
            {
                greaterNode.next = head;
                greaterNode = greaterNode.next;
            }
            head = head.next;
        }
        greaterNode.next = null;
        lessNode.next = gHead.next;
        return lHead.next;
    }
}
