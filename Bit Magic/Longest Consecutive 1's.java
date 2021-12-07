/*
Given a number N. Find the length of the longest consecutive 1s in its binary representation.

Example 1:

Input: N = 14
Output: 3
Explanation: 
Binary representation of 14 is 1110, in which 111 is the longest consecutive set bits of length is 3.

Example 2:

Input: N = 222
Output: 4
Explanation: 
Binary representation of 222 is 11011110, in which 1111 is the longest consecutive set bits of length 4. 
*/

class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int res = 0;
        if(N <= 1)
            return N;
        int count = 0;
        while(N > 0) {
            if((N&1) == 1)
                count++;
            else {
                res = Math.max(res, count);
                count = 0;
            }
             N >>= 1;
        }
        
        return Math.max(res, count);
    }
}
