/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int outOfOrder = 0, index = -1, n = nums.length;
        for(int i=0;i<n-1;i++)
            if(nums[i] > nums[i+1]) {
                outOfOrder++;
                if(index == -1)
                    index = i;  
            }
        
        if(outOfOrder > 1)
            return false;
        
        //corner elements can be updated to nums[index]-1 or nums[index]+1 
        if(outOfOrder == 0 || index == 0 || index+1 == n-1)  
            return true;
        
        // consider nums[index-1] nums[index] nums[index+1] nums[index+2]
        if(nums[index-1] <= nums[index+1])
            return true;  // nums[index] can be set to nums[index-1]
        
        if(index+2 < n && nums[index] <= nums[index+2])
            return true;  // nums[index] can be set to nums[index+1]
        return false;
    }
}
