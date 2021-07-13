/*
Given a binary tree A with N nodes.
You have to remove all the half nodes and return the final binary tree.

NOTE:

Half nodes are nodes which have only one child.
Leaves should not be touched as they have both children as NULL.
*/

public class Solution {
    public TreeNode solve(TreeNode A) {
        if(A == null)
            return null;
        A.left = solve(A.left);
        A.right = solve(A.right);
        
        if((A.left == null && A.right == null)||(A.left != null && A.right != null))
            return A;
        return A.left !=null? A.left:A.right;
    }
}
