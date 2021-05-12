/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
*/
//T(n) = O(logn)
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.min(nums[0],nums[1]);
        
        if(nums[0] < nums[n-1])
            return nums[0];
        
        int l =0, h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m == 0||nums[m] < nums[m-1])&&(m == n-1||nums[m]<nums[m+1]))
                return nums[m];
            if(nums[m]<=nums[h])
                h = m-1;
            else
                l = m+1;
        }
        return nums[h];
    }
}
