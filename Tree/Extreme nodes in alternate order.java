/*
Given a binary tree, print nodes of extreme corners of each level but in alternate order.

Example 1:

Input:
       1
     /  \
    2    3
Output: 1 2
Explanation: This represents a tree
with 3 nodes and 2 edges where root
is 1, left child of 1 is 3 and
right child of 1 is 2.

Your Task:
You don't have to take any input. Just complete the function ExtremeNodes() that takes root node as paramter  and return the answer (as vector in cpp, 
as ArrayList in Java, as list in python)

*/

class Solution{
    public  ArrayList<Integer> ExtremeNode(Node root) {
        //add code here.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int first = -1, second = -1;
        boolean printLeft = false;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr == null) {
                if(!q.isEmpty())
                    q.add(null);
                if(printLeft)
                    res.add(first);
                else
                    res.add(second);
                first = -1;
                second = -1;
                printLeft = !printLeft;
            }
            else {
                if(first == -1)
                    first = curr.data;
                second = curr.data;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return res;
    }
}
