/*
Problem Description
Given an integer A find the Ath number whose binary representation is a palindrome.
NOTE:
Consider the 1st number whose binary representation is palindrome as 1, instead of 0.Do not consider the leading zeros, while considering the binary 
representation.
Problem Constraints
1 <= A <= 2104


Example Input
Input 1:

 A = 1
Input 1:

 A = 9


Example Output
Output 1:

 1
Output 2:

 27

Example Explanation*
Explanation 1:

 1st Number whose binary representation is palindrome is 1
Explanation 2

 9th Number whose binary representation is palindrome is 27 (11011)
 
 Identify length-group to which nth palindrome belongs and then identify its offset in that group.
 number of elements in a group of length n = Pow(2, (n-1)/2)
 
 Offset in that group = number of elements till length n - Offset of last element of group-length of n-1 - 1
 for e.g. number of palindromic binary strings of length 5 is 4 and number of elements till length 5 is 10
 So, offset of last palindromic binary string of length 4 is 10-4.
 Hence, offset of Ath palindromic string will be A-lastOffset-1.
 
 first character will be 1 so need to fill only len/2 characters with offset value.
 ans = (1 << (len-1))
 ans |= (offset << (len/2))
 
 right shift offset value so that it can be reversed
 
 valForRev = ans>>(len/2)
 rev = getReverse(valForRev)
 
 ans |= rev
*/

public class Solution {
    public int solve(int A) {
        int len = 1, count = 1;
        while(count < A) {
            len++;
            int numOfElementsOfThisLength = (1 << ((len-1)/2));
            count += numOfElementsOfThisLength;
        }
        
        int offsetOfLastElement = count - (1 << ((len-1)/2));       
        int offset = A-offsetOfLastElement-1;       //0-based
        
        int ans = (1 << (len-1));
        ans |= (offset << (len/2));
        
        int valForRev = (ans >> (len/2));
        int rev = getReverse(valForRev);
        return ans|rev;
    }
    private int getReverse(int n) {
        int rev = 0;
        while(n > 0) {
            int lb = (1&n);
            rev |= lb;
            rev <<= 1;
            n >>= 1;
        }
        
        rev >>= 1;
        return rev;
    }
}
