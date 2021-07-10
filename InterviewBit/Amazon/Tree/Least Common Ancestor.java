/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.
Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has
both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    int count = 0;
    public int lca(TreeNode A, int B, int C) {
        if(A == null)
            return -1;
        TreeNode ans = helper(A,B,C);
        if(count == 2)
            return ans.val;
        if(count == 1 && B == C)
            return ans.val;
        return -1;
    }
    private TreeNode helper(TreeNode root,int p,int q) {
        if(root == null)
            return null;
        TreeNode l = helper(root.left,p,q);
        TreeNode r = helper(root.right,p,q);
        if(root.val == p || root.val == q) {
            count++;
            return root;
        }
        if(l!=null && r!=null)
            return root;
        return l!=null?l:r;
    }
}
