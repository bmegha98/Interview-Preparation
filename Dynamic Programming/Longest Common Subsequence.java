/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the 
remaining characters.For example, "ace" is a subsequence of "abcde".A common subsequence of two strings is a subsequence that is common to both strings.
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
*/

//Recursion + Memoization

class Solution {
    int[][] T;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        T = new int[m+1][n+1];
        for(int i = 1;i<=m;i++)
            Arrays.fill(T[i],-1);
        return LCS(text1,text2,m,n);
    }
    private int LCS(String X, String Y, int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(T[m][n] != -1)
            return T[m][n];
        if(X.charAt(m-1) == Y.charAt(n-1))
            return T[m][n] = 1 + LCS(X, Y, m-1, n-1);
        return T[m][n] = Math.max(LCS(X,Y,m,n-1),LCS(X,Y,m-1,n));
    }
}

//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int[][] T = new int[m+1][n+1];
        for(int i =1;i<=m;i++) 
            for(int j =1;j<=n;j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    T[i][j] = T[i-1][j-1]+1;
                else
                    T[i][j] = Math.max(T[i][j-1],T[i-1][j]);
            }
        return T[m][n];
    }
}
