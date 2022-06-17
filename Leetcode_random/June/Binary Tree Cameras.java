/*
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its
immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:


Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0
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
class Solution {
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(root == null)
            return cameras;
        int res = helper(root);
        if(res == -1)
            cameras++;
        return cameras;
    }
    
    private int helper(TreeNode root) {
        if(root == null)
            return 1; //already covered
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == -1 || right == -1) {
            cameras++;
            return 0; //has camera
        }
        
        if(left == 0 || right == 0)
            return 1;
        
        return -1; //both children are covered, tell parent to cover this node
    }
}
