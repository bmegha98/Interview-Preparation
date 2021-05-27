/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
*/
//Memoization
class Solution {
    int[][] T;
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        T = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(T[i], -1);
        return editDistance(s,t,m,n);
    }
    private int editDistance(String s, String t, int m, int n) {
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        if(T[m][n] != -1)
            return T[m][n];
        if(s.charAt(m-1) == t.charAt(n-1))
            return T[m][n] = editDistance(s,t,m-1,n-1);
        return T[m][n] = Math.min(Math.min(editDistance(s,t,m,n-1),
                                editDistance(s,t,m-1,n)),
                       editDistance(s,t,m-1,n-1)) + 1;
    }
}

//Tabulation
class Solution {
    int[][] T;
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        T = new int[m+1][n+1];
        for(int i = 0;i<=m;i++)
            T[i][0] = i;            //n == 0 => m deletions
        
        for(int j = 0;j<=n;j++)
            T[0][j] = j;            //m == 0 => n insertions
        
        for(int i=1;i<=m;i++) {
            for(int j =1;j<=n;j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    T[i][j] = T[i-1][j-1];
                else
                    T[i][j] = Math.min(Math.min(T[i][j-1],T[i-1][j]),T[i-1][j-1])+1;
            }
        }
        return T[m][n];
    }
}
