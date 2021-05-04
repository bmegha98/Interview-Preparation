/*
Complete the function to find spiral order traversal of a tree. 
Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
*/

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        
        int rToL = 1;
        curr.push(root);
        while(!curr.isEmpty()) {
            Node tmp = curr.pop();
            res.add(tmp.data);
            
            if(rToL == 1) {
                if(tmp.right != null)
                    next.push(tmp.right);
                if(tmp.left != null)
                    next.push(tmp.left);
            }
            else {
                if(tmp.left != null)
                    next.push(tmp.left);
                if(tmp.right != null)
                    next.push(tmp.right);
            }
            
            if(curr.isEmpty()) {
                rToL = 1-rToL;
                Stack<Node> s = curr;
                curr = next;
                next = s;
            }
        }
        return res;
    }
}
