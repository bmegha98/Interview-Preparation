/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j],
[i,j-1], [i,j+1] (up, down, left and right) in unit time. 
*/

class Pair {
    int key, value;
    public Pair(int x, int y) {
        key = x;
        value = y;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}

class Solution
{
    int[] row = {0, 1, 0, -1};
    int[] col = {-1, 0, 1, 0};
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Pair> aux = new LinkedList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    aux.add(new Pair(i,j));
            }
        }
        
        int ans = 0;
        while(!aux.isEmpty()) {
            int len = aux.size();
            ans++;
            while(len-- > 0) {
                Pair p = aux.poll();
                int x = p.getKey();
                int y = p.getValue();
                for(int i = 0;i<4;i++) {
                    int x_new = x+row[i];
                    int y_new = y+col[i];
                    
                    if(x_new >= 0 && x_new < m && y_new >=0 && y_new < n &&
                    grid[x_new][y_new]==1) {
                        grid[x_new][y_new] = 2;
                        fresh--;
                        aux.add(new Pair(x_new,y_new));
                    }
                }
            }
        }
        
        if(fresh > 0)
            return -1;
        return ans-1;
    }
}
