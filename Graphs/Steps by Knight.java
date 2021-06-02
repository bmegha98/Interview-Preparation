/*
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.
Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

(i,j) -> (i-2,j+1), (i-1,j+2), (i+1,j+2), (i+2,j+1), (i+2,j-1), (i+1,j-2), (i-1,j-2), (i-2,j-1)

BFS can be used to find shortest path from start to target.
*/

class Solution
{
    int[] ROW = {-2,-1,1,2,2,1,-1,-2};
    int[] COL = {1,2,2,1,-1,-2,-2,-1};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        KnightPos[0] -= 1;
        KnightPos[1] -= 1;
        TargetPos[0] -= 1;
        TargetPos[1] -= 1;
        
        Queue<int[]> aux = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        aux.add(new int[]{KnightPos[0],KnightPos[1],0});
        visited[KnightPos[0]][KnightPos[1]] = true;
        
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            if(r == TargetPos[0] && c == TargetPos[1])
                return d;
            
            for(int i =0;i<8;i++) {
                int newR = r+ROW[i], newC = c+COL[i];
                if(newR >= 0 && newR < N && newC >= 0 && newC < N && !visited[newR][newC]) {
                    aux.add(new int[]{newR,newC,d+1});
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
}
