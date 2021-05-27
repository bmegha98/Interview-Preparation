/*
Given a string str, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position, i.e., 
any i’th character in the two subsequences shouldn’t have the same index in the original string.
Exampel 1:

Input: str = "axxxy"
Output: 2
Explanation: The longest repeating subsequenece
is "xx".
*/
//T(n) = O(n^2) , Space = O(n^2)
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        if(n == 1)
            return 0;
        int[][] T = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++) 
            for(int j=1;j<=n;j++) {
                if(str.charAt(i-1) == str.charAt(j-1) && i != j)
                    T[i][j] = T[i-1][j-1]+1;
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        return T[n][n];
    }
}
