/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take
to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix
represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of 
paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.
*/

class Solution {
    static ArrayList<String> paths;
    static int[] ROW = {-1,0,0,1};
    static int[] COL = {0,-1,1,0};
    static char[] dir = {'U','L','R','D'};
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        paths = new ArrayList<>();
        if(m[0][0] == 0)
            return paths;
        int[][] visited = new int[n][n];
        helper(m,visited,n,0,0,"");
        Collections.sort(paths);
        return paths;
    }
    
    private static void helper(int[][] M,int[][] V, int n, int i, int j, 
        String tmp) {
        if(i == n-1 && j == n-1) {
            paths.add(tmp);
            return;
        }
        V[i][j] = 1;
        for(int k=0;k<4;k++) {
            int newR = i+ROW[k], newC = j+COL[k];
            if(newR >= 0 && newR < n && newC >= 0 && newC < n &&
                M[newR][newC] == 1 && V[newR][newC] == 0) {
                    helper(M,V,n,newR,newC,tmp+dir[k]);
                }
        }
        V[i][j] = 0;
    }
}
