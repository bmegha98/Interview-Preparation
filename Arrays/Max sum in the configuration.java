/*
Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. The only operation allowed is to 
rotate(clock-wise or counter clock-wise) the array any number of times.
Example 1:

Input:
N = 4
A[] = {8,3,1,2}
Output: 29
Explanation: Above the configuration
possible by rotating elements are
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
Here the max sum is 29 
*/

class GfG
{
    int max_sum(int A[], int n)
    {
	    // Your code here
	    int prev = 0, SUM = 0;
	    for(int i = 0;i<n;i++) {
	        prev += i*A[i];
	        SUM += A[i];
	    }
	    int maxSum = prev;
	    
	    for(int i=1;i<n;i++) {
	        prev = prev + A[i-1]*(n-1) - (SUM-A[i-1]);
	        maxSum = Math.max(maxSum, prev);
	    }
	    
	    return maxSum;
    }	
}
