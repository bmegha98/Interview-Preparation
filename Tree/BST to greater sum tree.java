/*
Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.

Example 1:

Input:
           2
         /    \
        1      6
              /  \
             3    7
Output: 18 16 13 7 0
Explanation:
Every node is replaced with the 
sum of nodes greater than itself. 
The resultant tree is:
               16
             /    \
           18       7
                  /   \
                 13    0
Example 2:

Input:
          2
         /
        1
Output: 2 0
Explanation:
The resultant tree is :
             0
            /
          2
Your task :
You don't have to read input or print anything. Your task is to complete the function transformTree() which takes the root of the tree as input and transforms
the BST to a greater sum tree.
Note : The driver code prints the inorder traversal of the transformed BST.
 
*/

class Solution
{
    int sum = 0;
    public void transformTree (Node root) {
        //code here
        if(root == null)
            return;
        transformTree(root.right);
        int tmp = root.data;
        root.data = sum;
        //System.out.println(root.data);
        sum += tmp;
        transformTree(root.left);
    }
}
