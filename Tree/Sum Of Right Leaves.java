//Given the root of a binary tree, return the sum of all right leaves.

class TreeNode {
	int data;
	TreeNode left,right;
	public TreeNode(int d) {
		data = d;
		left = null;
		right = null;
	}
}
class Solution {
	private int sum = 0;
	public int sumOfRightLeaves(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.data;
		recursiveMethod(root);
		return sum;
	}
	private void recursiveMethod(TreeNode root) {
		if(root == null) return;
		if(root.right != null) {
			if(root.right.left == null && root.right.right == null)
				sum += root.right.data;
			else
				recursiveMethod(root.right);
		}
		recursiveMethod(root.left);
	}
	private int iterativeMethod(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.data;
		Queue<TreeNode> aux = new LinkedList<>();
		aux.add(root);
		while(!aux.isEmpty()) {
			TreeNode curr = aux.poll();
			if(curr.left != null) aux.add(curr.left);
			if(curr.right != null) {
				if(curr.right.left == null && curr.right.right == null)
					sum += curr.right.data;
				aux.add(curr.right);
			}
		}
		return sum;
	}
}
