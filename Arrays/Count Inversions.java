/*
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is
0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
*/

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        if(N == 1)
            return 0;
        return mergeSort(arr,0,(int)(N-1));
    }
    static long mergeSort(long[] A, int l, int h) {
        if(l >= h)
            return 0;
        int m = l+(h-l)/2;
        long tmp1 = mergeSort(A, l, m);
        long tmp2 = mergeSort(A,m+1, h);
        return tmp1 + tmp2 + merge(A,l,m,h);
    }
    
    static long merge(long[] A, int l, int m, int h) {
        int n1 = m-l+1, n2 = h-m;
        long res = 0;
        long[] left = new long[n1];
        long[] right = new long[n2];
        
        for(int i = 0;i<n1;i++)
            left[i] = A[l+i];
        for(int j=0;j<n2;j++)
            right[j] = A[m+1+j];
        
        int i = 0, j = 0, k = l;
        while(i<n1 && j < n2) {
            if(left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            }
            else {
                //inversion
                res += (n1-i);
                A[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i<n1)
            A[k++] = left[i++];
        while(j<n2)
            A[k++] = right[j++];
        return res;
    }
}
