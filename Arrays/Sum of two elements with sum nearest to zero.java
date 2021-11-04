/*
Given an array of n integers

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
Explanation: Sum of two elements closest to zero is -14 using numbers -18 and 4.
*/

class Sol
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        int l = 0, h = n-1;
        long res = Integer.MAX_VALUE;
        while(l<h) {
            long s = arr[l]+arr[h];
            if(s == 0)
                return 0;
            if(Math.abs(s) <= Math.abs(res)) {
                if(Math.abs(s) < Math.abs(res))
                    res = s;
                else if(res < s)
                    res = s;
            }
            if(s < 0)
                l++;
            else
                h--;
        }
        return (int)res;
    }
}
