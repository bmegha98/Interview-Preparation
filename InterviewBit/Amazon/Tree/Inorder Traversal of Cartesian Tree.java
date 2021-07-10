/*
Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1

root = max element
At each step , find index of max element (say i) 
  root = A[i]
  root.left = A[0....i-1] and root.right = A[i+1....n-1]
  
  
 Worst case : Array is in increasing order
 T(n) = T(n-1)+O(n) = O(n*n)
 Space = O(n)
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
    public TreeNode buildTree(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 0)
            return null;
        if(n == 1)
            return new TreeNode(A.get(0));
        return constructTree(A,0,n-1);
    }
    private TreeNode constructTree(ArrayList<Integer> A,int l,int h) {
        if(l > h)
            return null;
        int i = findMax(A,l,h);
        TreeNode root = new TreeNode(A.get(i));
        if(l == h)
            return root;
        root.left = constructTree(A,l,i-1);
        root.right = constructTree(A,i+1,h);
        return root;
    }
    private int findMax(ArrayList<Integer> A,int l,int h) {
        int ans = Integer.MIN_VALUE,ind = -1;
        while(l<=h) {
            if(ans < A.get(l)) {
                ans = A.get(l);
                ind = l;
            }
            l++;
        }
        return ind;
    }
}
