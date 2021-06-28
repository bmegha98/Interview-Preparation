/*
Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value of K.

Example 1:

Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.
Example 2:

Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 0
Explanation: The given array is not rotated.

count = index of min element
*/

class Solution {
    int findKRotation(int arr[], int n) {
        int l = 0,h=n-1;
        if(arr[l]<arr[h])
            return l;
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m==0||arr[m]<arr[m-1])&&(m==n-1||arr[m]<arr[m+1]))
                return m;
            if(arr[m] < arr[h])
                h = m-1;
            else
                l = m+1;
        }
        return h;
    }
}
