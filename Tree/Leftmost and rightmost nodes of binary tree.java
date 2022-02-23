/*
Given a Binary Tree of size N, Print the corner nodes ie- the node at the leftmost and rightmost of each level.


Example 1:

Input :
         1
       /  \
     2      3
    / \    / \
   4   5  6   7    
Output: 1 2 3 4 7
Explanation:
Corners at level 0: 1
Corners at level 1: 2 3
Corners at level 2: 4 7
Example 2:

Input:

        10
      /    \
     20     30
    / \  
   40  60
Output: 10 20 30 40 60

Your Task:  
You dont need to read input. Complete the function printCorner() which takes root node as input parameter and prints the corner nodes separated by spaces. The left
corner should be printed before the right for each level starting from level 0.
Note: Don't print a new line after printing all the corner nodes.
*/

class Tree
{
    public static void printCorner(Node root)
    {
        // add your code here  
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int first = -1, last = -1,levelCount = 0;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr == null) {
                if(levelCount > 1)
                    System.out.print(first+" ");
                System.out.print(last+" ");
                if(!q.isEmpty()) {
                    q.add(null);
                }
                first = -1;
                last = -1;
                levelCount = 0;
            }
            else {
                if(first == -1)
                    first = curr.data;
                last = curr.data;
                levelCount++;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    
}
