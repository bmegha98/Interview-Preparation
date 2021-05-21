/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer.
Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
*/
//Time = O(target), space = O(target)
class Solution {
    int[] T;
    public int combinationSum4(int[] nums, int target) {
        if(target == 0)
            return 1;
        T = new int[target+1];
        Arrays.fill(T,-1);
        T[0] = 1;
        return helper(nums,target);
    }
    private int helper(int[] nums, int target) {
        if(target == 0)
            return 1;
        if(T[target] != -1)
            return T[target];
        
        int res = 0;        
        for(int ele : nums) 
            if(ele <= target)
                res += helper(nums,target-ele);
        T[target] = res;
        return res;
    }
}
