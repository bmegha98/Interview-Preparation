/*
Given a stream of integers,lookup the rank of a given integer x.Rank of an integer in-stream is “Total number of elements less than or equal to x (not including x)”.
If an element is not found in the stream or is smallest in stream, return -1. 
Examples: 
 
Input :  arr[] = {10, 20, 15, 3, 4, 4, 1}
              x = 4;
Output : Rank of 4 in stream is: 3
There are total three elements less than
or equal to x (and not including x)
*/

package com.paytm.gfg;

class BST {
  static class TreeNode {
    int val, leftSize;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.leftSize = 0;
      this.left = null;
      this.right = null;
    }
  }

  TreeNode root;
  public BST() {
    root = null;
  }
  public void track(int ele) {
    if(root == null) {
      root = new TreeNode(ele);
      return;
    }
    TreeNode curr = root;
    insert(curr, ele);
  }
  private TreeNode insert(TreeNode curr, int ele) {
    if(curr == null)
      return new TreeNode(ele);
    if(curr.val >= ele)
    {
      curr.leftSize++;
      curr.left = insert(curr.left, ele);
    }
    else
      curr.right = insert(curr.right, ele);
    return curr;
  }
  public int getRankOfNumber(int num) {
    if(root.val == num)
      return root.leftSize;
    TreeNode curr = root;
    return getRank(curr, num);
  }
  private int getRank(TreeNode curr, int ele) {
    if(curr == null)
      return 0;
    if(curr.val == ele)
      return curr.leftSize;
    if(curr.val > ele)
      return getRank(curr.left, ele);
    return getRank(curr.right, ele)+curr.leftSize+1;
  }
}
public class RankInStream {
  public static void main(String[] args) {
    int[] arr = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };

    BST b = new BST();
    for(int ele : arr) {
      b.track(ele);
    }
    System.out.println("Rank of 13 : "+b.getRankOfNumber(13));
  }
}
