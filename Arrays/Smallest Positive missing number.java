/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing number is 2.
*/

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Your code here
        if(n == 1)
            return arr[0] != 1 ? 1 : 2;
            
        for(int i=0;i<n;i++)
            if(arr[i] <= 0)
                arr[i] = n+1;
                
        for(int i=0;i<n;i++) 
            if(Math.abs(arr[i]) < n && arr[Math.abs(arr[i])-1] > 0)
                arr[Math.abs(arr[i])-1] *= -1;
            
        
        
        for(int i=0;i<n;i++) {
            if(arr[i] > 0)
                return i+1;
        }
        
        return n+1;
    }
}
