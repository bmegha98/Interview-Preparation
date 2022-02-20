/*
Given a perfect binary tree, reverse the nodes present at alternate levels.

Example 1:

Input:
             1
          /   \
        3      2

Output:

             1
          /   \
        2      3

Explanation: Nodes at level 2 are reversed.
Example 2:

Input:
              1
          /      \
         2        3
       /  \      /  \
     42   51   63   72

Output:
             1
          /      \
         3        2
       /  \      /  \
     42   51   63   72

Explanation:
Nodes at level 2 are reversed.
Level 1 and 3 remain as it is.

Your Task:  
You dont need to read input or print anything. Complete the function reverseAlternate() which takes root node as input parameter and modifies the given tree
in-place.
*/

class Tree
{
	static void reverseAlternate( Node root) {  
        // code here.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
       
        boolean odd = false;
        Deque<Node> level = new LinkedList<>();
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr == null) {
                if(odd) {
                    while(level.size() > 1) {
                        Node f = level.pollFirst(), r = level.pollLast();
                        int tmp = f.data;
                        f.data = r.data;
                        r.data = tmp;
                    }
                }
                odd = !odd;
                level.clear();
                if(!q.isEmpty())
                    q.add(null);
            }
            else {
                level.addLast(curr);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
       }
    }  
}
