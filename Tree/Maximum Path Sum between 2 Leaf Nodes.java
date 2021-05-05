//Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.

class Tree
{
    int maxSum = Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
        // code here 
        if(root == null)
            return 0;
        helper(root);
        return maxSum;
    } 
    private int helper(Node root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
        int l = helper(root.left);
        int r = helper(root.right);
        
        if(root.right == null)
            return l+root.data;
        if(root.left == null)
            return r+root.data;
        int tmp = l+root.data+r;
        maxSum = Math.max(maxSum, tmp);
        return Math.max(l,r)+root.data;
    }
}
