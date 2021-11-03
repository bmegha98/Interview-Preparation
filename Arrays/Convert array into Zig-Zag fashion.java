/*
Given an array Arr (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array should be in form a < b > c < d > e < f.
The relative order of elements is same in the output i.e you have to iterate on the original array only.

Example 1:

Input:
N = 7
Arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 3 7 4 8 2 6 1
Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1
Example 2:

Input:
N = 4
Arr[] = {1, 4, 3, 2}
Output: 1 4 2 3
Explanation: 1 < 4 > 2 < 3
*/

class Solution {
    void zigZag(int arr[], int n) {
        // code here
        if(n == 1)
            return;
        
        int rel = 1;
        for(int i=0;i<n-1;i++) {
            if(rel == 1) {
                if(arr[i] > arr[i+1])
                    swap(arr,i,i+1);
            }
            else {
                if(arr[i] < arr[i+1])
                    swap(arr,i,i+1);
            }
            rel = 1-rel;
        }
    }
    void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
