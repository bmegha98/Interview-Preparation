/*
Given an N-ary tree, find and return the node with second largest value in the given tree. Return NULL if no node with required value is present.
*/

class Solution {
  Node max = null,secondMax = null;
  public Node secondLargest(Node root) {
    if(root == null)
      return null;
    helper(root);
    return secondMax;
  }
  private void helper(Node root) {
    if(root == null)
      return;
    if(max == null || max.val < root.val) {
      secondMax = max;
      max = root;
    }
    else if(root.val > secondMax.val && root.val != max.val)
      secondMax = root;
    for(Node x : root.children)
      helper(x);
  }
}
