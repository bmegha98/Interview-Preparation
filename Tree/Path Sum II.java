//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.A leaf is a node with no children.

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        if(root.left == null && root.right == null)
        {
            if(root.val == targetSum){
                path.add(root.val);
                res.add(path);
            }
            return res;
        }
        allPaths(root,targetSum,path);
        return res;
    }
    
    private void allPaths(TreeNode root, int sum, List<Integer> path) {
        if(root == null)
            return;
        path.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null) {
            if(sum == 0)
                res.add(new ArrayList<Integer>(path));
        } 
        else {   
            if(root.left != null)
                allPaths(root.left, sum, path);
            if(root.right != null)
                allPaths(root.right, sum, path);
        }
        path.remove(path.size()-1);
    }
}
