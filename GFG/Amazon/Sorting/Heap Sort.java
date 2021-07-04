/*
Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.
Example 1:

Input:
N = 5
arr[] = {4,1,3,9,7}
Output:
1 3 4 7 9
Explanation:
After sorting elements using heap sort, elements will be in order as 1,3,4,7,9.
Example 2:

Input:
N = 10
arr[] = {10,9,8,7,6,5,4,3,2,1}
Output:
1 2 3 4 5 6 7 8 9 10
Explanation:
After sorting elements using heap sort, elements will be in order as 1, 2,3,4,5,6,7,8,9,10.
*/

class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        //Top to bottom heapification
        for(int i=(n-2)/2;i>=0;i--)
            heapify(arr,n,i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int ele = arr[i];
        while(i < n) {
            int l = 2*i+1;
            if(l >= n)
                break;
            int r = 2*i+2;
            if(r >= n) {
                if(arr[l] < ele) {
                    arr[i] = arr[l];
                    i = l;
                }
                break;
            }
            
            int minInd = arr[l]<=arr[r]?l:r;
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
        if(n < 2)
            return;
        buildHeap(arr,n);
        for(int last = n-1;last > 0;last--) {
            swap(arr,0,last);
            heapify(arr,last,0);
        }
        
        int l = 0, h = n-1;
        while(l<h) {
            swap(arr,l,h);
            l++;
            h--;
        }
    }
    private void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
 }
