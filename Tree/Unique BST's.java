/*
Given an integer. Find how many structurally unique binary search trees are there that stores the values from 1 to that integer (inclusive). 

Example 1:

Input:
N = 2
Output: 2
Explanation:for N = 2, there are 2 unique
BSTs
     1               2  
      \            /
       2         1
Example 2:

Input:
N = 3
Output: 5
Explanation: for N = 3, there are 5
possible BSTs
  1           3     3       2     1
    \        /     /      /  \     \
     3      2     1      1    3     2
    /      /       \                 \
   2      1         2                 3
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numTrees() which takes the integer N as input and returns the total number
of Binary Search Trees possible with keys [1.....N] inclusive. Since the answer can be very large, return the answer modulo 10e9 + 7.
*/

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        // Your code goes here
        if(N <= 1)
            return 1;
        long[] T = new long[N+1];
        int MOD = 1000000007;
        T[0] = 1; T[1] = 1;
        for(int i=2;i<=N;i++)
            for(int j=1;j<=i;j++)
                T[i] = (T[i] + (T[j-1]* T[i-j])%MOD)%MOD;
        return (int)T[N];
    }
    
}
