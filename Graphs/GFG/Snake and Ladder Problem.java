/*
Given a 5x6 snakes and ladders board, find the minimum number of dice throws required to reach the destination or last cell (30th cell) from the source (1st cell).
You are given an integer N denoting the total number of snakes and ladders and an array arr[] of 2*N size where 2*i and (2*i + 1)th values denote the starting and 
ending point respectively of ith snake or ladder. The board looks like the following.

Input:
N = 8
arr[] = {3, 22, 5, 8, 11, 26, 20, 29, 
       17, 4, 19, 7, 27, 1, 21, 9}
Output: 3
Explanation:
The given board is the board shown
in the figure. For the above board 
output will be 3. 
a) For 1st throw get a 2. 
b) For 2nd throw get a 6.
c) For 3rd throw get a 2.

BFS can be used. At each cell i, there are 6 adjacent cells i+1,i+2,.....,i+6
*/

class Solution{
    static int minThrow(int N, int arr[]){
        int[] move = new int[31];
        for(int i =0;i<2*N;i+=2)
            move[arr[i]] = arr[i+1];
        
        boolean[] visited = new boolean[31];
        Queue<int[]> aux = new LinkedList<>();
        aux.add(new int[]{1,0});
        visited[1] = true;
        while(!aux.isEmpty()) {
            int[] curr = aux.poll();
            int cell = curr[0],moves = curr[1];
            if(cell == 30)
                return moves;
    
            for(int i = 1;i<=6;i++) {
                int newCell = cell+i;
                if(newCell < 31 && !visited[newCell]) {
                    if(move[newCell] != 0)
                        newCell = move[newCell];
                    aux.add(new int[]{newCell,moves+1});
                    visited[newCell] = true;
                }
            }
        }
        return -1;
    }
}
