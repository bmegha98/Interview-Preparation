/*
Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set in the binary
representation.

Example 1:

Input: N = 2
Output: 1
Explanation: Binary Representation of 2 is 10, which is not having consecutive set bits. So, it is sparse number.
Example 2:

Input: N = 3
Output: 0
Explanation: Binary Representation of 3 is 11, which is having consecutive set bits in it. So, it is not a sparse number.
*/

class Solution
{
    //Function to check if the number is sparse or not.
    public static boolean isSparse(int n)
    {
        // Your code here
        if(n < 3)
            return true;
        
        int count = 0,prev = -1;
        while(n > 0) {
            if((n&1) == 1) {
                count++;
                if(count > 1 && prev == 1)
                    return false;
            }
            else
                count = 0;
            prev = n&1;
            n >>= 1;
        }
        return true;
    }
    
}

// n = 1010, n>>1 = 0101 ==> n&(n>>1) = 0
class Solution
{
    //Function to check if the number is sparse or not.
    public static boolean isSparse(int n)
    {
        // Your code here
        if(n < 3)
            return true;
        
        return (n & (n>>1)) == 0;
    }
    
}
