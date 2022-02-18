/*
Given a Binary Tree and a target key you need to find the level of target key in the given Binary Tree.

Note: The level of the root node is 1.

           3
         /   \
        2     5
      /   \
     1     4
Key: 4
Level: 3  
Note: if no such key exists then return 0.

Example 1:

Input:
        1
      /   \
     2     3
target = 4
Output: 0

Example 2:

Input:
         3
       /   \
      2     5
    /   \
   1     4
target = 4
Output: 3
Your Task:
 You don't have to take input. Just complete the function getLevel() that takes a node and a target as parameters and returns the level of the target value. 


*/

class Solution
{
    /* Returns level of given data value */
    int getLevel(Node node, int data)  
    { 
        // Write your code here
        return helper(node,data,1);
    } 
    
    int helper(Node root, int ele, int level) {
        if(root == null)
            return 0;
        
        if(root.data == ele)
            return level;
            
        int left = helper(root.left,ele,level+1);
        if(left != 0)
            return left;
        return helper(root.right,ele,level+1);
    }

}
