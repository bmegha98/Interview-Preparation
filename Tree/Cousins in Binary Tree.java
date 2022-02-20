/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values
x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

*/

class Solution {
    public boolean isCousins(TreeNode root, int a, int b) {
        if(root == null)
            return false;
        
        List<Integer> parents = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int currLevel = 0;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                if(!q.isEmpty())
                    q.add(null);
                currLevel++;
            }
            else {
                if(curr.left != null) {
                    q.add(curr.left);
                    if(curr.left.val == a || curr.left.val == b) {
                        parents.add(curr.val);
                        levels.add(currLevel+1);
                    }
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    if(curr.right.val == a || curr.right.val == b) {
                        parents.add(curr.val);
                        levels.add(currLevel+1);
                    }
                }
            }
        }
        
        if(parents.size() < 2)
            return false;
        return (levels.get(0) == levels.get(1))
                &&(parents.get(0) != parents.get(1));
    }
}
