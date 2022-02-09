/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in
any order.

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if(low > high) {
            res.add(null);
            return res;
        }
        if(low == high) {
            res.add(new TreeNode(low));
            return res;
        }
        
        for(int i=low;i<=high;i++) {
            List<TreeNode> left = helper(low,i-1);
            List<TreeNode> right = helper(i+1,high);
            
            for(TreeNode l : left)
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
        }
        return res;
    }
}
