/*
Given a binary tree, determine if it is a valid binary search tree (BST).Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
    public int isValidBST(TreeNode A) {
        if(A == null||(A.left == null && A.right == null))
            return 1;
        int prev = Integer.MIN_VALUE;
        Stack<TreeNode> aux = new Stack<>();
        while(true) {
            while(A != null) {
                aux.push(A);
                A = A.left;
            }
            if(aux.isEmpty())
                break;
            A = aux.pop();
            if(A.val <= prev)
                return 0;
            prev = A.val;
            A = A.right;
        }
        return 1;
    }
}
