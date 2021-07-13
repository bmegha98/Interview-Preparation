/*
Given a binary tree A consisting of N nodes, return a 2-D array denoting the vertical order traversal of A.Go through the example and image for more details.
NOTE:
If 2 or more Tree Nodes shares the same vertical level then the one with earlier occurence in the pre-order traversal of tree comes first in the output.
Row 1 of the output array will be the nodes on leftmost vertical line similarly last row of the output array will be the nodes on the rightmost vertical line.
Problem Constraints
0 <= N <= 104

Input Format
First and only argument is an pointer to root of the binary tree A.
Output Format
Return a 2D array denoting the vertical order traversal of A.
Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

           1
         /   \
        2     3
       / \
      4   5


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [4],
    [2],
    [1, 5],
    [3]
 ]
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

//T(n) = O(n) , Space = O(n)
class Pair {
    TreeNode node;
    int level;
    public Pair(TreeNode n, int l) {
        node = n;
        level = l;
    }
    public TreeNode getNode() {
        return node;
    }
    public int getLevel() {
        return level;
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null)
            return res;
        TreeMap<Integer,ArrayList<Integer>> levelMap = new TreeMap<>();
        Queue<Pair> aux = new LinkedList<>();
        aux.add(new Pair(A,0));
        
        while(!aux.isEmpty()) {
            Pair curr = aux.poll();
            TreeNode t = curr.getNode();
            int l = curr.getLevel();
            ArrayList<Integer> tmp;
            if(levelMap.containsKey(l))
                tmp = levelMap.get(l);
            else
                tmp = new ArrayList<>();
            tmp.add(t.val);
            levelMap.put(l,tmp);
            if(t.left != null)
                aux.add(new Pair(t.left,l-1));
            if(t.right != null)
                aux.add(new Pair(t.right,l+1));
        }
        
        for(Map.Entry<Integer,ArrayList<Integer>> entry : levelMap.entrySet())
            res.add(entry.getValue());
        
        return res;
    }
}
