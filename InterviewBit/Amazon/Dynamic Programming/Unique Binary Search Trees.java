/*
Given A, generate all structurally unique BST’s (binary search trees) that store values 1…A.
Input Format:

The first and the only argument of input contains the integer, A.
Output Format:

Return a list of tree nodes representing the generated BST's.
Constraints:

1 <= A <= 15
Example:

Input 1:
    A = 3

Output 1:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ArrayList<TreeNode> generateTrees(int a) {
	    return UniqueBSTs(1,a);
	}
	
	private ArrayList<TreeNode> UniqueBSTs(int l, int h) {
	    ArrayList<TreeNode> tmp = new ArrayList<>();
	    if(l > h) {
	        tmp.add(null);
	        return tmp;
	    }
	    if(l == h) {
	        tmp.add(new TreeNode(l));
	        return tmp;
	    }
	    for(int i=l;i<=h;i++) {
	        ArrayList<TreeNode> left = UniqueBSTs(l,i-1);
	        ArrayList<TreeNode> right = UniqueBSTs(i+1,h);
	        
	        for(TreeNode lft : left)
	            for(TreeNode r : right) {
	                TreeNode root = new TreeNode(i);
	                root.left = lft;
	                root.right = r;
	                tmp.add(root);
	            }
	    }
	    return tmp;
	}
}
