/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
*/

//Only 1 set bit and that too should be at even positions only
//1 hex digit = 4 bits
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
            return false;
        int tmp = n&(n-1);
        if(tmp != 0)
            return false;
        return (n&(0xAAAAAAAA)) == 0;
    }
}
