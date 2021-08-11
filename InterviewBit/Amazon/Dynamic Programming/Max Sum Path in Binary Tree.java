/*
Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.

Input Format:

The first and the only argument contains a pointer to the root of T, A.
Output Format:

Return an integer representing the maximum sum path.
Constraints:

1 <= Number of Nodes <= 7e4
-1000 <= Value of Node in T <= 1000
Example :

Input 1:

       1
      / \
     2   3

Output 1:
     6

Explanation 1:
    The path with maximum sum is: 2 -> 1 -> 3

Input 2:
    
       -10
       /  \
     -20  -30

Output 2:
    -10

Explanation 2
    The path with maximum sum is: -10

At every node, there are 4 cases :
left + root, right+root, root, left+root+right
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode A) {
        if(A == null)
            return 0;
        helper(A);
        return ans;
    }
    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        int tmp = Math.max(Math.max(l,r)+root.val,root.val);
        int res = Math.max(tmp,l+root.val+r);
        ans = Math.max(ans,res);
        return tmp;
    }
}
