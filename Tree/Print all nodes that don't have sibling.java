/*
Given a Binary Tree of size N, find all the nodes which don't have any sibling. You need to return a list of integers containing all the nodes that don't have a 
sibling in sorted order.Note: Root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: -1
Explanation: Every node has a sibling.

Your Task:  
You dont need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers
containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.
*/

class Tree
{
    ArrayList<Integer> res;
    ArrayList<Integer> noSibling(Node node) {
        // code here
        res = new ArrayList<>();
        helper(node);
        if(res.isEmpty())
            res.add(-1);
        else
            Collections.sort(res);
        return res;
    }
    
    private void helper(Node root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        if(root.left == null) 
            res.add(root.right.data);
        
        else if(root.right == null) 
            res.add(root.left.data);
        
        helper(root.left);
        helper(root.right);
        
    }
}
