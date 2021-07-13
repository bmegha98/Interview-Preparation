/*
Given a Binary Tree A containing N nodes.You need to find the path from Root to a given node B.
NOTE:
No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.
Problem Constraints
1 <= N <= 105
1 <= Data Values of Each Node <= N
1 <= B <= N

Input Format
First Argument represents pointer to the root of binary tree A.
Second Argument is an integer B denoting the node number.

Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.
Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7 


B = 5

Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [1]

*/

public class Solution {
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<Integer> solve(TreeNode A, int B) {
        if(A == null)
            return path;
        findPath(A,B);
        return path;
    }
    private boolean findPath(TreeNode root,int x) {
        if(root == null)
            return false;
        path.add(root.val);
        if(root.val == x)
            return true;
        boolean l = findPath(root.left,x);
        if(l)
            return true;
        boolean r = findPath(root.right,x);
        if(r)
            return true;
        path.remove(path.size()-1);
        return false;
    }
}
