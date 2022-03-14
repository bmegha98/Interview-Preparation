/*
Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building.
Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters O, B, and W where: 
O represents an open space.
B represents a bomb.
W represents a wall.
You have to replace all of the Os (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace
the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

Example 1:

Input: N = 3, M = 3
A[] = {{O, O, O}, 
       {W, B, B}, 
       {W, O, O}}
Output: {{2, 1, 1}, 
         {-1, 0, 0},  
         {-1, 1, 1}}
Explanation: The walls at (1,0) and (2,0) 
are replaced by -1. The bombs at (1,1) and 
(1,2) are replaced by 0. The impact zone 
for the bomb at (1,1) includes open spaces 
at index (0,0), (0,1) and (2,1) with distance 
from bomb calculated as 2,1,1 respectively.
The impact zone for the bomb at (1,2) 
includes open spaces at index (0,3) and (2,2) 
with distance from bomb calculated as 1,1 
respectively.

Example 2:

IInput: N = 2, M = 2
A[] = {{O, O},
       {O, O}} 
Output: {{-1, -1}
         {-1, -1}
Your Task:  
You don't need to read input or print anything. Complete the function findDistance() which takes the matrix A[], M, and N as input parameters and the resultant
matrix
*/

class Solution
{
    static int[] ROW = {-1,0,0,1};
    static int[] COL = {0,-1,1,0};
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 'W')
                    res[i][j] = -1;
                else if(mat[i][j] == 'B') {
                    res[i][j] = 0;
                    q.add(new int[]{i,j,0});
                }
                else
                    res[i][j] = -2;
            }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[2];
            for(int i=0;i<4;i++) {
                int newR = curr[0]+ROW[i], newC = curr[1]+COL[i];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && 
                    res[newR][newC] == -2) {
                        res[newR][newC] = d+1;
                        q.add(new int[]{newR,newC,d+1});
                    }
            }
        }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(res[i][j] == -2)
                    res[i][j] = -1;
        return res;
    }
}
