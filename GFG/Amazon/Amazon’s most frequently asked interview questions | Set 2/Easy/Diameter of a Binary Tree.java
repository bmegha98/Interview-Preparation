/*
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with 
diameter nine, the leaves that form the ends of the longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer
than nine nodes). 

Example 1:

Input:
       1
     /  \
    2    3
Output: 3
Example 2:

Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4
*/

class Solution {
    // Function to return the diameter of a Binary Tree.
    int d = 0;
    int diameter(Node root) {
        // Your code here
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        getHeight(root);
        return d;
    }
    
    int getHeight(Node root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        d = Math.max(d, l+r+1);
        return Math.max(l,r)+1;
    }
}
