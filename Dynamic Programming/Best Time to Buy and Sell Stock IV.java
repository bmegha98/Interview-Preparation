/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
*/

//Recursion + Memoization
class Solution {
    int[][] T;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k == 0 || n < 2)
            return 0;
        /*
        OPT(K,X) = MAX {
                            OPT(K,X-1),     no transaction done
                            MAX{            complete transaction i.e. sell stock today
                                OPT(K-1,Y)+prices[X]-prices[Y]
                            } ,             if there exists 1<=Y<X s.t. price[Y]<price[X]
                            0 , otherwise
                        }
        */
        T = new int[k+1][n];
        for(int i=1;i<=k;i++)
            Arrays.fill(T[i],-1);
        
        return buySellStock(prices,n-1,k);
    }
    private int buySellStock(int[] prices,int n,int k) {
            if(k == 0 || n == 0)
                return 0;
            if(T[k][n] != -1)
                return T[k][n];
            int noTrans = buySellStock(prices,n-1,k);
            int completeTrans = Integer.MIN_VALUE;
            
            for(int i = 0;i<n;i++) 
                if(prices[i] < prices[n])
                    completeTrans = Math.max(completeTrans, buySellStock(prices,i,k-1) +                                                        prices[n]-prices[i]);
            return T[k][n] = Math.max(completeTrans,noTrans);
        }
}

//Tabulation
    int[][] T;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k == 0 || n < 2)
            return 0;
        /*
        OPT(K,X) = MAX {
                            OPT(K,X-1),     no transaction done
                            MAX{            complete transaction i.e. sell stock today
                                OPT(K-1,Y)+prices[X]-prices[Y]
                            } ,             if there exists 1<=Y<X s.t. price[Y]<price[X]
                            0 , otherwise
                        }
        */
        T = new int[k+1][n];
        
        for(int i = 1;i<=k;i++) {
            for(int j=1;j<n;j++) {
                T[i][j] = T[i][j-1];
                int tmp = 0;
                for(int d = 0;d<j;d++)
                    if(prices[d] < prices[j])
                        tmp = Math.max(tmp, T[i-1][d]+prices[j]-prices[d]);
                T[i][j] = Math.max(T[i][j],tmp);
            }
        }
        return T[k][n-1];
    }
