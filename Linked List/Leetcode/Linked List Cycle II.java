/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used 
to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Notice that you should not modify the linked list.
*/
//

//T(n) = O(n) , space = O(n)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head)
    {
        
        if(head == null || head.next == null)
            return null;
        if(head.next == head)
            return head;
        Set<ListNode> s = new HashSet<>();
        while(head != null)
        {
            if(s.contains(head))
                return head;
            s.add(head);
            head = head.next;
        }
        return null;
    }
}

//T(n) = O(n) , space = O(1)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head)
    {
        if(head == null || head.next == null)
            return null;
        if(head.next == head)
            return head;
        ListNode slow = head,fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return null;
        slow = head;
        while(fast != slow)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
