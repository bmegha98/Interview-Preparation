//Given a binary tree, return the inorder traversal of its nodes’ values.

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        Stack<TreeNode> aux = new Stack<>();
        while(true) {
            while(A != null) {
                aux.push(A);
                A = A.left;
            }
            if(aux.isEmpty())
                break;
            A = aux.pop();
            res.add(A.val);
            A = A.right;
        }
        return res;
    }
}
