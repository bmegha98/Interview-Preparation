/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
*/

//Unbounded Knapsack

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 && amount > 0)
            return -1;
        int[][] T = new int[n+1][amount+1];
        Arrays.fill(T[0],Integer.MAX_VALUE-1);
        T[0][0] = 0;
        
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=amount;j++) {
                if(coins[i-1] > j)
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = Math.min(T[i-1][j],1+T[i][j-coins[i-1]]);
            }
        }
        return T[n][amount] >= Integer.MAX_VALUE-1?-1:T[n][amount];
    }
}
