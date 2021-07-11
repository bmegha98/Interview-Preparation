/*
Given a binary tree, determine if it is height-balanced.
Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 

*/
//PostOrder traversal
public class Solution {
    int res = 1;
    public int isBalanced(TreeNode A) {
        if(A == null)
            return 1;
        helper(A);
        return res;
    }
    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        
        if(Math.abs(l-r) > 1)
            res = 0;
        return Math.max(l,r)+1;
    }
}
