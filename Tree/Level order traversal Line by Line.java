/*
Given a Binary Tree, your task is to find its level order traversal.
For the below tree the output will be 1 $ 2 3 $ 4 5 6 7 $ 8 $.

          1
       /     \
     2        3
   /    \     /   \
  4     5   6    7
    \
     8

Example 1:

Input:
          1
        /
       4
     /   \
    4     2
Output:1 $ 4 $ 4 2 $

Example 2:

Input:
            10
          /    \
        20      30
     /     \
    40     60
Output: 10 $ 20 30 $ 40 60 $
Your Task:
This is a function problem. You don't need to read input. Just complete the function levelOrder() that takes nodes as parameter and returns level order traversal 
as a 2D list.
*/

class Level_Order_Traverse
{
    //Function to return the level order traversal line by line of a tree.
    static ArrayList<ArrayList<Integer>> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> level = new ArrayList<>();
        
        q.add(node);
        q.add(null);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr == null) {
                res.add(new ArrayList<>(level));
                level.clear();
                if(!q.isEmpty())
                    q.add(null);
            }
            else {
                level.add(curr.data);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return res;
    }
}
