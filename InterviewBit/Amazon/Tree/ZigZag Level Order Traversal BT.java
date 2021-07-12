/*
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate 
between).
Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        
        Stack<TreeNode> curr = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        int lToR = 1;
        curr.push(A);
        while(!curr.isEmpty()) {
            TreeNode x = curr.pop();
            tmp.add(x.val);
            if(lToR == 1) {
                if(x.left != null)
                    next.push(x.left);
                if(x.right != null)
                    next.push(x.right);
            }
            else {
                if(x.right != null)
                    next.push(x.right);
                if(x.left != null)
                    next.push(x.left);
            }
            
            if(curr.isEmpty()) {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                lToR = 1-lToR;
                Stack<TreeNode> s = curr;
                curr = next;
                next = s;
            }
        }
        return res;
    }
}
