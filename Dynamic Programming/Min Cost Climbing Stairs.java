/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
*/

//Top = nth floor

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n < 2)
            return 0;
        
        int[] T = new int[n+1];
        int a = 0, b = 0;
        for(int i = 2;i<=n;i++) {
            //T[i] = Math.min(T[i-1]+cost[i-1],T[i-2]+cost[i-2]);
            int res = Math.min(a+cost[i-1],b+cost[i-2]);
            b = a;
            a = res;
        }
        return a;
    }
}
