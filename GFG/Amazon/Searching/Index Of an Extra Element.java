/*
Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the index of
the extra element.

Example 1:

Input:
N = 7
A[] = {2,4,6,8,9,10,12}
B[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the second array, 9 is missing and it's index in the first array is 4.
Example 2:

Input:
N = 6
A[] = {3,5,7,9,11,13}
B[] = {3,5,7,11,13}
Output: 3

if A[m] == B[m] : l = m+1
else :
        ans = m;
        h = m-1;
*/

class Solution {
    public int findExtra(int a[], int b[], int n) {
        int l =0,h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(m < h && a[m] == b[m])
                l = m+1;
            else {
                if((m == 0 || a[m-1] == b[m-1]) && (m == h || a[m+1] == b[m]))
                    return m;
            
                h = m-1;
            }
        }
        return -1;
    }
}
