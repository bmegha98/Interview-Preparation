//Given the root of a binary tree, return the postorder traversal of its nodes' values.

//Modifying the tree

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> aux = new Stack<>();
        aux.push(root);
        while(!aux.isEmpty())
        {
            TreeNode curr = aux.peek();
            if(curr.left == null && curr.right == null)
            {
                aux.pop();
                res.add(curr.val);
            }
            else
            {
                if(curr.right != null)
                {
                    aux.push(curr.right);
                    curr.right = null;
                }
                if(curr.left != null)
                {
                    aux.push(curr.left);
                    curr.left = null;
                }
            }
        }
        return res;
    }
}

//Without modifying the tree

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> aux = new Stack<>();
        TreeNode mark = null;
        do
        {
            while(root != null)
            {
                aux.push(root);
                root = root.left;
            }
            while(root == null && !aux.isEmpty())
            {
                root = aux.peek();
                if(root.right == null || root.right == mark)
                {
                    res.add(root.val);
                    aux.pop();
                    mark = root;
                    root = null;
                }
                else
                    root = root.right;
            }
        }
        while(!aux.isEmpty());
        return res;
    }
}
