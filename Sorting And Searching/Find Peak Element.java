/*
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;
        if(n==2)
            return nums[0]> nums[1]?0:1;
        int l=0,h=n-1;
        while(l<=h) {
            int m=l+(h-l)/2;
            if((m==0|| nums[m]>nums[m-1])&&(m==n-1||nums[m]>nums[m+1]))
                return m;
            if(m>0&&nums[m]<nums[m-1])
                h=m-1;
            else
                l=m+1;
        }
        return l;
    }
}
