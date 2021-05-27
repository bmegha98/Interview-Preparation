/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.
A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters'
relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).It is guaranteed the answer fits on a 32-bit signed integer.
Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
*/
/*OPT(i,j) = OPT(i-1,j-1)                     + OPT(i-1,j) if last characters match  ; OPT(i-1,j) otherwise
                |                                   |
                checking for current Occurrence    checking for other occurrences   
*/
class Solution {
    int[][] T;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(n == 0)
            return 1;
        if(m == 0)
            return 0;
        T = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(T[i],-1);
        return countOccurrences(s,t,m,n);
    }
    private int countOccurrences(String s,String t,int m,int n) {
        if(n == 0)
            return 1;
        if(m == 0)
            return 0;
        if(T[m][n] != -1)
            return T[m][n];
        if(s.charAt(m-1) == t.charAt(n-1))
            return T[m][n]=countOccurrences(s,t,m-1,n-1)+countOccurrences(s,t,m-1,n);
        return T[m][n]=countOccurrences(s,t,m-1,n);
    }
}

//Tabulation
    int[][] T;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(n == 0)
            return 1;
        if(m == 0)
            return 0;
        T = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            T[i][0] = 1;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    T[i][j] = T[i-1][j-1]+T[i-1][j];
                else
                    T[i][j] = T[i-1][j];
            }
        return T[m][n];
    }
