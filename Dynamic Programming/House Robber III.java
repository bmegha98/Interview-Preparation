/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will 
automatically contact the police if two directly-linked houses were broken into on the same night.
Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
*/

//Two choices : Rob the node and go to its grandChildren or not rob the node and go to its children (A node has at max 4 grandchildren and at max 2 children)

//T(n) = O(n) , Space = O(n)
class Solution {
    Map<TreeNode,Integer> aux = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(aux.containsKey(root))
            return aux.get(root);
        
        //Two options : rob or not rob
        int val = 0;
        if(root.left != null)
            val = rob(root.left.left)+rob(root.left.right);
        if(root.right != null)
            val += rob(root.right.left)+rob(root.right.right);
        
        int rob = root.val + val;
        int notRob = rob(root.left)+rob(root.right);
        
        aux.put(root,Math.max(rob,notRob));
        return aux.get(root);
    }
}

//Another Method : Postorder Traversal
class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int[] res = anotherMethod(root);
        return Math.max(res[0],res[1]);
    }
    
    private int[] anotherMethod(TreeNode root) {
        if(root == null)
            return new int[2];
        int[] left = anotherMethod(root.left);
        int[] right = anotherMethod(root.right);
        
        int rob = root.val + left[0] + right[0];
        int notRob = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{notRob,rob};
    }
}
