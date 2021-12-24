/*
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
           1
         /   \
       2       3
     /   \   /   \
   4      5 6      7
              \      \
               8      9           
Output: 
4 2 1 5 6 3 8 7 9 
*/

class Pair {
    Node currNode;
    int level;
    public Pair(Node node, int l) {
        currNode = node;
        level = l;
    }
}
class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer, List<Integer>> levelMap = new TreeMap<>();
        
        Queue<Pair> aux = new LinkedList<>();
        aux.add(new Pair(root, 0));
        
        while(!aux.isEmpty()) {
            Pair curr = aux.poll();
            Node n = curr.currNode;
            int level = curr.level;
            List<Integer> elementsAtLevel;
            if(levelMap.containsKey(level))
                elementsAtLevel = levelMap.get(level);
            else
                elementsAtLevel = new ArrayList<>();
            elementsAtLevel.add(n.data);
            levelMap.put(level, elementsAtLevel);
            if(n.left != null)
                aux.add(new Pair(n.left, level-1));
            if(n.right != null)
                aux.add(new Pair(n.right, level+1));
        }
        
        for(int k : levelMap.keySet())
            res.addAll(levelMap.get(k));
        return res;
    }
}
