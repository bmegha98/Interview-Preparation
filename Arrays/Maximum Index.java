/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.
Example 1:

Input:
N = 2
A[] = {1, 10}
Output:
1
Explanation:
A[0]<A[1] so (j-i) is 1-0 = 1.
Example 2:

Input:
N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7] satisfying the required condition(A[i] < A[j]) thus giving the maximum difference of j - i which is 6(7-1).
*/

class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N) { 
        
        // Your code here
        int res = 0;
        int[] leftMin = new int[N];
        int[] rightMax = new int[N];
        
        leftMin[0] = A[0];
        for(int i=1;i<N;i++)
            leftMin[i] = Math.min(leftMin[i-1], A[i]);
        
        rightMax[N-1] = A[N-1];
        for(int i=N-2;i>=0;i--)
            rightMax[i] = Math.max(rightMax[i+1], A[i]);
        
        int i=0,j=0;
        while(i<N && j<N) {
            if(leftMin[i] <= rightMax[j]) {
                res = Math.max(res, j-i);
                j++;
            }
            else
                i++;
        }
        return res;
    }
}
