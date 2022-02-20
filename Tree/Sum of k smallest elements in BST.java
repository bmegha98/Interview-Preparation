/*
Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

Example 1:

Input: 
          20
        /    \
       8     22
     /    \
    4     12
         /    \
        10    14   , K=3

Output: 22
Explanation:
Sum of 3 smallest elements are: 
4 + 8 + 10 = 22
Example 2:
Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8 , K=2

Output: 9
Explanation:
The sum of two smallest elements 
is 4+5=9.

*/

class Tree {
    int kSum = 0, count = 0;
    int sum(Node root, int k) { 
        // Code here
        helper(root,k);
        return kSum;
    } 
    
    private void helper(Node root, int k) {
        if(root == null)
            return;
        helper(root.left,k);
        if(count < k)
            kSum += root.data;
        count++;
        helper(root.right,k);
    }
}
