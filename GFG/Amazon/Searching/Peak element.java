/*
A peak element in an array is the one that is not smaller than its neighbours.
Given an array arr[] of size N, find the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0. 
Example 1:

Input:
N = 3
arr[] = {1,2,3}
Output: 1
Explanation: index 2 is 3.It is the peak element as it is greater than its neighbour 2.
*/

class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
        int l = 0, h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m == 0 || arr[m] >= arr[m-1]) && (m==n-1||arr[m] >= arr[m+1]))
                return m;
            if(m > 0 && arr[m] < arr[m-1])
                h = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}
