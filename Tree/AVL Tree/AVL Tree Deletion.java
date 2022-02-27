/*
Given a AVL tree and N values to be deleted from the tree. Write a function to delete a given value from the tree.

Example 1:

Tree = 
        4
      /   \
     2     6
    / \   / \  
   1   3 5   7

N = 4
Values to be deleted = {4,1,3,6}

Input: Value to be deleted = 4
Output:
        5    
      /   \
     2     6
    / \     \  
   1   3     7

Input: Value to be deleted = 1
Output:
        5    
      /   \
     2     6
      \     \  
       3     7

Input: Value to be deleted = 3
Output:
        5    
      /   \
     2     6
            \  
             7

Input: Value to be deleted = 6
Output:
        5    
      /   \
     2     7

Your Task:  
You dont need to read input or print anything. Complete the function delelteNode() which takes the root of the tree and the value of the node to be deleted as
input parameters and returns the root of the modified tree.

Note: The tree will be checked after each deletion. 
If it violates the properties of balanced BST, an error message will be printed followed by the inorder traversal of the tree at that moment.
If instead all deletion are successful, inorder traversal of tree will be printed.
If every single node is deleted from tree, 'null' will be printed.
*/

class Sol
{
    public static Node deleteNode(Node root, int key) {
        // code here.
        if(root == null || (root.data == key && root.left == null &&
                            root.right == null))
            return null;
        if(key < root.data)
            root.left = deleteNode(root.left,key);
        else if(key > root.data)
            root.right = deleteNode(root.right,key);
        else {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            Node tmp = root.left;
            while(tmp.right != null)
                tmp = tmp.right;
            root.data = tmp.data;
            root.left = deleteNode(root.left, tmp.data);
        }
        int lHeight = getHeight(root.left), rHeight = getHeight(root.right);
        root.height = Math.max(lHeight, rHeight)+1;
        
        int balFactor = getBalance(root);
        if(Math.abs(balFactor) < 2)
            return root;
        
        if(balFactor < 0) {
            //right subtree is imbalanced
            if(getBalance(root.right) <= 0)
                root = RRRotation(root);
            else
                root = RLRotation(root);
            
        } else {
            //left subtree is imbalanced
            if(getBalance(root.left) >= 0)
                root = LLRotation(root);
            else
                root = LRRotation(root);
        }
        return root;
    }
    
    private static int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return getHeight(N.left) - getHeight(N.right);
    }
    
    private static Node LLRotation(Node A) {
        Node B = A.left;
        A.left = B.right;
        B.right = A;
        
        A.height = getHeight(A);
        B.height = getHeight(B);
        
        return B;
    }
    
    private static Node RRRotation(Node A) {
        Node B = A.right;
        A.right = B.left;
        B.left = A;
        
        A.height = getHeight(A);
        B.height = getHeight(B);
        
        return B;
    }
    
    private static Node LRRotation(Node A) {
        Node B = A.left;
        Node C = B.right;
        B.right = C.left;
        A.left = C.right;
        C.left = B;
        C.right = A;
        A.height = getHeight(A);
        B.height = getHeight(B);
        C.height = getHeight(C);
        
        return C;
    }
    
    private static Node RLRotation(Node A) {
        Node B = A.right;
        Node C = B.left;
        B.left = C.right;
        A.right = C.left;
        C.left = A;
        C.right = B;
        A.height = getHeight(A);
        B.height = getHeight(B);
        C.height = getHeight(C);
        
        return C;
    }
    
    private static int getHeight(Node curr) {
        if(curr == null)
            return 0;
        int l = curr.left == null? 0 : curr.left.height;
        int r = curr.right == null?0 : curr.right.height;
        return Math.max(l,r)+1;
    }
}
