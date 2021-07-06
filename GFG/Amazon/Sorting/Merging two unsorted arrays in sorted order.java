/*
Given two different arrays A and B of size N and M, the task is to merge the two arrays which are unsorted into another array which is sorted.
Example 1:

Input: N = 3, M = 3
A[] = {10, 5, 15}
B[] = {20, 3, 2}
Output: 2 3 5 10 15 20
Explanation: After merging both the array's and sorting it with get the desired output.  

Example 2:

Input: N = 4, M = 3
A[] = {1, 10, 5, 15}
B[] = {20, 0, 2}
Output: 0 1 2 5 10 15 20
*/

class Solution
{
    void sortedMerge(long A[], long B[], long res[], int N,int M)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int k = 0,i=0,j=0;
        while(i < N && j < M) {
            if(A[i] <= B[j]) 
                res[k++] = A[i++];
            else
                res[k++] = B[j++];
        }
        
        while(i < N)
            res[k++] = A[i++];
        while(j < M)
            res[k++] = B[j++];
    }
}
