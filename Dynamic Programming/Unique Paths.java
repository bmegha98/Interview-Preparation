/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram
below).
How many possible unique paths are there?
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1)
            return 1;
        int[][] T = new int[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(i == 0||j == 0)
                    T[i][j] = 1;
                else
                    T[i][j] = T[i][j-1]+T[i-1][j];
            }
        }
        return T[m-1][n-1];
    }
}
