/*
Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
Example 1:

Input:
        1
      /   \
     2     3
target = 2
Output: 1
Example 2:

Input:
         1
       /   \
      2     3
    /  \   /  \
   4    5 6    8
  /
 7
target = 7
Output: 4 2 1
Your Task:
Your task is to complete the function Ancestors() that finds all the ancestors of the key in the given binary tree.
*/

class Solution
{
    static ArrayList<Integer> res;
    public static ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        res = new ArrayList<>();
        helper(root,target);
        return res;
    }
    
    private static boolean helper(Node root, int x) {
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        boolean left = helper(root.left,x);
        boolean right = helper(root.right,x);
        
        if(left || right) {
            res.add(root.data);
            return true;
        }
        return false;
    }
}
