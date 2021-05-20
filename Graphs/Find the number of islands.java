/*
Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i,e in all 8 directions.
*/

//Determine number of connected components

class Solution
{
    int[] ROW = {-1,-1,-1,0,0,1,1,1};
    int[] COL = {-1,0,1,-1,1,-1,0,1};
    //Function to find the number of islands.
    private void dfs(char[][] A, boolean[][] V, int r, int c,int m, int n) {
        V[r][c] = true;
        for(int i = 0;i<8;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && A[newR][newC] == '1'
                && !V[newR][newC])
                dfs(A,V,newR,newC,m,n);
        }
    }
    public int numIslands(char[][] grid)
    {
        int m = grid.length,n = grid[0].length;
        if(m == 1 && n == 1) 
            return grid[0][0] == '0' ? 0 : 1;
        
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i =0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid,visited,i,j,m,n);
                }
            }
        }
        return res;
    }
}
