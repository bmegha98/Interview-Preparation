/*
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 
Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that appears exactly once.
A pair starts at even index and ends at odd index. So if a pair starts at odd index then there exists a single element on its left otherwise search right.
*/

class Solution 
{
    int findOnce(int arr[], int n)
    {
        int l =0,h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m==0||arr[m]!=arr[m-1])&&(m==n-1||arr[m]!=arr[m+1]))
                return arr[m];
            if(m > 0 && arr[m] == arr[m-1]) {
                if(m%2 == 1)
                    l = m+1;
                else
                    h = m-1;
            }
            else {
                if(m%2 == 0)
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return -1;
    }
}
