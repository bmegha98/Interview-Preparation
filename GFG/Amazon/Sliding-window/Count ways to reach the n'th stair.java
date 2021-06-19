/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, 
the person can reach the top (order does matter).
Example 1:

Input:
n = 4
Output: 5
Explanation:
You can reach 4th stair in 5 ways. 
Way 1: Climb 2 stairs at a time. 
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair
and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs
then 1 stair.
Way 5: Climb 1 stair, then 1 stair and
then 2 stairs.

OPT(n) = no. of ways to reach nth stair = OPT(n-1) + OPT(n-2) 
OPT(0) = OPT(1) = 1
*/

class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int mod = 1000000007;
        int secondLast = 1, last = 2;
        for(int i=3;i<=n;i++) {
            int curr = (secondLast+last)%mod;
            secondLast = last;
            last = curr;
        }
        return last%mod;
    }
}
