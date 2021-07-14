/*
Given a generic tree and a integer x. Find and return the node with next larger element in the tree i.e. find a node just greater than x. Return NULL if no node is
present with value greater than x. 
*/

class Node {
  int val;
  ArrayList<Node> children;
  public Node(int v, ArrayList<Node> A) {
    val = v;
    children = A;
  }
}

class Solution {
  Node res = null;
  public Node nextLarger(Node root, int x) {
    if(root == null)
      return null;
    helper(root,x);
    return res;
  }
  private void helper(Node root, int x) {
    if(root == null)
      return;
    if(root.val > x) {
      if(res == null || res.val > root.val)
        res = root;
    }
    for(Node child : root.children)
      helper(child,x);
  }
}
