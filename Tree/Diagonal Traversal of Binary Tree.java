/*
Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
Explanation:
unnamed
Diagonal Traversal of binary tree : 
 8 10 14 3 6 7 13 1 4
Your Task:
You don't need to read input or print anything. The task is to complete the function diagonal() that takes the root node as input argumets and returns the diagonal
traversal of the given tree.
*/

//T(n) = O(nlogn), Space = O(n)
class Tree
{
    Map<Integer,List<Integer>> aux;
    public ArrayList<Integer> diagonal(Node root) {
        //add your code here.
        aux = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        helper(root,0);
        for(List<Integer> l : aux.values())
            res.addAll(l);
        return res;
    }
    
    private void helper(Node root, int level) {
        if(root == null)
            return;
        List<Integer> tmp = aux.getOrDefault(level, new ArrayList<>());
        tmp.add(root.data);
        aux.put(level, tmp);
        //preorder
        helper(root.left, level+1);
        helper(root.right, level);
    }
}

//T(n) = O(n)
class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            while(curr != null) {
                res.add(curr.data);
                if(curr.left != null)
                    q.add(curr.left);
                curr = curr.right;
            }
        }
        
        return res;
    }
}
