/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.

A leaf node is a node with no children.
*/

class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        String tmp = "";
        getSum(root, tmp);
        return res;
    }
    private void getSum(TreeNode root, String num) {
	    if(root == null)
	        return;
	    num += String.valueOf(root.val);
	    //System.out.println(num);
	    if(root.left == null && root.right == null) {
	        res += Integer.parseInt(num);
	        return;
	    }
	    getSum(root.left, num);
	    getSum(root.right, num);
	}
}
