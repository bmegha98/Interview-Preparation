/*
Given a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
*/

public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        // code here.
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        boolean isBst = true;
        int prev = Integer.MIN_VALUE;
        
        Stack<Node> aux = new Stack<>();
        while(true) {
            while(root != null) {
                aux.push(root);
                root = root.left;
            }
            if(aux.isEmpty())
                break;
            root = aux.pop();
            if(root.data <= prev)
                return false;
            prev = root.data;
            root = root.right;
        }
        return true;
    }
}
