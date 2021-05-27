/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.
(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the
string S.)
Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

|SCS| = |S|+|T|-|LCS(S,T)|
*/

class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int m = s.length(), n = t.length();
        
        int[][] T = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    T[i][j] = 1+T[i-1][j-1];
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        }
        
        String res = "";
        int i = m,j = n;
        while(i > 0 && j > 0) {
            if(s.charAt(i-1) == t.charAt(j-1)){
                res = s.charAt(i-1)+res;
                i--;
                j--;
            }
            else if(T[i-1][j] > T[i][j-1]) {
                res = s.charAt(i-1)+res;
                i--;
            }
            else {
                res = t.charAt(j-1)+res;
                j--;
            }
        }
        while(i > 0) {
            res = s.charAt(i-1)+res;
            i--;
        }
        while(j > 0) {
            res = t.charAt(j-1)+res;
            j--;
        }
        return res;
    }
}
