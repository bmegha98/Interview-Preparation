/*
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4
Example 2:

Input:
N = 10
A[] = {1,2,3,4,5,6,7,8,10}
Output: 9
*/

//Using XOR
class Solution {
    int MissingNumber(int array[], int n) {
        int res = 0;
        for(int ele : array)
            res ^= ele;
        for(int i=1;i<=n;i++)
            res ^= i;
        return res;
    }
}

//Using sum of natural numbers = n*(n+1) / 2
class Solution {
    int MissingNumber(int array[], int n) {
        int S = (n*(n+1))>>1;
        
        for(int ele : array)
            S -= ele;
        return S;
    }
}
