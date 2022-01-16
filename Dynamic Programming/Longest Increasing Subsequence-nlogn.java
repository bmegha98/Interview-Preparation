/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example,
[3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

class Solution {
    public int lengthOfLIS(int[] A) {
        int n = A.length,k=-1;
        int[] tmp = new int[n];
        for(int ele : A) {
            if(k == -1 || tmp[k] < ele)
                tmp[++k] = ele; 
            else {
                int ind = getElementGTE(tmp,k+1,ele);
                tmp[ind] = ele;
            }
        }
        return k+1;
    }
    int getElementGTE(int[] arr, int n, int ele) {
        int ans = -1, l = 0, h = n-1;
        while(l<=h) {
            int m = l+(h-l)/2;
            if(arr[m] >= ele) {
                ans = m;
                h = m-1;
            }
            else
                l = m+1;
        }
        return ans == -1?n:ans;
    }
}
