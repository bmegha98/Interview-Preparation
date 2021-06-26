/*
Given an array arr of n elements which is first increasing and then may be decreasing, find the maximum element in the array.
Note: If the array is increasing then just print then last element will be the maximum value.

Example 1:

Input: 
n = 9
arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.
Example 2:

Input: 
n = 5
arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.
*/
//If A[mid] < A[mid-1] we're in decreasing array so move left else move right
class Solution {
    int findMaximum(int[] arr, int n) {
        if(n == 1)
            return arr[0];
        int l = 0,h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m==0||arr[m]>arr[m-1])&&(m==n-1||arr[m]>arr[m+1]))
                return arr[m];
            if(m > 0 && arr[m]<arr[m-1])
                h = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}
