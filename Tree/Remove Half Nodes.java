/*
Given A binary Tree. Your task is to remove all the half nodes (which has only one child).

Example 1:

Input:
         7
       /   \
      7     8
     / 
    2
Output: 2 7 8 
Example 2:

Input:
         2
       /   \
      7     5
       \      \
        9      1
       /  \
      11   4
Output: 11 9 4 2 1 
*/

//PostOrder traversal

class Tree
{
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root) {
        // Code Here
        if(root == null)
            return null;
        
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        
        if(root.left == null && root.right != null)
            return root.right;
        
        if(root.left != null && root.right == null)
            return root.left;
        return root;
    }
}
