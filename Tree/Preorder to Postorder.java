/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.
In Pre-Order traversal, the root node is visited before the left child and right child nodes.
Post-order traversal is one of the multiple methods to traverse a tree.

Example 1:

Input:
N = 5
arr[]  = {40,30,35,80,100}
Output: 35 30 100 80 40
Explanation: PreOrder: 40 30 35 80 100
InOrder: 30 35 40 80 100
Therefore, the BST will be:
              40
           /      \
         30       80
           \        \   
           35      100
Hence, the postOrder traversal will
be: 35 30 100 80 40
Example 2:

Input:
N = 8
arr[]  = {40,30,32,35,80,90,100,120}
Output: 35 32 30 120 100 90 80 40
Your Task:
You need to complete the given function and return the root of the tree. The driver code will then use this root to print the post order traversal.


*/

public static Node post_order(int pre[], int size) 
{
    //Your code here
    Node root = new Node(pre[0]);
    for(int i=1;i<size;i++)
        constructBST(root, pre[i]);
    return root;
} 

private static Node constructBST(Node root, int ele) {
    if(root == null)
        return new Node(ele);
    if(ele < root.data)
        root.left = constructBST(root.left, ele);
    else
        root.right = constructBST(root.right, ele);
    return root;
}
