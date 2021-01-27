//Given the head of a linked list, return the list after sorting it in ascending order.

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
    ListNode getMiddle(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head,fast = head.next;
        while(fast != null)
        { 
            fast = fast.next;
            if(fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
    
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    
    ListNode mergeLists(ListNode first,ListNode second)
    {
        if(first == null)
            return second;
        if(second == null)
            return first;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(first != null && second != null)
        {
            if(first.val <= second.val)
            {
                res.next = first;
                first = first.next;
            }
            else
            {
                res.next = second;
                second = second.next;
            }
            res = res.next;
        }
        if(first != null)
            res.next = first;
        else
            res.next = second;
        return dummy.next;
    }
    void printList(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val +"  ");
            head = head.next;
        }
        System.out.println();
    }
    public ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
       
        ListNode mid = getMiddle(head);
        
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        return mergeLists(first,second);
    }
}
