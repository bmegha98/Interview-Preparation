/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
*/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return nums[0]<=nums[1]?nums[0]:nums[1];
        
        if(nums[0] < nums[n-1])
            return nums[0];
        int l =0,r = n-1;
        while(l<r) {
            int m = l+(r-l)/2;
            if(nums[m] == nums[r])
                r--;
            else if(nums[m] < nums[r])
                r = m;
            else
                l = m+1;
        }
        return nums[l];
    }
}
