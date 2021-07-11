/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :
Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3
In BST, nodes in left subtree < root < nodes in right subtree.
Balanced BST is a BST with equal number of nodes on both sides of root.
So at each step, select mid element as root.
*/
//T(n) = 2*T(n/2)+O(1) = O(n) , Space = O(logn)
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        int n = A.length;
        if(n == 0)
            return null;
        if(n == 1)
            return new TreeNode(A[0]);
        return constructTree(A,0,n-1);
    }
    private TreeNode constructTree(int[] A,int l,int h) {
        if(l > h)
            return null;
        int m = l+(h-l)/2;
        TreeNode root = new TreeNode(A[m]);
        if(l == h)
            return root;
        root.left = constructTree(A,l,m-1);
        root.right = constructTree(A,m+1,h);
        return root;
    }
}
