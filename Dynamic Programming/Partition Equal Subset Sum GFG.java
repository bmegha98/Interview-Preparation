/*
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be partitioned into two such parts.
*/

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int ele : arr)
            sum += ele;
        if(sum%2 != 0)
            return 0;
        
        return boundedKnapSack(arr, N, sum/2);
    }
    
    static int boundedKnapSack(int[] A, int n, int W) {
        int[][] T = new int[n+1][W+1];
        
        for(int i=0;i<=n;i++)
            T[i][0] = 1;
        
        for(int i=1;i<=n;i++)
            for(int j=1;j<=W;j++) {
                if(A[i-1] > j)
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = (T[i-1][j] | T[i-1][j-A[i-1]])==1?1 : 0;
            }
        return T[n][W];        
    }
}
