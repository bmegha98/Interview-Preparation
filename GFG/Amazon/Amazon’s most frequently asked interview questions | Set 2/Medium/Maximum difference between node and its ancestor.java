/*
Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes
of the binary tree and A is an ancestor of B. 

Example 1:

Input:
    5
 /    \
2      1
Output: 4
Explanation:The maximum difference we can
get is 4, which is bewteen 5 and 1.
Example 2:

Input:
      1
    /    \
   2      3
           \
            7
Output: -1
Explanation:The maximum difference we can
get is -1, which is between 1 and 2.
Your Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.
*/

class Tree
{
    //Function to return the maximum difference between any 
    //node and its ancestor.
    int d = Integer.MIN_VALUE;
    int maxDiff(Node root)
    {
        //your code here
        helper(root);
        
        return d;
    }
    
    int[] helper(Node root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return new int[]{root.data,root.data};
        
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        
        int[] res1 = new int[2];
        if(l != null) {
            d = Math.max(d, Math.max(root.data-l[0], root.data-l[1]));
            res1[0] = Math.max(l[0], root.data);
            res1[1] = Math.min(l[1], root.data);
        }
        int[] res2 = new int[2];
        if(r != null) {
            d = Math.max(d, Math.max(root.data-r[0], root.data-r[1]));
            res2[0] = Math.max(r[0], root.data);
            res2[1] = Math.min(r[1], root.data);
        }
        
        if(l != null && r != null)
            return new int[]{Math.max(res1[0],res2[0]), 
                Math.min(res1[1],res2[1])};
        
        return l!=null?res1:res2;
    }
}
