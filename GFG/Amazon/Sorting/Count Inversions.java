/*
Given an array of integers. Find the Inversion Count in the array. 
Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 
Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
*/

//T(n) = O(n^2) , Space = O(1)
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long n)
    {
        long count = 0;
        for(int j = 1;j<n;j++) {
            int i=j-1;
            while(i >= 0) {
                if(arr[i] > arr[j])
                    count++;
                i--;
            }
        }
        return count;
    }
}

//Using Divide And Conquer

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long n)
    {
        return mergeSort(arr,0,(int)(n-1));
    }
    static long mergeSort(long arr[], long l, long r)
    {
        if(l >= r)
            return 0;
        long m = l+(r-l)/2;
        long res = 0;
        res += mergeSort(arr,l,m);
        res += mergeSort(arr,m+1,r);
        res += merge(arr,l,m,r);
        return res;
    }
    static long merge(long arr[], long l, long m, long r)
    {
        long[] tmp = new long[(int)(r-l+1)];
        long i=l,j=m+1,k=0;
        long count = 0;
        
        while(i<=m && j<=r) {
            if(arr[(int)i] <= arr[(int)j]) {
                tmp[(int)k] = arr[(int)i];
                i++;
            }
            else {
                count += (m+1-i);
                tmp[(int)k] = arr[(int)j];
                j++;
            }
            k++;
        }
        
        while(i<=m){
            tmp[(int)k] = arr[(int)i];
            i++;
            k++;
        }
        while(j<=r){
            tmp[(int)k] = arr[(int)j];
            j++;
            k++;
        }
        
        for(long p=0;p<tmp.length;p++)
            arr[(int)(p+l)] = tmp[(int)p];
        return count;
    }  
}
