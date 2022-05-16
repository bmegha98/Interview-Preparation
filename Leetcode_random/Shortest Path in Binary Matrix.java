/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[] ROW = {-1,-1,-1,0,0,1,1,1};
        int[] COL = {-1,0,1,-1,1,-1,0,1};
        
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        
        q.add(new int[]{0,0,1});
        visited[0][0] = 1;
        grid[0][0] = 1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            if(r == n-1 && c == n-1)
                return d;
            for(int i=0;i<8;i++) {
                int newR = r+ROW[i], newC = c+COL[i];
                if(newR >= 0 && newR < n && newC >=0 && newC < n &&
                   visited[newR][newC] == 0 && grid[newR][newC] == 0) {
                    grid[newR][newC] = grid[r][c]+1;
                    visited[newR][newC] = 1;
                    q.add(new int[]{newR,newC,grid[newR][newC]});
                }
                    
            }
        }
        return -1;
        
    }
}
