/*
Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left
cell to bottom right cell by which the total cost incurred is minimum.From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 
Note: It is assumed that negative cost cycles do not exist in the input matrix.
Example 1:

Input: grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.

Weighted graph with no -ve edges => Dijikstra's algo
*/

class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	int[] ROW = {0,0,-1,1};
	int[] COL = {-1,1,0,0};
    public int minimumCostPath(int[][] grid)
    {
        int V = grid.length;
        int[][] dist = new int[V][V];
        
        for(int i=0;i<V;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        
        dist[0][0] = grid[0][0];

        Queue<int[]> aux = new PriorityQueue<>(1,(a,b)->a[2]-b[2]);
        boolean[][] visited = new boolean[V][V];
        int count = 0;
        
        aux.add(new int[]{0,0,dist[0][0]});
        while(count != V*V) {
            int[] tmp = aux.poll();
            int r = tmp[0],c = tmp[1];
            if(!visited[r][c]) {
                for(int i=0;i<4;i++) {
                    int newR = r+ROW[i],newC = c+COL[i];
                    if(newR >= 0 && newR < V && newC >= 0 && newC < V && 
                        !visited[newR][newC] && dist[r][c] != Integer.MAX_VALUE && 
                        dist[newR][newC] > dist[r][c]+grid[newR][newC]) {
                            dist[newR][newC] = dist[r][c]+grid[newR][newC];
                            aux.add(new int[]{newR,newC,dist[newR][newC]});
                        }
                }
                visited[r][c] = true;
                count++;
            }
        }
        
        return dist[V-1][V-1];
    }
    
    
}
