/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/

//Preorder traversal + Map
//T(n) = O(n), Space = O(n)
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> aux = new HashMap<>();
        int maxFreq = 0;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                aux.put(curr.val,aux.getOrDefault(curr.val,0)+1);
                maxFreq = Math.max(maxFreq,aux.get(curr.val));
                curr = curr.right;
            }
            else {
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = curr;
                    aux.put(curr.val,aux.getOrDefault(curr.val,0)+1);
                    maxFreq = Math.max(maxFreq,aux.get(curr.val));
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : aux.entrySet()) 
            if(entry.getValue() == maxFreq)
                res.add(entry.getKey());
        
        int[] modeList = new int[res.size()];
        for(int i=0;i<res.size();i++)
            modeList[i] = res.get(i);
        return modeList;
    }
}

//Without extra space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int maxFreq = 1,count = 1;
        
        TreeNode curr = root,prev = null;
        while(curr != null) {
            if(curr.left == null) {
                if(prev != null) {
                    if(prev.val == curr.val) {
                        count++;
                    }
                    else 
                        count = 1;
                }
                if (count == maxFreq)
                    res.add(curr.val);
                else if(count>maxFreq) {
                        res.clear();
                        res.add(curr.val);
                        maxFreq = count;
                }
                prev = curr;
                curr = curr.right;
            }
            else {
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    if(prev != null) {
                        if(prev.val == curr.val) 
                            count++;
                        else 
                            count = 1;
                    }
                    if (count == maxFreq)
                        res.add(curr.val);
                    else if(count>maxFreq){
                        res.clear();
                        res.add(curr.val);
                        maxFreq = count;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        int[] modeList = new int[res.size()];
        for(int i=0;i<res.size();i++)
            modeList[i] = res.get(i);
        return modeList;
    }
}
