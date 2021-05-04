/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 
3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
*/

class Pair {
    Node key;
    int value;
    public Pair(Node n, int v) {
        key = n;
        value = v;
    }
    public Node getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}
class Tree
{
    TreeMap<Integer, Integer> map = new TreeMap<>();
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null) {
            res.add(root.data);
            return res;
        }
        
        levelOrder(root);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) 
            res.add(entry.getValue());
        
        return res;
    }
    
    private void levelOrder(Node root) {
        if(root == null)
            return;
        Queue<Pair> aux = new LinkedList<>();
        aux.add(new Pair(root, 0));

        while(!aux.isEmpty()) {
            Pair p = aux.poll();
            Node curr = p.getKey();
            int level = p.getValue();
            map.put(level, curr.data);
            if(curr.left != null)
                aux.add(new Pair(curr.left, level-1));
            if(curr.right != null)
                aux.add(new Pair(curr.right, level+1));
        }
    }
}
