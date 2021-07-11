/*
Given a binary tree, return the postorder traversal of its nodes’ values.
Example :
Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        if(A.left == null && A.right == null) {
            res.add(A.val);
            return res;
        }
        Stack<TreeNode> aux = new Stack<>();
        TreeNode r = null;
        do {
            while(A != null) {
                aux.push(A);
                A = A.left;
            }
            
            while(!aux.isEmpty() && A == null) {
                A = aux.peek();
                if(A.right == null || A.right == r) {
                    res.add(A.val);
                    aux.pop();
                    r = A;
                    A = null;
                }
                else
                    A = A.right;
            }
        }
        while(!aux.isEmpty());
        return res;
    }
}
