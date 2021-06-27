/*
Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).
Example 1:

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
*/

class Solution
{
    long floorSqrt(long x)
	{
	    
		if(x < 4)
		    return 1;
		long l = 1,h = x/2;
		long ans = 1;
		while(l <= h) {
		    long m = l+(h-l)/2;
		    long tmp = m*m;
		    if(tmp == x)
		        return m;
		    if(tmp < x) {
		        ans = m;
		        l = m+1;
		    }
		    else
		        h = m-1;
		}
		return ans;
	}
}
