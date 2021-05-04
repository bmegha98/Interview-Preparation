/*
Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.
*/

class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
        // code here.   
        if(root == null)
            return null;
        while(root != null) {
            if(n1 < root.data && n2 < root.data)
                root = root.left;
            else if(n1 > root.data && n2 > root.data)
                root = root.right;
            else
                break;
        }
        return root;
    }
    
}
