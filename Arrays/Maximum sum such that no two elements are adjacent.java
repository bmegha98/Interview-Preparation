/*
Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Examples : 

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {2,1,1,3}
Output: 2+3 = 5
*/

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        if(n == 1) return arr[0];
        if(n == 2) return Math.max(arr[0], arr[1]);
        
        int secondLast = arr[0], last = Math.max(arr[0],arr[1]);
        for(int i = 2;i<n;i++) {
            int tmp = Math.max(last, arr[i]+secondLast);
            secondLast = last;
            last = tmp;
        }
        return last;
    }
}
