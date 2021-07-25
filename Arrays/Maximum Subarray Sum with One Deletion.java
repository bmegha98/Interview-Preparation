/*
Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to 
choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum
possible.
Note that the subarray needs to be non-empty after deleting one element.
Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
*/

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        boolean hasPos = false;
        int res = Integer.MIN_VALUE;
        for(int ele : arr){
            res = Math.max(res,ele);
            if(ele > 0) 
                hasPos = true;
        }
        if(!hasPos)
            return res;
        
        int[] F = new int[n];
        int[] B = new int[n];
        
        int currSum = 0,maxSum = 0;
        
        for(int i=0;i<n;i++) {
            currSum += arr[i];
            if(currSum < 0)
                currSum = 0;
            else 
                maxSum = Math.max(maxSum, currSum);
            F[i] = currSum;
        }
        
        currSum = 0;
        for(int i=n-1;i>=0;i--) {
            currSum += arr[i];
            if(currSum < 0)
                currSum = 0;
            else 
                maxSum = Math.max(maxSum, currSum);
            B[i] = currSum;
        }
        
        // for(int ele : B)
        // System.out.println(ele);
        for(int i = 1;i<n-1;i++)
            maxSum = Math.max(maxSum, F[i-1]+B[i+1]);
        return maxSum;
    }
}
