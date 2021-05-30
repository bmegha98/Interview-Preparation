/*
You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will
not break.
Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not
break, you may reuse it in future moves.
Return the minimum number of moves that you need to determine with certainty what the value of f is.
Example 1:

Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

Try to drop the egg from each floor and pick the floor that gives min moves in the worst case. At each floor , there are two cases : either the egg breaks or egg
doesn't break. Choose the worst case because it will give surety of threshold floor.
*/

//Recursive + Memoization
class Solution {
    int[][] T;
    public int superEggDrop(int k, int n) {
        if(k == 1)
            return n;
        if(n == 1)
            return 1;
        T = new int[n+1][k+1];
        for(int i=1;i<=n;i++)
            Arrays.fill(T[i],-1);
        return minMoves(n,k);
    }
    private int minMoves(int n, int e) {
        if(n == 1 || n == 0)
            return n;
        if(e == 1)
            return n;
        if(T[n][e] != -1)
            return T[n][e];
        int moves = Integer.MAX_VALUE;
        for(int f = 1;f<=n;f++) 
            moves = Math.min(moves, Math.max(minMoves(f-1,e-1),minMoves(n-f,e))+1);
        return T[n][e] = moves;
    }
}

//Tabulation , Time = O(n*n*k) , Space = O(n*k)
class Solution {
    int[][] T;
    public int superEggDrop(int k, int n) {
        if(k == 1)
            return n;
        if(n == 1)
            return 1;
        T = new int[n+1][k+1];
        for(int i = 1;i<=n;i++)
            T[i][1] = i;
        for(int j = 2;j<=k;j++)
            T[1][j] = 1;
        
        for(int i = 2;i<=n;i++) {
            for(int j = 2;j<=k;j++) {
                T[i][j] = Integer.MAX_VALUE;
                
                for(int f = 1;f<=i;f++)
                    T[i][j] = Math.min(T[i][j],Math.max(T[f-1][j-1],T[i-f][j])+1);
            }
        }
        return T[n][k];
    }
}

/*
Above solutions are giving TLE. We can view the problem as follows :
Given k eggs and m moves, determine max number of floors we can check.Each move is dropping an egg. Here also , two cases arise : egg breaks or not
OPT(k,m) = OPT(k-1,m-1)+OPT(k,m-1)+1 (for current floor)
Increase moves by 1 until you're able to cover num of floors >= N . 
*/
//T(n) = O(klogn) , Space = O(nk)
class Solution {
    int[][] T;
    public int superEggDrop(int k, int n) {
        if(k == 1)
            return n;
        if(n == 1)
            return 1;
        T = new int[k+1][n+1];          //Num of floors that we can check
        int m = 0;
        while(T[k][m] < n) {
            m++;
            for(int egg=1;egg<=k;egg++)
                T[egg][m] = T[egg-1][m-1]+T[egg][m-1]+1;
        }
        return m;
    }
}

