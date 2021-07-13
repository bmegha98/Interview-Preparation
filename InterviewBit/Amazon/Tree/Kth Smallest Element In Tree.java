/*
Given a binary search tree, write a function to find the kth smallest element in the tree.
Example :
Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
NOTE : You may assume 1 <= k <= Total number of nodes in BST 
*/
//Using Inorder Traversal
public class Solution {
    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> aux = new Stack<>();
        while(true) {
            while(A != null) {
                aux.push(A);
                A = A.left;
            }
            if(aux.isEmpty())
                break;
            A = aux.pop();
            --B;
            if(B == 0)
                return A.val;
            A = A.right;
        }
        return -1;
    }
}
