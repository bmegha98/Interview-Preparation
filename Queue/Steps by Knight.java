/*
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the initial position of Knight (KnightPos), the target position of Knight (TargetPos), and the size of the chessboard (N) as input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.

*/

class Solution
{
    int[] ROW = {-1,-2,-2,-1,1,2,2,1};
    int[] COL = {-2,-1,1,2,2,1,-1,-2};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Code here
        Queue<int[]> aux = new LinkedList<>();
        int[][] visited = new int[N][N];
        
        aux.add(new int[]{KnightPos[0]-1,KnightPos[1]-1,0});
        visited[KnightPos[0]-1][KnightPos[1]-1] = 1;
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            //System.out.println(curr[0]+" : "+curr[1]+" : "+curr[2]);
            if(curr[0] == TargetPos[0]-1 && curr[1] == TargetPos[1]-1)
                return curr[2];
            for(int i=0;i<8;i++) {
                int newR = curr[0]+ROW[i], newC = curr[1]+COL[i];
                if(newR >= 0 && newR < N && newC >= 0 && newC < N &&
                    visited[newR][newC] == 0) {
                        aux.add(new int[]{newR,newC,curr[2]+1});
                        visited[newR][newC] = 1;
                }
            }
        }
        return -1;
    }
}
