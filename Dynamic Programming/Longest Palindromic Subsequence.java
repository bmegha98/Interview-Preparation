/*
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
*/

//Using LCS
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        String rev = "";
        for(char ch : s.toCharArray())
            rev = ch+rev;
        int[][] T = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == rev.charAt(j-1))
                    T[i][j] = 1+T[i-1][j-1];
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        return T[n][n];
    }
}

//OPT(i,j) = {2+OPT(i+1,j-1) if X[i] == X[j] , max{OPT(i+1,j),OPT(i,j-1)} otherwise}

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1)
            return 1;
        char[] A = s.toCharArray();
        int[][] T = new int[n][n];
        for(int i=0;i<n;i++) {
            T[i][i] = 1;
            if(i < n-1)
                T[i][i+1] = A[i]==A[i+1]?2:1;
        }
        
        for(int j = 2;j<n;j++) {
            for(int i = j-1;i>=0;i--){
                if(T[i][j] != 0)
                    continue;
                if(A[i] == A[j])
                    T[i][j] = 2+T[i+1][j-1];
                else
                    T[i][j] = Math.max(T[i+1][j],T[i][j-1]);
            }
        }
        return T[0][n-1];
    }
}
