/*
Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.
*/

class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // T(n) = O(n)
        for(int i = (n-2)/2;i>=0;i--)
            heapify(arr,n,i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // T(n) = O(logn)
        int ele = arr[i];
        while(i < n) {
            int l = 2*i+1;
            int r = 2*i+2;
            if(l >= n)
                break;
            if(r >= n) {
                if(arr[l] < ele) {
                    arr[i] = arr[l];
                    i = l;
                }
                break;
            }
            int minInd = arr[l] < arr[r]?l:r;
            if(ele <= arr[minInd])
                break;
            arr[i] = arr[minInd];
            i = minInd;
        }
        arr[i] = ele;
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        if(n < 2)
            return;
        buildHeap(arr,n);
        
        for(int i =n-1;i>0;i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr,i,0);
        }
        
        int start = 0, end = n-1;
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
 }
