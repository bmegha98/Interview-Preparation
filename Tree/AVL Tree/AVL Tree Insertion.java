/*
Given a AVL tree and N values to be inserted in the tree. Write a function to insert a given value into the tree.

Example 1:

â€‹N = 3
Values to be inserted = {5,1,4}

Input:      
Value to be inserted = 5
Output:
    5

Input :      
Value to be inserted = 1
Output:
    5
   /
  1

â€‹Input :      
Value to be inserted = 4
Output:
    4
   / \
  1   5

Your Task:  
You dont need to read input or print anything. Complete the function insertToAVL() which takes the root of the tree and the value of the node to be inserted as
input parameters and returns the root of the modified tree.

Note:
The tree will be checked after each insertion. 
If it violates the properties of balanced BST, an error message will be printed followed by the inorder traversal of the tree at that moment.
If instead all insertions are successful, inorder traversal of tree will be printed.
*/

class Solution
{
    public  Node insertToAVL(Node node,int data) {
        //code here
        if(node == null)
            return new Node(data);
        
        if(data < node.data)
            node.left = insertToAVL(node.left,data);
        else if(data > node.data)
            node.right = insertToAVL(node.right,data);
        else
            return node;
        
        int lHeight = getHeight(node.left), rHeight = getHeight(node.right);
        node.height = Math.max(lHeight, rHeight)+1;
        
        int balFactor = lHeight-rHeight;
        if(Math.abs(balFactor) < 2)
            return node;
        
        if(balFactor < 0) {
            //right subtree is imbalanced
            if(data > node.right.data)
                node = RRRotation(node);
            else
                node = RLRotation(node);
            
        } else {
            //left subtree is imbalanced
            if(data < node.left.data)
                node = LLRotation(node);
            else
                node = LRRotation(node);
        }
        return node;
    }
    
    private Node LLRotation(Node A) {
        Node B = A.left;
        A.left = B.right;
        B.right = A;
        
        A.height = getHeight(A);
        B.height = getHeight(B);
        
        return B;
    }
    
    private Node RRRotation(Node A) {
        Node B = A.right;
        A.right = B.left;
        B.left = A;
        
        A.height = getHeight(A);
        B.height = getHeight(B);
        
        return B;
    }
    
    private Node LRRotation(Node A) {
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
    
    private Node RLRotation(Node A) {
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
    
    private int getHeight(Node curr) {
        if(curr == null)
            return 0;
        int l = curr.left == null? 0 : curr.left.height;
        int r = curr.right == null?0 : curr.right.height;
        return Math.max(l,r)+1;
    }
} 
