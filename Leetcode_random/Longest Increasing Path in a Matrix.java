/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., 
wrap-around is not allowed).

Example 1:
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Example 3:
Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/

//Time = Space = O(mn)
class Solution {
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    int[][] T;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int longestPath = 1;
        T = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                //Consider each cell as start point
                int path = dfs(matrix,i,j,m,n);
                longestPath = Math.max(longestPath,path);
            }
        return longestPath;
    }
    
    private int dfs(int[][] M, int r, int c, int m, int n) {
        if(T[r][c] > 0)
            return T[r][c];
        int res = 1;
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && 
               M[newR][newC] > M[r][c])
               res = Math.max(res,dfs(M,newR,newC,m,n)+1); 
        }
        
        return T[r][c] = res;
    }
}
