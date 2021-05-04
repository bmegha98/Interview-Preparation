/*
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.
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

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null) {
            res.add(root.data);
            return res;
        }
        TreeMap<Integer, ArrayList<Integer>> aux = new TreeMap<>();
        
        levelOrder(root, aux);
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : aux.entrySet())
            res.addAll(entry.getValue());
        return res;
    }
    
    private static void levelOrder(Node root, TreeMap<Integer, ArrayList<Integer>> map) {
        if(root == null)
            return;
        Queue<Pair> aux = new LinkedList<>();
        aux.add(new Pair(root, 0));

        while(!aux.isEmpty()) {
            Pair p = aux.poll();
            Node curr = p.getKey();
            int level = p.getValue();
            if(map.containsKey(level))
                map.get(level).add(curr.data);
            else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(curr.data);
                map.put(level, l);
            }
            if(curr.left != null)
                aux.add(new Pair(curr.left, level-1));
            if(curr.right != null)
                aux.add(new Pair(curr.right, level+1));
        }
    }
}
