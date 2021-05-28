/*
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 
Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree
over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always 
travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
*/

class Solution
{
    ArrayList<Integer> res = new ArrayList<>();
    void printLeftBoundary(Node root) {
        while(root != null) {
            if(root.left != null) {
                res.add(root.data);
                root = root.left;
            }
            else if(root.right != null) {
                res.add(root.data);
                root = root.right;
            }
            else
                break;
        }
    }
    void printLeaves(Node root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }
    void printRightBoundary(Node root) {
        if(root == null)
            return;
        if(root.right != null) {
            printRightBoundary(root.right);
            res.add(root.data);
        }
        else if(root.left != null) {
            printRightBoundary(root.left);
            res.add(root.data);
        }
        //else leaf node : do nothing
    }
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    if(node == null)
	        return res;
	    if(node.left == null && node.right == null) {
	        res.add(node.data);
	        return res;
	    }
	    
	    res.add(node.data);
	    printLeftBoundary(node.left);
	    printLeaves(node);
	    printRightBoundary(node.right);
	    
	    return res;
	}
}
