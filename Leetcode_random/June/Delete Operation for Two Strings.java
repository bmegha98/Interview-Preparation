/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
*/

class Solution {
    int[][] T;
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        T = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(T[i],-1);
        return helper(s,t,m-1,n-1);
    }
    
    private int helper(String s, String t, int i, int j) {
        if(i < 0)
            return j+1;
        if(j < 0)
            return i+1;
        if(T[i][j] != -1)
            return T[i][j];
        
        if(s.charAt(i) == t.charAt(j))
            return T[i][j] = helper(s,t,i-1,j-1);
        
        return T[i][j] = Math.min(helper(s,t,i-1,j), helper(s,t,i,j-1)) + 1;
    }
}
