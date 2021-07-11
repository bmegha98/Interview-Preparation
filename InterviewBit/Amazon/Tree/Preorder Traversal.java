/*
Given a binary tree, return the preorder traversal of its nodes’ values.
Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].
Using recursion is not allowed.
*/

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        if(A.left == null && A.right == null) {
            res.add(A.val);
            return res;
        }
        Stack<TreeNode> aux = new Stack<>();
        while(true) {
            while(A != null) {
                res.add(A.val);
                aux.push(A);
                A = A.left;
            }
            if(aux.isEmpty())
                break;
            A = aux.pop();
            A = A.right;
        }
        return res;
    }
}
