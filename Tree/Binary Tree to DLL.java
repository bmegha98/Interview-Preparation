/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers 
respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal
(leftmost node in BT) must be the head node of the DLL.
Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:  DLL would be 
40<=>20<=>60<=>10<=>30.

*/

class Solution
{
    Node prev;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        if(root == null)
            return null;
        Node dummy = new Node(-1);
        prev = dummy;
        helper(root);
        dummy.right.left = null;
        return dummy.right;
    }
    
    private void helper(Node root) {
        if(root == null)
            return;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
    }
}
