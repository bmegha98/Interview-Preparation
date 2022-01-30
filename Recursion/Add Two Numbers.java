/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single
digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

//Iterative T(n) = Space = O(max(m,n))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        
        int carry = 0;
        while(l1 != null || l2 != null) {
            int num1 = l1 != null?l1.val : 0;
            int num2 = l2 != null?l2.val : 0;
            
            int sum = num1+num2+carry;
            carry = sum/10;
            sum %= 10;
            
            ListNode curr = new ListNode(sum);
            res.next = curr;
            res = res.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry == 1)
            res.next = new ListNode(1);
        return dummy.next;
    }
}

//Recursive
class Solution {
    ListNode dummy = new ListNode();
    ListNode res = dummy;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        helper(l1,l2);
        if(carry == 1)
            res.next = new ListNode(1);
        return dummy.next;
    }
    private void helper(ListNode a, ListNode b) {
        if(a == null && b == null)
            return;
        int num1 = a != null?a.val : 0;
        int num2 = b != null?b.val : 0;
            
        int sum = num1+num2+carry;
        carry = sum/10;
        sum %= 10;

        res.next = new ListNode(sum);;
        res = res.next;
        
        ListNode newA = a == null?null : a.next;
        ListNode newB = b == null?null : b.next;
        helper(newA, newB);
    }
}
