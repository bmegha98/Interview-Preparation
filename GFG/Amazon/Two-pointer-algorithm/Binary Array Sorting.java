/*
Given a binary array A[] of size N. The task is to arrange the array in increasing order.Note: The binary array contains only 0  and 1.
Example 1:
Input:
N = 5
A[] = {1,0,1,1,0}
Output: 0 0 1 1 1
*/

class Solution 
{ 
	static int[] SortBinaryArray(int arr[], int n) 
	{ 
	    if(n == 1)
	        return arr;
	    int k = 0;
	    for(int i=0;i<n;i++)
	        if(arr[i] == 0) {
	            arr[k] = 0;
	            k++;
	        }
	   while(k < n)
	    arr[k++] = 1;
	   return arr;
	} 
} 

class Solution 
{ 
	static int[] SortBinaryArray(int arr[], int n) 
	{ 
	    if(n == 1)
	        return arr;
	    int l = 0, h = n-1;
	    while(l < h) {
	        while(l<h && arr[l] == 0)
	            l++;
	        while(h > l && arr[h] == 1)
	            h--;
	        if(l < h) 
	            swap(arr,l,h);
	    }
	    return arr;
	} 
	private static void swap(int[] A,int i,int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;
	}
} 
