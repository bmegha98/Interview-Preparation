/*
Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint
that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in 
consideration and vice versa.

                                               

Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the
maximum sum as described.
*/

//first Approach
class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static Map<Node, Integer> aux;
    static int getMaxSum(Node root)
    {
        // add your code here
        aux = new HashMap<>();
        return helper(root);
    }
    
    private static int helper(Node root) {
        if(root == null)
            return 0;
        if(aux.containsKey(root))
            return aux.get(root);
        int include = root.data;
        if(root.left != null)
            include += helper(root.left.left)+ helper(root.left.right);
        if(root.right != null)
            include += helper(root.right.left)+ helper(root.right.right);
        int exclude = 0;
        exclude += helper(root.left)+helper(root.right);
        
        int res = Math.max(include,exclude);
        aux.put(root,res);
        return res;
    }
}

//Second approach

class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        // add your code here
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    
    private static int[] helper(Node root) {
        if(root == null)
            return new int[]{0,0};
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int include = root.data+left[1]+right[1];
        int exclude = 0;
        exclude += Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
    
        return new int[]{include,exclude};
    }
}
