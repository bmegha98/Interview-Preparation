/*
Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 
*/

class Tree
{
    boolean flag = true;
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if(root == null)
            return true;
        getHeight(root);
        return flag;
    }
    private int getHeight(Node root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        if(Math.abs(l-r) > 1)
            flag = false;
        return Math.max(l,r)+1;
    }
}
