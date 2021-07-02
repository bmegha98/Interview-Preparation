/*
Given an unsorted array, find the minimum difference between any pair in given array.
Example 1:

Input: nums = [2, 4, 5, 9, 7]
Output: 1
Explanation: Difference between 5 and 4 is 1.
Example 2:

Input: nums = [3, 10, 8, 6]
Output: 2
Explanation: Difference between 8 and 6 is 2.
*/

class Solution
{
    public int minimum_difference(int[] nums)
    {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++)
            minDiff = Math.min(minDiff,nums[i+1]-nums[i]);
        return minDiff;
    }
}
