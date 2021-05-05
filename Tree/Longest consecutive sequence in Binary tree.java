/*
Given a Binary Tree find the length of the longest path which comprises of connected nodes with consecutive values in increasing order. 
*/

class Solution
{
    int maxLen = -1;
	public int longestConsecutive(Node root)
    {
        //add code here.
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        helper(root, 0, root.data);
        return maxLen==1?-1:maxLen;
    }
    
    private void helper(Node root, int curr, int expected) {
        if(root == null)
            return;
        if(root.data == expected) 
            curr++;
        else
            curr = 1;
        maxLen = Math.max(maxLen, curr);
        helper(root.left, curr, root.data+1);
        helper(root.right, curr, root.data+1);
    }
}
