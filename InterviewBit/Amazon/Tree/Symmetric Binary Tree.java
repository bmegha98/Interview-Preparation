/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric.
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Symmetric tree of a binary tree is a tree in which left and right children of all non-leaf nodes are interchanged.
*/

public class Solution {
    public int isSymmetric(TreeNode A) {
        if(A == null || (A.left == null && A.right == null))
            return 1;
        return helper(A,A)?1:0;
    }
    
    private boolean helper(TreeNode a, TreeNode b) {
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return (a.val == b.val)&&helper(a.left,b.right)&&helper(a.right,b.left);
    }
}
