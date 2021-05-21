/*
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num:nums){
          sum+=num;
        }
        int diff = S;
		
		if(diff>sum||(diff+sum)%2!=0){
          return 0;
        }
        int s1Sum = (diff+sum)/2;
        int[][] memo = new int[nums.length+1][s1Sum+1];
        for(int[] mm:memo){
          Arrays.fill(mm,-1);
        }
        return countSubsetSum(nums, s1Sum, nums.length,memo);
    }
  
    public int countSubsetSum(int[] nums, int sum, int n, int[][] memo){
      if(sum==0&&n==0){
        return 1;  
      }
      if(n==0){
        return 0;
      }
      if(memo[n][sum]!=-1){
        return memo[n][sum];
      }
      if(nums[n-1]<=sum){
        memo[n][sum] = countSubsetSum(nums,sum-nums[n-1],n-1,memo) 
            + countSubsetSum(nums,sum,n-1,memo);
      } else {
        memo[n][sum] = countSubsetSum(nums,sum,n-1,memo);
      }
      return memo[n][sum];
    }
}
