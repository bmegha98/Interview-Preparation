/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and
returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).
*/

class Pair {
    int count;
    int max;
    int min;
    boolean isBst;
    public Pair(int c, int mn, int mx, boolean b) {
        count = c;
        max = mx;
        min = mn;
        isBst = b;
    }
    public String toString() {
        return "{"+count+ ": "+ min+" : "+max+" : "+isBst+" }";
    }
}
class Solution{
    
    static int res;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        if(root == null)
            return 0;
        res = 1;
        helper(root);
        return res;
    }
    
    static Pair helper(Node root) {
        if(root == null)
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        if(root.left == null && root.right == null)
            return new Pair(1,root.data,root.data,true);
        Pair l = helper(root.left);
        Pair r = helper(root.right);
        
        //System.out.println("left -> "+l+" right -> " + r);
        int newMax = Math.max(l.max,Math.max(r.max,root.data));
        int newMin = Math.min(l.min,Math.min(r.min,root.data));
        if (l.isBst && r.isBst && l.max < root.data && r.min > root.data) {
            res = Math.max(res,l.count+1+r.count);
            return new Pair(l.count+r.count+1,newMin,newMax,true);   
        } 
            
        return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
    }
    
}
