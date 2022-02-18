/*
Given a Binary Tree of size N and an integer K. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes should be
printed from left to right. If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6 
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameter and return the value of the nodes that are at a 
distance k from the root. (The values are returned as vector in cpp, as ArrayList in java and list in python)
*/

class Pair {
    Node node;
    int distance;
    public Pair(Node n, int d) {
        node = n;
        distance = d;
    }
}
class Tree
{
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(k == 0) {
            res.add(root.data);
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            Node n = curr.node;
            int d = curr.distance;
            if(d > k)
                break;
            if(d == k) 
                res.add(n.data);
            else {
                if(n.left != null)
                    q.add(new Pair(n.left,d+1));
                if(n.right != null)
                    q.add(new Pair(n.right,d+1));
            }
        }
        return res;
    }
}
