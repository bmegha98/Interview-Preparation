/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram
below).Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
*/

//Time = O(mn) , Space = O(mn)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1)
            return 0;
        int[][] T = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(obstacleGrid[i][j] == 1)
                    T[i][j] = 0;
                else {
                    if(i == 0 && j == 0)
                        T[i][j] = 1;
                    else if(i == 0)
                        T[i][j] = T[i][j-1];
                    else if(j == 0)
                        T[i][j] = T[i-1][j];
                    else
                        T[i][j] = T[i-1][j] + T[i][j-1];
                }
            }
        }
        return T[m-1][n-1];
    }
}

//T(n) = O(mn) , Space = O(1)
class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int m = Grid.length,n = Grid[0].length;
        
        if(Grid[0][0] == 1)
            return 0;
        Grid[0][0] = 1-Grid[0][0];
        for(int i = 0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0)
                    continue;
                Grid[i][j] = 1-Grid[i][j];
                if(i == 0)
                    Grid[i][j] *= Grid[i][j-1];
                else if(j == 0)
                    Grid[i][j] *= Grid[i-1][j];
                else if(Grid[i][j] == 1)
                    Grid[i][j] = Grid[i-1][j] + Grid[i][j-1];
                }
            }
        return Grid[m-1][n-1];
    }
}
