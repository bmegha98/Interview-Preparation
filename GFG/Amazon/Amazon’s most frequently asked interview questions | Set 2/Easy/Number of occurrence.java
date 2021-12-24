/*
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
*/

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        if(n == 1)
            return arr[0] == x? 1 : 0;
        int ind1 = firstOccurrence(arr, n, x);
        if(ind1 == -1)
            return 0;
        int ind2 = lastOccurrence(arr,n,x);
        
        return ind2-ind1+1;
    }
    
    int firstOccurrence(int[] A, int n, int ele) {
        int l = 0, h = n-1, ans = -1;
        while(l<=h) {
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
    
    int lastOccurrence(int[] A, int n, int ele) {
        int l = 0, h = n-1, ans = -1;
        while(l<=h) {
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
}
