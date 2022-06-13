/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract 
its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
*/

//Giving MLE
class Solution {
    int[][] T;
    public int minOperations(int[] nums, int x) {
        //OPT(i,j) = 0 if x == 0
        //         = MIN{OPT(i+1,j), OPT(i,j-1)}+1
        
        int n = nums.length;
        T = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(T[i], -1);
        if(n == 1)
            return nums[0] == x? 1 : -1;
        int ops = helper(nums,0,n-1,x);
        return ops == Integer.MAX_VALUE? -1 : ops;
    }
    
    private int helper(int[] nums, int i, int j, int x) {
        if(x == 0)
            return 0;
        if(i > j)
            return Integer.MAX_VALUE;
        if(i == j)
             return nums[i] == x? 1 : Integer.MAX_VALUE;
        
        if(T[i][j] != -1)
            return T[i][j];
        int subLeft = Integer.MAX_VALUE;
        if(nums[i] <= x)
            subLeft = helper(nums,i+1,j,x-nums[i]);
        
        int subRight = Integer.MAX_VALUE;
        if(nums[j] <= x)
            subRight = helper(nums,i,j-1,x-nums[j]);
        
        if(subLeft == Integer.MAX_VALUE && subRight == Integer.MAX_VALUE)
            return T[i][j] = Integer.MAX_VALUE;
        
        return T[i][j] = Math.min(subLeft, subRight)+1;
    }
}

//Optimized
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        //Find max subarray with sum = sum(nums)-x so that ans = n - len
        
        int sum = 0, left = 0, right = 0;
        for(int ele : nums)
            sum += ele;
        
        int target = sum-x,currSum = 0,maxLen = -1;
        
        while(right < n) {
            currSum += nums[right];
            right++;
            
            while(left < right && currSum > target) {
                currSum -= nums[left];
                left++;
            }
            
            if(currSum == target)
                maxLen = Math.max(maxLen, right-left);
        }
        
        return maxLen == -1? -1 : n - maxLen;
    }
}
