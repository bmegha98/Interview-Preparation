/*
Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 

Example 1:

Input:
      1
    /   \
   2     3
Output: 1 2 3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1
*/
//inorder traversal of BST gives sorted keys So, keep the sorted keys while doing inorder traversal of the binary tree
class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    int ind = 0;
    Node binaryTreeToBST(Node root)
    {
        // Your code here
        if(root == null)
            return null;
        List<Integer> aux = new ArrayList<>();
        preorder(root, aux);
        Collections.sort(aux);
        constructBST(root, aux);
        return root;
    }
    
    private void preorder(Node root, List<Integer> l) {
        if(root == null)
            return;
        l.add(root.data);
        preorder(root.left,l);
        preorder(root.right,l);
    }
    
    private void constructBST(Node root, List<Integer> arr) {
        if(root == null)
            return;
        constructBST(root.left, arr);
        root.data = arr.get(ind);
        ind++;
        constructBST(root.right, arr);
    }
}
