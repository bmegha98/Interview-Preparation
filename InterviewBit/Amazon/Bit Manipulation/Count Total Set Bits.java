/*
Problem Description
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
Return the count modulo 109 + 7.
Problem Constraints
1 <= A <= 109
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.

Example Input
Input 1:

 A = 3
Input 2:

 A = 1
Example Output
Output 1:

 4
Output 2:

 1
Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1
*/

//T(n) = O(n), Space = O(n)
public class Solution {
    public int solve(int A) {
        if(A <= 1)
            return A;
        int mod = 1000000007;
        int count = 1;
        int[] T = new int[A+1];
        T[1] = 1;
        
        for(int i=2;i<=A;i++) {
            if(i%2 == 0)
                T[i] = T[i/2];
            else
                T[i] = T[i/2]+1;
            T[i] %= mod;
            count += T[i];
        }
        return count;
    }
}

//T(n) = O(logn)
public class Solution {
    int mod = 1000000007;
    public int solve(int A) {
        if(A == 0)
            return 0;
        int x = largestPowerOf2(A);
        int setBitsBeforePowerOf2 = ((1 <<(x-1))*x)%mod;
        int setBitsOfMSB = (A-(1 << x)+1)%mod;
        int rest = (A-(1 << x))%mod;
        int ans = (setBitsBeforePowerOf2 + setBitsOfMSB + solve(rest))%mod;
        return ans;
    }
    private int largestPowerOf2(int n) {
        int x = 0;
        while((1<<x) <= n)
            x++;
        return x-1;
    }
}
