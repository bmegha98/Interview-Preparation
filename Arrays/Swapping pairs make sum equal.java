/*
Given two arrays of integers A[] and B[] of size N and M, the task is to check if a pair of values (one value from each array) exists such that swapping the 
elements of the pair will make the sum of two arrays equal.

Example 1:

Input: N = 6, M = 4
A[] = {4, 1, 2, 1, 1, 2}
B[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in A[] = 11
Sum of elements in B[] = 15, To get same 
sum from both arrays, we can swap following 
values: 1 from A[] and 3 from B[]
Example 2:

Input: N = 4, M = 4
A[] = {5, 7, 4, 6}
B[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array 
A[] and 2 from array B[]
*/

//Brute-force ,T(n) = O(mn)
class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        long sumA = getSum(A), sumB = getSum(B);
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                long newSumA = sumA-A[i]+B[j];
                long newSumB = sumB-B[j]+A[i];
                
                if(newSumA == newSumB)
                    return 1;
            }
        return -1;
    }
    long getSum(long[] arr) {
        long sum = 0;
        for(long ele : arr)
            sum += ele;
        return sum;
    }
}


/*
  We're looking for a tuple (a,b) such that sumA-a+b = sumB-b+a ==> a-b = (sumA-sumB)/2
*/

class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        Arrays.sort(A);
        Arrays.sort(B);
        long diff = getSum(A) - getSum(B);
        if(diff%2 == 1)
            return -1;
        long target = diff/2;
            
        int i=0,j=0;
        while(i<n && j<m) {
            long tmp = A[i]-B[j];
            if(tmp == target)
                return 1;
            if(tmp<target)
                i++;
            else
                j++;
        }
        return -1;
    }
    long getSum(long[] arr) {
        long sum = 0;
        for(long ele : arr)
            sum += ele;
        return sum;
    }
}
