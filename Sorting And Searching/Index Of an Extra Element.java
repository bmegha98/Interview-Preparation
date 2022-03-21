/*
Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the 
index of the extra element.

Example 1:

Input:
N = 7
A[] = {2,4,6,8,9,10,12}
B[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the second array, 9 is
missing and it's index in the first array
is 4.
Example 2:

Input:
N = 6
A[] = {3,5,7,9,11,13}
B[] = {3,5,7,11,13}
Output: 3
Your Task:
You don't have to take any input. Just complete the provided function findExtra() that takes array A[], B[] and size of A[] and return the valid index 
(0 based indexing).
*/

class Solution {
    public int findExtra(int a[], int b[], int n) {
        // add code here.
        
        int l = 0, h = n-2;
        while(l<=h) {
            int m = l+(h-l)/2;
            if(a[m] == b[m])
                l = m+1;
            else {
                if(m > 0 && a[m] == b[m-1])
                    h = m-1;
                else if(m < b.length-1 && a[m] == b[m+1])
                    l = m+1;
                else
                    return m;
            }
        }
        return l;
    }
}
