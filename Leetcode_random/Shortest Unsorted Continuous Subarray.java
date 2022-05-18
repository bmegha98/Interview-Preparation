/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be
sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
*/

/*
Find window that is out of order
Expand the window accordingly
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;
        while(l<n-1) {
            if(nums[l] > nums[l+1])
                break;
            l++;
        }
        
        if(l == n-1)
            return 0;
        
        while(h>0) {
            if(nums[h]<nums[h-1])
                break;
            h--;
        }
        
        int minVal = nums[l], maxVal = nums[l];
        for(int i=l+1;i<=h;i++) {
            minVal = Math.min(minVal,nums[i]);
            maxVal = Math.max(maxVal,nums[i]);
        }
        
        for(int i=0;i<l;i++)
            if(nums[i] > minVal) {
                l = i;
                break;
            }
        
        for(int j=n-1;j>h;j--)
            if(nums[j] < maxVal) {
                h = j;
                break;
            }
        
        return h-l+1;
    }
}
