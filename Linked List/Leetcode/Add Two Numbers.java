/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single 
digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    
    ListNode res;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        res = dummy;
        while(l1 != null || l2 != null)
        {
            int num1 = l1 != null?l1.val:0;
            int num2 = l2 != null?l2.val:0;
            
            int s = num1+num2+carry;
            carry = s/10;
            s = s%10;
            ListNode tmp = new ListNode(s,null);
            dummy.next = tmp;
            dummy = dummy.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1)
        {
            ListNode tmp = new ListNode(1,null);
            dummy.next = tmp;
            dummy = dummy.next;
        }
        return res.next;
    }
}
