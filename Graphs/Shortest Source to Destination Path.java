/*
Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.

Example 1:

Input:
N=3
M=4
A=[[1,0,0,0], 
[1,1,0,1],[0,1,1,1]]
X=2
Y=3 
Output:
5
*/

class Solution {
    int[] ROW = {0,-1,0,1};
    int[] COL = {-1,0,1,0};
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0)
            return -1;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> aux = new LinkedList<>();
        aux.add(new int[]{0,0,0});
        visited[0][0] = true;
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            if(curr[0] == X && curr[1] == Y)
                return curr[2];
            
            for(int i =0;i<4;i++) {
                int newR = curr[0]+ROW[i],newC = curr[1]+COL[i];
                if(newR >= 0 && newR <N && newC >= 0 && newC < M && A[newR][newC] == 1
                    && !visited[newR][newC]) {
                    aux.add(new int[]{newR,newC,curr[2]+1});
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
}
