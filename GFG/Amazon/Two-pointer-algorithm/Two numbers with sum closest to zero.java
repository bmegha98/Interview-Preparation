/*
Given an integer array of N elements. You need to find the maximum sum of two elements such that sum is closest to zero.
Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to zero is -68 using numbers -60 and -8.
Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to zero is -14 using numbers -18 and 4.
*/

class Sol
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE,ans =Integer.MIN_VALUE;
        
        int l =0,h = n-1;
        while(l < h) {
            int s = arr[l]+arr[h];
            if(s == 0)
                return 0;
            if(diff >= Math.abs(s)) {
                if(diff == Math.abs(s))
                    ans = Math.max(ans,s);
                else {
                    diff = Math.abs(s);
                    ans = s;
                }
            }
            if(s < 0)
                l++;
            else
                h--;
        }
        return ans;
    }
}
