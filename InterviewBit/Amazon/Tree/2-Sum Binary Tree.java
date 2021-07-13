/*
Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and 
B such that A.value + B.value = K.Return 1 to denote that two such nodes exist. Return 0, otherwise.
Notes
Your solution should run in linear time and not take memory more than O(height of T).Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

//T(n) = O(n), Space = O(n)
public class Solution {
    public int t2Sum(TreeNode A, int B) {
        List<Integer> tmp = new ArrayList<>();
        
        TreeNode curr = A;
        while(curr != null) {
            if(curr.left == null) {
                tmp.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode l = curr.left;
                while(l.right != null && l.right != curr)
                    l = l.right;
                if(l.right == null) {
                    l.right = curr;
                    curr = curr.left;
                }
                else {
                    l.right = null;
                    tmp.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        int l = 0,h = tmp.size()-1;
        while(l<h) {
            int s = tmp.get(l)+tmp.get(h);
            if(s == B)
                return 1;
            if(s < B)
                l++;
            else
                h--;
        }
        return 0;
    }
}
// It can also be done using doubly linked list with head and tail pointers. T(n) = O(n) , Space = O(h)
public class Solution {
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;
    public int t2Sum(TreeNode A, int B) {
        if(A == null)
            return 0;
        convertToList(A);
        TreeNode l = dummy.right, h = prev;
        while(l != h) {
            int s = l.val+h.val;
            if(s == B)
                return 1;
            if(s < B)
                l = l.right;
            else
                h = h.left;
        }
        return 0;
    }
    
    private void convertToList(TreeNode root) {
        if(root == null)
            return;
        convertToList(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        convertToList(root.right);
    }
}
