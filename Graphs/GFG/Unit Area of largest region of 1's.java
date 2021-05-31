/*
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally(horizontally, vertically, dioganally).
Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored in orange.
*/

//size of largest connected component
class Solution
{
    int[] ROW = {-1,-1,-1,0,0,1,1,1};
    int[] COL = {-1,0,1,-1,1,-1,0,1};
    int count;
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int m = grid.length,n = grid[0].length;
        if(m == 1 && n == 1)
            return grid[0][0];
        
        boolean[][] visited = new boolean[m][n];
        int maxCount = 0;
        
        for(int i =0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid,visited,i,j,m,n);
                    maxCount = Math.max(maxCount,count);
                }
            }
        }
        return Math.max(maxCount,count);
    }
    
    private void dfs(int[][] M,boolean[][] V,int r,int c, int m,int n) {
        count++;
        V[r][c] = true;
        for(int i=0;i<8;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && M[newR][newC] == 1
                && !V[newR][newC])
                dfs(M,V,newR,newC,m,n);
        }
    }
}
