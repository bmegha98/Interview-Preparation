/*
Quick Sort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
Given an array arr[], its starting position low and its ending position high.
Implement the partition() and quickSort() functions to sort the array.
Example 1:

Input: 
N = 5 
arr[] = { 4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Example 2:

Input: 
N = 9
arr[] = { 2, 1, 6, 10, 4, 1, 3, 9, 7}
Output:
1 1 2 3 4 6 7 9 10
*/

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low > high)
            return;
        int pivot = partition(arr,low,high);
        //System.out.println(pivot);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }
    static int partition(int arr[], int low, int high)
    {
        if(low == high)
            return low;
        int pivot = arr[low],ind = low;
        while(low < high) {
            while(low<=high && arr[low] <= pivot)
                low++;
            while(high>=ind && arr[high] > pivot)
                high--;
            if(low < high)
                swap(arr,low,high);
        }
        swap(arr,ind,high);
        return high;
    } 
    static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
