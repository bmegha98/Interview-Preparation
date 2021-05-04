/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
*/

//Iterative

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        
        Queue<TreeNode> aux = new LinkedList<>();
        res.add(root.val);
        aux.add(root);
        aux.add(null);
        
        while(!aux.isEmpty()) {
            TreeNode curr = aux.poll();
            if(curr == null) {
                if(!aux.isEmpty()) {
                    res.add(aux.peek().val);
                    aux.add(null);
                }
            }
            else {
                if(curr.right != null)
                    aux.add(curr.right);
                if(curr.left != null)
                    aux.add(curr.left);
            }
        }
        return res;
    }
}

//Recursive

class Solution {
    int visited = -1;
    private void helper(TreeNode root, int curr, List<Integer> l) {
        if(root == null)
            return;
        if(curr > visited) {
            l.add(root.val);
            visited = curr;
        }
        helper(root.right, curr+1, l);
        helper(root.left, curr+1, l);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        
        helper(root, 0, res);
        return res;
    }
}
