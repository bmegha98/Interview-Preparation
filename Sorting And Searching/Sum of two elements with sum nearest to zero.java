/*
Given an integer array of N elements. You need to find the maximum sum of two elements such that sum is closest to zero.

Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.
â€‹Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to
zero is -14 using numbers -18 and 4.

Your Task:
You don't need to read input or print anything. You just need to complete the function closestToZero() which takes an array arr[] and its size n as inputs
and returns the maximum sum closest to zero that can be formed by summing any two elements in the array.
*/

class Sol
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        
        int res = Integer.MIN_VALUE, diff = Integer.MAX_VALUE;
        
        int l = 0, h = n-1;
        while(l < h) {
            int sum = arr[l] + arr[h];
            if(sum == 0)
                return sum;
            if(diff >= Math.abs(sum)) {
                if(diff > Math.abs(sum)) 
                    res = sum;
                else
                    res = Math.max(res, sum);
                diff = Math.abs(sum);
            }
            
            if(sum < 0)
                l++;
            else
                h--;
        }
        return res;
    }
}
