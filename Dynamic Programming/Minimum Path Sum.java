/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/
//Two ways to reach cell (i,j) : through (i,j-1) or (i-1,j). Choose one with minimum path.

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        if(m == 1 && n == 1)
            return grid[0][0];
        
        for(int i=0;i<m;i++) {
            for(int j =0;j<n;j++) {
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    grid[i][j] += grid[i][j-1];
                else if(j == 0)
                    grid[i][j] += grid[i-1][j];
                else
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
