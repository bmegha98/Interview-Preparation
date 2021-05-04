/*
Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL
*/

class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        // Your code goes here.
        if(root == null)
            return;
        Queue<Node> aux = new LinkedList<>();
        aux.add(root);
        aux.add(null);
        
        while(!aux.isEmpty()) {
            Node curr = aux.poll();
            if(curr == null) {
                if(!aux.isEmpty())
                    aux.add(null);
            }
            else {
                curr.nextRight = aux.peek();
                if(curr.left != null)
                    aux.add(curr.left);
                if(curr.right != null)
                    aux.add(curr.right);
            }
        }
    }
}
