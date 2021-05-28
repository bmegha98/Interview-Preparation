/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from 
robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into 
on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Input: nums = [2,1,1,4]
Output: 4

*/

//Only two choices per house : rob it or not rob it
//Recursive+Memoization
class Solution {
    int[] T;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0],nums[1]);
        T = new int[n+1];
        Arrays.fill(T,-1);
        return robHouses(nums,n);
        
    }
    private int robHouses(int[] nums,int n) {
        if(n <= 0)
            return 0;
        if(T[n] != -1)
            return T[n];
        int rob = nums[n-1]+robHouses(nums,n-2);
        int notRobbed = robHouses(nums,n-1);
        return T[n]=Math.max(rob,notRobbed);
    }
}

//Tabulation
class Solution {
    int[] T;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0],nums[1]);
        
        T = new int[n+1];
        T[1] = nums[0];
        T[2] = Math.max(nums[0],nums[1]);
        for(int i=3;i<=n;i++) 
            T[i] = Math.max(T[i-1],nums[i-1]+T[i-2]);
        return T[n];
    }
}

//Constant Space
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0],nums[1]);
        
        int secondLast = nums[0];
        int last = Math.max(nums[0],nums[1]);
        for(int i=3;i<=n;i++) {
            int tmp = Math.max(last, nums[i-1]+secondLast);
            secondLast = last;
            last = tmp;
        }
        return last;
    }
}
