/*
Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.


Example 1:

Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
Example 2:

Input:
N = 4
Arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 of element (-1)
*/

class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        // Your code here
        boolean hasPositive = false;
        int maxEle = Integer.MIN_VALUE;
        
        for(int ele : arr) {
            if(ele >= 0) {
                hasPositive = true;
                break;
            }
            maxEle = Math.max(maxEle,ele);
        }
        
        if(!hasPositive)
            return maxEle;
        int currSum = 0, maxSum = 0;
        for(int ele : arr) {
            currSum += ele;
            if(currSum < 0)
                currSum = 0;
            else
                maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    
}
