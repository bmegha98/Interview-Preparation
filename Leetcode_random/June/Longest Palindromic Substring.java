/*
Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

//Using Tabulation,Time = Space = O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] T = new boolean[n][n];
        int maxLen = 1, start = 0;
        for(int i=0;i<n;i++) {
            T[i][i] = true;
            if(i<n-1) {
                T[i][i+1] = s.charAt(i) == s.charAt(i+1);
                if(T[i][i+1]) {
                    maxLen = 2;
                    start = i;
                }
            }
        }
        
        for(int j=2;j<n;j++)
            for(int i=j-2;i>=0;i--) {
                if(s.charAt(i) == s.charAt(j) && T[i+1][j-1]) {
                    T[i][j] = true;
                    if(maxLen < j-i+1) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        
        return s.substring(start,start+maxLen);
    }
}

//Using Window Expansion
//Consider each character as a centre of odd and even-length palindromes
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1, start = 0;
        for(int i=0;i<n;i++) {
            //odd-length palindrome
            int low = i-1, high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(maxLen < high-low+1) {
                    maxLen = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
            
            //even-length palindrome
            low = i;
            high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(maxLen < high-low+1) {
                    maxLen = high-low+1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        
        return s.substring(start,start+maxLen);
    }
}
