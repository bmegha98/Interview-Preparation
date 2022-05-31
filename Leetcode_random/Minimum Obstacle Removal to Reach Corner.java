/*
You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).

 

Example 1:


Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.
Example 2:


Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
Output: 0
Explanation: We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 105
2 <= m * n <= 105
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
*/

//Shortest path from (0,0) to (m-1,n-1), Time = O(MN * LOG(MN))
class Solution {
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        Queue<int[]> aux = new PriorityQueue<>(1, (a,b)->a[2]-b[2]);
        aux.add(new int[]{0,0,grid[0][0]});
        dist[0][0] = 0;
        
        
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            if(r == m-1 && c == n-1) 
                return d;
            
            for(int i=0;i<4;i++) {
                int newR = r+ROW[i], newC = c+COL[i];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && dist[newR][newC] > d+grid[newR][newC]) {
                    dist[newR][newC] = d+grid[newR][newC];
                    aux.add(new int[]{newR, newC, dist[newR][newC]});
                }
            }
        }
        
        return -1;
    }
}
