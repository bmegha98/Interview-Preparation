/*
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        res = new ArrayList<>();
        if(A == null)
            return res;
        helper(A,B,new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int sum, ArrayList<Integer> path) {
        if(root == null) {
            if(sum == 0) 
                res.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if(root.left == null)
            helper(root.right, sum, path);
        else if(root.right == null) 
            helper(root.left,sum,path);
        else {
            helper(root.left,sum,path);
            helper(root.right,sum,path);
        }
        path.remove(path.size()-1);
    }
}
