/*
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:

Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.
*/

class Solution
{
    int res = Integer.MIN_VALUE;
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node)
    {
        //your code goes here
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return node.data;
        helper(node);
        return res;
    }
    private int helper(Node root) {
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        
        int tmp = Math.max(root.data, Math.max(l,r)+root.data);
        res = Math.max(res, Math.max(tmp, l+root.data+r));
        return tmp;
    }
}
