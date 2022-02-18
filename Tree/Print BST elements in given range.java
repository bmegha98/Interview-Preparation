/*
Given a Binary Search Tree and a range [low, high]. Find all the numbers in the BST that lie in the given range.
Note: Element greater than or equal to root go to the right side.

Example 1:

Input:
       17
     /    \
    4     18
  /   \
 2     9 
l = 4, h = 24
Output: 4 9 17 18 
Example 2:

Input:
       16
     /    \
    7     20
  /   \
 1    10
l = 13, h = 23
Output: 16 20 
Your Task:
You don't need to read input or print anything. Your task is to complete the function printNearNodes() which takes the root Node of the BST and the range elements 
low and high as inputs and returns an array that contains the BST elements in the given range low to high (inclusive) in non-decreasing order.
*/

class Solution
{   
    static ArrayList<Integer> res;
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        res = new ArrayList<Integer>();
        helper(root,low,high);
        return res;
    }
    
    private static void helper(Node root, int l, int h) {
        if(root == null)
            return;
        if(root.data < l)
            helper(root.right,l,h);
        else if(root.data > h)
            helper(root.left,l,h);
        else {
            helper(root.left,l,h);
            res.add(root.data);
            helper(root.right,l,h);
        }
    }
    
}
