/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. 
The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*/

/*
Hint :
Think of the final answer as a sum of weights with + or - sign symbols infront of each weight. Actually, all sums with 1 of each sign symbol are possible.
*/

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for(int ele : stones)
            s += ele;
        
        int S1 = subsetSum(stones,s/2);
        int S2 = s-S1;
        return S2-S1;
    }
    
    private int subsetSum(int[] A, int s) {
        int n = A.length;
        
        int[][] T = new int[n+1][s+1];
        for(int i = 1;i<=n;i++) {
            for(int j =1;j<=s;j++) {
                if(A[i-1] > j)
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = Math.max(T[i-1][j],A[i-1]+T[i-1][j-A[i-1]]);
            }
        }
        return T[n][s];
    }
}
