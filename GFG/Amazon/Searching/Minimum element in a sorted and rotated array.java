/*
A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.
Example

Input
N = 5
arr[] = {4 ,5 ,1 ,2 ,3}
Output
1
Explanation: 1 is the minimum element in the array.
Example

Input
N = 6
arr[] = {10, 20, 30, 40, 50, 5, 7}
Output
5
Explanation: Here 5 is the minimum element.
*/
//Handles duplicates as well
class Solution
{
    int findMin(int arr[], int n)
    {
        if(n == 1)
            return arr[0];
        int l = 0, h = n-1;
        if(arr[l] < arr[h])
            return arr[l];
        
        while(l < h) {
            int m = l+(h-l)/2;
            if(arr[m] == arr[h])
                h--;
            else if(arr[m] < arr[h])
                h = m;
            else
                l = m+1;
        }
        return arr[l];
    }
}
