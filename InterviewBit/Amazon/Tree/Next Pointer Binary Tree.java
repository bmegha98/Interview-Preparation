/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example :

Given the following perfect binary tree,

         1
       /  \
      2    5
     / \  / \
    3  4  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL
Note that using recursion has memory overhead and does not qualify for constant space.
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        TreeLinkNode curr = root;
        while(curr != null) {
            TreeLinkNode tmp = curr;
            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode res = dummy;
            
            while(tmp != null) {
                if(tmp.left != null) {
                    res.next = tmp.left;
                    res = res.next;
                }
                if(tmp.right != null) {
                    res.next = tmp.right;
                    res = res.next;
                }
                tmp = tmp.next;
            }
            
            curr = dummy.next;
        }
    }
}
