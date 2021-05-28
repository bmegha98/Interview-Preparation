/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a
circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact
the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0],nums[1]);
        //Two choices : either rob House[1....n-1] or rob House[2....n]
        
        int robFirst = robHouses(nums,0,n-1);
        int robLast = robHouses(nums,1,n);
        
        return Math.max(robFirst,robLast);
    }
    private int robHouses(int[] nums,int start,int end) {
        int secondLast = nums[start];
        int last = Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<end;i++) {
            int tmp = Math.max(last, nums[i]+secondLast);
            secondLast = last;
            last = tmp;
        }
        return last;
    }
    
}
