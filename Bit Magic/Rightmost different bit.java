/*
Given two numbers M and N. The task is to find the position of the rightmost different bit in the binary representation of numbers.

Example 1: 

Input: M = 11, N = 9
Output: 2
Explanation: Binary representation of the given numbers are: 1011 and 1001, 2nd bit from right is different.
Example 2:

Input: M = 52, N = 4
Output: 5
Explanation: Binary representation of the given numbers are: 110100 and 0100, 5th-bit from right is different.
*/

//n&-n gives rightmost set bit -> position will be determined by log2(n&-n)
class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        // Your code here        
        int tmp = m^n;
        if(m == n)
            return -1;
        return (int)(Math.log(tmp & -tmp)/Math.log(2.0)) + 1;
        
        // int pos = 1;
        // if(m == 0)
        //     return (int)(Math.log(n)/Math.log(2.0)) + 1;
        // if(n == 0)
        //     return (int)(Math.log(m)/Math.log(2.0)) + 1;
        // while(m > 0 && n > 0) {
        //     int tmp1 = m&1, tmp2 = n&1;
        //     if(tmp1 != tmp2)
        //         return pos;
        //     m >>= 1;
        //     n >>= 1;
        //     pos++;
        // }
        
        // if(m == 0 && n == 0)
        //     return -1;
        // return pos;
    }
}
