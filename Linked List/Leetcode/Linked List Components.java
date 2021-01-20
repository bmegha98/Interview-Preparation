/*
We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
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
    public int numComponents(ListNode head, int[] G) 
    {
        int count = 0;
        if(head == null || G.length == 0)
            return 0;
        if(head.next == null)
            return 1;
        Set<Integer> s = new HashSet<Integer>();
        for(int ele:G)
            s.add(ele);
        while(head != null)
        {
            if(s.contains(head.val))
            {
                while(head != null && s.contains(head.val))
                    head = head.next;
                count++;
            }
            else
                head = head.next;
            //System.out.println(count);
        }
        return count;
    }
}
