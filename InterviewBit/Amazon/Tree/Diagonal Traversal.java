/*
Consider lines of slope -1 passing between nodes.Given a Binary Tree A containing N nodes, return all diagonal elements in a binary tree belonging to same line.
NOTE:
See Sample Explanation for better understanding.
Order does matter in the output.
To get the same order as in the output traverse the tree same as we do in pre-order traversal.
Problem Constraints
0 <= N <= 105
Input Format
First and only Argument represents the root of binary tree A.
Output Format
Return a 1D array denoting the diagonal traversal of the tree.
Example Input
Input 1:

            1
          /   \
         4      2
        / \      \
       8   5      3
          / \    /
         9   7  6
Input 2:

             11
          /     \
         20      12
        / \       \
       1   15      13
          /  \     /
         2    17  16
          \   /
          22 34


Example Output
Output 1:

 [1, 2, 3, 4, 5, 7, 6, 8, 9]
Output 2:

 [11, 12, 13, 20, 15, 17, 16, 1, 2, 22, 34]
*/

public class Solution {
    TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<>();
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null)
            return res;
        helper(A, 0);
        for(Map.Entry<Integer,ArrayList<Integer>> entry : levelMap.entrySet())
            res.addAll(entry.getValue());

        return res;
    }
    private void helper(TreeNode root, int l) {
        if(root == null)
            return;
        ArrayList<Integer> tmp;
        if(levelMap.containsKey(l))
            tmp = levelMap.get(l);
        else
            tmp = new ArrayList<>();
        tmp.add(root.val);
        levelMap.put(l,tmp);
        helper(root.left,l+1);
        helper(root.right,l);
    }
}
