/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length == 0)
            return null;
        Queue<ListNode> p = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
                     public int compare(ListNode l1,ListNode l2)
                     {
                         return l1.val-l2.val;
                     }
        });
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i] != null)
                p.offer(lists[i]);
        }
        ListNode res = null,newHead = null;
        while(!p.isEmpty())
        {
            ListNode curr = p.poll();
            if(curr.next != null)
                p.offer(curr.next);
            if(res == null)
            {
                res = curr;
                newHead = curr;
            }
            else
            {
                res.next = curr;
                res = res.next;
            }
        }
        return newHead;
    }
}
