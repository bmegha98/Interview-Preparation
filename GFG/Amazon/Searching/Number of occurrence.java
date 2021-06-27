/*
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
*/

class Solution {
    int firstOccurrence(int[] A,int l,int h,int ele) {
        int ans = -1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A[m] == ele) {
                ans = m;
                h = m-1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                h = m-1;
        }
        return ans;
    }
    
    int lastOccurrence(int[] A,int l,int h,int ele) {
        int ans = -1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A[m] == ele) {
                ans = m;
                l = m+1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                h = m-1;
        }
        return ans;
    }
    int count(int[] arr, int n, int x) {
        int first = firstOccurrence(arr,0,n-1,x);
        if(first == -1)
            return 0;
        return lastOccurrence(arr,0,n-1,x)-first+1;
    }
}
