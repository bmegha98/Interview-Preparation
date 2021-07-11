/*
Given a binary tree, flatten it to a linked list in-place.
Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
*/

//Recursive T(n) = O(n^2) , Space = O(n)

public class Solution {
    public TreeNode flatten(TreeNode a) {
        if(a == null)
            return null;
        if(a.left == null && a.right == null)
            return a;
        TreeNode l = flatten(a.left);
        TreeNode r = flatten(a.right);
        
        if(l == null)
            return a;
        a.left = null;
        TreeNode tmp = l;
        while(tmp.right != null)
            tmp = tmp.right;
        tmp.right = r;
        a.right = l;
        return a;
    }
}

//Iterative
public class Solution {
    public TreeNode flatten(TreeNode a) {
        if(a == null)
            return null;
        if(a.left == null && a.right == null)
            return a;
        TreeNode curr = a;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode pre = curr.left;
                while(pre.right != null)
                    pre = pre.right;
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return a;
    }
}
