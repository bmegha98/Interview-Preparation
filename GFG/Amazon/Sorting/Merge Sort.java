/*
Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
Example 1:

Input:
N = 5
arr[] = {4 1 3 9 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10 9 8 7 6 5 4 3 2 1}
Output:
1 2 3 4 5 6 7 8 9 10
*/

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m-l+1, n2 = r-m;
        int[] A = new int[n1];
        int[] B = new int[n2];
        
        for(int i=l;i<=m;i++)
            A[i-l] = arr[i];
        
        for(int i=m+1;i<=r;i++)
            B[i-m-1] = arr[i];
        
        int i = 0, j = 0, k = l;
        while(i<n1 && j<n2) {
            if(A[i] <= B[j]) 
                arr[k++] = A[i++];
            else
                arr[k++] = B[j++];
        }
        
        while(i<n1)
            arr[k++] = A[i++];
        while(j<n2)
            arr[k++] = B[j++];
    }
    
    void mergeSort(int arr[], int l, int r)
    {
        if(l >= r)
            return;
        int m = l+(r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }
}
