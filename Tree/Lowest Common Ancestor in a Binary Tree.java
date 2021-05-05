/*
Given a Binary Tree with all unique values and two nodes value n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume that
either both n1 and n2 are present in the tree or none of them is present. 
*/

class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		if(root == null)
		    return null;
		if(root.data == n1 || root.data == n2)
		    return root;
		Node l = lca(root.left, n1, n2);
		Node r = lca(root.right, n1, n2);
		
		if(l != null && r != null)
		    return root;
		return l != null ? l : r;
	}
}
