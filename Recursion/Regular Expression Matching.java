/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
*/

class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,s.length(),p.length());
    }
    
    private boolean helper(String s, String p, int m, int n) {
        if(m == 0 && n == 0)
            return true;
        if(n == 0)
            return false;
        if(m == 0) {
            if(p.charAt(n-1) == '*')
                return helper(s,p,m,n-2);
            return false;
        }
        if(p.charAt(n-1) == '.')
            return helper(s,p,m-1,n-1);
        if(p.charAt(n-1) == '*') {
            if(s.charAt(m-1) == p.charAt(n-2) || p.charAt(n-2) == '.')
                return helper(s,p,m-1,n) || helper(s,p,m,n-2);
            return helper(s,p,m,n-2); // skip matching
        }
        return s.charAt(m-1) == p.charAt(n-1) && helper(s,p,m-1,n-1);
    }
}
