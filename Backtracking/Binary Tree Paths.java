/*
Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no children.
Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]

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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root,"");
        return res;
    }
    
    private void helper(TreeNode root, String path) {
        if(root.left == null && root.right == null) {
            path += ""+root.val;
            res.add(path);
            return;
        }
        path += root.val+"->";
        if(root.left != null)
            helper(root.left, path);

        if(root.right != null)
            helper(root.right, path);
    }
}
