/*
Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
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
    
    int getLength(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode[] splitListToParts(ListNode root, int k) 
    {
        ListNode[] res = new ListNode[k];
        int n = getLength(root);
        ListNode curr = root;
        if(n <= k)
        {
            for(int i=0;i<k && curr != null;i++)
            {
                res[i] = curr;
                curr = curr.next;
                res[i].next = null;
            }
            return res;
        }
        int parts = n/k,rem = n%k;
        curr = root;
        ListNode prev = null;
        for(int i=0;i<k;i++)
        {
            int count = parts;
            if(rem > 0)
            {
                count++;
                rem--;
            }
            res[i] = curr;
            while(count > 0)
            {
                prev = curr;
                curr = curr.next;
                count--;
            }
            if(prev != null)
                prev.next = null;
        }
        return res;
    }
}
