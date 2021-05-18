/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

//T(n) = O(n) , space = O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2)
            return 0;
        int sell = prices[n-1], maxProfit = 0;
        for(int i=n-2;i>=0;i--) {
            if(prices[i] > sell)
                sell = prices[i];
            else
                maxProfit = Math.max(maxProfit, sell-prices[i]);
        }
        return maxProfit;
    }
}
