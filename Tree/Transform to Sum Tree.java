/*
Given a Binary Tree of size N , where each node can have positive or negative values. Convert this to a tree where each node contains the sum of the left and right
sub trees of the original tree. The values of leaf nodes are changed to 0.

Example 1:

Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5

Output:
            20
          /    \
        4        12
       /  \     /  \
     0     0   0    0

Explanation:

           (4-2+12+6)
          /           \
      (8-4)          (7+5)
       /   \         /  \
      0     0       0    0
 

Your Task:  
You dont need to read input or print anything. Complete the function toSumTree() which takes root node as input parameter and modifies the given tree in-place.

Note: If you click on Compile and Test the output will be the in-order traversal of the modified tree.
*/

class Solution{
    public void toSumTree(Node root){
        //add code here.
        helper(root);
    }
    
    private int helper(Node root) {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int origVal = root.data;
        root.data = left+right;
        return origVal+root.data;
    }
}
