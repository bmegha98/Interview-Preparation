/*
Given a binary tree and a integer value K, the task is to find all nodes data in given binary tree having exactly K leaves in sub-tree rooted with them.

NOTE: Nodes should be printed in the order in which they appear in postorder traversal.

Example 1:

Input:
K = 1
      0
    /   \
   1     2
Output: -1
Explanation: There is no node in this
tree which has one leaf in the sub tree
below it.
Example 2:

Input:
K = 2
          0
        /   \
       1     2
           /  
          4
        /   \
       5     9
Output: 4 2
Explanation: Nodes with data 2 and 4, have
2 leaves in the subtree below it.
Your Task:
Just complete the function btWithKleaves() and returns the answer (as a vector in cpp, as a ArrayList in java and as list in python)

Note: If no node is found the list returned should contain only one value -1.
*/

class Solution
{
    private ArrayList<Integer> res;
    public ArrayList<Integer> btWithKleaves(Node root, int k)
    {
        //add code here.
        res = new ArrayList<Integer>();
        helper(root, k);
        if(res.size() == 0)
            res.add(-1);
        return res;
    }
    
    private int helper(Node root, int k) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftCount = helper(root.left,k);
        int rightCount = helper(root.right, k);
        
        if(leftCount + rightCount == k)
            res.add(root.data);
        return leftCount+rightCount;
    }
}
