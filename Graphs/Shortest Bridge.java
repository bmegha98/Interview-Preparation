/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
*/

class Pair {
    int x, y, dist;
    public Pair(int i, int j, int d) {
        x = i;
        y = j;
        dist = d;
    }
}
class Solution {
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    private void dfs(int[][] M, int r, int c, int n, Queue<Pair> aux) {
        aux.add(new Pair(r,c,0));
        M[r][c] = -1;
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < n && newC >= 0 && newC < n && M[newR][newC] == 1)
                dfs(M,newR,newC,n,aux);
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        
        boolean exit = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                if(grid[i][j] == 1) {
                    dfs(grid,i,j,n,q);
                    exit = true;
                    break;
                }
            if(exit)
                break;
        }
        
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.x,c = p.y, d = p.dist;
            for(int i=0;i<4;i++) {
                int newR = r+ROW[i], newC = c+COL[i];
                if(newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] >= 0) {
                    if(grid[newR][newC] == 1)
                        res = Math.min(res,d);
                    else {
                        q.add(new Pair(newR,newC,d+1));
                        grid[newR][newC] = -1;
                    }
                }
            }
        }
        return res;
    }
}
