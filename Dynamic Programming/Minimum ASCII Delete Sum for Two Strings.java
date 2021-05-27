/*
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
*/

//Memoization
class Solution {
    int[] asciiS,asciiT; 
    int[][] T;
    public int minimumDeleteSum(String s, String t) {
        int m = s.length(),n = t.length();
        asciiS = new int[m+1];
        asciiT = new int[n+1];
        T = new int[m+1][n+1];
        
        for(int i = 1;i<=m;i++)
            asciiS[i] = asciiS[i-1]+s.charAt(i-1);
        for(int j = 1;j<=n;j++)
            asciiT[j] = asciiT[j-1]+t.charAt(j-1);
        for(int i = 0;i<=m;i++)
            Arrays.fill(T[i],-1);
        
        return deleteSum(s,t,m,n);
    }
    private int deleteSum(String s, String t, int m, int n) {
        if(m == 0)
            return asciiT[n];
        if(n == 0)
            return asciiS[m];
        if(T[m][n] != -1)
            return T[m][n];
        if(s.charAt(m-1) == t.charAt(n-1))
            return T[m][n] = deleteSum(s,t,m-1,n-1);
        return T[m][n] = Math.min(s.charAt(m-1)+deleteSum(s,t,m-1,n), 
                       t.charAt(n-1)+deleteSum(s,t,m,n-1));
    }
    private int getSum(String x,int size) {
        int val = 0;
        for(int i =0;i<size;i++)
            val += x.charAt(i);
        return val;
    }
}
//Tabulation

    int[][] T;
    public int minimumDeleteSum(String s, String t) {
        int m = s.length(),n = t.length();
        T = new int[m+1][n+1];
        
        for(int i = 1;i<=m;i++)
            T[i][0] = T[i-1][0]+s.charAt(i-1);
        
        for(int j = 1;j<=n;j++)
            T[0][j] = T[0][j-1]+t.charAt(j-1);
        
        for(int i=1;i<=m;i++) {
            for(int j = 1;j<=n;j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    T[i][j] = T[i-1][j-1];
                else
                    T[i][j] = Math.min(s.charAt(i-1)+T[i-1][j], 
                       t.charAt(j-1)+T[i][j-1]);
            }
        }
        
        return T[m][n];
    }
