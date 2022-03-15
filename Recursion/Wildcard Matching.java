/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/

class Solution {
    private int[][] T;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        T = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(T[i],-1);
        return helper(s,p,m,n) == 1? true : false;
    }
    
    private int helper(String s, String p, int m, int n) {
        if(m == 0 && n == 0)
            return 1;
        if(n == 0)
            return 0;
        if(T[m][n] != -1)
            return T[m][n];
        if(m == 0) {
            if(p.charAt(n-1) == '*')
                return T[m][n] = helper(s,p,m,n-1);
            return 0;
        }
        if(p.charAt(n-1) == '?')
            return T[m][n] = helper(s,p,m-1,n-1);
        if(p.charAt(n-1) == '*') {
            boolean tmp = (helper(s,p,m,n-1) == 1 || helper(s,p,m-1,n) == 1);
            return T[m][n] = tmp?1 : 0;
        }
        
        boolean res = (s.charAt(m-1) == p.charAt(n-1) && helper(s,p,m-1,n-1) == 1);
        return T[m][n] = res? 1 : 0;
    }
}
