/*
Given a full binary expression tree consisting of basic binary operators (+ , – ,*, /) and some integers, Your task is to evaluate the expression tree.

Example 1:

Input: 
              +
           /     \
          *       -
        /  \    /   \
       5    4  100  20 

Output: 100

Explanation:
((5 * 4) + (100 - 20)) = 100

Example 2:

Input:
            -
          /   \
         4     7

Output: -3

Explanation:
4 - 7 = -3

Your Task:  
You dont need to read input or print anything. Complete the function evalTree() which takes root node as input parameter and returns an integer denoting the result
obtained by simplifying the expression tree.
*/

class Solution {
    public int evalTree(Node root) {
        // Your code here.
        if(root.left == null && root.right == null)
            return Integer.parseInt(root.data);
        
        int left = evalTree(root.left);
        int right = evalTree(root.right);
        
        return evaluateExprsn(root.data, left,right);
    }
    
    private int evaluateExprsn(String op, int a, int b) {
        if(op.equals("+"))
            return a+b;
        if(op.equals("-"))
            return a-b;
        if(op.equals("*"))
            return a*b;
        return a/b;
    }
}
