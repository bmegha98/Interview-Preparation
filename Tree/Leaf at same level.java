/*
Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input: 
            1
          /   \
         2     3

Output: 1

Explanation: 
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \        
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.

Your Task: 
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns true/false depending on whether
all the leaf nodes are at the same level or not.
*/

//all leaves should be at last level i.e. as soon as a leaf is occurred that should be the last level
class Solution
{
    boolean check(Node root) {
	    // Your code here	
	    if(root == null)
	        return true;
	    
	    boolean leafFound = false;
	    
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    q.add(null);
	    
	    while(!q.isEmpty()) {
	        Node curr = q.poll();
	        if(curr == null) {
	            if(leafFound && !q.isEmpty())
	                return false;
	            if(!q.isEmpty())
	                q.add(null);
	        }
	        else {
	            if(curr.left == null && curr.right == null) 
	                    leafFound = true;
	            
	            if(curr.left != null)
	                   q.add(curr.left);
	            if(curr.right != null)
	                    q.add(curr.right);
	        }
	    }
	    return true;
    }
}

class Solution
{
    int leafLevel;
    boolean check(Node root) {
	    // Your code here	
	    if(root == null)
	        return true;
	    leafLevel = -1;
	    return helper(root,0);
    }
    private boolean helper(Node root, int level) {
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null) {
            if(leafLevel == -1)
                leafLevel = level;
            else
                return level == leafLevel;
        }
    
        boolean l = helper(root.left,level+1);
        boolean r = helper(root.right,level+1);
    
        return l && r;
    }
}
