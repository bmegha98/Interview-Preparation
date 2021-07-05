/*
Given an array Arr of size N with all elements greater than or equal to zero. Return the maximum product of two numbers possible.
Example 1:

Input: 
N = 6
Arr[] = {1, 4, 3, 6, 7, 0}  
Output: 42
Example 2:

Input: 
N = 5
Arr = {1, 100, 42, 4, 23}
Output: 4200
*/

class Solution {
    int maxProduct(int arr[], int n) {
        int max = arr[0],secondMax = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            if(arr[i] >= max) {         //may have duplicates
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] != max)
                secondMax = arr[i];
        }
        return max*secondMax;
    }
}
