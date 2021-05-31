/*
Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
Note: 'X' shape consists of one or more adjacent X's (diagonals not included).
Example 1:

Input: grid = {{X,O,X},{O,X,O},{X,X,X}}
Output: 3
Explanation: 
The grid is-
X O X
O X O
X X X
So, X with same colour are adjacent to each 
other vertically for horizontally (diagonals 
not included). So, there are 3 different groups 
in the given grid.
*/

class Solution
{
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        int m = grid.length,n = grid[0].length;
        if(m == 1 && n == 1)
            return grid[0][0] == 'X'?1:0;
        
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 'X' && !visited[i][j]) {
                    count++;
                    dfs(grid,visited,i,j,m,n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] M,boolean[][] V,int r,int c,int m,int n) {
        V[r][c] = true;
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i],newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && M[newR][newC] == 'X'
                && !V[newR][newC])
                dfs(M,V,newR,newC,m,n);
        }
    }
}
