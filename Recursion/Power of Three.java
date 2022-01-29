/*
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
 

Constraints:

-231 <= n <= 231 - 1
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        double power = Math.log10(n)/Math.log10(3);
        return Math.floor(power) == Math.ceil(power);
    }
}

//Max value of k such that 3^k <= Integer.MAX_VALUE is 19 and 3^19 is only divisible by 3^k for all k = 0 to 19
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        return Math.pow(3,19)%n == 0;
    }
}
