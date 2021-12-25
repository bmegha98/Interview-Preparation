/*
Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
 

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands one is colored in blue 
and other in orange.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes grid as input parameter and returns the total number of 
islands. 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
*/

//Each cell is traversed only once
class Solution {
    // Function to find the number of islands.
    int[] ROW = {-1,-1,-1,0,0,1,1,1};
    int[] COL = {-1,0,1,-1,1,-1,0,1};
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length, n = grid[0].length;
        
        int[][] visited = new int[m][n];
        
        int count = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid,i,j,m,n,visited);
                    count++;
                }
            }
        return count;
    }
    
    private void dfs(char[][] M, int r, int c, int m, int n, int[][] V) {
        V[r][c] = 1;
        for(int i=0;i<8;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >=0 && newC < n && 
                M[newR][newC] == '1' && V[newR][newC] == 0)
                dfs(M,newR,newC,m,n,V);
        }
    }
}
