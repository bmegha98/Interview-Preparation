/*
Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3
Worst case occurs when tree is left/right skewed
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
    Map<Integer,Integer> aux = new HashMap<>();
    int ind = 0;
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        if(n == 0) return null;
        if(n == 1) return new TreeNode(A.get(0));
        
        for(int i=0;i<n;i++)
            aux.put(B.get(i),i);
        
        return helper(A,B,0,n-1);
    }
    private TreeNode helper(ArrayList<Integer> pre,ArrayList<Integer> in,int l,int h) {
        if(l > h)
            return null;
        TreeNode root = new TreeNode(pre.get(ind));
        ind++;
        if(l == h)
            return root;
        int pos = aux.get(root.val);
        root.left = helper(pre,in,l,pos-1);
        root.right = helper(pre,in,pos+1,h);
        return root;
    }
}
