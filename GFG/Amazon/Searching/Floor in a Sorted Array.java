/*
Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than
or equal to x. Find the index of K(0-based indexing).
Example 1:

Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less than 0 is found. So output is "-1".
Example 2:

Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is 2 (i.e K = 2), whose index is 1(0-based indexing).
*/

class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int l =0,h = n-1,ans = -1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(arr[m] == x)
                return m;
            if(arr[m] < x) {
                ans = m;
                l = m+1;
            }
            else
                h = m-1;
        }
        return ans;
    }
    
}
