/*
Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of level order traversal as a
list. The newline is automatically appended by the driver code.
*/

//T(n) = Space = O(n)
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<Node> currStk = new Stack<>();
        Stack<Node> nextStk = new Stack<>();
        
        int rToL = 1;
        currStk.push(root);
        
        while(!currStk.isEmpty()) {
            Node curr = currStk.pop();
            res.add(curr.data);
            if(rToL == 1) {
                if(curr.right != null)
                    nextStk.push(curr.right);
                if(curr.left != null)
                    nextStk.push(curr.left);
            } else {
                if(curr.left != null)
                    nextStk.push(curr.left);
                if(curr.right != null)
                    nextStk.push(curr.right);
            }
            
            if(currStk.isEmpty()) {
                rToL = 1 - rToL;
                Stack<Node> tmp = currStk;
                currStk = nextStk;
                nextStk = tmp;
            }
        }
        return res;
    }
}
