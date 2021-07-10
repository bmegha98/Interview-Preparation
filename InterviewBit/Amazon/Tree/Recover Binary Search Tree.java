/*
Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST          
*/

//Using Recursion
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
    int first = -1,second = -1;
    TreeNode prev = null;
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        helper(A);
        res.add(second);
        res.add(first);
        return res;
    }
    private void helper(TreeNode curr) {
        if(curr == null)
            return;
        helper(curr.left);
        if(prev != null) {
            if(prev.val > curr.val) {
                if(first == -1)
                    first = prev.val;
                second = curr.val;
            } 
        }
        prev = curr;
        helper(curr.right);
    }
}

//Using Morris Traversal
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
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        
        TreeNode curr = A,prev = null;
        int first = -1,second = -1;
        while(curr != null) {
            if(curr.left == null) {
                if(prev != null) {
                    if(prev.val > curr.val) {
                        if(first == -1)
                            first = prev.val;
                        second = curr.val;
                    } 
                }
                prev = curr;
                curr = curr.right;
            }
            else {
                TreeNode tmp = curr.left;
                while(tmp.right != null && tmp.right != curr)
                    tmp = tmp.right;
                if(tmp.right == null) {
                    tmp.right = curr;
                    curr = curr.left;
                }
                else {
                    tmp.right = null;
                    if(prev != null) {
                        if(prev.val > curr.val) {
                            if(first == -1)
                                first = prev.val;
                            second = curr.val;
                        } 
                    }
                prev = curr;
                curr = curr.right;
                }
            }
        }
        res.add(second);
        res.add(first);
        return res;
    }
}
