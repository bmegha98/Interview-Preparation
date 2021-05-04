//Given a binary tree, find its height.

class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        // code here 
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        int l = height(node.left);
        int r = height(node.right);
        return Math.max(l,r)+1;
    }
}
