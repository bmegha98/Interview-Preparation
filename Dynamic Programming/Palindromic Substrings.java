/*
Given a string s, return the number of palindromic substrings in it.A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

//Using DP : count number of true values in dp table

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        
        char[] A = s.toCharArray();
        int count = n;
        for(int i = 1;i<n;i++) {
            int low = i-1,high = i;
            while(low >= 0 && high < n && A[low] == A[high]) {
                count++;
                low--;
                high++;
            }
            low = i-1;
            high = i+1;
            while(low >= 0 && high < n && A[low] == A[high]) {
                count++;
                low--;
                high++;
            }
        }
        return count;
    }
}
