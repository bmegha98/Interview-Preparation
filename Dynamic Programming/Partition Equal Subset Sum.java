/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets
is equal.
Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
*/
//Time = O(n*sum(nums)/2)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return false;
        int s = 0;
        for(int ele : nums)
            s += ele;
        if(s%2 == 1)
            return false;
        return subsetSum(nums,n,s/2);
    }
    private boolean subsetSum(int[] A,int n, int target) {
        boolean[][] T = new boolean[n+1][target+1];
        for(int i = 0;i<=n;i++)
            T[i][0] = true;
        
        for(int i=1;i<=n;i++) {
            for(int j = 1;j<=target;j++) {
                if(A[i-1] > j)
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = T[i-1][j]||T[i-1][j-A[i-1]];
            }
        }
        return T[n][target];
    }
}
