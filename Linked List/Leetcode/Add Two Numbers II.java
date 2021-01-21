/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
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
class Solution 
{
    ListNode res;
    int carry = 0;
    void addSameSize(ListNode a,ListNode b)
    {
        if(a == null || b == null)
            return;
        
        addSameSize(a.next,b.next);
        int s = a.val+b.val+carry;
        carry = s/10;
        s %= 10;
        ListNode tmp = new ListNode(s);
        tmp.next = res;
        res = tmp;
    }
    void addRemaining(ListNode l,ListNode curr)
    {
        if(l == curr)
            return;
        addRemaining(l.next,curr);
        int s = carry + l.val;
        carry = s/10;
        s %= 10;
        ListNode tmp = new ListNode(s);
        tmp.next = res;
        res = tmp;
    }
    
    int getLength(ListNode l)
    {
        int len = 0;
        for(ListNode curr =l;curr != null;curr = curr.next)
            len++;
        return len;
    }
    void printList(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int m = getLength(l1),n = getLength(l2);
    
        if(m == n)
            addSameSize(l1,l2);
        else
        {
            int diff = Math.abs(m-n);
            if(m<n)
            {
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
          
            
            ListNode curr = l1;
            while(diff-- > 0)
                curr = curr.next;
            addSameSize(curr,l2);
            
            addRemaining(l1,curr);
        }
        if(carry == 1)
        {
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }
        return res;
    }
}
