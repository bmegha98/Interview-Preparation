/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

//T(n) = O(nlogn) , space = O(logn)
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    ListNode getMiddle(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head,fast = head,prev = null;
        while(fast != null && fast.next != null)
        {
                fast = fast.next.next;
                slow = slow.next;
        }
        return slow;
    }
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head == null)
            return null;
        if(head.next == null)
        {
            TreeNode t = new TreeNode(head.val);
            return t;
        }
        ListNode mid = getMiddle(head);
        
        ListNode prev = head;
        while(prev != null && prev.next != mid)
            prev = prev.next;
        if(prev != null)
            prev.next = null;
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}

// T(n) = O(n) , space = O(logn)
//Insert nodes in the given list order 
class Solution 
{
    ListNode head_orig = null;
    int getSize(ListNode head)
    {
        if(head == null)
            return 0;
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head == null)
            return null;
        if(head.next == null)
        {
            TreeNode t = new TreeNode(head.val);
            return t;
        }
        int n = getSize(head);
        head_orig = head;
        return helper(0,n-1);
    }
    TreeNode helper(int start,int end)
    {
        if(start > end)
            return null;
        int m = start+(end-start)/2;
        TreeNode l = helper(start,m-1);
        TreeNode root = new TreeNode(head_orig.val);
        root.left = l;
        head_orig = head_orig.next;
        root.right = helper(m+1,end);
        return root;
    }
}
