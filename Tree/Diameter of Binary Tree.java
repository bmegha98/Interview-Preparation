//Given a Binary Tree, find diameter of it.The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. 
class Solution 
{
    int diameter = 1;
    //Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here
        if(root == null)
            return 0;
        
        getHeight(root);
        return diameter;
    }
    private int getHeight(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        diameter = Math.max(diameter, l+1+r);
        return Math.max(l,r)+1;
    }
}
