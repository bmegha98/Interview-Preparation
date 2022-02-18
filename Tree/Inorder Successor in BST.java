/*
Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
Example 1:

Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3 
Explanation: 
Inorder traversal : 1 2 3 
Hence, inorder successor of 2 is 3.

Example 2:

Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrderSuccessor(). This function takes the root node and the reference node
as argument and returns the node that is inOrder successor of the reference node. If there is no successor, return null value.
*/

//Using Morris Inorder Traversal
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x) {
        //add code here.
        Node curr = root;
        while(curr != null) {
            if(curr.left == null) {
                int currData = curr.data;
                if(currData > x.data)
                    return curr;
                curr = curr.right;
            }
            else {
                Node pre = curr.left; //determining predecessor
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else {
                    //left subtree is visited
                    pre.right = null;
                    int currData = curr.data;
                    if(currData > x.data)
                        return curr;
                    curr = curr.right;
                }
            }
        }
        return null;
    }
}

//Using BST property
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x) {
        //add code here.
        Node tmp = null;
        
        while(root != null) {
            if(root.data <= x.data)
                root = root.right;
            else {
                tmp = root;
                root = root.left;
            }
        }
        
        return tmp;
    }
}
