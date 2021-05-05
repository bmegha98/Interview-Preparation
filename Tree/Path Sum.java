/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals
targetSum.A leaf is a node with no children.
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null)
            return root.val == targetSum?true:false;
        return hasPath(root, targetSum);
    }
    private boolean hasPath(TreeNode root, int sum) {
        if(root == null) 
            return false;
        sum -= root.val;
        if(root.left == null && root.right == null)
        {
            if(sum == 0)
                return true;
            return false;
        }
        boolean l = false;
        if(root.left != null) 
            l = hasPath(root.left, sum);
        if(l)
            return true;
        
        if(root.right != null)
            return hasPath(root.right, sum);
        return false;
    }
}
