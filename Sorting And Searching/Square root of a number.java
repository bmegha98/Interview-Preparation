/*
Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).
Example 1:

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.
Example 2:

Input:
x = 4
Output: 2
Explanation: Since, 4 is a perfect 
square, so its square root is 2.
 

Your Task:
You don't need to read input or print anything. The task is to complete the function floorSqrt() which takes x as the input parameter and return its 
square root.
Note: Try Solving the question without using sqrt Function.
*/

class Solution
{
    long floorSqrt(long x) {
		// Your code here
		if(x < 4)
		    return 1;
		
		long low = 1, high = x/2;
		long res = -1;
		while(low <= high) {
		    long mid = low+(high-low)/2;
		    long actual = mid*mid;
		    if(actual == x)
		        return mid;
		    if(actual > x)
		        high = mid -1;
		    else {
		        res = mid;
		        low = mid+1;
		    }
		}
		return res;
	}
}
