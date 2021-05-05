//Given a Binary Tree, convert it into its mirror.

class Solution
{
    //Function to convert a binary tree into its mirror tree.
    void mirror(Node node)
    {
	    // Your code here
	    if(node == null)
	        return;
	    if(node.left == null && node.right == null)
	        return;
	    node = helper(node);
    }
    
    private Node helper(Node node) {
        if(node == null)
	        return null;
	    if(node.left == null && node.right == null)
	        return node;
	    Node l = helper(node.left);
	    Node r = helper(node.right);
	    node.left = r;
	    node.right = l;
	    return node;
    }
}
