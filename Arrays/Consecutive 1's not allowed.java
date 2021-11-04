/*
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s. Output your answer modulo 10^9 + 7.

Example 1:

Input:
N = 3
Output: 5
Explanation: 5 strings are (000,
001, 010, 100, 101).
Example 2:

Input:
N = 2
Output: 3
Explanation: 3 strings are
(00,01,10).
*/

class Solution {
    long MOD = 1000000007;
    long countStrings(int n) {
        // code here
        if(n == 0)
            return 1;
        if(n == 1)
            return 2;
        
        long a = 1, b = 2;
        for(int i=2;i<=n;i++) {
            long tmp = (a+b)%MOD;
            a = b;
            b = tmp;
        }
        return b;
    }
}
