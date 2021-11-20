/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j],
[i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1), (2,2) and (2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1 Oranges at (0,0) and (0,1) can't rot orange at (0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time
to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n)
*/

class Pair {
    int x,y;
    public Pair(int r, int c) {
        x = r;
        y = c;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    int[] ROW = {0,-1,0,1};
    int[] COL = {-1,0,1,0};
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int m = grid.length, n = grid[0].length;
        Queue<Pair> aux = new LinkedList<>();
        int fresh = 0,res = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    aux.add(new Pair(i,j));
            }
        
        while(!aux.isEmpty()) {
            int l = aux.size();
            res++;
            while(l-- > 0) {
                Pair curr = aux.poll();
                int r = curr.x, c = curr.y;
                for(int i=0;i<4;i++) {
                    int newR = r+ROW[i], newC = c+COL[i];
                    if(newR >=0 && newR < m && newC >= 0 && newC < n &&
                        grid[newR][newC] == 1) {
                            grid[newR][newC] = 2;
                            aux.add(new Pair(newR, newC));
                            fresh--;
                        }
                }
            }
        }
        
        return fresh > 0?-1:res-1;
    }
}
