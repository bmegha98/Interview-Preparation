/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the 
nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        
        ListNode oddHead = oddList,evenHead = evenList;
        int count = 1;
        while(head != null)
        {
            if(count%2 == 0)
            {
                evenList.next = head;
                evenList = evenList.next;
            }
            else
            {
                oddList.next = head;
                oddList = oddList.next;
            }
            head = head.next;
            count++;
        }
        evenList.next = null;
        oddList.next = evenHead.next;
        return oddHead.next;
    }
}
