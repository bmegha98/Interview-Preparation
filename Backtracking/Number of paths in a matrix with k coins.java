/*
Given a N x N matrix such that each of its cells contains some coins. Count the number of ways to collect exactly K coins while moving from top left corner of the
matrix to the bottom right. From a cell (i, j), you can only move to (i+1, j) or (i, j+1).

Example 1:

Input:
K = 12, N = 3
arr[] = [[1, 2, 3], 
         [4, 6, 5], 
         [3, 2, 1]]
Output: 2
Explanation: 
There are 2 possible paths 
with exactly K coins, (1 + 4 + 
3 + 2 + 1) and (1 + 2 + 3 + 5 + 1).
Example 2:

Input:
K = 16, N = 3
arr[] = [[1, 2, 3], 
         [4, 6, 5], 
         [9, 8, 7]]
Output: 0 
Explanation: 
There are no possible paths that lead 
to sum=16
Your Task:  
You don't need to read input or print anything. Your task is to complete the function numberOfPath() which takes N, K and 2D matrix arr[][] as input parameters 
and returns the number of possible paths.

*/

class Solution {
    Map<String,Long> aux;
    long numberOfPath(int N, int K, int [][]arr) {
        // code here
        if(arr[0][0] > K)
            return 0;
        aux = new HashMap<>();
        return helper(arr,N,K,0,0);
    }
    
    private long helper(int[][] A, int n, int k, int i, int j) {
        if(i == n-1 && j == n-1) {
            if (A[i][j] == k)
                return 1;
            return 0;
        }
        
        String key = ""+i+"_"+j+"_"+k;
        if(aux.containsKey(key))
            return aux.get(key);
        
        long count = 0;
        //bottom
        if(i+1 < n && A[i+1][j] <= k)
            count += helper(A,n,k-A[i][j],i+1,j);
        
        //right
        if(j+1 < n && A[i][j+1] <= k)
            count += helper(A,n,k-A[i][j],i,j+1);
        aux.put(key, count);
        return count;
    }
}
