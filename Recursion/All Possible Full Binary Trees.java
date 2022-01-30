/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 

Example 1:


Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]
 

Constraints:

1 <= n <= 20
*/

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0) {
            res.add(null);
            return res;
        }
        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if(n%2 == 0)
            return res;
        for(int k=1;k<n;k++) {
            List<TreeNode> left = allPossibleFBT(k);
            List<TreeNode> right = allPossibleFBT(n-k-1);
            for(TreeNode l : left)
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
        }
        return res;
    }
}

//With memoization
class Solution {
    Map<Integer,List<TreeNode>> aux = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0) {
            res.add(null);
            return res;
        }
        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if(n%2 == 0)
            return res;
        if(aux.containsKey(n))
            return aux.get(n);
        for(int k=1;k<n;k++) {
            List<TreeNode> left = allPossibleFBT(k);
            List<TreeNode> right = allPossibleFBT(n-k-1);
            for(TreeNode l : left)
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
        }
        aux.put(n,res);
        return res;
    }
}
