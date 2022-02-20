/*
Given a binary tree, find the largest value in each level.

Example 1:

Input :
        1
       / \
      2   3 

Output : 1 3
Explanation : 
There are two levels in the tree :
1. {1}, max = 1
2. {2, 3}, max = 3
Example 2:

Input :
        4
       / \
      9   2
     / \   \
    3   5   7 

Output : 4 9 7
Explanation : 
There are three levels in the tree:
1. {4}, max = 4
2. {9, 2}, max = 9
3. {3, 5, 7}, max=7
Your task :
You don't need to read input or print anything. Your task is to complete the function largestValues() which takes the root node of the tree as input and returns
a vector containing the largest value in each level. 
*/

class Solution
{
    public ArrayList<Integer> largestValues(Node node)
    {
        //code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        int maxLevel = Integer.MIN_VALUE;
        
        q.add(node);
        q.add(null);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr == null) {
                res.add(maxLevel);
                maxLevel = Integer.MIN_VALUE;
                if(!q.isEmpty())
                    q.add(null);
            }
            else {
                maxLevel = Math.max(maxLevel, curr.data);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return res;
    }
}
