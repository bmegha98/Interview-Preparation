/*
Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.
*/
//For each element x,determine the number of elements y that causes max length till x

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 1;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLen = 1;
        Arrays.fill(length,1);
        Arrays.fill(count,1);
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<i;j++) {
                if(nums[j] >= nums[i])
                    continue;
                if(length[j] + 1 > length[i])
                {
                    length[i] = length[j]+1;
                    count[i] = count[j];
                }
                else if(length[j]+1 == length[i])
                    count[i] += count[j];
                
            }
            if(maxLen < length[i])
                maxLen = length[i];
        }
        
        int res = 0;
        for(int i=0;i<n;i++)
            if(length[i]==maxLen)
                res += count[i];
        return res;
    }
}
