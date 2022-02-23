/*
Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List starting from the left most leaf. Modify the original tree to make the DLL
thus removing the leaf nodes from the tree. Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.

Example 1:

Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7

Explanation:
The leaf nodes are modified to form the DLL 
in-place. Thus their links are removed from 
the tree.
Example 2:

Input :
        1
      /   \
     2     3
    / \   
   4   5 

Output: 
Modified Tree :
        1
      /   
     2    

Doubly Link List :
4 <-> 5 <-> 3

Your Task:  
You dont need to read input or print anything. Complete the function convertToDLL() which takes root of the given tree as input parameter and returns the head of
the doubly link list.

Note:
The generated output will contain the inorder traversal of the modified tree, the DLL from left to right and the DLL from right to left.
*/

class Tree{
    // return the head of the DLL and remove those node from the tree as well.
    Node dummy;
    public Node convertToDLL(Node root)
    {
        // Code here
        if(root == null)
            return null;
        dummy = new Node(-1);
        Node res = dummy;
        helper(root);
        res.right.left = null;
        return res.right;
    }
    private Node helper(Node root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null) {
            //System.out.println(dummy.data);
            dummy.right = root;
            root.left = dummy;
            dummy = dummy.right;
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        return root;
    }
}
