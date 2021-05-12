/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ...,
nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1)
            return nums[0]==target?true:false;
        int l =0,h=n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(nums[m] == target)
                return true;
            if(nums[l] == nums[m]) {
                l++;
            }
            else if(nums[l] <= nums[m]) {
                if(target >= nums[l] && target <= nums[m])
                    h = m-1;
                else
                    l = m+1;
            }
            else {
                if(target >= nums[m] && target <= nums[h])
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return false;
    }
}
