/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/

//Brute-force, T(n) = O(n^3), Space = O(1)

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        int count = 0;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                if(isPalindrome(s,i,j))
                    count++;
        return count;
    }
    private boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

//Optimized, T(n) = Space = O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        int count = n;
        
        boolean[][] T = new boolean[n][n];
        for(int i=0;i<n;i++) {
            T[i][i] = true;
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                T[i][i+1] = true;
                count++;
            }
        }
        
        for(int j=2;j<n;j++)
            for(int i=j-2;i>=0;i--) {
                T[i][j] = (s.charAt(i) == s.charAt(j) && T[i+1][j-1]);
                if(T[i][j])
                    count++;
            }
        return count;
    }
}
