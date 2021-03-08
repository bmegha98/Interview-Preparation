/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and
alternate between).
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        boolean leftToRight = true;
        List<Integer> level = new ArrayList<>();
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currentLevel.push(root);
       
        while(!currentLevel.isEmpty())
        {
            TreeNode curr = currentLevel.pop();
        
            level.add(curr.val);
            if(leftToRight)
            {
                if(curr.left != null)
                    nextLevel.push(curr.left);
                if(curr.right != null)
                    nextLevel.push(curr.right);
            }
            else
            {
                if(curr.right != null)
                    nextLevel.push(curr.right);
                if(curr.left != null)
                    nextLevel.push(curr.left);
            }
                
            if(currentLevel.isEmpty())
            {
                res.add(level);
                level = new ArrayList<>();
                leftToRight = leftToRight?false:true;
                Stack<TreeNode> tmp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmp;
            }
        }
        return res;
    }
}
