/*
Given a binary tree and data value of two of its nodes. Find the number of turns needed to reach from one node to another in the given binary tree.

Example 1:

Input:      
Tree = 
           1
        /    \
       2       3
     /  \     /  \
    4    5   6    7                        
   /        / \                        
  8        9   10   
first node = 5
second node = 10
Output: 4
Explanation: 
Turns will be at 2, 1, 3, 6.
Example 2:

Input:      
Tree = 
           1
        /     \
       2        3
     /  \      /  \
    4    5    6    7                        
   /         / \                        
  8         9   10   
first node = 1
second node = 4  
Output: -1
Explanation: No turn is required since 
they are in a straight line.

Your Task:  
You don't need to read input or print anything. Complete the function NumberOFTurns() which takes root node and data value of 2 nodes as input parameters and 
returns the number of turns required to navigate between them. If the two nodes are in a straight line, ie- the path does not involve any turns, return -1.
*/

class Solution
{
    static List<String> paths;
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        if(first == second)
            return 0;
        Node lca = LCA(root, first, second);
        paths = new ArrayList<>();
        
        pathFromLCA(lca,first,second,"");
        StringBuilder firstPath = new StringBuilder(paths.get(0));
        firstPath.reverse();
        String route = firstPath.toString()+paths.get(1);
        int turns = 0;
        for(int i=0;i<route.length()-1;i++)
            if(route.charAt(i) != route.charAt(i+1))
                turns++;
        
        return turns == 0?-1:turns;
    }
    
    private static void pathFromLCA(Node root, int f, int s, String tmp) {
        if(root == null)
            return;
        if(root.data == f || root.data == s) {
            paths.add(tmp);
        }
        pathFromLCA(root.left, f, s, tmp+"l");
        pathFromLCA(root.right, f, s, tmp+"r");
    }
    
    private static Node LCA(Node root, int x, int y) {
        if(root == null)
            return null;
        if(root.data == x || root.data == y)
            return root;
        Node l = LCA(root.left,x,y);
        Node r = LCA(root.right,x,y);
        
        if(l != null && r != null)
            return root;
        return l != null?l : r;
    }
}
