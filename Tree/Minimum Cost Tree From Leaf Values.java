/*
Given an array arr of positive integers, consider all binary trees such that:
Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit
integer.
Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4
*/
//T(n) = O(n^2)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        if(n == 2)
            return arr[0]*arr[1];
        int res = 0;
        while(n > 1) {
            int prod = arr[0]*arr[1];
            int ind1 = 0,ind2 = 1;
            for(int i = 1;i<n-1;i++) 
                if(prod > arr[i]*arr[i+1]) {
                    prod = arr[i]*arr[i+1];
                    ind1 = i;
                    ind2 = i+1;
                }
            int minInd = arr[ind1] < arr[ind2]?ind1:ind2;
            res += prod;
            while(minInd < n-1){
                arr[minInd] = arr[minInd+1];
                minInd++;
            }
            n--;
        }
        return res;
    }
}
