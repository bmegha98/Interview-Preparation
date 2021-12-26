/*
Given a binary tree, find its minimum depth.

Example 1:

Input:
            1
          /   \
         3     2
        /
       4           

Output: 2

Explanation:
Minimum depth is between nodes 1 and 2 since
minimum depth is defined as  the number of 
nodes along the shortest path from the root 
node down to the nearest leaf node.

Example 2:

Input:
             10
          /     \
        20       30
          \        \   
          40        60 
                   /
                  2 

Output: 3

Explanation:
Minimum depth is between nodes 10,20 and 40.
*/

class Solution
{
	int minDepth(Node root)
	{
	    //code here
	    if(root == null)
	        return 0;
	    return helper(root);
	}
	
	int helper(Node root) {
	    if(root == null)
	        return 0;
	    if(root.left == null && root.right == null)
	        return 1;
	    if(root.left == null)
	        return helper(root.right)+1;
	    if(root.right == null)
	        return helper(root.left)+1;
	    return Math.min(helper(root.left),helper(root.right))+1;
	}
}
