/*
Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines starting from left-most 
vertical line to right-most vertical line.

Example 1:

Input:
       1
    /   \
  2      3
 / \    / \
4   5  6   7
Output: 
Explanation:
The tree has 5 vertical lines
Vertical-Line-1 has only one node
4 => vertical sum is 4
Vertical-Line-2: has only one node
2=> vertical sum is 2
Vertical-Line-3: has three nodes:
1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3
=> vertical sum is 3
Vertical-Line-5: has only one node 7
=> vertical sum is 7
Your Task:
You don't need to take input. Just complete the function verticalSum() that takes root node of the tree as parameter and returns an array containing the vertical
sum of tree from left to right.


*/

class Solution{
    Map<Integer, Integer> aux;
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        ArrayList <Integer> res = new ArrayList <Integer>();
        aux = new TreeMap<>();
        helper(root, 0);
        for(int v : aux.values())
            res.add(v);
        return res;
    }
    
    private void helper(Node root, int level) {
        if(root == null)
            return;
        aux.put(level, aux.getOrDefault(level,0)+root.data);
        helper(root.left, level-1);
        helper(root.right, level+1);
    }
}
