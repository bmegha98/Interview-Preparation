/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6 

Possible with [2, 3]

I/P: [-1, 6, 2, 0, 7, 9]
O/P: 63

curr_max = Max{prev_max*curr, prev_min*curr, curr}
curr_min = Min{prev_max*curr, prev_min*curr, curr}
ans = Math.max(ans,curr_max}
prev_max = curr_max
prev_min = curr_min
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int n = A.length;
        if(n == 1)
            return A[0];
        int prev_max = A[0], prev_min = A[0], ans = A[0];
        int curr_max = prev_max, curr_min = prev_min;
        for(int i=1;i<n;i++) {
            curr_max = Math.max(Math.max(prev_max*A[i], prev_min*A[i]), A[i]);
            curr_min = Math.min(Math.min(prev_max*A[i], prev_min*A[i]), A[i]);
            ans = Math.max(ans, curr_max);
            prev_max = curr_max;
            prev_min = curr_min;
        }
        return ans;
    }
}
