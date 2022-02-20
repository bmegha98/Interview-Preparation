/*
Given a special Binary Tree whose leaf nodes are connected to form a circular doubly linked list. Find the height of this special Binary Tree.

Example 1:

Input:
        1
      /   \
     2     3
    /
   4
Output: 3
â€‹Explanation: There are 3 edges and 4
nodes in spiral tree where leaf nodes
4 and 3 are connected in circular
doubly linked list form. Thus the
height of spiral tree is 3.
Example 2:

Input:
        1
      /   \
     2     3
    / \
   4   5
  /
 6
Output: 4
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTreeHeight() which takes the root of the special Binary Tree as its 
input and returns the Height of this special Binary Tree.
In a special Binary Tree, the leaf nodes form a circular doubly linked list.
For Example:

      1
     /   \ 
    2    3
   /  \
  4  5
 /  
6 

In the above binary tree, 6, 5 and 3 are leaf nodes and they form a circular doubly linked list. Here, the left pointer of leaf node will act as a previous
pointer of circular doubly linked list and its right pointer will act as next pointer of circular doubly linked list.
*/

//By modifying tree

class Pair {
    Node node;
    int dist;
    public Pair(Node n, int d) {
        node = n;
        dist = d;
    }
}
class Tree
{
    // Return the height of the given special binary tree
    public static int findTreeHeight(Node root) {
        // code here.
        Queue<Pair> aux = new LinkedList<>();
        
        aux.add(new Pair(root,0));
        int height = 0;
        
        while(!aux.isEmpty()) {
            Pair p = aux.poll();
            Node curr = p.node;
            int d = p.dist;
            
            height = Math.max(height, d);
            
            if (curr.left != null) {
                    aux.add(new Pair(curr.left, d+1));
                    curr.left = null;
            }
                
            if (curr.right != null) {
                    aux.add(new Pair(curr.right, d+1));
                    curr.right = null;
            }
        }
        return height;
    }
}

//By not modifying tree
// The given node is a leaf node if it satisfies the following 2 things:
// 1. The right child of the left child of the current node is the node itself.
// 2. The left child of the right child of the current node is the node itself.

class Tree
{
    // Return the height of the given special binary tree
    public static int findTreeHeight(Node root) {
        // code here.
        if(root == null)
            return 0;
        if(isLeaf(root))
            return 1;
        int left = findTreeHeight(root.left);
        int right = findTreeHeight(root.right);
        
        return Math.max(left,right)+1;
    }
    
    private static boolean isLeaf(Node root) {
        if(root.left != null && root.right != null) {
            return root.left.right == root && root.right.left == root;
        }
        return false;
    }
}
