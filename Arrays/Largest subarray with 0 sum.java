/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the 
largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
*/

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer,Integer> aux = new HashMap<>();
        int prefixSum = 0;
        aux.put(0,-1);
        int res = 0;
        for(int i=0;i<n;i++) {
            prefixSum += arr[i];
            if(aux.containsKey(prefixSum))
                res = Math.max(res, i-aux.get(prefixSum));
            else
                aux.put(prefixSum,i);
        }
        return res;
    }
}
