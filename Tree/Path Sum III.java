/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
*/

//T(n) = O(n^2)

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val == targetSum?1:0;
        List<Integer> path = new ArrayList<>();
        allPaths(root, targetSum, path);
        return count;
    }
    
    private void allPaths(TreeNode root, int sum, List<Integer> path) {
        if(root == null)
            return;
        path.add(root.val);
        allPaths(root.left, sum,path);
        allPaths(root.right, sum, path);
        
        int tmp = 0,n = path.size();
        for(int i = n-1;i>=0;i--){
            tmp += path.get(i);
            if(tmp == sum)
                count++;
        }
        path.remove(n-1);
    }
}

//T(n) = O(n)
class Solution {
    int count = 0;
    Map<Integer,Integer> aux = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val == targetSum?1:0;
        allPaths(root, targetSum, 0);
        return count;
    }
  private void allPaths(TreeNode root, int target, int curr) {
        if(root == null) return;
        curr += root.val;
        if(curr == target) count++;
        if(aux.containsKey(curr-target))
            count += aux.get(curr-target);
        aux.put(curr, aux.getOrDefault(curr,0)+1);
        allPaths(root.left, target, curr);
        allPaths(root.right, target, curr);
        aux.put(curr, aux.get(curr)-1);
    }
}
