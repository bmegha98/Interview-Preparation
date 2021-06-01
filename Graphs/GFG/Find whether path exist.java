/*
Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and 
left.The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.
 

Example 1:

Input: grid = {{3,0,3,0,0},{3,0,0,0,3}
,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}}
Output: 0
Explanation: The grid is-
3 0 3 0 0 
3 0 0 0 3 
3 3 3 3 3 
0 2 3 0 0 
3 0 0 1 3 
There is no path to reach at (3,1) i,e at destination from (4,3) i,e source.
*/

class Solution
{
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        int[] src = new int[2];
        
        for(int i = 0;i<n;i++) 
            for(int j =0;j<n;j++) 
                if(grid[i][j] == 1) {
                    src[0] = i;
                    src[1] = j;
                    break;
                }
        
        return dfs(grid, visited, n, src);
    }
    
    private boolean dfs(int[][] A, boolean[][] V, int n, int[] src) {
        if(A[src[0]][src[1]] == 2)
            return true;
        V[src[0]][src[1]] = true;
        for(int i =0;i<4;i++) {
            int newR = src[0]+ROW[i],newC = src[1]+COL[i];
            if(newR >= 0 && newR < n && newC >= 0 && newC < n && A[newR][newC] != 0 
                && !V[newR][newC]) {
                if(dfs(A,V,n,new int[]{newR,newC}))
                    return true;
            }
        }
        return false;
    }
    
}
