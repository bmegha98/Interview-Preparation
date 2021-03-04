//Given the root of a binary tree, return the preorder traversal of its nodes' values.

//Iterative

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Stack<TreeNode> aux = new Stack<>();
        while(true)
        {
            while(root != null)
            {
                res.add(root.val);
                aux.push(root);
                root = root.left;
            }
            if(aux.isEmpty())
                break;
            root = aux.pop();
            root = root.right;
        }
        return res;
    }
}

//Recursive

class Solution {
    
    private void helper(TreeNode root,List<Integer> result)
    {
        if(root == null)
            return;
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        helper(root,res);
        return res;
    }
}
