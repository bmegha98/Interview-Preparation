/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example,
[3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

OPT(i) = Length of LIS ending at index i 
       =  max{OPT(j)}+1 for all 0<=j<i such that nums[j] < nums[i]
       =  1  if there is no such j
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 1;
        int[] length = new int[n];
        
        int maxLen = 1;
        Arrays.fill(length,1);
        
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<i;j++) {
                if(nums[j] < nums[i] && length[j] + 1 > length[i])
                    length[i] = length[j]+1;  
            }
            if(maxLen < length[i])
                maxLen = length[i];
        }
        return maxLen;
    }
}
