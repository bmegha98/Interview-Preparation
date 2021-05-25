/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the
balloons.If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as 
if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.
Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
*/

/*
for each balloon, determine coins if that balloon is burst at last 
Coins[i] = Coins[i-1] (left)+ Coins[i+1] (right)+ coins if ith balloon is burst at last
So, consider window of each size and determine max coins that can be collected in that window .
For each window = [left,right], find max coins if ith balloon is burst at last where i = left to right 
coins that can be collected if ith balloon is burst at last coins[left][right] = nums[i]*nums[left-1]*nums[right+1] + coins[left][i-1] + coins[i+1][right] 
If ith balloon is burst at last then all other balloons in the window would have been burst.
*/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        if(n == 1)
            return nums[0];
        int[] A = new int[n + 2];
        A[0] = A[n+1] = 1;
          
        for(int i = 1; i <= n; i++)
            A[i] = nums[i-1];
        
        int T[][] = new int[n+2][n+2];
        
        for(int w = 1;w<=n;w++) {
            for(int left = 1;left <= n-w+1;left++) {
                int right = left+w-1;
                
                for(int i = left;i<=right;i++) //ith balloon is burst at last
                    T[left][right] = Math.max(T[left][right], T[left][i-1]+T[i+1][right]+
                                             A[i]*A[left-1]*A[right+1]);
                
            }
        }
        return T[1][n];
    }
}
